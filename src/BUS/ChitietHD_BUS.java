
package BUS;

import DAO.ChitietHD_DAO;
import DTO.ChitietHD_DTO;
import DTO.chitietsanpham_DTO;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChitietHD_BUS {
    public ArrayList<ChitietHD_DTO> list;

    public ChitietHD_BUS(String maHD) throws SQLException {
        list(maHD); 
    }
  public ChitietHD_BUS(){
        
    }
    public void list(String maHD) throws SQLException {
        ChitietHD_DAO listsphd = new ChitietHD_DAO();
        list = listsphd.list(maHD);
    }
    public ArrayList<ChitietHD_DTO> getList(){
        return list;
    }
    public void delete(String maHD) throws SQLException {
        ChitietHD_DAO cdDAO = new ChitietHD_DAO();
        cdDAO.delete(maHD);
    }
    public ArrayList<chitietsanpham_DTO> listtorestore(String maHD) throws SQLException {
        ChitietHD_DAO listsphd = new ChitietHD_DAO();
        return listsphd.listtorestore(maHD);
    }
    public void addInSQL(ChitietHD_DTO item){
        System.out.println("MAHD la "+item.getMaHD());
        try {
            ChitietHD_DAO cthdDAO= new ChitietHD_DAO();
           
                 cthdDAO.add(item);
        
           
        } catch (SQLException ex) {
            Logger.getLogger(ChitietHD_BUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
         public static void main (String[] args) throws SQLException{
        ChitietHD_BUS hd = new ChitietHD_BUS("HD002");
        hd.listtorestore("HD002");
    }

         
         
}
