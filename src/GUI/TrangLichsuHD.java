
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//import java.sql.*;
public final class TrangLichsuHD extends JPanel  {
    private JPanel left, right;
    private JPanel p;
//    private DefaultTableModel  model2;
//    ArrayList<HoaDon> listHD;
//    ArrayList<Chi_tiet_hoa_don> list2;
//    private JTable dsHD, dsSP;
    private int chieurong,chieucao;
    private Color backGroundColor;
    private Font f = new Font("Tahoma", Font.BOLD, 16);
    
    public TrangLichsuHD(int chieurong,int chieucao) {
       this.chieurong=chieurong;
       this.chieucao=chieucao;
       init();
        
    }
    
    public void init() {
        this.setPreferredSize(new Dimension(chieurong,chieucao));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        
            right = new JPanel(); 
            right.setPreferredSize(new Dimension(chieurong*2/3, 0));
            right.setBackground(Color.white); 
            right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
                p = new JPanel(); 
                p.setLayout(new BorderLayout());
                p.add(new JLabel("Chưa lựa chọn Hóa đơn để hiển thị chi tiết",JLabel.CENTER),BorderLayout.CENTER);
                p.setPreferredSize(new Dimension(chieurong*2/3,0));
                p.setBackground(Color.WHITE);
            right.add(p);
                
            left = new JPanel();
            left.setPreferredSize(new Dimension(chieurong/3, 0));
            left.setBackground(Color.white);
            left.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4,  Color.decode("#60A3BC")));
    
        this.add(left);
        this.add(right);
            
        
        
            Object[][] Hoadon = {
            {"23/07/2024", "12:06", "icon", "HD001", "2500000"},
            {"24/07/2024", "14:35", "icon", "HD002", "750000"},
            {"25/07/2024", "21:15", "icon", "HD003", "1000000"}
            };
            
            for (Object[] item : Hoadon) {
                JPanel pa = new JPanel();
                    pa.setLayout(new FlowLayout(0,5,0));
                    pa.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#0A3D62")));
                    pa.setBackground(Color.white);
                for (Object d : item) {
                    JLabel l = new JLabel((String) d, JLabel.CENTER);
                        l.setPreferredSize(new Dimension(((chieurong/3)-40)/5, 30));
                        pa.add(l);
                }
                left.add(pa);
              
                pa.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JPanel HDItem = (JPanel) e.getSource();
                            HDItem.setBackground(Color.decode("#0A3D62"));
                            HDItem.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#60A3BC")));
                            right.removeAll();
                            Show_ChitietHD s = new Show_ChitietHD(chieurong, chieucao);
                            JScrollPane scrollPane = new JScrollPane(s);
                            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                            right.add(scrollPane);
                            right.revalidate(); 
                            right.repaint();
                            Component[] components = HDItem.getComponents();
                            for (Component component : components) {
                                if (component instanceof JLabel label) {
                                    label.setForeground(Color.white);
                                }
                            }
                        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
                    }
                    
                    @Override
                    public void mousePressed(MouseEvent e) {
                        
                        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
                    }

                     @Override
                    public void mouseReleased(MouseEvent e) {
                      
                        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
                    }
    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        JPanel HDItem = (JPanel) e.getSource();
                        HDItem.setBackground(Cacthuoctinh_phuongthuc_chung.light_gray);
                        pa.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#60A3BC")));
                        HDItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        Component[] components = HDItem.getComponents();
                        for (Component component : components) {
                            if (component instanceof JLabel label) {
                                label.setForeground(Color.decode("#0A3D62"));
                            }
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        JPanel HDItem = (JPanel) e.getSource();
                            HDItem.setBackground(Color.white);
                            HDItem.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#60A3BC")));
                        Component[] components = HDItem.getComponents();
                        for (Component component : components) {
                            if (component instanceof JLabel label) {
                                label.setForeground(Color.black);
                            }
                        }
                    }
            });

         } 
    }  
    
    
}
            
//            try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ten_cua_co_so_du_lieu", "ten_nguoi_dung", "mat_khau");
//            String sql = "SELECT * FROM HOADON";
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//            listHD= new ArrayList<>();
//            while (resultSet.next()) {
//                int idHD = resultSet.getInt("idHD");
//                String name = resultSet.getString("tenKH"); 
//                int idNV = resultSet.getInt("idNV");
//                Date ngayHD = resultSet.getDate("ngayHD");
//                int tongTT  = resultSet.getInt("idNV");
//                HoaDon hd = new HoaDon(idHD, name, idNV, ngayHD, tongTT);
//                listHD.add(hd);
//            }
//            resultSet.close();
//            statement.close();
//            connection.close();
//            for (HoaDon hd: listHD) {
//                Object[] rowData = {hd.getIdHD(), hd.getTenKH(), hd.getIdNV(), hd.getNgayHD(), hd.getTongTT()};
//                JPanel p = new JPanel();
//                p.setLayout(new FlowLayout(0,5,0));
//                p.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#0A3D62")));
//                p.setBackground(Color.yellow);
//                for (int i = 0; rowData.length> i;i++) {
//                    JLabel l = new JLabel((String) rowData[i]);
//                    p.add(l);
//                }
//            }  
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//          
          
           



