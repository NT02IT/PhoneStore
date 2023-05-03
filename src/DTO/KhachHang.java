/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author agond
 */
public class KhachHang {
    private static int soLuongKH = 0;
    private String maKH;
    private String hoLot;
    private String ten;
    private String diaChi;
    private String SDT;
    private String username;
    private String pass; 
    
    public KhachHang() {
        soLuongKH++;
        maKH = "KH" + soLuongKH;
    }

    public KhachHang(String hoLot, String ten, String diaChi, String SDT, String username, String pass) {
        this.hoLot = hoLot;
        this.ten = ten;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.username = username;
        this.pass = pass;
        soLuongKH++;
        maKH += 100 + soLuongKH;
    }

    public static int getSoLuongKH() {
        return soLuongKH;
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

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
        
//    Test phương thức
//    public static void main(String[] args){
//        KhachHang kh = new KhachHang();
//        System.out.println(kh.maKH);
//        KhachHang kh2 = new KhachHang();
//        System.out.println(kh2.maKH);
//    }
}
