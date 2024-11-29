/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.tristan_suud.mahasiswa.controller;
import me.tristan_suud.mahasiswa.model.MahasiswaDAO;
import me.tristan_suud.mahasiswa.model.modelMahasiswa;
import java.util.List;


/**
 *
 * @author LENOVO
 */
public class MahasiswaController {
    private MahasiswaDAO mahasiswaDAO;
    
    public MahasiswaController(MahasiswaDAO mahasiswaDAO){
        this.mahasiswaDAO = mahasiswaDAO;
    }
    
    public void displayMahasiswaList(List<modelMahasiswa> mahasiswaList){
        if (mahasiswaList.isEmpty()){
            System.out.println("Tidak ada data mahasiswa");
        } else {
            System.out.println("");
            System.out.println("===================");
            for (modelMahasiswa m: mahasiswaList){
                System.out.println("ID          : " + m.getId());
                System.out.println("NPM         : " + m.getNpm());
                System.out.println("NAMA        : " + m.getNama());
                System.out.println("SEMESTER    : " + m.getSemester());
                System.out.println("IPK         : " + m.getIpk());
                System.out.println("------------------");
            }
        }
        System.out.println("===================");
    }
    
    public void displayMessage(String message){
        System.out.println(message);
    }
    
    public void checkDatabaseConnection(){
        boolean isConnected = mahasiswaDAO.checkConnection();
        if (isConnected) {
            displayMessage("Koneksi berhasil");
        } else {
            displayMessage("Koneksi Gagal");
        }
    }
    
    public void displayAllMahasiswa(){
        List<modelMahasiswa> mahasiswaList = mahasiswaDAO.getAllMahasiswa();
        displayMahasiswaList(mahasiswaList);
    }
    
    public void addMahasiswa(String npm, String nama, int semester, float ipk){
        modelMahasiswa mahasiswaBaru = new modelMahasiswa(0, npm, nama, semester, ipk);
        System.out.println("Controller Data: " + npm + nama + semester + ipk);
        System.out.println(mahasiswaBaru);
        mahasiswaDAO.addMahasiswa(mahasiswaBaru);
        displayMessage("Mahasiswa telah ditambahkan");
    }
    public void updateMahasiswa(int id, String npm, String nama, int semester, float ipk){
        modelMahasiswa mahasiswaTarget = new modelMahasiswa(id, nama, npm, semester, ipk);
        mahasiswaDAO.updateMahasiswa(mahasiswaTarget);
        displayMessage("Mahasiswa telah diperbaharui");
    }
    public void deleteMahasiswa(int id){
        mahasiswaDAO.deleteMahasiswa(id);
        displayMessage("Mahasiswa telah dihapus");
    }
    public void closeConnection() {
        mahasiswaDAO.closeConnection();
    }
}
