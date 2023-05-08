/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.CT_SanPham;
import DAO.CT_SanPham_DAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
/**
 *
 * @author duong
 */
public class CT_SanPham_BUS {
    private ArrayList<CT_SanPham> ctsanpham;
    private CT_SanPham_DAO ct_sanpham;
    
    public CT_SanPham_BUS() throws ClassNotFoundException, SQLException, IOException{
        this.ct_sanpham = new CT_SanPham_DAO();
        readCT_SANPHAM();
    }
    
    public void readCT_SANPHAM() throws IOException{
        this.ctsanpham = ct_sanpham.readData();
    }
}
