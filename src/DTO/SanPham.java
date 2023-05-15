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
public class SanPham{
    private int SLTrongKho, donGia;
    private int SLKhachChon = 0;
    private String maSP, maLoai, tenSP, donViTinh;
    
    public SanPham() {
    }

    public SanPham(int SLTrongKho, int donGia, String maSP, String maLoai, String tenSP, String donViTinh) {
        this.SLTrongKho = SLTrongKho;
        this.donGia = donGia;
        this.maSP = maSP;
        this.maLoai = maLoai;
        this.tenSP = tenSP;
        this.donViTinh = donViTinh;
    }

    public int getSLTrongKho() {
        return SLTrongKho;
    }

    public int getSLKhachChon() {
        return SLKhachChon;
    }

    public int getDonGia() {
        return donGia;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setSLTrongKho(int SLTrongKho) {
        this.SLTrongKho = SLTrongKho;
    }

    public void setSLKhachChon(int SLKhachChon) {
        this.SLKhachChon = SLKhachChon;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
    
}
