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
import DTO.chitietquyenDTO;
import DAO.chitietquyenDAO;
public class chitietquyenBUS {
    private ArrayList<chitietquyenDTO> listChitietquyen;
    
    public chitietquyenBUS(){
         listChitietquyen = new ArrayList<>();
         init();
    }
    
    private void init(){
        chitietquyenDAO ctq = new chitietquyenDAO();
        listChitietquyen = ctq.listChitietquyen();
    }
    
    public ArrayList<chitietquyenDTO> getList(){
        return listChitietquyen;
    }
    
     
}
