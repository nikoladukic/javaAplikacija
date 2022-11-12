/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.modelTable;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import model.Nastavnik;
import model.Zvanje;

/**
 *
 * @author PC
 */
public class TableModelZaSinhronizacija extends  AbstractTableModel{
    public boolean  flag=false;
    public TableModelZaSinhronizacija() {
    }

    List<Nastavnik> nastavnici;
    String []columns=new String[]{"Ime","Prezime","Zvanje"};
    Class[] classes=new Class[]{Object.class,Object.class,Object.class};
    @Override
    public int getRowCount() {
            return nastavnici.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Nastavnik nastavnik=nastavnici.get(rowIndex);
        switch (columnIndex) {
            case 0: return nastavnik.getName();
            case 1: return nastavnik.getLastname();
            case 2:if(nastavnik.getZvanje()!=null){
                     return nastavnik.getZvanje().getNaziv();
            }else return null;
            default:
                return "n/a";
        }    
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            
        Nastavnik nastavnik=nastavnici.get(rowIndex);
        
        switch (columnIndex) {
            case 0: nastavnik.setName((String)(aValue)); break; 
            case 1: nastavnik.setLastname((String)(aValue));break;
            case 2: nastavnik.setZvanje((Zvanje)(aValue));break;
                
            default:
                throw new AssertionError();
        }

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
       
        if(nastavnici.get(rowIndex)==null||nastavnici.get(rowIndex).getName()==""||nastavnici.get(rowIndex).getName()==null){
            return true;
        }
         if(nastavnici.get(rowIndex)==null||nastavnici.get(rowIndex).getLastname()==""||nastavnici.get(rowIndex).getLastname()==null){
            return true;
        }
         if(nastavnici.get(rowIndex)==null||nastavnici.get(rowIndex).getZvanje()==null){
            return true;
        }
         
        for (int i = 0; i < getRowCount(); i++) {
            for (int j = 0; j < getColumnCount(); j++) {
                if(i==rowIndex && j==columnIndex && j==2){
                    return false;
                }
                
                }
            }
        int i=0;
        for (Nastavnik nastavnik : nastavnici) {
            if(nastavnik.getZvanje()!=null){
             if(nastavnik.getZvanje().getId()!=5 && rowIndex==i){
                return false;
                }
            }
            i++;
            
            
        }
        
        
        return true;
       
       
       
          
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public List getAllNastavnici(){
        return nastavnici;
    }
    
    public void addNastacnik(Nastavnik nastavnik){
        nastavnici.add(nastavnik);
        fireTableDataChanged();
    }
    public void removeNastavnik(int index){
        nastavnici.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public TableModelZaSinhronizacija(List<Nastavnik> nastavnici) {
        this.nastavnici = nastavnici;
    }
   
   
    
    
    
}
