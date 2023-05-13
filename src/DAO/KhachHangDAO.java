/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHang;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.MyConnection;
import DTO.ID;

/**
 *
 * @author agond
 */
public class KhachHangDAO implements Action<KhachHang> {
    private ArrayList<KhachHang> list = new ArrayList<>();    
    private static int soLuong = 0;
    private KhachHang kh;
    ID maxMaKH = new ID("khachhang");

    public KhachHangDAO() throws ClassNotFoundException, SQLException, IOException {
        MyConnection myConn = new MyConnection();
        read();
    }

    public ArrayList<KhachHang> getList() {
        return list;
    }

    public static int getSoLuong() {
        return soLuong;
    }
        
    @Override
    public ArrayList<KhachHang> read() throws IOException{
        try {
            String sql = "Select * from KHACHHANG";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){  
                kh = new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setTen(rs.getString(2));
                kh.setHoLot(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                kh.setSDT(rs.getString(5));
                kh.setUsername(rs.getString(6));
                kh.setPassword(rs.getString(7));
                list.add(kh);
                soLuong++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean write(KhachHang data) {
        try {
            data.setMaKH("KH" + maxMaKH.getMax());
            String sql = "INSERT INTO KHACHHANG (MaKH, Ten, HoLot, DiaChi, SDT, Username, Pass) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaKH());
            pstmt.setString(2, data.getTen());
            pstmt.setString(3, data.getHoLot());
            pstmt.setString(4, data.getDiaChi());
            pstmt.setString(5, data.getSDT());
            pstmt.setString(6, data.getUsername());
            pstmt.setString(7, data.getPassword());
            pstmt.executeUpdate();
            soLuong++;
            list.add(data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(KhachHang data) {
        try {
            String sql = "DELETE FROM KHACHHANG WHERE MaKH = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaKH());
            pstmt.executeUpdate();     
            soLuong--;
            list.remove(searchByID(data.getMaKH()));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(KhachHang data) {
        try {
            String sql = "UPDATE KHACHHANG SET Ten = ?, HoLot = ?, DiaChi = ?, SDT = ?, Username = ?, Pass = ? WHERE MaKH = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getTen());
            pstmt.setString(2, data.getHoLot());
            pstmt.setString(3, data.getDiaChi());
            pstmt.setString(4, data.getSDT());
            pstmt.setString(5, data.getUsername());
            pstmt.setString(6, data.getPassword());
            pstmt.setString(7, data.getMaKH());
            pstmt.executeUpdate();              
            list.set(searchByID(data.getMaKH()), data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean resetPassword(String username, String newPwd) throws IOException{
        try {
            String sql = "UPDATE KHACHHANG SET Pass = ? WHERE Username = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, newPwd);
            pstmt.setString(2, username);
            pstmt.executeUpdate();    
            int indexKH = searchByUsername(username);  
            list.get(indexKH).setUsername(username);     
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int searchByID(String ID) { // ID = MaKH
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaKH().equals(ID)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int searchByUsername(String username) { 
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
