package com.example.springinitializrdemo.models;

public class Kompis {

    protected int id;
    protected String namn;
    protected String adress;
    protected String telefonnummer;

    public Kompis(int id, String namn, String adress, String telefonnummer) {
        this.id = id;
        this.namn = namn;
        this.adress = adress;
        this.telefonnummer = telefonnummer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
}
