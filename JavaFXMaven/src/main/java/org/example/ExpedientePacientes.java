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


    private ObservableList<Paciente> P;
    @FXML
    private TableView<Paciente> tblpacientes;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellido;
    @FXML
    private TableColumn colTelefono;
    @FXML
    private TableColumn colCorreo;
    @FXML
    private TableColumn colTipo;
    @FXML
    private TableColumn colAlergias;
    @FXML
    private Button btnfind;
    @FXML
    private TextField buscador;
    @FXML
    private TableColumn colSexo;
    @FXML private Button btninit;




    public void Buscar() throws SQLException {
        this.LimpiarT();
        this.ExpedienteT();
        String clave=this.buscador.getText();
        String path = ((URL) Objects.requireNonNull(CitasHoy.class.getResource("Pacientes.db"))).toString();
        String url = "jdbc:sqlite:" + path;
        Connection connection = DriverManager.getConnection(url);
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Paciente where Nombre= '"+clave+"' or Apellido='"+clave+"';");
            System.out.println(rs.toString());

            while(rs.next()) {
                String nom = rs.getString("Nombre");
                String apll = rs.getString("Apellido");
                String mail = rs.getString("Correo");
                String tipo = rs.getString("TipoS");
                String alg = rs.getString("Alergias");
                String tel = rs.getString("Telefono");
                String sex = rs.getString("Sexo");
                Paciente a = new Paciente(nom, apll, mail,tipo,alg,tel,sex);
                System.out.println(a);
                this.P.add(a);
                this.tblpacientes.setItems(this.P);
            }
        } catch (Throwable var13) {
            if (connection != null) {
                try {
                } catch (Exception e) {
                    System.out.println("No existe");
                }
            }
        }
    }
    public void initialize() throws SQLException {
        this.LimpiarT();
        this.ExpedienteT();
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
                    String tel = rs.getString("Telefono");
                    String sex = rs.getString("Sexo");
                    Paciente a = new Paciente(nom, apll, mail,tipo,alg,tel,sex);
                    System.out.println(a);
                    this.P.add(a);
                    this.tblpacientes.setItems(this.P);
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
            System.out.println("No hay Pacientes?");
        }


    }

    public void LimpiarT() {
        this.ExpedienteT();
        Paciente a = new Paciente("", "", "","","","","");
        this.P.add(a);
        this.tblpacientes.setItems(this.P);
    }

    public void ExpedienteT() {
        this.P = FXCollections.observableArrayList();
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nom"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("apll"));
        this.colCorreo.setCellValueFactory(new PropertyValueFactory("mail"));
        this.colTelefono.setCellValueFactory(new PropertyValueFactory("tel"));
        this.colAlergias.setCellValueFactory(new PropertyValueFactory("alg"));
        this.colTipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        this.colSexo.setCellValueFactory(new PropertyValueFactory("sex"));
    }



    public void back(ActionEvent actionEvent) throws IOException {
        App.setRoot("CitasHoy");
    }
}
