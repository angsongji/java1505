
package DAO;

import DTO.ChitietHD_DTO;
import DTO.chitietsanpham_DTO;
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

    private static void ConnectDataBase() {
        try {
            try{
            mySQL = new ConnectDataBase();
        } catch (SQLException ex) {
            Logger.getLogger(ChitietHD_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }catch(Exception e){}
        
    }
    
    public static ArrayList<ChitietHD_DTO> list(String maHD)
    {
        ArrayList<ChitietHD_DTO> dscthd = new ArrayList<>();
        try {
            ConnectDataBase();
           mySQL.connect();
           String sql="select `chitiethoadon`.`MASP`, `sanpham`.`TENSP`, `size`.`TENSIZE`, `chitiethoadon`.`SOLUONG`, `chitiethoadon`.`DONGIA`, (`chitiethoadon`.`SOLUONG`*`chitiethoadon`.`DONGIA`)as THANHTIEN from `size`, `sanpham`,`chitiethoadon` where `chitiethoadon`.`SOHD`='" +maHD +"' and `chitiethoadon`.`MASP`=`sanpham`.`MASP` and `chitiethoadon`.`MASIZE` = `size`.`MASIZE`;";
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
                    double gia = rs.getDouble("DONGIA");
                    System.out.println(gia);
                    double tt = rs.getDouble("THANHTIEN"); // Corrected column name
                    System.out.println(tt);
                              
                    ChitietHD_DTO cthd = new ChitietHD_DTO("heehe",masp,tensp, size, sl, gia, tt);
                                System.out.println("Lay danh sach chi tiet hoa don thanh congc");

            }
            rs.close();        
           mySQL.disconnect();
        }
}
        catch (SQLException ex) {
            System.out.println("Lay danh sach chi tiet hoa don that bai");
        }
        return dscthd;   
     
    }
    

    // trả về danh sách chi tiết sản phẩm cần set số lượng
    public static ArrayList<chitietsanpham_DTO> listtorestore(String mahd) throws SQLException {
        ArrayList<chitietsanpham_DTO> listupdate = new ArrayList<>();
        try {
            ConnectDataBase();
           mySQL.connect();
            String sql ="SELECT cs.MASP as ID, cs.MASIZE as SIZE, (cs.SOLUONG + ch.SOLUONG) as SL FROM chitiethoadon ch INNER JOIN chitietsanpham cs ON ch.MASP = cs.MASP AND ch.MASIZE = cs.MASIZE WHERE ch.SOHD = '"+mahd+"';";
                try (ResultSet rs = mySQL.executeQuery(sql)) {
                    while (rs.next()) {
                    String id = rs.getString("ID");
                    System.out.println(id);
                    String s = rs.getString("SIZE");
                    System.out.println(s);
                    int slg = rs.getInt("SL"); // Corrected column name
                    System.out.println(slg);
                    chitietsanpham_DTO ctsp = new chitietsanpham_DTO(id, s, slg);
                    listupdate.add(ctsp);                   
                }
                System.out.println("Lay danh sach ctsp sau khi tra hang thanh cong!");
            rs.close();        
           mySQL.disconnect();
        }
    }
        catch (SQLException ex) {
            System.out.println("Lay danh sach ctsp sau khi tra hang that bai");
        }
        return listupdate;        
    }
    

    public static boolean addCTHD(ChitietHD_DTO ctHD) {
        boolean result = false;
        try {
            ConnectDataBase();
            mySQL.connect();
            String query= "INSERT INTO `chitiethoadon`(`SOHD`, `MASP`, `MASIZE`, `SOLUONG`, `DONGIA`) " +
                        "VALUES ('"+ctHD.getMaHD()+"', '" + ctHD.getMaSP() + "', '" + ctHD.getMaSize() + "', '" + ctHD.getSl() + "', '"+ ctHD.getGia() + "')";
            System.out.println("            "+ctHD.getMaHD()+", " + ctHD.getMaSP() + ", " + ctHD.getMaSize() + ", " + ctHD.getSl() + ", " + (double)ctHD.getGia() + "");
            result = mySQL.executeupdate(query);
            mySQL.disconnect();
        } catch (SQLException ex) {
            // Logger.getLogger(ChitietHD_DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());

        }
        return result;
    }
     
    
    public boolean delete(String m) throws SQLException {
        boolean result = false;
        boolean success = false;
        try {
            ConnectDataBase();
            mySQL.connect();
        } catch (SQLException ex) {
            String query= "DELETE FROM chitiethoadon WHERE SOHD = '" + m +"';";
            result = mySQL.executeupdate(query);
            Logger.getLogger(ChitietHD_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    String query= "DELETE FROM chitiethoadon WHERE SOHD = '" + m +"';";
          result = mySQL.executeupdate(query);
    if(result) {
        // cập nhật lại số lượng sản phẩm 
        System.out.println("Xoa san pham hoa don thanh cong!");
        success = true; 
    } else {
        System.out.println("Xoa san pham hoa don that bai!");
    }
    mySQL.disconnect();
    return success;
}

    public static void main (String[] args) throws SQLException{
        ChitietHD_DAO cthd = new ChitietHD_DAO();
        ArrayList<ChitietHD_DTO> list = cthd.list("HD001");
//        ArrayList<chitietsanpham_DTO> listup = cthd.listtorestore("HD002");
//        cthd.delete("HD001");

    }
}
