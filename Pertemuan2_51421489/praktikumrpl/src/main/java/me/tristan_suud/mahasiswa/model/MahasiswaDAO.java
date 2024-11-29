/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.tristan_suud.mahasiswa.model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class MahasiswaDAO {
    private Connection connection;
    
    public MahasiswaDAO(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc_51421489", "root", "");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean checkConnection(){
        try {
            if (connection != null && !connection.isClosed()){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public void closeConnection(){
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void addMahasiswa(modelMahasiswa mahasiswa){
        String sql = "INSERT INTO mahasiswa (npm, nama, semester, ipk) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, mahasiswa.getNpm());
            pstmt.setString(2, mahasiswa.getNama());
            pstmt.setInt(3, mahasiswa.getSemester());
            pstmt.setFloat(4, mahasiswa.getIpk());
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public List<modelMahasiswa> getAllMahasiswa(){
        List<modelMahasiswa> mahasiswaList = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                mahasiswaList.add(new modelMahasiswa(
                        rs.getInt("id"),
                        rs.getString("npm"),
                        rs.getString("nama"),
                        rs.getInt("semester"),
                        rs.getFloat("ipk")));
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return mahasiswaList;
    }
    public void updateMahasiswa(modelMahasiswa mahasiswa){
        String sql = "UPDATE mahasiswa SET npm = ?, nama = ?, semester = ?, ipk = ? where id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, mahasiswa.getNpm());
            pstmt.setString(2, mahasiswa.getNama());
            pstmt.setInt(3, mahasiswa.getSemester());
            pstmt.setFloat(4, mahasiswa.getIpk());
            pstmt.setInt(5, mahasiswa.getId());
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteMahasiswa(int id){
        String sql = "DELETE FROM mahasiswa WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
