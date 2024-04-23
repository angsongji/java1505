/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author hp
 */
import java.util.ArrayList;
import DTO.quyenDTO;
import DAO.quyenDAO;
public class quyenBUS {
    private ArrayList<quyenDTO> list;
    
    public quyenBUS(){
        list = new ArrayList<>();
        init();
    }
    
    private void init(){
        quyenDAO dao = new quyenDAO();
        list = dao.listQuyen();
    }
    
    public  ArrayList<quyenDTO> getList(){
        return list;
    }
    
    public static void main(String[] args) {
        quyenBUS p = new quyenBUS();
        ArrayList<quyenDTO> list = p.getList();
        for(quyenDTO i: list)
              System.out.println(i.getMAQUYEN()+" "+i.getTENQUYEN());
    }
}
