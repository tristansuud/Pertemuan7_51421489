/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.tristan_suud.model;

import jakarta.persistence.*;
/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "mahasiswa")
public class ModelMahasiswa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "npm", nullable = false, length = 10)
    private String npm;
    
    @Column(name = "nama", nullable = false, length = 55)
    private String nama;
    
    @Column(name = "semester")
    private int semester;
            
    @Column(name = "ipk")
    private float ipk;
    
    public ModelMahasiswa(){
    
    }
    
    public ModelMahasiswa(int id, String npm, String nama, int semester, float ipk){
        this.id = id;
        this.npm = npm;
        this.nama = nama;
        this.semester = semester;
        this.ipk = ipk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public float getIpk() {
        return ipk;
    }

    public void setIpk(float ipk) {
        this.ipk = ipk;
    }
    
    @Override
    public String toString() {
        return "Mahasiswa" +
                "id=" + id +
                "npm='" + npm + '\'' +
                "nama='" + nama + '\'' +
                "semester='" + semester + '\'' +
                "ipk='" + ipk + '\'' + '}';
    }
}
