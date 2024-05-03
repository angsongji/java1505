/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import DTO.SanPhamDTO;
import GUI.SanPhamGUI;
import GUI.view_chi_tiet_san_pham;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author LENOVO
 */
public class vd extends JFrame{
       public vd (){
           this.setSize(800,800);
           this.setLocationRelativeTo(null);
           
           
           SanPhamDTO k = new SanPhamDTO("SP8", "LOAI1", "ao sieu nhan ", 40, null, WIDTH);
                   
           
//           view_chi_tiet_san_pham h = new view_chi_tiet_san_pham(k);
           
           SanPhamGUI h = new SanPhamGUI(800, 800, Color.darkGray);
           
           this.add(h);
           this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.setVisible(true);
       }
       public static void main(String[] args) {
        new vd();
    }
}
