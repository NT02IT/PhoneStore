/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.Loai_SP;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAO.LoaiSanPhamDAO;
import java.sql.SQLException;

/**
 *
 * @author duong
 */
public class LOAI_SP_BUS {
    private ArrayList<Loai_SP> loaisp;
    private LoaiSanPhamDAO loaisp_DAO;
    
    public LOAI_SP_BUS() throws IOException, SQLException, ClassNotFoundException{
        this.loaisp_DAO = new LoaiSanPhamDAO();
        readLOAI_SP_BUS();
    }
    
    public void readLOAI_SP_BUS(){
        try {
            this.loaisp = loaisp_DAO.readData();
        } catch (IOException ex) {
            Logger.getLogger(LOAI_SP_BUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Hàm thêm loại sản phẩm
    public boolean addLOAI_SP_BUS(Loai_SP data){
        loaisp.add(data);
        if(loaisp_DAO.writeData(data) == true){
            return true;
        }
        return false;
    }
    
    //Hàm xóa loại sản phẩm
    public boolean deleteLOAI_SP_BUS(String ma){
        ma = ma.trim().toLowerCase();
        for(Loai_SP loai : loaisp){
            if(loai.getMaLoai().trim().toLowerCase().equals(ma)){
                loaisp.remove(loai);
                if(loaisp_DAO.deleteData(ma) == true){
                    return true;
                }
            }
        }
        return false;
    }
    
    //Hàm sửa loại sản phẩm
    public boolean updateLOAI_SP_BUS(Loai_SP data){
        String ma = data.getMaLoai();
        int i=0; 
        ma = ma.trim().toLowerCase();
        for(Loai_SP loai : loaisp){
            if(loai.getMaLoai().trim().toLowerCase().equals(ma)){
                loaisp.set(i, data);
                if(loaisp_DAO.updateData(data) == true){
                    return true;
                }
            }
        }
        return false;
    }
}
