/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import DAO.SanPham_DAO;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author agond
 */
public class testmain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
        // int soLuong, int donGia, String maLoai, String tenSP, String donViTinh
        
        SanPham newNV1 = new SanPham( 10, 10000, "1", "0327531105", "ntoan");
        SanPham newNV2 = new SanPham( 10, 10000, "2", "0327531105", "ntoan");
        SanPham newNV3 = new SanPham( 10, 10000, "3", "0327531105", "ntoan");
        SanPham newNV4 = new SanPham( 10, 10000, "4", "0327531105", "ntoan");
        SanPham newNV5 = new SanPham( 10, 10000, "5", "0327531105", "ntoan");
        
        SanPham_DAO khDAO = new SanPham_DAO();
        
        khDAO.addSANPHAM(newNV5);
        khDAO.addSANPHAM(newNV5);
        khDAO.readSANPHAM();
        System.out.print(khDAO.readSANPHAM());
        khDAO.addSANPHAM(newNV5);
        khDAO.addSANPHAM(newNV5);
        khDAO.addSANPHAM(newNV5);
        khDAO.readSANPHAM();
        System.out.print(khDAO.readSANPHAM());
    }
    
}
