/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author agond
 */
public class NhanVien extends User{
    private int luong; // luong/thang
    private String maNV, ten, hoLot, diaChi, SDT;

    public NhanVien() {
        super.setNhanVien(true);
    }

    public NhanVien(String maNV, int luong, String ten, String hoLot, String diaChi, String SDT, String username, String pass) {
        this.maNV = maNV;
        this.luong = luong;
        this.ten = ten;
        this.hoLot = hoLot;
        this.diaChi = diaChi;
        this.SDT = SDT;
        super.setUsername(username);
        super.setPassword(pass);
        super.setNhanVien(true);
    }

    public String getMaNV() {
        return maNV;
    }

    public int getLuong() {
        return luong;
    }

    public String getTen() {
        return ten;
    }

    public String getHoLot() {
        return hoLot;
    }

    public String getDiaChi() {
        return diaChi;
    }
    
    public String getSDT() {
        return SDT;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setHoLot(String hoLot) {
        this.hoLot = hoLot;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
}
