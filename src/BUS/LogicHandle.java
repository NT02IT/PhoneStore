/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.CT_SanPham;
import DTO.SanPham;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class LogicHandle {
    private int sum;
    SanPhamBUS spBUS;
    
    public LogicHandle() throws IOException, ClassNotFoundException, SQLException{
        spBUS = new SanPhamBUS();
    }
    
    public int TongTien(ArrayList<CT_SanPham> listCT){
        sum = 0;
        for (CT_SanPham ctsp : listCT){
            String maSP = ctsp.getMaSP();
            SanPham sp = spBUS.getSanPhamByID(maSP);
//            sp = spBUS.getSanPhamByID(maSP);
//            int donGia = spBUS.getDonGiabyMaSP(maSP);
//            int SL = spBUS.getSoLuongKCbyID(maSP);
            int donGia = sp.getDonGia();
            ArrayList<SanPham> list = spBUS.getList();
            int SL = sp.getSLKhachChon();
            
            sum += donGia*SL;
        }
        return sum;
    }
    
    
}
