/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.CT_SanPham;
import DAO.CT_SanPhamDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.MyConnection;
import DTO.SanPham;

import java.util.ArrayList;

/**
 *
 * @author duong
 */
public class CT_SanPhamBUS {
    private ArrayList<CT_SanPham> list;    
    private int soLuong = 0;
    private CT_SanPhamDAO ctspDAO;
    
    public CT_SanPhamBUS() throws ClassNotFoundException, SQLException, IOException{
        MyConnection myConn = new MyConnection();
        ctspDAO = new CT_SanPhamDAO();
        this.list = new ArrayList<>(ctspDAO.getList());
    }

    public ArrayList<CT_SanPham> getList() {
        return list;
    }

    public int getSoLuong() {
        soLuong = CT_SanPhamDAO.getSoLuong();
        return soLuong;
    }

    public boolean write(CT_SanPham data) throws IOException{
        if(ctspDAO.write(data)){
            list.add(data);
            return true;
        } else return false;     
    }
    
    public boolean delete(CT_SanPham data){
        String maSP = data.getMaSP();
        for (CT_SanPham ctsp : list){
            if(ctsp.getMaSP().equals(maSP)){
                if(ctspDAO.delete(data)){
                    list.remove(searchIndexByID(data.getMaSP()));
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean update(CT_SanPham data){
        String maSP = data.getMaSP();
        for (CT_SanPham ctsp : list){
            if(ctsp.getMaSP().equals(maSP)){
                if(ctspDAO.update(data)){
                    list.set(searchIndexByID(data.getMaSP()), data);
                    return true;
                }
            }
        }        
        return false;
    }

    public int searchIndexByID(String ID) { // ID = MaSP
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaSP().equals(ID)) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public CT_SanPham getCTSPBySP(SanPham sp){
        for(CT_SanPham ctsp : list){
            if(ctsp.getMaSP().equals(sp.getMaSP())){
                return ctsp;
            }
        }
        return null;
    }
}
