/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author pc
 */
public class Medecin {
    private int Id;
    private String Nom;
    private int Nombre_jours;
    private float Taux_journalier;

    public Medecin(String Nom, int Nombre_jours, float Taux_journalier) {
        this.Nom = Nom;
        this.Nombre_jours = Nombre_jours;
        this.Taux_journalier = Taux_journalier;
    }

    public Medecin() {
    }

    public Medecin(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public Medecin(int Id, String Nom, int Nombre_jours, float Taux_journalier) {
        this.Id = Id;
        this.Nom = Nom;
        this.Nombre_jours = Nombre_jours;
        this.Taux_journalier = Taux_journalier;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public int getNombre_jours() {
        return Nombre_jours;
    }

    public void setNombre_jours(int Nombre_jours) {
        this.Nombre_jours = Nombre_jours;
    }

    public float getTaux_journalier() {
        return Taux_journalier;
    }

    public void setTaux_journalier(float Taux_journalier) {
        this.Taux_journalier = Taux_journalier;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.Id;
        hash = 61 * hash + Objects.hashCode(this.Nom);
        hash = 61 * hash + this.Nombre_jours;
        hash = 61 * hash + Float.floatToIntBits(this.Taux_journalier);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medecin other = (Medecin) obj;
        if (this.Id != other.Id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medecin{" + "Id=" + Id + ", Nom=" + Nom + ", Nombre_jours=" + Nombre_jours + ", Taux_journalier=" + Taux_journalier + '}';
    }
    
}
