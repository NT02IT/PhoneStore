/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author agond
 */
public class CT_KhuyenMai {
    private int maKM, maHD, phanTramGiam;
    private String tenKM, ngayBD, ngayKT;

    public CT_KhuyenMai() {
    }

    public CT_KhuyenMai(int maKM, int maHD, int phanTramGiam, String tenKM, String ngayBD, String ngayKT) {
        this.maKM = maKM;
        this.maHD = maHD;
        this.phanTramGiam = phanTramGiam;
        this.tenKM = tenKM;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    public int getMaKM() {
        return maKM;
    }

    public int getMaHD() {
        return maHD;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public String getTenKM() {
        return tenKM;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }
        
}
