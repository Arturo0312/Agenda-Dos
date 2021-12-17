package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AsignarAgenda {

    @FXML
    private Button btnAg;
    @FXML
    private ComboBox<String> cmbhor;
    @FXML
    private ComboBox<String> cmbPac;
    @FXML
    private TextField txtdoc;
    @FXML
    private TextField txtpad;
    @FXML
    private DatePicker dtCalendario;
    @FXML
    private ComboBox<String> cmbdoc;

    public AsignarAgenda() {
    }

    public void initialize() throws SQLException {
        String path = AsignarAgenda.class.getResource("Pacientes.db").toString();
        String url = "jdbc:sqlite:" + path;
        System.out.println(path);
        ObservableList<String> Pacientes = FXCollections.observableArrayList();
        Connection connection = DriverManager.getConnection(url);
        Statement st = connection.createStatement();

        ResultSet rs;
        try {
            rs = st.executeQuery("SELECT * from Paciente;");

            while(rs.next()) {
                String n = rs.getString("Nombre");
                String a = rs.getString("Apellido");
                Pacientes.addAll(new String[]{n + " " + a});
            }

            System.out.println(Pacientes);
            this.cmbPac.setItems(Pacientes);
        } catch (SQLException var14) {
            System.out.println("a");
        }

        ObservableList<String> h = FXCollections.observableArrayList();
        h.addAll(new String[]{"11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00"});
        this.cmbhor.setItems(h);
        path = AsignarAgenda.class.getResource("Usuarios.db").toString();
        url = "jdbc:sqlite:" + path;
        ObservableList<String> Doctores = FXCollections.observableArrayList();
        connection = DriverManager.getConnection(url);
        st = connection.createStatement();

        try {
            rs = st.executeQuery("SELECT * from Users;");

            while(rs.next()) {
                String Doc = rs.getString("Usuario");
                Doctores.addAll(new String[]{Doc});
            }

            this.cmbdoc.setItems(Doctores);
        } catch (SQLException var13) {
            System.out.println("a");
        }

    }

    public void atras() throws IOException {
        App.setRoot("CitasHoy");
    }
    public void Agendar() throws SQLException {
        String P = (String)this.cmbPac.getValue();
        String Doc = (String)this.cmbdoc.getValue();
        String Pad = this.txtpad.getText();
        String hora = (String)this.cmbhor.getValue();
        LocalDate dia = (LocalDate)this.dtCalendario.getValue();
        LocalDate hoy = LocalDate.now();
        String d = dia.toString();
        if (!dia.isBefore(hoy)) {
            String path = AsignarAgenda.class.getResource("Citas.db").toString();
            String url = "jdbc:sqlite:" + path;
            String sql = "Insert into Citas values('" + P + "','" + Pad + "','" + hora + "','" + Doc + "','" + d + "');";
            Connection connection = DriverManager.getConnection(url);
            Statement st = connection.createStatement();

            try {
                st.execute(sql);
            } catch (SQLException var15) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText((String)null);
                alert.setTitle("Error");
                if (var15.toString().contains("PRIMARY KEY")) {
                    alert.setContentText("Esta fecha ya esta ocupada.");
                } else {
                    alert.setContentText("No ingreso correctamente los datos");
                }

                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText((String)null);
            alert.setTitle("Error");
            alert.setContentText("La fecha ya paso");
            alert.showAndWait();
        }

    }

}
