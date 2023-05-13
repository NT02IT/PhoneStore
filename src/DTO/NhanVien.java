/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.IOException;

/**
 *
 * @author agond
 */
public class NhanVien{
    private String maNV, ten, hoLot, diaChi, SDT;
    private int luong; // luong/thang
    private String username, password;
    private boolean nhanVien;

    public NhanVien() throws IOException {
    }

    public NhanVien(int luong, String ten, String hoLot, String diaChi, String SDT, String username, String pass) throws IOException {
        this.luong = luong;
        this.ten = ten;
        this.hoLot = hoLot;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.username = username;
        this.password = pass;
        this.nhanVien = true;
    }

    public String getMaNV() {
        return maNV;
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

    public int getLuong() {
        return luong;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isNhanVien() {
        return nhanVien;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
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

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNhanVien(boolean nhanVien) {
        this.nhanVien = nhanVien;
    }
        
}
