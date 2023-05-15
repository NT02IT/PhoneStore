/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;
import DTO.HoaDon;
import DTO.CT_HoaDon;
import DTO.SanPham;
import DTO.CT_SanPham;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JTable;


/**
 *
 * @author duong
 */
public class ExportBill {
    ArrayList<SanPham> sp = new ArrayList<>();
    ArrayList<CT_SanPham> ctsp = new ArrayList<>();
    

    public ExportBill(ArrayList<SanPham> sanpham, ArrayList<CT_SanPham> ct_sanpham){
        this.sp = sanpham;
        this.ctsp = ct_sanpham;
    }
    
    //Hàm lưu file hóa đơn pdf
    //Đầu vào là bảng giỏ hàng
    public boolean save_pdf(JTable giohang) throws FileNotFoundException{
        JFileChooser file = new JFileChooser();
        file.setDialogTitle("Save PDF file");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF file", "pdf");
        file.setFileFilter(filter);
        
        int userSelection = file.showSaveDialog(null);
        if(userSelection == JFileChooser.APPROVE_OPTION){
            String filePath = file.getSelectedFile().getAbsolutePath();
            System.out.println(filePath);
            if(!filePath.toLowerCase().endsWith(".pdf")){
                filePath += ".pdf";
            }
            create_pdf(filePath, giohang);
            return true;
        } else return false;
    }
    
    //Hàm thực hiện tạo và lưu file pdf
    public void create_pdf(String filePath, JTable giohang) throws FileNotFoundException{
        if (filePath != null) {
            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(filePath));
                document.open();
                
                int row = giohang.getRowCount();//hàng
                int column = giohang.getColumnCount();//cột
                
                //Tiêu đề cột
                String[] columnHeaders = { "Tên sp", "Nhà sản xuất", "Đơn giá", "Số lượng"};
                
                PdfPTable table = new PdfPTable(column);
                
                Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
                
                // Font cho các tiêu đề cột
                Font columnHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
                
                //Đặt tiêu đề cho từng cột
                for(String header : columnHeaders){
                    PdfPCell columnHeader = new PdfPCell(new Paragraph(header, columnHeaderFont));
                    table.addCell(columnHeader);
                }
                
                //Đổ dữ liệu vào bảng
                for(int i=1; i <= row; i++){
                    // Đổ dữ liệu cho từng ô trong hàng
                    for(int j=1; j <= column; j++){
                        Object value = giohang.getValueAt(row, column);
                        table.addCell(new Paragraph(value.toString()));
                    }
                }
                     
                document.close();
                System.out.println("PDF file saved at: " + filePath);
            } catch (DocumentException | FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
