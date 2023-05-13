/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Hang_SX;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import DTO.ID;
import Connection.MyConnection;

/**
 *
 * @author duong
 */
public class HangSxDAO implements Action<Hang_SX> {
    private ArrayList<Hang_SX> list = new ArrayList<>();
    private static int soLuong = 0;
    private Hang_SX hsx;
    ID maxMaHang = new ID("hangsx");
    
    public HangSxDAO() throws IOException, ClassNotFoundException, SQLException{
        MyConnection myConn = new MyConnection();
        read();
    }
    
    public ArrayList<Hang_SX> getList() {
        return list;
    }

    public static int getSoLuong() {
        return soLuong;
    }
    
    public ArrayList<Hang_SX> read() throws IOException{
        try {
            String sql = "Select * from HANG_SX";
            Statement stmt = MyConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){  
                hsx = new Hang_SX(); 
                hsx.setMaHang(rs.getString("MaHang"));
                hsx.setTenHang(rs.getString("TenHang"));
                list.add(hsx);
                soLuong++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangSxDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
    
    public boolean write(Hang_SX data) {
        try {
            data.setMaHang("MH" + maxMaHang.getMax());
            String sql = "INSERT INTO HANG_SX (MaHang, TenHang) VALUES (?, ?)";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaHang());
            pstmt.setString(2, data.getTenHang());
            pstmt.executeUpdate();  
            soLuong++;  
            list.add(data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HangSxDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(Hang_SX data) {
        try {
            String sql = "DELETE FROM HANG_SX WHERE MaHang = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getMaHang());
            pstmt.executeUpdate();     
            soLuong--;
            list.remove(searchByID(data.getMaHang()));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HangSxDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(Hang_SX data) {
        try {
            String sql = "UPDATE HANG_SX SET TenHang = ? WHERE MaHang = ?;";
            PreparedStatement pstmt = MyConnection.conn.prepareStatement(sql);
            pstmt.setString(1, data.getTenHang());
            pstmt.setString(2, data.getMaHang());
            pstmt.executeUpdate();              
            list.set(searchByID(data.getMaHang()), data);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HangSxDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int searchByID(String ID) { // ID = MaHang
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaHang().equals(ID)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
