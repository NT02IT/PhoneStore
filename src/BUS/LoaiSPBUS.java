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
public class LoaiSPBUS {
    private ArrayList<Loai_SP> list;    
    private int soLuong = 0;
    LoaiSanPhamDAO loaispDAO;
    
    public LoaiSPBUS() throws IOException, ClassNotFoundException, SQLException{
        loaispDAO = new LoaiSanPhamDAO();
        this.list = new ArrayList<>(loaispDAO.getList());
    }

    public ArrayList<Loai_SP> getList() {
        return list;
    }

    public int getSoLuong() {
        soLuong = LoaiSanPhamDAO.getSoLuong();
        return soLuong;
    }

    public boolean write(Loai_SP data){
        if (!checkUnique(data))
            return false; // Ten Loai bị trùng
        loaispDAO.write(data);
        list.add(data);
        return true; // Thêm thành công        
    }

    public boolean delete(Loai_SP data){
        String maLoai = data.getMaLoai().trim();
        for (Loai_SP loai : list){
            if(loai.getMaLoai().equals(maLoai)){
                if(loaispDAO.delete(data)){
                    list.remove(searchIndexByID(data.getMaLoai()));
                    return true;
                }
            }
        }
        return false;
    }

    //Làm 1 hàm xóa hàng loạt nhiều cái

    public boolean update(Loai_SP data){
        String maLoai = data.getMaLoai().trim();
        for (Loai_SP loai : list){
            if(loai.getMaLoai().equals(maLoai)){
                if(loaispDAO.update(data)){
                    list.set(searchIndexByID(data.getMaLoai()), data);
                    return true;
                }
            }
        }        
        return false;
    }

    public int searchIndexByID(String ID) { // ID = MaLoai
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaLoai().equals(ID)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int searchIndexByTenLoai(String tenLoai) {
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        String tempTenLoai;
        for(int i = 0; i < list.size(); i++){
            tempTenLoai = list.get(i).getTenLoai().trim();
            if (tempTenLoai.equals(tenLoai)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean checkUnique(Loai_SP data){
        if (searchIndexByTenLoai(data.getTenLoai()) >= 0)
            return false;
        return true;
    }
    
    public String getLoaiSPbyID(String maLoai){
        for (Loai_SP loai : list){
            if (maLoai.equals(loai.getMaLoai()))
                return loai.getTenLoai();
        }
        return null;
    }
}
