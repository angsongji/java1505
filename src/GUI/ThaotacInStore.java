package GUI;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
public class ThaotacInStore extends JPanel implements MouseListener{
    private String[] titleThaotac={"Thêm","Sửa","Xóa","Import Excel","Export Excel","In PDF"};
    private Font font_title;
    private int chieurong;
    public ThaotacInStore(int chieurong){
        this.chieurong=chieurong;
        init();
    }
    
    public void init(){
        font_title= new Font("Tahoma",Font.PLAIN,14);
        setPreferredSize(new Dimension(chieurong, 150));
        setLayout(new FlowLayout(3,0,0));
        setBackground(Cacthuoctinh_phuongthuc_chung.light_gray);
        setOpaque(true);
        

         JPanel jp_title= new JPanel();
        jp_title.setLayout(new BorderLayout());
        jp_title.setPreferredSize(new Dimension(chieurong,50));
        jp_title.add(new JLabel("<html><h1 style='font-family:Tahoma;font-weight:600;font-size:16;'>Thao tác</h1></html>"),BorderLayout.WEST);
        jp_title.setBackground(Cacthuoctinh_phuongthuc_chung.light_gray);
        jp_title.setOpaque(true);

        add(jp_title);

        
       JPanel x= new JPanel();

      x.setLayout(new FlowLayout(3,5,0));
      x.setBackground(Cacthuoctinh_phuongthuc_chung.light_gray);
        x.setOpaque(true);
        x.setPreferredSize(new Dimension(chieurong, 80));
        for(int i=0;i<titleThaotac.length;i++){
            JPanel thaotac= new JPanel();
            
           thaotac.setLayout(new GridLayout(2,1,0,0));
           // thaotac.setPreferredSize(new Dimension(chieurong/(titleThaotac.length+1), 40));
           JLabel title= new JLabel(titleThaotac[i]+"",JLabel.CENTER);
           title.setPreferredSize(new Dimension((int)title.getPreferredSize().getWidth()+30,(int)title.getPreferredSize().getHeight()+20));
            JLabel icon=new JLabel();
           switch(titleThaotac[i]){
               case "Thêm":
                   icon.setIcon(new ImageIcon("./src/images/add_icon.png"));
                   break;
               case "Sửa":
                    icon.setIcon(new ImageIcon("./src/images/edit_icon.png"));
                   break;
               case "Xóa":
                    icon.setIcon(new ImageIcon("./src/images/remove_icon.png"));
                   break;
                case "Import Excel":
                    icon.setIcon(new ImageIcon("./src/images/import_icon.png"));
                   break;
                 case "Export Excel":
                    icon.setIcon(new ImageIcon("./src/images/export_icon.png"));
                   break;
                 case "In PDF":
                    icon.setIcon(new ImageIcon("./src/images/pdf_icon.png"));
                   break;
                   
           }
            icon.setHorizontalAlignment(SwingConstants.CENTER);
            thaotac.add(title);
            thaotac.add(icon);
            thaotac.setBackground(Color.WHITE);
            thaotac.setOpaque(true);
            Border top=BorderFactory.createMatteBorder(3, 0, 0, 0, Color.BLACK);
            Border arround=BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
      
           // thaotac.setBorder();
           thaotac.setBorder(BorderFactory.createCompoundBorder(top,arround));
           thaotac.addMouseListener(this);
            x.add(thaotac);
        }
        add(x);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }
    @Override
        public void mouseEntered(MouseEvent e) {
            JPanel item = (JPanel) e.getSource();
        item.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
        item.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Component[] components = item.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.setForeground(Color.WHITE);
            }
        }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JPanel item = (JPanel) e.getSource();
            item.setBackground(Color.WHITE);
            Component[] components = item.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.setForeground(Color.BLACK);
            }
        }
        }
}
