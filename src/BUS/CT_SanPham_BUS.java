/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.CT_SanPham;
import DAO.CT_SanPham_DAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
/**
 *
 * @author duong
 */
public class CT_SanPham_BUS {
    private ArrayList<CT_SanPham> ctsanpham;
    private CT_SanPham_DAO ct_sanpham;
    
    public CT_SanPham_BUS() throws ClassNotFoundException, SQLException, IOException{
        this.ct_sanpham = new CT_SanPham_DAO();
        readCT_SANPHAM();
    }
    
    public void readCT_SANPHAM() throws IOException{
        this.ctsanpham = ct_sanpham.readData();
    }
    
    //Hàm thêm chi tiết sản phẩm
    public boolean addCT_SANPHAM_BUS(CT_SanPham ctsp){
        ctsanpham.add(ctsp);
        if(ct_sanpham.writeData(ctsp) == true){
            return true;
        } else return false;
    }
    
    //Hàm xóa chi tiết sản phẩm
    public boolean deleteCT_SANPHAM_BUS(String ma){
        ma = ma.trim().toLowerCase();
        for(CT_SanPham ct : ctsanpham){
            if(ct.getMaSP().trim().toLowerCase().equals(ma)){
                ctsanpham.remove(ct);
                if(ct_sanpham.deleteData(ma) == true){
                    return true;
                }
            }
        }
        return false;
    }
    
    //Hàm sửa chi tiết sản phẩm
    public boolean updateCT_SANPHAM_BUS(CT_SanPham ctsp){
        String ma = ctsp.getMaSP();
        int i=0;
        ma = ma.trim().toLowerCase();
        for(CT_SanPham ct : ctsanpham){
            if(ct.getMaSP().trim().toLowerCase().equals(ma)){
                ctsanpham.set(i, ctsp);
                if(ct_sanpham.updateData(ctsp) == true){
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}
