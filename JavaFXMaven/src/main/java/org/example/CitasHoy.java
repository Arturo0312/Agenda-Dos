package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

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

    public CitasHoy() {
    }

    public void initialize() throws SQLException, FileNotFoundException {
        this.LimpiarT();
        this.CitasTabla();
        String homeUsuario = System.getProperty("user.home");
        String b= homeUsuario+"\\Consultorio\\UsuarioAct.txt";
        Scanner input = new Scanner(new File(b));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
            this.doc=line;
        }
        input.close();
        this.lbldia.setText(String.valueOf(this.Hoy));
        String path = homeUsuario+"\\Consultorio\\Citas.db";
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
        App.setRoot("RegistrarPaciente");
    }

    public void Expediente() throws IOException {
        App.setRoot("AsignarAgenda");
    }

    public void Next() throws SQLException, FileNotFoundException {
        this.Hoy = this.Hoy.plusDays(1L);
        this.LimpiarT();
        initialize();
    }

    public void Prev() throws SQLException, FileNotFoundException {
        this.Hoy = this.Hoy.minusDays(1L);
        this.LimpiarT();
        initialize();
    }

    public void GoExpediente(ActionEvent actionEvent) throws IOException {
        App.setRoot("ExpedientePacientes");
    }
}
