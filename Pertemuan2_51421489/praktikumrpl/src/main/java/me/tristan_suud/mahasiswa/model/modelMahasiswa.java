
package me.tristan_suud.mahasiswa.model;

/**
 *
 * @author LENOVO
 */
public class modelMahasiswa {
    private int id;
    private String nama;
    private String npm;
    private int semester;
    private float ipk;
    
    public modelMahasiswa(int id, String nama, String npm, int semester, float ipk){
        this.id = id;
        this.nama = nama;
        this.npm = npm;
        this.semester = semester;
        this.ipk = ipk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
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
    
}
