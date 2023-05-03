/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author agond
 */
public class HoaDon {
    private static int soLuongHD = 0;
    private int maHD, maNV, maKH, tongTien, tienGiam, conLai; // conLai = tongTien - tienGiam
    private String ngayLap;

    public HoaDon() {
        soLuongHD++;
        maHD += 1000 + soLuongHD;
    }

    public HoaDon(int maNV, int maKH, int tongTien, int tienGiam, String ngayLap) {
        this.maNV = maNV;
        this.maKH = maKH;
        this.tongTien = tongTien;
        this.tienGiam = tienGiam;
        this.ngayLap = ngayLap;
        this.conLai = tongTien - tienGiam;
        soLuongHD++;
        maHD += 1000 + soLuongHD;
    }

    public static int getSoLuongHD() {
        return soLuongHD;
    }
        
    public int getMaHD() {
        return maHD;
    }

    public int getMaNV() {
        return maNV;
    }

    public int getMaKH() {
        return maKH;
    }

    public int getTongTien() {
        return tongTien;
    }

    public int getTienGiam() {
        return tienGiam;
    }

    public int getConLai() {
        return conLai;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public void setTienGiam(int tienGiam) {
        this.tienGiam = tienGiam;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }
        
}
