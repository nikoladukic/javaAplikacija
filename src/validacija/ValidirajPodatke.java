/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validacija;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import view.Start;

/**
 *
 * @author PC
 */
public class ValidirajPodatke {
     public boolean ValidirajPodatke(String firstname, String lastanme) {
            for (int i = 0; i < firstname.length(); i++) {
            if(!(Character.isAlphabetic(firstname.charAt(i)))||firstname.length()==0){
                JOptionPane.showMessageDialog(new Start(), "Lose uneto ime");
                return false;
            }
            }
            for (int i = 0; i < lastanme.length(); i++) {
            if(!(Character.isAlphabetic(lastanme.charAt(i)))||lastanme.length()==0){
                JOptionPane.showMessageDialog(new Start(), "Lose uneto prezime");
                return false;
            }
            }
            if(firstname.length()==0||lastanme.length()==0||firstname==null|| lastanme==null){
                JOptionPane.showMessageDialog(new Start(), "Ne mogu prazna polja da budu"); 
                return false;
            }
            if(!Character.isUpperCase(firstname.charAt(0))){
                JOptionPane.showMessageDialog(new Start(), "Ime mora poceti velikim slovom");
                return false;
            }
             if(!Character.isUpperCase(lastanme.charAt(0))){
                JOptionPane.showMessageDialog(new Start(), "Prezime mora poceti velikim slovom");
            return false;
             } 
            
             
             return true;
        
    }
}
