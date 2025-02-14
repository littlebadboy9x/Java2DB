/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Domain;

/**
 *
 * @author Tran Viet Vuong
 */
public class GiangVien {
    private String ma, ten, loai;
    private int tuoi, bac;
    private int gioiTinh;

    public GiangVien() {
    }

    public GiangVien(String ma, String ten, String loai, int tuoi, int bac, int gioiTinh) {
        this.ma = ma;
        this.ten = ten;
        this.loai = loai;
        this.tuoi = tuoi;
        this.bac = bac;
        this.gioiTinh = gioiTinh;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getGioiTinhToString(){
        return gioiTinh == 1 ? "Nam" : "Nữ";
    }

    @Override
    public String toString() {
        return "GiangVien{" + "ma=" + ma + ", ten=" + ten + ", loai=" + loai + ", tuoi=" + tuoi + ", bac=" + bac + ", gioiTinh=" + gioiTinh + '}';
    }
    
    public Object toDataRow(){
        return new Object[]{
            ma, ten, tuoi, bac, gioiTinh == 1 ? "Nam" : "Nữ"
        };
    }
    
}
