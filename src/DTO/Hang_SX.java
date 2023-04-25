/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author duong
 */
public class Hang_SX {
    private String MaHang;
    private String TenHang;

    public Hang_SX(String MaHang, String TenHang) {
        this.MaHang = MaHang;
        this.TenHang = TenHang;
    }
    public Hang_SX(){
        
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }
    
}
