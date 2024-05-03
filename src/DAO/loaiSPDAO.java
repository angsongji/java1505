/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.loaiSP;
import DTO.nhacungcapDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class loaiSPDAO {
    private ConnectDataBase c;
    
    public loaiSPDAO(){
        try {
            c = new ConnectDataBase();
        } catch (SQLException e) {
        }
    }
    
    public ArrayList<loaiSP> listLoaiSPRemoveTrangthai2() {
        ArrayList<loaiSP> list = new ArrayList<>();

        try {
            c.connect();
            String query = "SELECT * FROM loai";
            ResultSet result = c.executeQuery(query);
            while (result.next()) {
                if (result.getInt("TINHTRANG") != 2) {
                    list.add(new loaiSP(result.getString("MALOAI"), result.getString("TENLOAI"), result.getInt("TINHTRANG")));
                }
            }

            c.disconnect();
        } catch (SQLException e) {
        }

        return list;
    }
    
     public ArrayList<loaiSP> listLoaiSP() {
        ArrayList<loaiSP> list = new ArrayList<>();

        try {
            c.connect();
            String query = "SELECT * FROM loai";
            ResultSet result = c.executeQuery(query);
            while (result.next()) {
                
                    list.add(new loaiSP(result.getString("MALOAI"), result.getString("TENLOAI"), result.getInt("TINHTRANG")));
                
            }

            c.disconnect();
        } catch (SQLException e) {
        }

        return list;
    }
     
     public void add(loaiSP item) {
        try {
            c.connect();
            String query = "INSERT INTO loai(MALOAI,TENLOAI,TINHTRANG) VALUES ('" + item.getMALOAI() + "','" + item.getTENLOAI() +"','" + item.getTINHTRANG()+ "');";
            c.executeUpdate(query);
            c.disconnect();
        } catch (SQLException e) {
        }
    }
     
      public void update(loaiSP item) {
        try {
            c.connect();

            String query = " UPDATE loai SET TENLOAI='" + item.getTENLOAI()+ "', TINHTRANG=" + item.getTINHTRANG()+ " WHERE MALOAI='" + item.getMALOAI()+ "'";
            c.executeUpdate(query);
            c.disconnect();
        } catch (SQLException e) {
        }
    }
       public void delete(String m) {
        try {
            c.connect();
            String query = "UPDATE loai SET TINHTRANG = 2 WHERE MALOAI = '" + m + "'";
            c.executeUpdate(query);
            c.disconnect();
        } catch (SQLException e) {
        }
    }
}
