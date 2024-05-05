/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPhamDTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import DTO.chitietsanpham_DTO;
/**
 *
 * @author LENOVO
 */
public class DAO_chitietsanpham {
	private ConnectDataBase c;
	private SanPhamDTO sanpham_DTO;
	public DAO_chitietsanpham(SanPhamDTO h) {
            try {
                this.sanpham_DTO = h;
                c = new ConnectDataBase();
            } catch (java.sql.SQLException ex) {
                Logger.getLogger(DAO_chitietsanpham.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	public ArrayList<String> select_size(SanPhamDTO h){
		ArrayList<String> k = new ArrayList<String>();
		try {
			c.connect();
			
			String sql = "select TENSIZE from size where MASIZE in ("
					+ "SELECT DISTINCT MASIZE FROM chitietsanpham WHERE MASP = '"+ h .getMaSP() +"' )";
			
			ResultSet rs = c.executeQuery(sql);
			while(rs.next()) {
				String t = rs.getString("TENSIZE");
				k.add(t);
				
			}
			c.disconnect();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}
	
	public ArrayList<chitietsanpham_DTO> select_all(SanPhamDTO h){
		ArrayList<chitietsanpham_DTO> ds = new ArrayList<chitietsanpham_DTO>();
		
		try {
			c.connect();
			
			String sql = "select * from chitietsanpham where MASP = '" + h.getMaSP() +"'";
			
			ResultSet rs = c.executeQuery(sql);
			
			while (rs.next()) {
				
				String masp = rs.getString("MASP");
				String masize = rs.getString("MASIZE");
				int solong = rs.getInt("SOLUONG");
				
				chitietsanpham_DTO k = new chitietsanpham_DTO(masp, masize, solong);
				ds.add(k);
			}
			c.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
      
    
}
