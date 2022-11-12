/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Nastavnik;
import model.Zvanje;
import view.Start;
/**
 *
 * @author PC
 */
public class DatabseConnection {
    private Connection connection;
    public  void Connect() {
        try {
            String url="jdbc:mysql://localhost:3306/bazadomaci";
            String user = "Nikola";
            String password = "nikola";
            connection=DriverManager.getConnection(url,user,password);
            System.out.println("Konekcija sa bazom uspesna!");
            connection.setAutoCommit(false);
        }
        catch (SQLException ex) {
            
            ex.printStackTrace();
            System.out.println("Konekcija sa bazom neuspesna!");

        }
        
        
    }
    public void Disconnect(){
        if(connection==null){
            System.out.println("Konekcija je vec zatvorena");
        }else{
            try {
                connection.close();
            } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("Doslo je do neke greske prilkom zatvranja konekcije");
            }
        }
    }
    public void Commit(){
        if(connection!=null){
            try {
                connection.commit();
            } catch (SQLException ex) {
                System.out.println("Neuspesan commit");
                ex.printStackTrace();
            }
        }else{
            System.out.println("konekcija je prazna");
        }
    }
    public void Rollback(){
    if(connection!=null){
        try {
            connection.rollback();
        } catch (SQLException ex) {
            System.out.println("Greska je prilikom disconnecta");
            ex.printStackTrace();
            
        }
    }
    else {
        System.out.println("Konekcija je null ne moze da se rollbackuje");
        
    }
    
    }
    public void addNastavnik(Nastavnik nastavnik) throws SQLException{
        try {
            String query="Insert into nastavnik(ime,prezime,zvanje_id) values(?,?,?)";
            
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, nastavnik.getName());
            preparedStatement.setString(2, nastavnik.getLastname());
            preparedStatement.setInt(3, nastavnik.getZvanje().getId());
            int result=preparedStatement.executeUpdate();
            preparedStatement.close();
            if(result>0){
                System.out.println("sve je uspesno prikom dodavanja nastavnika, dodato je {result} nastavnik");
            Commit();
            }else{
                System.out.println("nastavnik nije dodat");
            }
        } catch (SQLException ex) {
            Rollback();
            System.out.println("Greska prilikom dodavanja nastavnika");
            throw ex;

        }
        finally{
            Disconnect();
        }
            
        
        
        
        
    }
    public List<Zvanje> GetAllZvanja(){
                    List<Zvanje> zvanja=new ArrayList<>();

        try {
            String query="select * from zvanje";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                zvanja.add(new Zvanje(resultSet.getInt(1), resultSet.getString(2)));
            }
            
            
            return zvanja;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return zvanja;
    }
    public List<Nastavnik> getAllNastavnik(){
                    List<Nastavnik> nastavnici=new ArrayList<>();

        try {
            String query="Select * from nastavnik as n inner join zvanje as z on n.zvanje_id=z.id order by z.naziv";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()) {                
                nastavnici.add(new Nastavnik(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                new Zvanje(resultSet.getInt("zvanje_id"), resultSet.getString("naziv"))));
                
            }
            System.out.println("Nastavnci ucitani preko joinovane tabele");
            return nastavnici;
            
        } catch (SQLException ex) {
            System.out.println("Greska prilikom konekcije!");
            ex.printStackTrace();
        }
        
        return nastavnici;
        
    }
    public void izbrisiNastavnika(Nastavnik nastavnik) {

        try {
            String query="Delete  from Nastavnik where id=?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, nastavnik.getId());
            int result=statement.executeUpdate();
            if(result==1){
                System.out.println("Moze se reci da je sve spremo za brisanje, ceka se commit...");
            }
            statement.close();
            Commit();
            System.out.println("commit uspesan! Nastavnik izbrisan!");
        } catch (SQLException ex) {
            System.out.println("Grska prilkom brisanja");    
            ex.printStackTrace();
            Rollback();
            System.out.println("Uspesan roolback");    

        }
        finally{
            Disconnect();
        }
                
        
        
        
    }
    public void updateNastavnici(Nastavnik nastavnik) {
        try {
            String query="update nastavnik set ime=?, prezime=?,zvanje_id=? where id=?";
            PreparedStatement statment=connection.prepareStatement(query);
            statment.setString(1, nastavnik.getName());
            statment.setString(2, nastavnik.getLastname());
            statment.setInt(3, nastavnik.getZvanje().getId());
            statment.setInt(4, nastavnik.getId());
            int res=statment.executeUpdate();
            if(res>0)Commit();
            System.out.println("Uspesan update");
            statment.close();
            JOptionPane.showMessageDialog(new Start(), "Nastavnik uspesno izmenjen");

        } catch (SQLException ex) {
            Rollback();
            System.out.println("Neuspesan update");
            JOptionPane.showMessageDialog(new Start(), "Nastavnik ne mode da se izmenni");

            ex.printStackTrace();
            
            
        }
        finally{
            Disconnect();
        }

    }
}
