/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author agond
 */
public class CT_HoaDon {
    // MaSP, MaHoaDon, DonGia, SoLuong, ThanhTien
    private int maSP, maHoaDon, donGia, soLuong, thanhTien;

    public CT_HoaDon() {
    }

    public CT_HoaDon(int maSP, int maHoaDon, int donGia, int soLuong, int thanhTien) {
        this.maSP = maSP;
        this.maHoaDon = maHoaDon;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public int getMaSP() {
        return maSP;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public int getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
    
}
