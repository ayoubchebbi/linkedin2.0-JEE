package com.isamm.linkedin.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Job {
    private int id;
    private String descOffre;
    private String hashtag1;
    private String hashtag2;
    private String hashtag3;
    private String nomOffre;
    private int idRecruteur;
    private Timestamp date;
    private String place;
    private String price;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "desc_offre", nullable = false, length = -1)
    public String getDescOffre() {
        return descOffre;
    }

    public void setDescOffre(String descOffre) {
        this.descOffre = descOffre;
    }

    @Basic
    @Column(name = "hashtag1", nullable = false, length = 50)
    public String getHashtag1() {
        return hashtag1;
    }

    public void setHashtag1(String hashtag1) {
        this.hashtag1 = hashtag1;
    }

    @Basic
    @Column(name = "hashtag2", nullable = false, length = 50)
    public String getHashtag2() {
        return hashtag2;
    }

    public void setHashtag2(String hashtag2) {
        this.hashtag2 = hashtag2;
    }

    @Basic
    @Column(name = "hashtag3", nullable = false, length = 50)
    public String getHashtag3() {
        return hashtag3;
    }

    public void setHashtag3(String hashtag3) {
        this.hashtag3 = hashtag3;
    }

    @Basic
    @Column(name = "nom_offre", nullable = false, length = 300)
    public String getNomOffre() {
        return nomOffre;
    }

    public void setNomOffre(String nomOffre) {
        this.nomOffre = nomOffre;
    }

    @Basic
    @Column(name = "id_recruteur", nullable = false)
    public int getIdRecruteur() {
        return idRecruteur;
    }

    public void setIdRecruteur(int idRecruteur) {
        this.idRecruteur = idRecruteur;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "place", nullable = false, length = 100)
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Basic
    @Column(name = "price", nullable = false, length = 10)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id &&
                idRecruteur == job.idRecruteur &&
                Objects.equals(descOffre, job.descOffre) &&
                Objects.equals(hashtag1, job.hashtag1) &&
                Objects.equals(hashtag2, job.hashtag2) &&
                Objects.equals(hashtag3, job.hashtag3) &&
                Objects.equals(nomOffre, job.nomOffre) &&
                Objects.equals(date, job.date) &&
                Objects.equals(place, job.place) &&
                Objects.equals(price, job.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descOffre, hashtag1, hashtag2, hashtag3, nomOffre, idRecruteur, date, place, price);
    }
}
