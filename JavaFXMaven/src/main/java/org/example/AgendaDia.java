package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;

public class AgendaDia {

    @FXML
    private Button btnbackcal;
    @FXML
    private Button btnHomeAgendar;
    @FXML
    private TableView tbldia;

    private ObservableList<Agendados> Horarios = FXCollections.observableArrayList(
            new Agendados("9:00", "DISPONIBLE"),
            new Agendados("9:30", "DISPONIBLE"),
            new Agendados("10:00", "DISPONIBLE"),
            new Agendados("10:30", "DISPONIBLE"),
            new Agendados("11:00", "DISPONIBLE"),
            new Agendados("11:30", "DISPONIBLE"),
            new Agendados("12:00", "DISPONIBLE"),
            new Agendados("12:30", "DISPONIBLE"),
            new Agendados("1:00", "DISPONIBLE"),
            new Agendados("1:30", "DISPONIBLE"),
            new Agendados("2:00", "DISPONIBLE")
    );

    public void initialize() throws SQLException {

        this.tbldia.setItems(this.Horarios);

    }


        public void atras() throws IOException {
        App.setRoot("Calendario");
    }
    public void GoHome() throws IOException {
        App.setRoot("CitasHoy");
    }

}
