/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import DAO.KhachHangDAO;
import java.sql.SQLException;

/**
 *
 * @author agond
 */
public class testmain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        KhachHang newNV = new KhachHang("Toàn", "Nguyễn Đức", "Bình Định", "0327531105", "ntoan", "123456");
        
        KhachHangDAO nvDAO = new KhachHangDAO();
        
        nvDAO.writeData(newNV);
        nvDAO.readData();
        System.out.print(nvDAO.getList());
    }
    
}
