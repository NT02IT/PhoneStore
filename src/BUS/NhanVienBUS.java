/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import Connection.MyConnection;
import DAO.NhanVienDAO;
import DTO.NhanVien;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class NhanVienBUS{
    private ArrayList<NhanVien> list;    
    private int soLuong = 0;
    NhanVienDAO nvDAO;
    
    public NhanVienBUS() throws ClassNotFoundException, SQLException, IOException {
        MyConnection myConn = new MyConnection();
        nvDAO = new NhanVienDAO();
        this.list = new ArrayList<>(nvDAO.getList());
    }

    public ArrayList<NhanVien> getList() {
        return list;
    }

    public int getSoLuong() {
        soLuong = NhanVienDAO.getSoLuong();
        return soLuong;
    }
    
    public int write(NhanVien data, String pwdConfirm){
        if (!checkUnique(data))
            return 1; // Username bị trùng
        if (!checkPwdConfirm(data, pwdConfirm))
            return 2; // Password không trùng nhau
        nvDAO.write(data);
        list.add(data);
        return 0; // Thêm thành công        
    }
    
    public boolean delete(NhanVien data){
        String maNV = data.getMaNV();
        for (NhanVien nv : list){
            if(nv.getMaNV().equals(maNV)){
                if(nvDAO.delete(data)){
                    list.remove(searchIndexByID(data.getMaNV()));
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean update(NhanVien data){
        String maNV = data.getMaNV();
        for (NhanVien nv : list){
            if(nv.getMaNV().equals(maNV)){
                if(nvDAO.update(data)){
                    list.set(searchIndexByID(data.getMaNV()), data);
                    return true;
                }
            }
        }        
        return false;
    }
    
    public boolean resetPassword(String username, String newPwd) throws IOException{
        if (nvDAO.resetPassword(username, newPwd)){
            int indexNV = searchIndexByUsername(username);  
            list.get(indexNV).setUsername(username);     
            return true;
        }
        return false;
    }
    
    public int searchIndexByID(String ID) { // ID = MaNV
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaNV().equals(ID)) {
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
    
    public NhanVien searchObjectByUsername(String username) {
        NhanVien result = null;
        String tempUsername;
        for(NhanVien nv : list){
            tempUsername = nv.getUsername();
            if (tempUsername.equals(username)){
                result = nv;  
                break;
            }
        }
        return result;
    }
    
    public boolean checkUnique(NhanVien data){
        if (searchIndexByUsername(data.getUsername()) >= 0)
            return false;
        return true;
    }
    
    public boolean checkPwdConfirm(NhanVien data, String pwdConfirm){
        if (pwdConfirm.equals(data.getPassword()))
            return true;
        return false;
    }
}
