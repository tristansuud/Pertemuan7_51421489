/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.tristan_suud.controller;

import me.tristan_suud.model.ModelMahasiswa;
import me.tristan_suud.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
/**
 *
 * @author LENOVO
 */
@Controller
public class MahasiswaController {
    
    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    public void tampilkanMenu() {
        Scanner scanner = new Scanner(System.in);
        int opsi;
        
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan mahasiswa");
            System.out.println("2. Tambahkan mahasiswa baru");
            System.out.println("3. Cek koneksi");
            System.out.println("4. Keluar");
            System.out.println("Pilih Opsi");
            opsi = scanner.nextInt();
            scanner.nextLine();
            
            switch (opsi) {
                    case 1:
                        tampilkanSemuaMahasiswa();
                        break;
                    case 2:
                        tambahMahasiswa(scanner);
                        break;
                    case 3:
                        cekKoneksi();
                        break;
                    case 4:
                        System.out.println("Keluar dari program");
                        break;
                    default:
                        System.out.println("Opsi tidak valid");
            }
        } while (opsi != 4);
    }
    
    private void tampilkanSemuaMahasiswa() {
        List<ModelMahasiswa> mahasiswaList = mahasiswaRepository.findAll();
        if (mahasiswaList.isEmpty()){
            System.out.println("Tidak ada data mahasiswa");
        } else {
            mahasiswaList.forEach(mahasiswa -> System.out.println(mahasiswa));
        }
    }
    private void tambahMahasiswa(Scanner scanner) {
        System.out.println("Masukkan NPM");
        String npm = scanner.nextLine();
        System.out.println("Masukkan nama");
        String nama = scanner.nextLine();
        System.out.println("Masukkan Semester");
        int semester = scanner.nextInt();
        System.out.println("Masukkan IPK");
        float ipk = scanner.nextFloat();
        
        ModelMahasiswa mahasiswa = new ModelMahasiswa(0, npm, nama, semester, ipk);
        mahasiswaRepository.save(mahasiswa);
    }
    
    private void cekKoneksi(){
        try {
            mahasiswaRepository.findAll();
            System.out.println("Koneksi berhasil");
        } catch (Exception e) {
            System.out.println("Gagal terhubung ke database.");
        }
    }
}
