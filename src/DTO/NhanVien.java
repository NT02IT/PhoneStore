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
    private int maNV, luong; // luong/thang
    private String ten, hoLot, diaChi;

    public NhanVien() {
        soLuongNV++;
        maNV += 1000 + soLuongNV;
    }

    public NhanVien(int luong, String ten, String hoLot, String diaChi) {
        this.luong = luong;
        this.ten = ten;
        this.hoLot = hoLot;
        this.diaChi = diaChi;
        soLuongNV++;
        maNV += 1000 + soLuongNV;
    }

    public static int getSoLuongNV() {
        return soLuongNV;
    }

    public int getMaNV() {
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

    public void setMaNV(int maNV) {
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
    
}
