package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class ExpedientePacientes {


    @FXML
    private TableView<Paciente> tblpacientes;
    @FXML
    private Button btnfind;
    @FXML
    private TextField buscador;
    @FXML
    private TableColumn<Paciente, String>colNombre;
    @FXML
    private TableColumn<Paciente, String>colApellido;
    @FXML
    private TableColumn<Paciente, String>colCorreo;
    @FXML
    private TableColumn<Paciente, String>colTipo;
    @FXML
    private TableColumn<Paciente, String>colAlergias;
    @FXML
    private TableColumn<Paciente, String>colTelefono;
    @FXML
    private TableColumn<Paciente, String>colSexo;

    private ObservableList Pacientes = FXCollections.observableArrayList(
            new Paciente("dumy", "dummy", "dummy", "A", "dummy", 12345678, "bato")
    );




    public void initialize() throws SQLException {

        String path = ((URL) Objects.requireNonNull(CitasHoy.class.getResource("Pacientes.db"))).toString();
        String url = "jdbc:sqlite:" + path;
        Connection connection = DriverManager.getConnection(url);

        try {
            Connection var7 = connection;

            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM Paciente ;");
                System.out.println(rs.toString());

                while(rs.next()) {
                    String nom = rs.getString("Nombre");
                    String apll = rs.getString("Apellido");
                    String mail = rs.getString("Correo");
                    String tipo = rs.getString("TipoS");
                    String alg = rs.getString("Alergias");
                    int tel = rs.getInt("Telefono");
                    String sex = rs.getString("Sexo");

                    Pacientes.add(new Paciente(nom, apll, mail, tipo, alg, tel, sex));

                }


                this.tblpacientes.setItems(this.Pacientes);
                System.out.println(Pacientes);


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
            System.out.println("No hay Pacientes?");
        }


    }



    public void back(ActionEvent actionEvent) throws IOException {
        App.setRoot("CitasHoy");
    }
}
