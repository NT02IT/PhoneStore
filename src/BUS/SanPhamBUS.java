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
    
    public SanPham getSanPhamByID(String maSP){
        for (SanPham sp : list){
            if(maSP.equals(sp.getMaSP())){
                return sp;
            }
        }
        return null;
    }
    
    public ArrayList<SanPham> getListSanPhamByName(String searchKeyword){
        searchKeyword = searchKeyword.toLowerCase();
        ArrayList<SanPham> kq = new ArrayList<>();
        for(SanPham sp : list){
            String name = sp.getTenSP().toLowerCase();
            if(name.contains(searchKeyword)){
                kq.add(sp);
            }
        }
        if(kq.isEmpty()){
            return null;
        } else return kq;
    }
    
    //Hàm trả về list được sắp xếp từ A-Z
    public ArrayList<SanPham> sortList_A_to_Z(){
        Collections.sort(list, new StringFirstLetterAscendingComparator());
        return list;
    }
    
    //Hàm trả về list được sắp xếp từ Z-A
    public ArrayList<SanPham> sortList_Z_to_A(){
        Collections.sort(list, new StringFirstLetterDescendingComparator());
        return list;
    }
}

//Hàm sắp xếp tên sản phẩm từ A-Z
class StringFirstLetterAscendingComparator implements Comparator<SanPham> {
    @Override
    public int compare(SanPham o1, SanPham o2) {
        char firstLetter1 = o1.getTenSP().charAt(0);
        char firstLetter2 = o2.getTenSP().charAt(0);
        return Character.compare(firstLetter1, firstLetter2);
    }
}

//Hàm sắp xếp tên sản phẩm từ Z-A
class StringFirstLetterDescendingComparator implements Comparator<SanPham> {
    @Override
    public int compare(SanPham o1, SanPham o2) {
        char firstLetter1 = o1.getTenSP().charAt(0);
        char firstLetter2 = o2.getTenSP().charAt(0);
        return Character.compare(firstLetter2, firstLetter1);
    }
}
