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
import Connection.MyConnection;
import DTO.CT_SanPham;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author duong
 */
public class SanPhamBUS {
    private ArrayList<SanPham> list;    
    private int soLuong = 0;
    private SanPhamDAO spDAO;
   
    public SanPhamBUS() throws IOException, ClassNotFoundException, SQLException{
        MyConnection myConn = new MyConnection();
        spDAO = new SanPhamDAO();
        this.list = new ArrayList<>(spDAO.getList());
    }

    public ArrayList<SanPham> getList() {
        return list;
    }

    public int getSoLuong() {
        soLuong = SanPhamDAO.getSoLuong();
        return soLuong;
    }

    public boolean write(SanPham data) throws IOException{
        if(spDAO.write(data)){
            list.add(data);
            return true;
        } else return false;     
    }
    
    public boolean delete(SanPham data){
        String maSP = data.getMaSP();
        for (SanPham sp : list){
            if(sp.getMaSP().equals(maSP)){
                if(spDAO.delete(data)){
                    list.remove(searchIndexByID(data.getMaSP()));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean update(SanPham data){
        String maSP = data.getMaSP();
        for (SanPham sp : list){
            if(sp.getMaSP().equals(maSP)){
                if(spDAO.update(data)){
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
    
    public String getTenSPbyMaSP(String maSP){
        for (SanPham sp : list){
            if(maSP.equals(sp.getMaSP()))
                return sp.getTenSP();
        }
        return null;
    }
    
    public int getDonGiabyMaSP(String maSP){
        for (SanPham sp : list){
            if(maSP.equals(sp.getMaSP())){
                return sp.getDonGia();
            }
        }
        return -1;
    }
    
    public SanPham getSanPhamByIndex (int Index){
        return list.get(Index);
    }
    
    public int getSoLuongKCbyID(String maSP){
        for (SanPham sp : list){
            if(maSP.equals(sp.getMaSP())){
                return sp.getSLKhachChon();
            }
        }
        return -1;    
    }
    
    public void setSLSanPhamKC (int index, int SL){ // Truyền vào vị trí trong list
        SanPham sp = this.getSanPhamByIndex(index); // tìm sản phẩm trong list ở vị trí index
        sp.setSLKhachChon(SL);
    }
    
    public SanPham getSanPhamByID(String maSP){
        for (SanPham sp : list){
            if(maSP.equals(sp.getMaSP())){
                return sp;
            }
        }
        return null;
    }
    public int TongTien(ArrayList<CT_SanPham> listCT){
        int sum = 0;
        for (CT_SanPham ctsp : listCT){
            String maSP = ctsp.getMaSP();
            SanPham sp = getSanPhamByID(maSP);
            int donGia = sp.getDonGia();
            int SL = sp.getSLKhachChon();
            
            sum += donGia*SL;
        }
        return sum;
}
