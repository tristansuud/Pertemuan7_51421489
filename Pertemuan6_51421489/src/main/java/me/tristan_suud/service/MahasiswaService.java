/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.tristan_suud.service;
import me.tristan_suud.model.ModelMahasiswa;
import me.tristan_suud.repository.MahasiswaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author LENOVO
 */
@Service
public class MahasiswaService {
    @Autowired
    private MahasiswaRepository repository;
    
    public void addMhs(ModelMahasiswa mhs){
        repository.save(mhs);
    }
    public ModelMahasiswa getMhs(int id) {
        return repository.findById(id).orElse(null);
    }
    public void updateMahasiswa(ModelMahasiswa mhs){
        repository.save(mhs);
    }
    public void deleteMahasiswa(int id){
        repository.deleteById(id);
    }
    public List<ModelMahasiswa> getAllMahasiswa(){
        return repository.findAll();
    }
}
