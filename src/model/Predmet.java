/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Predmet {


        int id;
        String naziv;
        int espb;

    public Predmet(int id, String naziv, int espb) {
        this.id = id;
        this.naziv = naziv;
        this.espb = espb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    @Override
    public String toString() {
        return "Predmet{" + "id=" + id + ", naziv=" + naziv + ", espb=" + espb + '}';
    }
        
}
