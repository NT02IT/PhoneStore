/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestoreBUS;

import DTO.Loai_SP;
import java.io.IOException;
import java.util.ArrayList;
import phonestoreDAO.LOAI_SP_DAO;

/**
 *
 * @author duong
 */
public class LOAI_SP_BUS {
    public LOAI_SP_BUS(){
        
    }
    
    //khai báo arraylist trung gian, lưu trữ dữ liệu để thực hiện truy xuất mà ko cần load database
    static ArrayList<Loai_SP> loai_sp = new ArrayList<>();
    
    //khai báo DAO
    LOAI_SP_DAO loaisp = new LOAI_SP_DAO();
    
    //gọi từ khi mở window
    //lấy data hãng sản xuất đưa lên arraylist trung gian
    public void getLoai_sp() throws IOException{
        loai_sp = loaisp.readLOAI_SP();
    }
}
