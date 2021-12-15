package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Login {
    private Parent root;
    @FXML
    private Button btnex;
    @FXML
    private Button btnlog;
    @FXML
    private PasswordField txtpass;
    @FXML
    private TextField txtus;

    public Login() {
    }

    public void Login() throws SQLException {
        String usuario = this.txtus.getText();
        String pass = this.txtpass.getText();
        String path = Login.class.getResource("Usuarios.db").toString();
        String url = "jdbc:sqlite:" + path;
        Connection connection = DriverManager.getConnection(url);
        Statement st = connection.createStatement();

        try {
            ResultSet rs = st.executeQuery("SELECT * from Users WHERE Usuario='" + usuario + "'and Contra='" + pass + "';");
            String usV = rs.getString("Usuario");
            String pasV = rs.getString("Contra");
            if (usV.equals(usuario) && pasV.equals(pass)) {
                App.setRoot("CitasHoy");
            }
        } catch (SQLException var15) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText((String)null);
            alert.setTitle("Error");
            alert.setContentText("Usuario o Contraseña Incorrectos");
            alert.showAndWait();
        } catch (IOException var16) {
            var16.printStackTrace();
        }

    }

    public void Exit() throws IOException {
        FXMLLoader C = new FXMLLoader(this.getClass().getResource("Login.fxml"));
        Parent root = (Parent)C.load();
        Login ad = (Login)C.getController();
        Scene scene3 = new Scene(root);
        Stage stage3 = new Stage();
        stage3.setScene(scene3);
        stage3.close();
    }
}
