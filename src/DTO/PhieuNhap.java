/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author agond
 */
public class PhieuNhap {
    private static int soLuongPN = 0;
    private int maPN, tongTien, maNCC, maNV;
    private String ngayLap;

    public PhieuNhap() {
        soLuongPN++;
        maPN += 1000 + soLuongPN;
    }

    public PhieuNhap(int tongTien, int maNCC, int maNV, String ngayLap) {
        this.tongTien = tongTien;
        this.maNCC = maNCC;
        this.maNV = maNV;
        this.ngayLap = ngayLap;
        soLuongPN++;
        maPN += 1000 + soLuongPN;
    }

    public static int getSoLuongPN() {
        return soLuongPN;
    }

    public int getMaPN() {
        return maPN;
    }

    public int getTongTien() {
        return tongTien;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public int getMaNV() {
        return maNV;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }
    
}
