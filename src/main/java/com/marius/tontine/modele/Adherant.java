package com.marius.tontine.modele;

import java.sql.Date;

public class Adherant {
    int id;
    String nomPrenom;
    String nom;
    String prenom;


    int age;
    Date dateNaissance;
    Date dateAdhesion;
    Integer contact;
    String email;
    String sexe;

    public Adherant(int id, String nomPrenom, String nom, String prenom, int age, Date dateNaissance, Date dateAdhesion, Integer contact, String email, String sexe) {
        this.id = id;
        this.nomPrenom = nomPrenom;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.dateNaissance = dateNaissance;
        this.dateAdhesion = dateAdhesion;
        this.contact = contact;
        this.email = email;
        this.sexe = sexe;
    }

    public Adherant(int id, String nomPrenom, int age, Date dateAdhesion, Integer contact, String email, String sexe) {
        this.id = id;
        this.nomPrenom = nomPrenom;
        this.age = age;
        this.dateAdhesion = dateAdhesion;
        this.contact = contact;
        this.email = email;
        this.sexe = sexe;
    }

    public Adherant() {

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
