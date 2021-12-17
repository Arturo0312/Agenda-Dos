package org.example;

public class Agendados {

    private String hora;
    private String estatus;

    public Agendados (String a, String b) {
        this.hora = a;
        this.estatus = b;
    }

    public String gethora() {
        return hora;
    }

    public void sethora(String hora) {
        this.hora = hora;
    }

    public String getestatus() {
        return estatus;
    }

    public void setestatus(String estatus) {
        this.estatus = estatus;
    }
}
