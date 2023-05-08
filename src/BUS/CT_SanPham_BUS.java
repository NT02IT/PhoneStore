/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.CT_SanPham;
import DAO.CT_SanPham_DAO;
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
    private CT_SanPham_DAO ct_sanpham = new CT_SanPham_DAO();
    
    public CT_SanPham_BUS(){
        readCT_SANPHAM();
    }
    
    public void readCT_SANPHAM(){
        this.ctsanpham = ct_sanpham.readCT_SANPHAM();
    }
}
