/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.tristan_suud.controller;

/**
 *
 * @author LENOVO
 */
import me.tristan_suud.model.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class MahasiswaController {
    
    public void addMhs(ModelMahasiswa mhs){
        Transaction trx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            session.save(mhs);
            trx.commit();
            
        }   catch (Exception e) {
            if (trx != null) trx.rollback();
            e.printStackTrace();
        }
           
    }
    
    public void updateMhs(ModelMahasiswa mhs){
        Transaction trx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            session.update(mhs);
            trx.commit();
            
        }   catch (Exception e) {
            if (trx != null) trx.rollback();
            e.printStackTrace();
        }
    }
    public void deleteMhs(int id){
        Transaction trx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            ModelMahasiswa mhs = session.get(ModelMahasiswa.class, id);
            if (mhs != null){
                session.delete(mhs);
                System.out.println("Berhasil dihapus");
            }
            trx.commit();
            
        }   catch (Exception e) {
            if (trx != null) trx.rollback();
            e.printStackTrace();
        }
    }
    
    public List<ModelMahasiswa> getAllMahasiswa(){
        Transaction trx = null;
        List<ModelMahasiswa> listMhs = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            Query<ModelMahasiswa> query = session.createQuery("from ModelMahasiswa", ModelMahasiswa.class);
            listMhs = query.list();
            trx.commit();

        } catch (Exception e) {
            if (trx != null) trx.rollback();
            e.printStackTrace();
        }
        return listMhs;
    }
}
