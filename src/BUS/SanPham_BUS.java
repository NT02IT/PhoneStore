/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.SanPham;
import DAO.SanPhamDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author duong
 */
public class SanPham_BUS {
    private ArrayList <SanPham> sanpham;
    private SanPhamDAO sanpham_DAO;
    
    public SanPham_BUS() throws IOException, ClassNotFoundException, SQLException{
        this.sanpham_DAO = new SanPhamDAO();
        readSANPHAM_BUS();
    }
    
    public void readSANPHAM_BUS() throws IOException{
        this.sanpham = sanpham_DAO.getList();
    }
}
