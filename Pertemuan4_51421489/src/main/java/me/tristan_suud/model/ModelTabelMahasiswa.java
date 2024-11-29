/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.tristan_suud.model;

/**
 *
 * @author LENOVO
 */
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModelTabelMahasiswa extends AbstractTableModel{
    private List<ModelMahasiswa> mahasiswaList;
    private String[] columnNames = {"ID", "NPM", "Nama", "Semester", "IPK"};
    
    public ModelTabelMahasiswa(List<ModelMahasiswa> mahasiswaList){
        this.mahasiswaList = mahasiswaList;
    }
    
    @Override
    public int getRowCount() {
        return mahasiswaList.size();
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelMahasiswa mahasiswa = mahasiswaList.get(rowIndex);
        
        switch (columnIndex){
            case 0:
                return mahasiswa.getId();
            case 1:
                return mahasiswa.getNpm();        
            case 2:
                return mahasiswa.getNama();
            case 3:
                return mahasiswa.getSemester();
            case 4:
                return mahasiswa.getIpk();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    public void setMahasiswaList(List<ModelMahasiswa> mahasiswaList){
        this.mahasiswaList = mahasiswaList;
        fireTableDataChanged();
        
    }
    
    
    
}
