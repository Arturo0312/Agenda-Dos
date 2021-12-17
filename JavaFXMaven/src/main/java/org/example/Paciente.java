package org.example;

public class Paciente {
    private String nom;
    private String apll;
    private String mail;
    private String tipo;
    private String alg;
    private String tel;
    private String sex;

    public Paciente(String nom, String apll, String mail, String tipo, String alg, String tel, String sex) {
        this.nom = nom;
        this.apll = apll;
        this.mail = mail;
        this.tipo = tipo;
        this.alg = alg;
        this.tel = tel;
        this.sex = sex;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApll() {
        return apll;
    }

    public void setApll(String apll) {
        this.apll = apll;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nom='" + nom + '\'' +
                ", apll='" + apll + '\'' +
                ", mail='" + mail + '\'' +
                ", tipo='" + tipo + '\'' +
                ", alg='" + alg + '\'' +
                ", tel=" + tel +
                ", sex='" + sex + '\'' +
                '}';
    }
}
