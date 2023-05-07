/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author agond
 */
public class CT_PhieuNhap {
    private int maSP; // MaSP
    private int maPN; // MaPN
    private int soLuong; // SoLuong
    private int thanhTien; // ThanhTien
    private int donGiaNhap; // DonGiaNhap
    
    public CT_PhieuNhap(){
    }

    public CT_PhieuNhap(int maSP, int maPN, int soLuong, int thanhTien, int donGiaNhap) {
        this.maSP = maSP;
        this.maPN = maPN;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.donGiaNhap = donGiaNhap;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setDonGiaNhap(int donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public int getMaSP() {
        return maSP;
    }

    public int getMaPN() {
        return maPN;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public int getDonGiaNhap() {
        return donGiaNhap;
    }
}
