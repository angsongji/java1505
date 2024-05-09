/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Hoadon_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hoadon_DAO {
    private  static ConnectDataBase mySQL  ;
    public Hoadon_DAO(){
        try {
            mySQL = new ConnectDataBase();
        } catch (SQLException ex) {
            Logger.getLogger(Hoadon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    public static ArrayList<Hoadon_DTO> list()
    {
        ArrayList<Hoadon_DTO> dshd = new ArrayList<>(Hoadon_DTO);
        try {
            mySQL.connect();
            String sql = "SELECT * FROM hoadon WHERE 1";
            try (ResultSet rs = mySQL.executeQuery(sql)) {
                while(rs.next())
                {
                    String maHD = rs.getString("SOHD");
                    String ngayHD = rs.getTimestamp("NGAYHD").toString();
                    int maKH = rs.getInt("MAKH");
                    String maNV = rs.getString("MANV");
                    int giamgia = rs.getInt("TIENGIAMGIA");
                    int tongtien = rs.getInt("TONGTIEN");
                    
                    Hoadon_DTO hd = new Hoadon_DTO(maHD, ngayHD, maKH, maNV,giamgia, tongtien, ChitietHD_DAO.list(maHD));
                }
            }
             System.out.println("Lay danh sach chuc nang thanh cong");
             mySQL.disconnect();
        } catch (SQLException ex) {
            System.out.println("Lay danh sach chuc nang that bai");
        }
        
        return dshd;
    }
    
     public static void add(Hoadon_DTO item){
        try {
            mySQL.connect();
            String query= "INSERT INTO hoadon VALUES ('" + item.getMaHD() +"','"+ item.getNgayHD() +"','" +item.getMaKH() +"','" +item.getMaNV() +"','"  +item.getGiamgia() +"','"+item.getTongTien()+");";
            mySQL.executeUpdate(query);
            System.out.println("Them Hoa don thanh cong");
            mySQL.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Hoadon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
     
//     public static void main (String[] args){
//        Hoadon_DAO hd = new Hoadon_DAO();
//        hd.list();
//    }
}
