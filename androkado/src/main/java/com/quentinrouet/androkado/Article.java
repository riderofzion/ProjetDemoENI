package com.quentinrouet.androkado;

/**
 * Created by quentin for Constraint Layout on 15/02/2022.
 */
public class Article {
    private String nom, description, url;
    private float prix;
    private double degreEnvie;
    private boolean isAchete;

    public Article(String nom, String description, String url, float prix, double degreEnvie, boolean isAchete) {
        this.nom = nom;
        this.description = description;
        this.url = url;
        this.prix = prix;
        this.degreEnvie = degreEnvie;
        this.isAchete = isAchete;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public double getDegreEnvie() {
        return degreEnvie;
    }

    public void setDegreEnvie(double degreEnvie) {
        this.degreEnvie = degreEnvie;
    }

    public boolean isAchete() {
        return isAchete;
    }

    public void setAchete(boolean achete) {
        isAchete = achete;
    }
}
