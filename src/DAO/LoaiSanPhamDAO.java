/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Loai_SP;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DTO.ID;
import Connection.MyConnection;

/**
 *
 * @author duong
 */
public class LoaiSanPhamDAO implements Action<Loai_SP> {
    private ArrayList<Loai_SP> list = new ArrayList<>();    
    private static int soLuong = 0;
    private Loai_SP loaiSP;
    ID maxMaLoai = new ID("loaisp");
    
    public LoaiSanPhamDAO() throws IOException, ClassNotFoundException, SQLException{
        MyConnection myConn = new MyConnection();   
        read();     
    }
    
    public ArrayList<Loai_SP> getList() {
        return list;
    }

    public static int getSoLuong() {
        return soLuong;
    }
    
    public ArrayList<Loai_SP> read() throws IOException{
        try {
            String sql = "Select * from LOAI_SP";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){   
                loaiSP = new Loai_SP(); 
                loaiSP.setMaLoai(rs.getString(1));
                loaiSP.setTenLoai(rs.getString(2));
                list.add(loaiSP);
                soLuong++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean write(Loai_SP data) { 
        try {
            data.setMaLoai("ML" + maxMaLoai.getMax());
            String sql = "INSERT INTO LOAI_SP (MaLoai, TenLoai) VALUES (?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaLoai());
            pstmt.setString(2, data.getTenLoai());
            pstmt.executeUpdate();  
            soLuong++;  
            list.add(data);  
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(Loai_SP data) {
        try {
            String sql = "DELETE FROM LOAI_SP WHERE MaLoai = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaLoai());
            pstmt.executeUpdate();     
            soLuong--;
            list.remove(searchByID(data.getMaLoai()));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(Loai_SP data) {
        try {
            String sql = "UPDATE LOAI_SP SET TenLoai = ? WHERE MaLoai = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getTenLoai());
            pstmt.setString(2, data.getMaLoai());
            pstmt.executeUpdate();              
            list.set(searchByID(data.getMaLoai()), data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int searchByID(String ID) { // ID = MaLoai
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaLoai().equals(ID)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
