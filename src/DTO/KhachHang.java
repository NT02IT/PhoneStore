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
public class KhachHang extends User{
    private String maKH, hoLot, ten, diaChi, SDT;
    DataTranferFor dt = new DataTranferFor("khachhang");
        
    public KhachHang() throws IOException {
        maKH = "KH" + dt.getMaxID();
    }

    public KhachHang(String hoLot, String ten, String diaChi, String SDT, String username, String pass) throws IOException {
        this.hoLot = hoLot;
        this.ten = ten;
        this.diaChi = diaChi;
        this.SDT = SDT;
        super.setUsername(username);
        super.setPassword(pass);
        super.setNhanVien(false);  
        maKH = "KH" + dt.getMaxID();
    }

    public String getMaKH() {
        return maKH;
    }

    public String getHoLot() {
        return hoLot;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setHoLot(String hoLot) {
        this.hoLot = hoLot;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
        
//    Test phương thức
//    public static void main(String[] args){
//        KhachHang kh = new KhachHang();
//        System.out.println(kh.maKH);
//        KhachHang kh2 = new KhachHang();
//        System.out.println(kh2.maKH);
//    }
}
