package org.example;

public class Agendados {

    private String hora;
    private String estatus;

    public Agendados (String a, String b) {
        this.hora = a;
        this.estatus = b;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
