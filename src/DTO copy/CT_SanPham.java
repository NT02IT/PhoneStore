/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author agond
 */
public class CT_SanPham {
    // MaSP, MaLoai, MaHang, MoTaSP
    private String maSP;
    private String maLoai;
    private String maHang;
    private String moTaSP;   

    public CT_SanPham() {
    }

    public CT_SanPham(String maSP, String maLoai, String maHang, String moTaSP) {
        this.maSP = maSP;
        this.maLoai = maLoai;
        this.maHang = maHang;
        this.moTaSP = moTaSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public void setMoTaSP(String moTaSP) {
        this.moTaSP = moTaSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getMoTaSP() {
        return moTaSP;
    }
}
