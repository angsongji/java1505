
package DAO;

import DTO.ChitietHD_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChitietHD_DAO {
    public static ConnectDataBase mySQL; 
    
    public ChitietHD_DAO() {
        try {
            mySQL = new ConnectDataBase();
        } catch (SQLException ex) {
            Logger.getLogger(ChitietHD_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<ChitietHD_DTO> list(String maHD)
    {
        ArrayList<ChitietHD_DTO> dscthd = new ArrayList<>();
        try {
           mySQL.connect();
           String sql = "SELECT sanpham.MASP, sanpham.TENSP, size.TENSIZE, chitiethoadon.SOLUONG, sanpham.PRICE, (chitiethoadon.SOLUONG * sanpham.PRICE) as 'THANHTIEN' FROM `chitiethoadon`, `sanpham`, `size` WHERE  chitiethoadon.MASIZE = size.MASIZE and  chitiethoadon.MASP = sanpham.MASP AND chitiethoadon.SOHD = '" + maHD + "'";
            try (ResultSet rs = mySQL.executeQuery(sql)) {
                while (rs.next()) {
                    String masp = rs.getString("MASP");
                    System.out.println(masp);
                    String tensp = rs.getString("TENSP");
                    System.out.println(tensp);
                    String size = rs.getString("TENSIZE"); // Corrected column name
                    System.out.println(size);
                    int sl = rs.getInt("SOLUONG");
                    System.out.println(sl);
                    double gia = rs.getDouble("PRICE");
                    System.out.println(gia);
                    double tt = rs.getDouble("THANHTIEN"); // Corrected column name
                    System.out.println(tt);
                              
                    ChitietHD_DTO cthd = new ChitietHD_DTO(masp,tensp, size, sl, gia, tt);
                    dscthd.add(cthd);
            }
            System.out.println("Lay danh sach chuc nang thanh cong");
            rs.close();        
           mySQL.disconnect();
        }
}
        catch (SQLException ex) {
            System.out.println("Lay danh sach chuc nang that bai");
        }
        return dscthd;   
     
    }
    
     public void add(ChitietHD_DTO item) {
        try {
            mySQL.connect();
            String query= "INSERT INTO hoadon VALUES ('" + item.getMaSP() +"','"+ item.getTenSP() +"','" +item.getMaSize() +"','" +item.getSl()+"','" +item.getGia()+"','" +item.getTt()+");";
            mySQL.executeUpdate(query);
            System.out.println("Them chi tiet hoa don thanh cong!");
            mySQL.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ChitietHD_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public static void main (String[] args){
        ChitietHD_DAO cthd = new ChitietHD_DAO();
        ArrayList<ChitietHD_DTO> list = cthd.list("HD001");
    }
}
