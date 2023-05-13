/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVien;
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
public class NhanVienDAO implements Action<NhanVien> {
    private ArrayList<NhanVien> list = new ArrayList<>();    
    private static int soLuong = 0;
    private NhanVien nv;
    ID maxMaNV = new ID("nhanvien");

    public NhanVienDAO() throws ClassNotFoundException, SQLException, IOException {
        MyConnection myConn = new MyConnection();
        read();
    }

    public ArrayList<NhanVien> getList() {
        return list;
    }

    public static int getSoLuong() {
        return soLuong;
    }
    
    public ArrayList<NhanVien> read() throws IOException{
        try {
            String sql = "Select * from NHANVIEN";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setTen(rs.getString(2));
                nv.setHoLot(rs.getString(3));
                nv.setDiaChi(rs.getString(4));
                nv.setSDT(rs.getString(5));
                nv.setLuong(rs.getInt(6));
                nv.setUsername(rs.getString(7));
                nv.setPassword(rs.getString(8));
                list.add(nv);
                soLuong++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean write(NhanVien data) {
        try {
            data.setMaNV("NV" + maxMaNV.getMax());
            String sql = "INSERT INTO NHANVIEN (MaNV, Ten, HoLot, DiaChi, SDT, Luong, Username, Pass) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaNV());
            pstmt.setString(2, data.getTen());
            pstmt.setString(3, data.getHoLot());
            pstmt.setString(4, data.getDiaChi());
            pstmt.setString(5, data.getSDT());
            pstmt.setInt(6, data.getLuong());
            pstmt.setString(7, data.getUsername());
            pstmt.setString(8, data.getPassword());
            pstmt.executeUpdate();    
            soLuong++;
            list.add(data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(NhanVien data) {
        try {
            String sql = "DELETE FROM NHANVIEN WHERE MaNV = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaNV());
            pstmt.executeUpdate();     
            soLuong--;
            list.remove(searchByID(data.getMaNV()));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(NhanVien data) {
        try {
            String sql = "UPDATE KHACHHANG SET Ten = ?, HoLot = ?, DiaChi = ?, SDT = ?, Luong = ?, Username = ?, Pass = ? WHERE MaNV = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getTen());
            pstmt.setString(2, data.getHoLot());
            pstmt.setString(3, data.getDiaChi());
            pstmt.setString(4, data.getSDT());
            pstmt.setInt(5, data.getLuong());
            pstmt.setString(6, data.getUsername());
            pstmt.setString(7, data.getPassword());
            pstmt.setString(8, data.getMaNV());
            pstmt.executeUpdate();              
            list.set(searchByID(data.getMaNV()), data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean resetPassword(String username, String newPwd) throws IOException{
        try {
            String sql = "UPDATE NHANVIEN SET Pass = ? WHERE Username = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, newPwd);
            pstmt.setString(2, username);
            pstmt.executeUpdate();    
            int indexNV = searchByUsername(username);  
            list.get(indexNV).setUsername(username);     
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int searchByID(String ID) { // ID = MaNV
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaNV().equals(ID)) {
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
