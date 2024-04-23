package GUI;

import BUS.SanPhamBUS;
import DTO.SanPhamDTO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

public class SanPhamGUI extends JPanel implements MouseListener {

    SanPhamBUS spBUS = new SanPhamBUS();
    ArrayList<SanPhamDTO> dsSP;

    private JPanel[] product;
    private int chieurong, chieucao;//Oanh them
    private Color backGroundColor;

    public SanPhamGUI(int chieurong, int chieucao, Color backG_thisJPanel) {//Oanh them doi so truyen vao
        this.chieurong = chieurong;
        this.chieucao = chieucao;
        backGroundColor = backG_thisJPanel;
        dsSP = spBUS.getDsSP();
        init();

    }

    public void init() {
        this.setPreferredSize(new Dimension(chieurong, chieucao));
        setLayout(new FlowLayout(3, 15, 15));
        setBackground(backGroundColor);
        setOpaque(true);

        for (int i = 0; i < dsSP.size(); i++) {
            product = new JPanel[dsSP.size()];
            //san pham con ban moi hien thi
            if (dsSP.get(i).getTrangThai() == 1) {
                product[i] = new JPanel();
                product[i].setPreferredSize(new Dimension(174, 270));
                product[i].setLayout(new BoxLayout(product[i], BoxLayout.Y_AXIS));
                product[i].setAlignmentY(TOP_ALIGNMENT);

                ImageIcon icon = new ImageIcon("./src/images/"+ dsSP.get(i).tenHinh[0]);
                System.out.println("./src/images/"+ dsSP.get(i).tenHinh[0]);
                Image scaledImage = icon.getImage().getScaledInstance(174, 210, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(scaledImage);
                JLabel label = new JLabel(resizedIcon, JLabel.CENTER);
                label.setPreferredSize(new Dimension(174, 200));
                label.setAlignmentX(Component.CENTER_ALIGNMENT); // Căn giữa theo chiều ngang
                label.setAlignmentY(Component.CENTER_ALIGNMENT); // Căn giữa theo chiều dọc
                product[i].add(label);
                product[i].add(Box.createVerticalStrut(5));

                JLabel productName = new JLabel(dsSP.get(i).getTenSP());
                productName.setAlignmentX(Component.CENTER_ALIGNMENT); // Căn giữa theo chiều ngang
                productName.setAlignmentY(Component.CENTER_ALIGNMENT); // Căn giữa theo chiều dọc
                product[i].add(productName);
                product[i].add(Box.createVerticalStrut(5));

                JLabel productPrice = new JLabel("Giá: " + dsSP.get(i).getPrice());
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

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        view_chi_tiet_san_pham m = new view_chi_tiet_san_pham();
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
        JPanel pn1 = (JPanel) e.getSource();
        Border lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4); // Đường viền ngoài
        pn1.setBorder(lineBorder);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JPanel pn1 = (JPanel) e.getSource();
        Border lineBorder = null;
        pn1.setBorder(lineBorder);
    }
}
