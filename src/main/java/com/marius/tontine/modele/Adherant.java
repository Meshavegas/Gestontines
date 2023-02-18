package com.marius.tontine.modele;

import java.sql.Date;

public class Adherant {
    int id;
    String nomPrenom;
    int age;
    Date dateAdhesion;
    Integer contact;
    String email;
    String sexe;

    public Adherant(int id, String nomPrenom, int age, Date dateAdhesion, Integer contact, String email, String sexe) {
        this.id = id;
        this.nomPrenom = nomPrenom;
        this.age = age;
        this.dateAdhesion = dateAdhesion;
        this.contact = contact;
        this.email = email;
        this.sexe = sexe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public int getAge() {
        return age;
    }

    public void setDateNaissance(int age) {
        this.age = age;
    }

    public Date getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(Date dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}
