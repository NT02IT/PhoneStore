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
public class HoaDon{
    private int tongTien, tienGiam, conLai; // conLai = tongTien - tienGiam
    private String maHD, maNV, maKH, ngayLap;
    ID dt = new ID("hoadon");

    public HoaDon() throws IOException {
        maHD = "HD" + dt.getMax();
    }

    public HoaDon(String maNV, String maKH, int tongTien, int tienGiam, String ngayLap) throws IOException {
        maHD = "HD" + dt.getMax();
        this.maNV = maNV;
        this.maKH = maKH;
        this.tongTien = tongTien;
        this.tienGiam = tienGiam;
        this.ngayLap = ngayLap;
        this.conLai = tongTien - tienGiam;        
    }
        
    public String getMaHD() {
        return maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMaKH() {
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

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setMaKH(String maKH) {
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

    public void setConLai(int conLai) {
        this.conLai = conLai;
    }
        
}
