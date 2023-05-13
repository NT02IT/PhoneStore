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
public class KhachHang{
    private String maKH, ten, hoLot, diaChi, SDT, username, password;
    private boolean nhanVien;
        
    public KhachHang() throws IOException {
    }

    public KhachHang(String ten, String hoLot, String diaChi, String SDT, String username, String pass) throws IOException { 
        this.ten = ten;
        this.hoLot = hoLot;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.username = username;
        this.password = pass;
        nhanVien = false;
    }
    
    public String getMaKH() {
        return maKH;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isNhanVien() {
        return nhanVien;
    }
    
    public void setMaKH(String maKH) {
        this.maKH = maKH;
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
