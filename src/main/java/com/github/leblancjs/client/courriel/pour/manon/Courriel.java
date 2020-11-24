package com.github.leblancjs.client.courriel.pour.manon;

public class Courriel {
    private final String expediteur;
    private final String sujet;
    private final String message;

    public Courriel(String expediteur, String sujet, String message) {
        this.expediteur = expediteur;
        this.sujet = sujet;
        this.message = message;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public String getSujet() {
        return sujet;
    }

    public String getMessage() {
        return message;
    }
}
