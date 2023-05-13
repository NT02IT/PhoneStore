/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHang;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class KhachHangBUS{
    private ArrayList<KhachHang> list;    
    private int soLuong = 0;
    KhachHangDAO khDAO;
    
    public KhachHangBUS() throws ClassNotFoundException, SQLException, IOException {
        khDAO = new KhachHangDAO();
        this.list = new ArrayList<>(khDAO.getList());
    }

    public ArrayList<KhachHang> getList() {
        return list;
    }

    public int getSoLuong() {
        soLuong = KhachHangDAO.getSoLuong();
        return soLuong;
    }
    
    public int write(KhachHang data, String pwdConfirm){
        if (!checkUnique(data))
            return 1; // Username bị trùng
        if (!checkPwdConfirm(data, pwdConfirm))
            return 2; // Password không trùng nhau
        khDAO.write(data);
        list.add(data);
        return 0; // Thêm thành công        
    }
    
    public boolean delete(KhachHang data){
        String maKH = data.getMaKH();
        for (KhachHang kh : list){
            if(kh.getMaKH().equals(maKH)){
                if(khDAO.delete(data)){
                    list.remove(searchIndexByID(data.getMaKH()));
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean update(KhachHang data){
        String maKH = data.getMaKH();
        for (KhachHang kh : list){
            if(kh.getMaKH().equals(maKH)){
                if(khDAO.update(data)){
                    list.set(searchIndexByID(data.getMaKH()), data);
                    return true;
                }
            }
        }        
        return false;
    }

    public boolean resetPassword(String username, String newPwd) throws IOException{
        if (khDAO.resetPassword(username, newPwd)){
            int indexKH = searchIndexByUsername(username);  
            list.get(indexKH).setUsername(username);     
            return true;
        }
        return false;
    }
    
    public int searchIndexByID(String ID) { // ID = MaKH
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaKH().equals(ID)) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public int searchIndexByUsername(String username) {
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        String tempUsername;
        for(int i = 0; i < list.size(); i++){
            tempUsername = list.get(i).getUsername();
            if (tempUsername.equals(username)) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public KhachHang searchObjectByUsername(String username) {
        KhachHang result = null;
        String tempUsername;
        for(KhachHang kh : list){
            tempUsername = kh.getUsername();
            if (tempUsername.equals(username))
                result = kh;  
                break;
        }
        return result;
    }
    
    public boolean checkUnique(KhachHang data){
        if (searchIndexByUsername(data.getUsername()) >= 0)
            return false;
        return true;
    }
    
    public boolean checkPwdConfirm(KhachHang data, String pwdConfirm){
        if (pwdConfirm.equals(data.getPassword()))
            return true;
        return false;
    }
}
