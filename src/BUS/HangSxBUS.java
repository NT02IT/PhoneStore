/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import java.io.IOException;
import java.util.ArrayList;
import DTO.Hang_SX;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAO.HangSxDAO;
import DTO.CT_SanPham;
import DTO.SanPham;
/**
 *
 * @author duong
 */
public class HangSxBUS {
    private ArrayList<Hang_SX> list;    
    private int soLuong = 0;
    HangSxDAO hangsxDAO;
       
    public HangSxBUS() throws IOException, ClassNotFoundException, SQLException{
        hangsxDAO = new HangSxDAO();
        this.list = new ArrayList<>(hangsxDAO.getList());
    }

    public ArrayList<Hang_SX> getList() {
        return list;
    }

    public int getSoLuong() {
        soLuong = HangSxDAO.getSoLuong();
        return soLuong;
    }

    public boolean write(Hang_SX data){
        if (!checkUnique(data))
            return false; // Tên Hãng bị trùng
        hangsxDAO.write(data);
        list.add(data);
        return true; // Thêm thành công        
    }

    public boolean delete(Hang_SX data){
        String maHang = data.getMaHang().trim();
        for (Hang_SX hsx : list){
            if(hsx.getMaHang().equals(maHang)){
                if(hangsxDAO.delete(data)){
                    list.remove(searchIndexByID(data.getMaHang()));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean update(Hang_SX data){
        String maHang = data.getMaHang().trim();
        for (Hang_SX hsx : list){
            if(hsx.getMaHang().equals(maHang)){
                if(hangsxDAO.update(data)){
                    list.set(searchIndexByID(data.getMaHang()), data);
                    return true;
                }
            }
        }        
        return false;
    }

    public int searchIndexByID(String ID) { // ID = MaHang
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaHang().equals(ID)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int searchIndexByTenHang(String tenHang) {
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        String tempTenHang;
        for(int i = 0; i < list.size(); i++){
            tempTenHang = list.get(i).getTenHang();
            if (tempTenHang.equals(tenHang)) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public Hang_SX getHangSXbyCTSP(CT_SanPham ctsp){
        String maHang = ctsp.getMaHang();
        for (Hang_SX hsx : list){
            if(hsx.getMaHang().equals(maHang))
                return hsx;
        }
        return null;
    }

    public boolean checkUnique(Hang_SX data){
        if (searchIndexByTenHang(data.getTenHang()) >= 0)
            return false;
        return true;
    }
    
    public String getTenHangByID(String maHang){
        for (Hang_SX hsx : list){
            if (maHang.equals(hsx.getMaHang()))
                return hsx.getTenHang();
        }
        return null;
    }
}
