/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author agond
 */
public class CT_KhuyenMai {
    private String maKM, tenKM;
    private Date ngayBD;
    private Date ngayKT;
    private int phanTramGiam;
    SimpleDateFormat dateFormat;

    public CT_KhuyenMai() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public CT_KhuyenMai(String maKM, String tenKM, Date ngayBD, Date ngayKT, int phanTramGiam) {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.phanTramGiam = phanTramGiam;
    }
    
    public CT_KhuyenMai(String maKM, String tenKM, String ngayBD, String ngayKT, int phanTramGiam) {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.maKM = maKM;
        this.tenKM = tenKM;
        java.sql.Date sqlDateBD = java.sql.Date.valueOf(ngayBD);
        this.ngayBD = sqlDateBD;
        java.sql.Date sqlDateKT = java.sql.Date.valueOf(ngayKT);
        this.ngayKT = sqlDateKT;
        this.phanTramGiam = phanTramGiam;
    }

    public String getMaKM() {
        return maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

//    public void setNgayBD(String ngayBD) throws ParseException {   
//        java.sql.Date sqlDateBD = java.sql.Date.valueOf(ngayBD);
//        //java.util.Date utilDateBD = new java.util.Date(sqlDateBD.getTime());
//        this.ngayBD = sqlDateBD;
//    }
//
//    public void setNgayKT(String ngayKT) throws ParseException {
//        java.sql.Date sqlDateKT = java.sql.Date.valueOf(ngayKT);
//        //java.util.Date utilDateKT = new java.util.Date(sqlDateKT.getTime());
//        this.ngayKT = sqlDateKT;
//    }
    
    public void setNgayBD(String ngayBD) throws ParseException {
        Date parseDate = (Date) dateFormat.parse(ngayBD);
        java.sql.Date sqlDateBD = new java.sql.Date(parseDate.getTime());
        this.ngayBD = sqlDateBD;
    }
    
    public void setNgayKT(String ngayKT) throws ParseException {
        Date parseDate = (Date) dateFormat.parse(ngayKT);
        java.sql.Date sqlDateKT = new java.sql.Date(parseDate.getTime());
        this.ngayKT = sqlDateKT;
    }
    
    public void setNgayBD(Date ngayBD) throws ParseException {        
        this.ngayBD = ngayBD;
    }
    public void setNgayKT(Date ngayKT) throws ParseException {
        this.ngayKT = ngayKT;
    }
    
    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }
            
}
