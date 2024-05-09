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
        public DAO_chitietsanpham() {
        try {
            c = new ConnectDataBase();
        } catch (SQLException e) {
        }
    }
        public ArrayList<chitietsanpham_DTO> listCTSP() {
        ArrayList<chitietsanpham_DTO> list = new ArrayList<>();

        try {
            c.connect();
            String query = "SELECT * FROM chitietsanpham";
            ResultSet result = c.executeQuery(query);
            while (result.next()) {
               
                    list.add(new chitietsanpham_DTO(result.getString("MASP"), result.getString("MASIZE"), result.getInt("SOLUONG")));
                
            }

            c.disconnect();
        } catch (SQLException e) {
        }

        return list;
    }

	 public DAO_chitietsanpham() {
            c = new ConnectDataBase();
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

   public void Restore_pro (chitietsanpham_DTO cp){
            try {
                c.connect();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_chitietsanpham.class.getName()).log(Level.SEVERE, null, ex);
            }
        String query= "UPDATE chitietsanpham set SOLUONG = '" + cp.getSoluong() + "' WHERE MASP='" + cp.getMASP() + "' AND MASIZE='" + cp.getMASIZE()+"';";
        boolean result = c.executeUpdate(query);
        if(result) {
            System.out.println("Phục hồi số lượng sản phẩm sau hủy hóa đơn thành công!");
        } else {
            System.out.println("Phục hồi số lượng sản phẩm sau hủy hóa đơn thất bại!");
        }
        c.disconnect();    
      }
}
