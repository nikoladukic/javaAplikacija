/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Nastavnik {
   int id;
   String name;
   String lastname;
   Zvanje zvanje;

    public Nastavnik() {
    }

    public Nastavnik(int id, String name, String lastname, Zvanje zvanje) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.zvanje = zvanje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(Zvanje zvanje) {
        this.zvanje = zvanje;
    }

    @Override
    public String toString() {
        return "Nastavnik{" + "name=" + name + ", lastname=" + lastname + ", zvanje=" + zvanje + '}';
    }

   

    
   
   
   
}
