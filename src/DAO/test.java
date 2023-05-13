/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BUS.KhachHangBUS;
import DTO.KhachHang;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
        KhachHangDAO khDAO = new KhachHangDAO();
        ArrayList<KhachHang> list1 = new ArrayList<>(khDAO.read());
        for(KhachHang kh : list1)
            System.out.print(kh.getMaKH() + "   ");
        System.out.println("\n");
        
        KhachHangBUS khBUS = new KhachHangBUS();
        ArrayList<KhachHang> list2 = new ArrayList<>(khBUS.getList());
        for(KhachHang kh : list2)
            System.out.print(kh.getMaKH() + "   ");
        System.out.println("\n");
            
    }
    
    
}
