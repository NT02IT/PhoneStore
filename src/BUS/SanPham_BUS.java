/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.SanPham;
import DAO.SanPhamDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author duong
 */
public class SanPham_BUS {
    private ArrayList <SanPham> sanpham;
    private SanPhamDAO sanpham_DAO;
    
    public SanPham_BUS() throws IOException, ClassNotFoundException, SQLException{
        this.sanpham_DAO = new SanPhamDAO();
        readSANPHAM_BUS();
    }
    
    //Hàm đọc sản phẩm khi khởi chạy chương trình
    public void readSANPHAM_BUS() throws IOException{
        this.sanpham = sanpham_DAO.readData();
    }
    
    //Hàm thêm sản phẩm
    public boolean addSANPHAM_BUS(SanPham sp){
        sanpham.add(sp);
        if(sanpham_DAO.writeData(sp) == true){
            return true;
        } else return false;
    }
    
    //Hàm xóa sản phẩm
    public boolean deleteSANPHAM_BUS(String ma){
        ma = ma.trim().toLowerCase();
        for(SanPham s : sanpham){
            if(s.getMaSP().trim().toLowerCase().equals(ma)){
                sanpham.remove(s);
                if(sanpham_DAO.deleteData(ma) == true){
                    return true;
                }
            }
        }
        return false;
    }
    
    //Hàm sửa sản phẩm
    public boolean updateSANPHAM_BUS(SanPham sp){
        String ma = sp.getMaSP();
        int i=0;
        ma = ma.trim().toLowerCase();
        for(SanPham s : sanpham){
            if(s.getMaSP().trim().toLowerCase().equals(ma)){
                sanpham.set(i, sp);
                if(sanpham_DAO.updateData(sp) == true){
                    return true;
                } 
            }
            i++;
        }
        return false;
    }
}
