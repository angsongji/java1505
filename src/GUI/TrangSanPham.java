package GUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;
public class TrangSanPham extends JPanel implements MouseListener{
    private JPanel[] product = new JPanel[7];
    SanPham[] detailProduct = new SanPham[7];
    private int chieurong,chieucao;//Oanh them
    private Color backGroundColor;
    public TrangSanPham(int chieurong,int chieucao,Color backG_thisJPanel) {//Oanh them doi so truyen vao
       this.chieurong=chieurong;
       this.chieucao=chieucao;
       backGroundColor=backG_thisJPanel;
        initSP();
        init();
        
    }
    
    public void initSP(){
        for (int i = 0; i < detailProduct.length; i++) {
            detailProduct[i] = new SanPham("D:/thanh phuong/images/10-van-cau-hoi-vi-sao.jpg",
                    "10 vạn câu hỏi vì sao", 25000);
        }
    }
    public void init(){
        this.setPreferredSize(new Dimension(chieurong,chieucao));
        setLayout(new FlowLayout(3,15,15));
        setBackground(backGroundColor);
        setOpaque(true);
        
//        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//        this.add(Box.createHorizontalStrut(10));
        
        for(int i=0;i<product.length;i++){
            product[i]=new JPanel();
            product[i].setPreferredSize(new Dimension(174, 270));
            product[i].setBackground(Color.red);
            product[i].setLayout(new BoxLayout(product[i], BoxLayout.Y_AXIS));
            product[i].setAlignmentY(TOP_ALIGNMENT);
         
             
            ImageIcon icon =new ImageIcon((String)detailProduct[i].getSrcAnh());
            Image scaledImage=icon.getImage().getScaledInstance(174, 206, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(scaledImage);
            JLabel label=new JLabel(resizedIcon,JLabel.CENTER);
            label.setAlignmentX(Component.CENTER_ALIGNMENT); // Căn giữa theo chiều ngang
            label.setAlignmentY(Component.CENTER_ALIGNMENT); // Căn giữa theo chiều dọc
            product[i].add(label);
            product[i].add(Box.createVerticalStrut(5));
           
            
            JLabel productName = new JLabel(detailProduct[i].getTenSP());
            productName.setAlignmentX(Component.CENTER_ALIGNMENT); // Căn giữa theo chiều ngang
            productName.setAlignmentY(Component.CENTER_ALIGNMENT); // Căn giữa theo chiều dọc
            product[i].add(productName);
            product[i].add(Box.createVerticalStrut(5));
            
            JLabel productPrice = new JLabel("Giá: "+detailProduct[i].getGiaSP());
            productPrice.setAlignmentX(Component.CENTER_ALIGNMENT); // Căn giữa theo chiều ngang
            productPrice.setAlignmentY(Component.CENTER_ALIGNMENT); // Căn giữa theo chiều dọc
            product[i].add(productPrice);

            product[i].addMouseListener(this);
            this.add(product[i]);
            
            if (i < product.length - 1) {
            this.add(Box.createHorizontalStrut(10)); // Khoảng cách 10 pixel
            }
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        view_chi_tiet_san_pham m= new view_chi_tiet_san_pham();
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JPanel pn1 = (JPanel)e.getSource();
        Border lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4); // Đường viền ngoài
        pn1.setBorder(lineBorder);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JPanel pn1 = (JPanel)e.getSource();  
        Border lineBorder = null;
        pn1.setBorder(lineBorder);
    }
}
