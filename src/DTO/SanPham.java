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
    private int SLTrongKho, SLKhachChon = 0, donGia;
    private String maSP, maLoai, maHang, tenSP, donViTinh, loaiSP, hangSX, moTaSP;
    ID dt = new ID("sanpham");

    public SanPham() throws IOException {
        maSP = "SP" + dt.getMax();
    }

    public SanPham(int SLTrongKho, int donGia, String tenSP, String donViTinh, String loaiSP, String hangSX, String moTaSP) throws IOException {
        this.SLTrongKho = SLTrongKho;
        this.donGia = donGia;
        this.tenSP = tenSP;
        this.donViTinh = donViTinh;
        this.loaiSP = loaiSP;
        this.hangSX = hangSX;
        this.moTaSP = moTaSP;
        maSP = "SP" + dt.getMax();
    }

    public String getMaSP() {
        return maSP;
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

    public String getMaLoai() {
        return maLoai;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public String getMaHang() {
        return maHang;
    }
    
    public String getHangSX() {
        return hangSX;
    }

    public String getMoTaSP() {
        return moTaSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
    
    public void setMoTaSP(String moTaSP) {
        this.moTaSP = moTaSP;
    }
    
    public void setMaSP(String maSP) {
        this.maSP = maSP;
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
