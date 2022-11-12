/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.modelTable;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Nastavnik;
import model.Zvanje;

/**
 *
 * @author PC
 */
public class TableModel extends AbstractTableModel {

    List<Nastavnik> nastavnici;
    String[] colummns=new String[]{"Firs Name","Last Name","Zvanje"};
    Class[]classes=new Class[]{Object.class,Object.class,Object.class};
    
    
    
    @Override
    public int getRowCount() {
        return nastavnici.size();
    }

    @Override
    public int getColumnCount() {
        return colummns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Nastavnik nastavnik=nastavnici.get(rowIndex);
        switch (columnIndex) {
            case 0: return nastavnik.getName();
            case 1: return nastavnik.getLastname();
            case 2: return nastavnik.getZvanje().getNaziv();
                
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
            return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return colummns[column];
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
    
}
