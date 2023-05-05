/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.SanPham;
import DAO.SanPham_DAO;
import java.util.ArrayList;
/**
 *
 * @author duong
 */
public class SanPham_BUS {
    private ArrayList <SanPham> sanpham;
    private SanPham_DAO sanpham_DAO = new SanPham_DAO();
    
    public SanPham_BUS(){
        readSANPHAM_BUS();
    }
    
    public void readSANPHAM_BUS(){
        this.sanpham = sanpham_DAO.readSANPHAM();
    }
}
