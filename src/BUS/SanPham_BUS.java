/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.SanPham;
import DTO.CT_SanPham;
import DAO.SanPham_DAO;
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
    
    //Đọc dữ liệu sản phẩm lên arraylist trung gian
    public void readSANPHAM_BUS(){
        sanpham = sanpham_DAO.getList();
    }
    
    //Đọc số lượng toàn bộ sản phẩm trong arraylist trung gian
    public int read_SL_SANPHAM_BUS(){
        int count = 0;
        for(int i=0; i < sanpham.size(); i++){
            count++;
        }
        return count;
    }
    
    //Hàm tìm sản phẩm theo mã sản phẩm
    //Đầu vào là mã sản phẩm, đầu ra là sản phẩm tương ứng
    public SanPham getSANPHAM(String masp){
        if(!masp.trim().equals("")){
            try {
                for (SanPham sp : sanpham) {
                    if (sp.getMaSP().equals(masp)) {
                        return sp;
                    }
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    //Hàm tìm các sản phẩm theo tên
    //Đầu vào là tên sản phẩm, đầu ra là 1 arraylist các sản phẩm có cùng tên
    public ArrayList<SanPham> getSANPHAM_ten(String ten){
        ArrayList<SanPham> dssp = new ArrayList<>();
        for(SanPham sp : sanpham){
            ten = ten.trim().toLowerCase();
            String tensp = sp.getTenSP().trim().toLowerCase();
            if(tensp.contains(ten)){
                dssp.add(sp);
            }
        }
        return dssp;
    }
    
    //Hàm tìm các sản phẩm theo loại
    //Đầu vào là mã loại, đầu ra là 1 arraylist các sản phẩm cùng loại
    public ArrayList<SanPham> getSANPHAM_loai(String ma){
        if(!ma.trim().equals("")){
            ArrayList<SanPham> dssp = new ArrayList<>();
            try {
                for (SanPham sp : sanpham) {
                    if (sp.getMaSP().equals(ma)) {
                        dssp.add(sp);
                    }
                }
                return dssp;
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    //Hàm thêm sản phẩm
    //Đầu vào là các thông tin của sản phẩm, đầu ra là true (nếu thêm thành công) hoặc false (thêm thất bại)
    public boolean addSANPHAM(String ten,
            String masp,
            String maloai,
            String mahang,
            int soluong,
            int dongia,
            String dvt,
            String mota) throws IOException {
        //Hàm xử lý các textfield (thông tin sản phẩm) còn trống
        
        
        //Gọi các biến chứa các dữ liệu sản phẩm lấy từ textfield
        String ten_sp = null;
        String ma_sp = null;
        String ma_loai = null;
        String ma_hang = null;
        int sl = 0;
        int dg = 0;
        String donvitinh = null;
        String mt = null;
        
        SanPham sp = new SanPham(sl, dg, ma_loai, ten_sp, donvitinh);
        ma_sp = sp.getMaSP();
        CT_SanPham ctsp = new CT_SanPham(ma_sp, ma_loai, ma_hang, mt);
        
        return false;
    }
}
