package org.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CitasHoy {

    @FXML
    private Button btnCons;
    @FXML
    private Button btnexp;
    private ObservableList<Cita> Citas;
    @FXML
    private TableView<Cita> tblCitas;
    @FXML
    private TableColumn ColPac;
    @FXML
    private TableColumn ColPad;
    @FXML
    private TableColumn ColHor;
    @FXML
    private Label lbldia;
    private LocalDate Hoy = LocalDate.now();
    @FXML
    private Button btnnext;
    @FXML
    private Button btnprev;
    private Node node;
    private String doc;
    Stage sd2;

    public CitasHoy() {
    }

    public void initialize(Stage ab) throws SQLException {
        this.sd2 = ab;
        this.LimpiarT();
        this.CitasTabla();
        System.out.println(this.sd2.getUserData());
        this.doc = this.sd2.getUserData().toString();
        this.lbldia.setText(String.valueOf(this.Hoy));
        String path = ((URL)Objects.requireNonNull(CitasHoy.class.getResource("Citas.db"))).toString();
        String url = "jdbc:sqlite:" + path;
        Connection connection = DriverManager.getConnection(url);

        try {
            Connection var7 = connection;

            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("SELECT * from Citas WHERE Día='" + this.Hoy + "' and Doctor='" + this.doc + "' order by Hora;");
                System.out.println(rs.toString());

                while(rs.next()) {
                    String nom = rs.getString("Nombre");
                    String pad = rs.getString("Padecimiento");
                    String ho = rs.getString("Hora");
                    Cita a = new Cita(nom, pad, ho);
                    this.Citas.add(a);
                    this.tblCitas.setItems(this.Citas);
                }
            } catch (Throwable var13) {
                if (connection != null) {
                    try {
                        var7.close();
                    } catch (Throwable var12) {
                        var13.addSuppressed(var12);
                    }
                }

                throw var13;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var14) {
            System.out.println("No hay citas");
        }

    }

    public void LimpiarT() {
        this.CitasTabla();
        Cita a = new Cita("", "", "");
        this.Citas.add(a);
        this.tblCitas.setItems(this.Citas);
    }

    public void CitasTabla() {
        this.Citas = FXCollections.observableArrayList();
        this.ColPac.setCellValueFactory(new PropertyValueFactory("Paciente"));
        this.ColPad.setCellValueFactory(new PropertyValueFactory("Padecimiento"));
        this.ColHor.setCellValueFactory(new PropertyValueFactory("Hora"));
    }



    public void Registrar() throws IOException {
        /*FXMLLoader Com = new FXMLLoader(this.getClass().getResource("RegistrarPaciente.fxml"));
        Parent root = (Parent)Com.load();
        RegistrarPaciente ad = (RegistrarPaciente)Com.getController();
        Scene scene3 = new Scene(root);
        Stage stage3 = new Stage();
        stage3.setScene(scene3);
        stage3.show();*/

        App.setRoot("RegistrarPaciente");

    }

    public void Expediente() throws IOException {
        App.setRoot("Calendario");
    }

    public void Next() throws SQLException {
        this.Hoy = this.Hoy.plusDays(1L);
        this.LimpiarT();
        this.initialize(this.sd2);
    }

    public void Prev() throws SQLException {
        this.Hoy = this.Hoy.minusDays(1L);
        this.LimpiarT();
        this.initialize(this.sd2);
    }

    public void GoExpediente(ActionEvent actionEvent) throws IOException {
        App.setRoot("ExpedientePacientes");
    }
}
