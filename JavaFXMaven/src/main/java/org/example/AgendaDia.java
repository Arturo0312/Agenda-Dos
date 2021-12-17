package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class AgendaDia {

    @FXML
    private Button btnbackcal;
    @FXML
    private Button btnHomeAgendar;
    @FXML private Button btninit;
    private ObservableList<Agendados> Ag;
    @FXML
    private TableView<Agendados> tbldia;
    @FXML
    private TableColumn tlbhor;
    @FXML
    private TableColumn tlbes;

    private String e1="DISPONIBLE";
    private String e2="NO DISPONIBLE";
    private String d;
    private String[] ho={"11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00"};

    public void AgendaT() {
        this.Ag = FXCollections.observableArrayList();
        this.tlbhor.setCellValueFactory(new PropertyValueFactory("hora"));
        this.tlbes.setCellValueFactory(new PropertyValueFactory("estatus"));
    }

    public void Inertar(String h, String e){
        System.out.println(h+" "+e);
    }
    public void initialize() throws SQLException, FileNotFoundException {
        String b= Login.class.getResource("CalendarioD.txt").toString();
        b=b.replace("file:/","");
        Scanner input = new Scanner(new File(b));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if(line.contains("JANUARY"))
                line=line.replace("JANUARY","01");
            if(line.contains("FEBRUARY"))
                line=line.replace("FEBRUARY","02");
            if(line.contains("MARCH"))
                line=line.replace("MARCH","03");
            if(line.contains("APRIL"))
                line=line.replace("APRIL","04");
            if(line.contains("MAY"))
                line=line.replace("MAY","05");
            if(line.contains("JUNE"))
                line=line.replace("JUNE","06");
            if(line.contains("JULY"))
                line=line.replace("JULY","07");
            if(line.contains("AUGUST"))
                line=line.replace("AUGUST","08");
            if(line.contains("SEPTEMBER"))
                line=line.replace("SEPTEMBER","09");
            if(line.contains("OCTOBER"))
                line=line.replace("OCTOBER","10");
            if(line.contains("NOVEMBER"))
                line=line.replace("NOVEMBER","11");
            if(line.contains("DECEMBER"))
                line=line.replace("DECEMBER","12");
            this.d=line;
        }
        input.close();
        String path = ((URL)Objects.requireNonNull(Agendados.class.getResource("Citas.db"))).toString();
        String url = "jdbc:sqlite:" + path;
        Connection connection = DriverManager.getConnection(url);

        try {
            Connection var7 = connection;

            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("SELECT * from Citas WHERE Día='" +d+ "'order by Hora;");
                while(rs.next()) {
                    String h=rs.getString("Hora");
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


        public void atras() throws IOException {
        App.setRoot("Calendario");
    }
    public void GoHome() throws IOException {
        App.setRoot("CitasHoy");
    }

}
