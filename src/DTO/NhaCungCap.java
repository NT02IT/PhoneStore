/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author agond
 */
public class NhaCungCap {
    private static int soLuongNCC = 0;
    private int maNCC;
    private String tenNCC, diaChi, SDT;

    public NhaCungCap() {
        soLuongNCC++;
        maNCC += 100 + soLuongNCC;
    }

    public NhaCungCap(String tenNCC, String diaChi, String SDT) {
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.SDT = SDT;
        soLuongNCC++;
        maNCC += 100 + soLuongNCC;
    }  

    public static int getSoLuongNCC() {
        return soLuongNCC;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
}
