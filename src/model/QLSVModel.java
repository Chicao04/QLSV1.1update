package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class QLSVModel {
    private ArrayList<SinhVien> dsSinhVien;
    private String luaChon;
    public QLSVModel() {
        this.dsSinhVien = new ArrayList<SinhVien>();
    }
    public QLSVModel(ArrayList<SinhVien> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
        this.luaChon= "";
    }
    public ArrayList<SinhVien> getDsSinhVien() {
        return dsSinhVien;
    }
    public void setDsSinhVien(ArrayList<SinhVien> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
    }
    public void insert(SinhVien sinhVien) {
        this.dsSinhVien.add(sinhVien);
    }
    public void delete(SinhVien sinhVien) {
        this.dsSinhVien.remove(sinhVien);
    }
    public void update(SinhVien sinhVien) {
        this.dsSinhVien.remove(sinhVien);
        this.dsSinhVien.add(sinhVien);
    }
    public String getLuaChon() {
        return luaChon;
    }
    public void setLuaChon(String luaChon) {
        this.luaChon = luaChon;
    }
    public boolean kiemTraTonTai(SinhVien sv) {
        for(SinhVien sinhVien:dsSinhVien) {
            if(sinhVien.getId() ==sv.getId())
                return true;
        }
        return false;
    }
    public void sapXepSinhVienGiamtheodiem() {
        Collections.sort(this.dsSinhVien,new Comparator<SinhVien>(){

            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                return Double.compare(sv2.getGpa(),sv1.getGpa());
            }

        });
    }

    public void sapXepSinhVienGiamtheoten() {
        Collections.sort(this.dsSinhVien,new Comparator<SinhVien>() {

            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                return sv1.getName().compareToIgnoreCase(sv2.getName());
            }

        });
    }
}
