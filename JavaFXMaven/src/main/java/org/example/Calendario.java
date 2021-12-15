package org.example;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Calendario {

    @FXML
    private Button btnmesant;
    @FXML
    private Button btnmessig;
    @FXML
    private Button btnd1;
    @FXML
    private Button btnd2;
    @FXML
    private Button btnd3;
    @FXML
    private Button btnd4;
    @FXML
    private Button btnd5;
    @FXML
    private Button btnl1;
    @FXML
    private Button btnl2;
    @FXML
    private Button btnl3;
    @FXML
    private Button btnl4;
    @FXML
    private Button btnl5;
    @FXML
    private Button btnm1;
    @FXML
    private Button btnm2;
    @FXML
    private Button btnm3;
    @FXML
    private Button btnm4;
    @FXML
    private Button btnm5;
    @FXML
    private Button btnmi1;
    @FXML
    private Button btnmi2;
    @FXML
    private Button btnmi3;
    @FXML
    private Button btnmi4;
    @FXML
    private Button btnmi5;
    @FXML
    private Button btnj1;
    @FXML
    private Button btnj2;
    @FXML
    private Button btnj3;
    @FXML
    private Button btnj4;
    @FXML
    private Button btnj5;
    @FXML
    private Button btnv1;
    @FXML
    private Button btnv2;
    @FXML
    private Button btnv3;
    @FXML
    private Button btnv4;
    @FXML
    private Button btnv5;
    @FXML
    private Button btns1;
    @FXML
    private Button btns2;
    @FXML
    private Button btns3;
    @FXML
    private Button btns4;
    @FXML
    private Button btns5;
    private int dia;
    @FXML
    private Label lblmes;
    private Month mes = LocalDate.now().getMonth();
    private int año = LocalDate.now().getYear();
    private String a;

    public Calendario() {
    }

    public void initialize() {
        Label var10000 = this.lblmes;
        String var10001 = String.valueOf(this.mes);
        var10000.setText(var10001 + "-" + this.año);
        int d = this.mes.minLength();
        LocalDate dia1 = LocalDate.of(this.año, this.mes, d);
        System.out.println(dia1);
        DayOfWeek f = dia1.getDayOfWeek();
        System.out.println(f);
        switch(f) {
            case SUNDAY:
                this.btnd5.setText(String.valueOf(d));
                this.btnd5.setVisible(true);
                this.btnl5.setVisible(false);
                this.btnm5.setVisible(false);
                this.btnmi5.setVisible(false);
                this.btnj5.setVisible(false);
                this.btnv5.setVisible(false);
                this.btns5.setVisible(false);
                this.btns4.setText(String.valueOf(d - 1));
                this.a = this.btnd5.getText();
                break;
            case MONDAY:
                this.btnl5.setText(String.valueOf(d));
                this.btnl5.setVisible(true);
                this.btnd5.setText(String.valueOf(d - 1));
                this.btnd5.setVisible(true);
                this.btnm5.setVisible(false);
                this.btnmi5.setVisible(false);
                this.btnj5.setVisible(false);
                this.btnv5.setVisible(false);
                this.btns5.setVisible(false);
                this.a = this.btnl5.getText();
                break;
            case TUESDAY:
                this.btnm5.setText(String.valueOf(d));
                this.btnm5.setVisible(true);
                this.btnl5.setText(String.valueOf(d - 1));
                this.btnl5.setVisible(true);
                this.btnd5.setText(String.valueOf(Integer.parseInt(this.btnl5.getText()) - 1));
                this.btnd5.setVisible(true);
                this.btnmi5.setVisible(false);
                this.btnj5.setVisible(false);
                this.btnv5.setVisible(false);
                this.btns5.setVisible(false);
                this.a = this.btnm5.getText();
                break;
            case WEDNESDAY:
                this.btnmi5.setText(String.valueOf(d));
                this.btnmi5.setVisible(true);
                this.btnm5.setText(String.valueOf(d - 1));
                this.btnm5.setVisible(true);
                this.btnl5.setText(String.valueOf(Integer.parseInt(this.btnm5.getText()) - 1));
                this.btnl5.setVisible(true);
                this.btnd5.setText(String.valueOf(Integer.parseInt(this.btnl5.getText()) - 1));
                this.btnd5.setVisible(true);
                this.btnj5.setVisible(false);
                this.btnv5.setVisible(false);
                this.btns5.setVisible(false);
                this.a = this.btnmi5.getText();
                break;
            case THURSDAY:
                this.btnj5.setText(String.valueOf(d));
                this.btnj5.setVisible(true);
                this.btnmi5.setText(String.valueOf(Integer.parseInt(this.btnj5.getText()) - 1));
                this.btnmi5.setVisible(true);
                this.btnm5.setText(String.valueOf(Integer.parseInt(this.btnmi5.getText()) - 1));
                this.btnm5.setVisible(true);
                this.btnl5.setText(String.valueOf(Integer.parseInt(this.btnm5.getText()) - 1));
                this.btnl5.setVisible(true);
                this.btnd5.setText(String.valueOf(Integer.parseInt(this.btnl5.getText()) - 1));
                this.btnd5.setVisible(true);
                this.btnv5.setVisible(false);
                this.btns5.setVisible(false);
                this.a = this.btnj5.getText();
                break;
            case FRIDAY:
                this.btnv5.setText(String.valueOf(d));
                this.btnv5.setVisible(true);
                this.btnj5.setText(String.valueOf(d - 1));
                this.btnj5.setVisible(true);
                this.btnmi5.setText(String.valueOf(Integer.parseInt(this.btnj5.getText()) - 1));
                this.btnmi5.setVisible(true);
                this.btnm5.setText(String.valueOf(Integer.parseInt(this.btnmi5.getText()) - 1));
                this.btnm5.setVisible(true);
                this.btnl5.setText(String.valueOf(Integer.parseInt(this.btnm5.getText()) - 1));
                this.btnl5.setVisible(true);
                this.btnd5.setText(String.valueOf(Integer.parseInt(this.btnl5.getText()) - 1));
                this.btnd5.setVisible(true);
                this.btns5.setVisible(false);
                this.a = this.btnv5.getText();
                break;
            case SATURDAY:
                this.btns5.setText(String.valueOf(d));
                this.btns5.setVisible(true);
                this.btnv5.setText(String.valueOf(d - 1));
                this.btnv5.setVisible(true);
                this.btnj5.setText(String.valueOf(d - 2));
                this.btnj5.setVisible(true);
                this.btnmi5.setText(String.valueOf(d - 3));
                this.btnmi5.setVisible(true);
                this.btnm5.setText(String.valueOf(d - 4));
                this.btnm5.setVisible(true);
                this.btnl5.setText(String.valueOf(d - 5));
                this.btnl5.setVisible(true);
                this.btnd5.setText(String.valueOf(Integer.parseInt(this.btnl5.getText()) - 1));
                this.btnd5.setVisible(true);
                this.a = this.btns5.getText();
        }

        this.Actualizar(1);
    }

    public void Actualizar(int intento) {
        int var2 = Integer.parseInt(this.a);

        try {
            this.btns4.setText(String.valueOf(Integer.parseInt(this.btnd5.getText()) - 1));
            this.btnv4.setText(String.valueOf(Integer.parseInt(this.btns4.getText()) - 1));
            this.btnj4.setText(String.valueOf(Integer.parseInt(this.btnv4.getText()) - 1));
            this.btnmi4.setText(String.valueOf(Integer.parseInt(this.btnj4.getText()) - 1));
            this.btnm4.setText(String.valueOf(Integer.parseInt(this.btnmi4.getText()) - 1));
            this.btnl4.setText(String.valueOf(Integer.parseInt(this.btnm4.getText()) - 1));
            this.btnd4.setText(String.valueOf(Integer.parseInt(this.btnl4.getText()) - 1));
            this.btns3.setText(String.valueOf(Integer.parseInt(this.btnd4.getText()) - 1));
            this.btnv3.setText(String.valueOf(Integer.parseInt(this.btns3.getText()) - 1));
            this.btnj3.setText(String.valueOf(Integer.parseInt(this.btnv3.getText()) - 1));
            this.btnmi3.setText(String.valueOf(Integer.parseInt(this.btnj3.getText()) - 1));
            this.btnm3.setText(String.valueOf(Integer.parseInt(this.btnmi3.getText()) - 1));
            this.btnl3.setText(String.valueOf(Integer.parseInt(this.btnm3.getText()) - 1));
            this.btnd3.setText(String.valueOf(Integer.parseInt(this.btnl3.getText()) - 1));
            this.btns2.setText(String.valueOf(Integer.parseInt(this.btnd3.getText()) - 1));
            this.btnv2.setText(String.valueOf(Integer.parseInt(this.btns2.getText()) - 1));
            this.btnj2.setText(String.valueOf(Integer.parseInt(this.btnv2.getText()) - 1));
            this.btnmi2.setText(String.valueOf(Integer.parseInt(this.btnj2.getText()) - 1));
            this.btnm2.setText(String.valueOf(Integer.parseInt(this.btnmi2.getText()) - 1));
            this.btnl2.setText(String.valueOf(Integer.parseInt(this.btnm2.getText()) - 1));
            this.btnd2.setText(String.valueOf(Integer.parseInt(this.btnl2.getText()) - 1));
            this.btns1.setText(String.valueOf(Integer.parseInt(this.btnd2.getText()) - 1));
            if (!this.btns1.getText().equals("") && !this.btns1.getText().equals("1")) {
                this.btnv1.setVisible(true);
                this.btnv1.setText(String.valueOf(Integer.parseInt(this.btns1.getText()) - 1));
            } else {
                this.btnv1.setText("");
                this.btnv1.setVisible(false);
            }

            if (!this.btnv1.getText().equals("") && !this.btnv1.getText().equals("1")) {
                this.btnj1.setVisible(true);
                this.btnj1.setText(String.valueOf(Integer.parseInt(this.btnv1.getText()) - 1));
            } else {
                this.btnj1.setText("");
                this.btnj1.setVisible(false);
            }

            if (!this.btnj1.getText().equals("") && !this.btnj1.getText().equals("1")) {
                this.btnmi1.setVisible(true);
                this.btnmi1.setText(String.valueOf(Integer.parseInt(this.btnj1.getText()) - 1));
            } else {
                this.btnmi1.setText("");
                this.btnmi1.setVisible(false);
            }

            if (!this.btnmi1.getText().equals("") && !this.btnmi1.getText().equals("1")) {
                this.btnm1.setVisible(true);
                this.btnm1.setText(String.valueOf(Integer.parseInt(this.btnmi1.getText()) - 1));
            } else {
                this.btnm1.setText("");
                this.btnm1.setVisible(false);
            }

            if (!this.btnm1.getText().equals("") && !this.btnm1.getText().equals("1")) {
                this.btnl1.setVisible(true);
                this.btnl1.setText(String.valueOf(Integer.parseInt(this.btnm1.getText()) - 1));
            } else {
                this.btnl1.setText("");
                this.btnl1.setVisible(false);
            }

            if (!this.btnl1.getText().equals("") && !this.btnl1.getText().equals("1")) {
                this.btnd1.setVisible(true);
                this.btnd1.setText(String.valueOf(Integer.parseInt(this.btnl1.getText()) - 1));
            } else {
                this.btnd1.setText("");
                this.btnd1.setVisible(false);
            }
        } catch (Exception var4) {
            System.out.println(var4);
        }

    }

    public void mesant() {
        this.mes = this.mes.minus(1L);
        if (this.mes.equals(Month.DECEMBER)) {
            --this.año;
        }

        this.initialize();
    }

    public void messig() {
        this.mes = this.mes.plus(1L);
        if (this.mes.equals(Month.JANUARY)) {
            ++this.año;
        }

        this.initialize();
    }

    public void atras() throws IOException {
        App.setRoot("CitasHoy");
    }

    public void PickDia(ActionEvent actionEvent) throws IOException {
        App.setRoot("AgendaDia");
    }
}
