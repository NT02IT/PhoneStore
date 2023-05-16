/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CT_KhuyenMai;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.MyConnection;
import java.security.Timestamp;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author agond
 */
public class CT_KhuyenMaiDAO implements Action<CT_KhuyenMai> {
    private ArrayList<CT_KhuyenMai> list = new ArrayList<>();    
    private static int soLuong = 0;
    private CT_KhuyenMai ctkm;

    public CT_KhuyenMaiDAO() throws ClassNotFoundException, SQLException, IOException {
        MyConnection myConn = new MyConnection();
        read();
    }

    public ArrayList<CT_KhuyenMai> getList() {
        return list;
    }

    public static int getSoLuong() {
        return soLuong;
    }
        
    @Override
    public ArrayList<CT_KhuyenMai> read() throws IOException{
        try {
            String sql = "Select * from CTKM";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){  
                ctkm = new CT_KhuyenMai();
                ctkm.setMaKM(rs.getString(1));
                ctkm.setTenKM(rs.getString(2));
                ctkm.setNgayBD(rs.getDate(3));
                ctkm.setNgayKT(rs.getDate(4));
                ctkm.setPhanTramGiam(rs.getInt(5));
                list.add(ctkm);
                soLuong++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CT_KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CT_KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean write(CT_KhuyenMai data) {
        try {
            
            String sql = "INSERT INTO CTKM (MaKM, TenKM, NgayBD, NgayKT, PhanTramGiam) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaKM());
            pstmt.setString(2, data.getTenKM());
            java.sql.Timestamp ngayBD = new java.sql.Timestamp(data.getNgayBD().getTime());
            pstmt.setTimestamp(3, ngayBD);
            java.sql.Timestamp ngayKT = new java.sql.Timestamp(data.getNgayKT().getTime());
            pstmt.setTimestamp(4, ngayKT);
            pstmt.setInt(5, data.getPhanTramGiam());
            pstmt.executeUpdate();
            soLuong++;
            list.add(data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CT_KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(CT_KhuyenMai data) {
        try {
            String sql = "DELETE FROM CTKM WHERE MaKM = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaKM());
            pstmt.executeUpdate();     
            soLuong--;
            list.remove(searchByID(data.getMaKM()));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CT_KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(CT_KhuyenMai data) {
        try {
            String sql = "UPDATE CTKM SET TenKM = ?, NgayBD = ?, NgayKT = ?, PhanTramGiam = ? WHERE MaKM = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getTenKM());
            pstmt.setDate(2, data.getNgayBD());
            pstmt.setDate(3, data.getNgayKT());
            pstmt.setInt(4, data.getPhanTramGiam());
            pstmt.setString(5, data.getMaKM());
            pstmt.executeUpdate();              
            list.set(searchByID(data.getMaKM()), data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CT_KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int searchByID(String ID) { // ID = MaKM
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaKM().equals(ID)) {
                index = i;
                break;
            }
        }
        return index;
    }

}
