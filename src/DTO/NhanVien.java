/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author agond
 */
public class NhanVien {
    private static int soLuongNV = 0;
    private int luong; // luong/thang
    private String maNV, ten, hoLot, diaChi, username, pass;

    public NhanVien() {
        soLuongNV++;
        maNV = "NV" + soLuongNV;
    }

    public NhanVien(int luong, String ten, String hoLot, String diaChi, String username, String pass) {
        this.luong = luong;
        this.ten = ten;
        this.hoLot = hoLot;
        this.diaChi = diaChi;
        this.username = username;
        this.pass = pass;
        soLuongNV++;
        maNV = "NV" + soLuongNV;
    }

    public static int getSoLuongNV() {
        return soLuongNV;
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

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
