package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Cursor;


import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;



public class SearchInStore extends JPanel implements MouseListener{
    private JTextField nameOrMASP;
    private JTextField cheapestPrice;
    private JTextField highestPrice;
    private JComboBox<String> typeShirt;
    private JSpinner startDate;
    private JSpinner endDate;
    private JButton reset;
    private JButton submit;
    private Font font_title;
    private int chieurong;
    private String[] titleTimkiem={"Theo tên hoặc MASP","Giá thấp nhất","đến","Giá cao nhất","Theo loại","Ngày bắt đầu","đến","Ngày kết thúc"};
    public SearchInStore(int chieurong){
        this.chieurong=chieurong;
        init();
    }
    public void cssBtn(JButton b){
        b.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
       
        b.setOpaque(true);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.addMouseListener(this);
    }
    public void init(){
        setPreferredSize(new Dimension(chieurong, 130));
        
        JPanel jp_title= new JPanel();
        jp_title.setLayout(new BorderLayout());
        jp_title.setPreferredSize(new Dimension(chieurong,50));
        jp_title.add(new JLabel("<html><h1 style='font-family:Tahoma;font-weight:600;font-size:16;'>Tìm kiếm</h1></html>"),BorderLayout.WEST);
        jp_title.setBackground(Cacthuoctinh_phuongthuc_chung.light_gray);
        jp_title.setOpaque(true);


       setLayout(new FlowLayout(3,0,0));

        add(jp_title);

        JPanel x= new JPanel();
     
        font_title= new Font("Tahoma",Font.PLAIN,14);
        
       
     
       x.setLayout(new FlowLayout(1,13,10));
       x.setBackground(Color.white);
       x.setOpaque(true);
       x.setPreferredSize(new Dimension(chieurong, 75));
        for(int i=0;i<titleTimkiem.length;i++){
            JPanel input;
            JPanel search= new JPanel();
            search.setLayout(new GridLayout(2,1,0,5));
            if(!titleTimkiem[i].equals("đến")){
            search.setPreferredSize(new Dimension(chieurong/(titleTimkiem.length), 55));
            JLabel title=new JLabel(titleTimkiem[i]+"",JLabel.CENTER);
            title.setFont(font_title);
            search.add(title);

            input= new JPanel();
            input.setLayout(new BorderLayout());
           // {"Theo tên hoặc MASP","Giá thấp nhất","đến","Giá cao nhất","Theo loại","Ngày bắt đầu","đến","Ngày kết thúc"};
            switch (titleTimkiem[i]) {
                case "Theo tên hoặc MASP":
                    nameOrMASP= new JTextField();
                    
                    input.add(nameOrMASP,BorderLayout.CENTER);
                    break;
                case "Giá thấp nhất":
                    cheapestPrice = new JTextField();
                    input.add(cheapestPrice,BorderLayout.CENTER);
                    break;
                case "Giá cao nhất":
                    highestPrice = new JTextField();
                    input.add(highestPrice,BorderLayout.CENTER);
                    break;
                case "Theo loại":
                    typeShirt = new JComboBox<>(new String[]{"Chọn loại áo","Áo hoodie", "Áo Flannel", "Áo khoác jeans"});
                    input.add(typeShirt,BorderLayout.CENTER);
                    input.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    break;
                case "Ngày bắt đầu":{
                    startDate = new JSpinner(new SpinnerDateModel());
                    JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(startDate, "dd/MM/yyyy");
                    startDate.setEditor(dateEditor);
                    input.add( startDate,BorderLayout.CENTER);
                    break;}
                case "Ngày kết thúc":{
                    endDate = new JSpinner(new SpinnerDateModel());
                    JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(endDate , "dd/MM/yyyy");
                    endDate.setEditor(dateEditor);
                    input.add(endDate,BorderLayout.CENTER);
                    break;}
            }
            
            
            search.add( input);
        }
            else{search.setPreferredSize(new Dimension(chieurong/(titleTimkiem.length+30), 45));
                JLabel title=new JLabel("",JLabel.CENTER);
                search.add(title);
                input= new JPanel();
              //  input.setLayout(new BorderLayout());    
              input.setLayout(new FlowLayout(1));
             
                
                input.add(new JLabel(titleTimkiem[i]+"",JLabel.CENTER));
                search.add( input);
            }
            input.setBackground(Color.WHITE);
                input.setOpaque(true);
            search.setBackground(Color.WHITE);
            search.setOpaque(true);
            x.add(search);
        }
        JPanel btn= new JPanel();
        btn.setLayout(new GridLayout(2,1,0,5));
        btn.setPreferredSize(new Dimension(chieurong/(titleTimkiem.length+5), 55));
        reset= new JButton("RESET");
        cssBtn(reset);
        submit= new JButton("SUBMIT");
        cssBtn(submit);
        btn.add(submit);
        btn.add(reset);
        btn.setBackground(Color.WHITE);
        btn.setOpaque(true);
        x.add( btn);
          Border top=BorderFactory.createMatteBorder(0, 3, 0, 0, Color.BLACK);
            Border arround=BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
      
           // thaotac.setBorder();
           x.setBorder(BorderFactory.createCompoundBorder(top,arround));
        
        
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
            JButton menuItem = (JButton) e.getSource();
            menuItem.setForeground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
            menuItem.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
            menuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton menuItem = (JButton) e.getSource();
            menuItem.setForeground(Color.WHITE);
            menuItem.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
            
        }
}
