package org.example;

public class Cita {
    private String Paciente;
    private String Padecimiento;
    private String Hora;

    public Cita(String Paciente, String Padecimiento, String Hora) {
        this.Paciente = Paciente;
        this.Padecimiento = Padecimiento;
        this.Hora = Hora;
    }

    public String getPaciente() {
        return this.Paciente;
    }

    public String getPadecimiento() {
        return this.Padecimiento;
    }

    public String getHora() {
        return this.Hora;
    }
}
