/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author hp
 */
import java.util.ArrayList;
import DTO.quyenDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
public class quyenDAO {
    private ConnectDataBase c;
    
     public  quyenDAO(){
        try{
             c = new ConnectDataBase();
        }catch(SQLException e){
            System.out.println("That bai");
        }
    }
     
     public ArrayList<quyenDTO> listQuyen(){
        ArrayList<quyenDTO> list = new ArrayList<>();
        try{
            c.connect();
            String query="SELECT * FROM quyen";
            try (ResultSet result = c.executeQuery(query)) {
                while(result.next()){
                    quyenDTO item = new quyenDTO(result.getString("MAQUYEN"),result.getString("TENQUYEN"));
                    list.add(item);
                }
            }
            System.out.println("Lay danh sach quyen thanh cong");
            c.disconnect();
        }catch(SQLException e){
            System.out.println("Lay danh sach quyen that bai");
        }
        return list;
    }
     
     public void add(quyenDTO item){
        try{
            c.connect();
            String query= "INSERT INTO quyen VALUES ('"+item.getMAQUYEN()+"','"+item.getTENQUYEN()+"');";
            c.executeUpdate(query);
            System.out.println("Them quyen thanh cong");
            c.disconnect();
        }catch(SQLException e){
            System.out.println("Them quyen that bai");
        }
    }
     
     public void delete(quyenDTO item){
        try{
            c.connect();
            String query = "DELETE FROM quyen WHERE MAQUYEN = '"+item.getMAQUYEN()+"'";
            c.executeUpdate(query);
            c.disconnect();
            System.out.println("Xoa quyen thanh cong");
        }catch(SQLException e){
            System.out.println("Xoa quyen that bai");
        }
    }
     
     public static void main(String[] args) {
        ArrayList<quyenDTO> list = new ArrayList<>();
        quyenDAO c= new quyenDAO();
        list=c.listQuyen();
        for(quyenDTO i : list){
            System.out.println(i.getMAQUYEN()+" "+i.getTENQUYEN());
        }
        
        quyenDTO c_new= new quyenDTO("TEST", "THEMCHUCNANG");
        c.delete(c_new);
    }
}
