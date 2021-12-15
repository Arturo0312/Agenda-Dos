package org.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RegistrarPaciente {

    @FXML
    private ComboBox<String> cmbsex;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtap;
    @FXML
    private TextField txtcorr;
    @FXML
    private TextField txttip;
    @FXML
    private TextField txtnum;
    @FXML
    private TextArea txfal;

    public RegistrarPaciente() {
    }

    public void initialize() {
        ObservableList<String> s = FXCollections.observableArrayList();
        s.addAll(new String[]{"M", "F"});
        this.cmbsex.setItems(s);
    }

    public void Registrar() throws SQLException {
        String Nombre = this.txtnom.getText();
        String Apellido = this.txtap.getText();
        String Correo = this.txtcorr.getText();
        String num = this.txtnum.getText();
        String tipo = this.txttip.getText();
        String sex = (String)this.cmbsex.getValue();
        String Alergia = this.txfal.getText();
        String path = ((URL)Objects.requireNonNull(RegistrarPaciente.class.getResource("Pacientes.db"))).toString();
        String url = "jdbc:sqlite:" + path;
        String sql = "Insert into Paciente values('" + Nombre + "','" + Apellido + "','" + Correo + "','" + tipo + "','" + Alergia + "','" + num + "','" + sex + "');";
        Connection connection = DriverManager.getConnection(url);
        Statement st = connection.createStatement();

        try {
            st.execute(sql);
            this.txtnom.setText("");
            this.txtap.setText("");
            this.txtcorr.setText("");
            this.txttip.setText("");
            this.txfal.setText("");
            this.txtnum.setText("");
        } catch (SQLException var15) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText((String)null);
            alert.setTitle("Error");
            alert.setContentText("No ingreso correctamente los datos");
            alert.showAndWait();
        }

    }

    public void atras() throws IOException {
        App.setRoot("CitasHoy");
    }

}
