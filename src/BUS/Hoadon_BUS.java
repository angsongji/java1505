
package BUS;

import DTO.Hoadon_DTO;
import DAO.Hoadon_DAO;
import java.util.ArrayList;

public final class Hoadon_BUS {
    // public ArrayList<Hoadon_DTO> dshoadon;
    
    // public Hoadon_BUS(){
    //     dshoadon = new ArrayList<>();
    //     list();
    // }
    
    // public void list(){
    //     Hoadon_DAO dshd = new Hoadon_DAO();
    //     dshoadon = dshd.listchucnang();
    // }

    public static ArrayList<Hoadon_DTO> list(){
        return Hoadon_DAO.list();
    }
    
     public static void main(String[] args) {
        Hoadon_BUS cthd = new Hoadon_BUS();
        cthd.list();
    }
}
