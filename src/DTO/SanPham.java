/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author agond
 */
public class SanPham {
    private static int tongSLhang = 0; // Không kể loại sản phẩm 
    private int soLuong, donGia;
    private String maSP, maLoai, tenSP, donViTinh;

    public SanPham() {
        tongSLhang++;
        maSP = "SP" + tongSLhang;
    }

    public SanPham(int soLuong, int donGia, String maLoai, String tenSP, String donViTinh) {
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.maLoai = maLoai;
        this.tenSP = tenSP;
        this.donViTinh = donViTinh;
        tongSLhang++;
        maSP = "SP" + tongSLhang;
    }

    public static int getTongSLhang() {
        return tongSLhang;
    }

    public String getMaSP() {
        return maSP;
    }

    public int getSoLuong() {
        return soLuong;
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

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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
