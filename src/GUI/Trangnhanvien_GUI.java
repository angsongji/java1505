
package GUI;
import BUS.Nhanvien_BUS;
import BUS.nhacungcapBUS;
import DTO.Nhanvien_DTO;
import DTO.nhacungcapDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Trangnhanvien_GUI extends JPanel {
    private int chieurong,chieucao;
    private Font f = new Font("Tahoma", Font.BOLD, 14);
    private ConnectDataBase mySQL = new ConnectDataBase();
    private Nhanvien_BUS dsnv;
    
     public Trangnhanvien_GUI(int chieurong,int chieucao) throws SQLException {
       this.chieurong=chieurong;
       this.chieucao=chieucao;
       init();
    }
    
      public void init() throws SQLException{   
        this.setPreferredSize(new Dimension(chieurong,chieucao));
        this.setLayout(new FlowLayout(0,0,0));

                    String[] columnNames = {"MANV", "TENNV", "CHUCVU","SDT","DIACHI","EMAIL" };
                    
                    JPanel titlePanel = new JPanel();
                        titlePanel.setLayout(new FlowLayout(0,0,0));
                        titlePanel.setBackground(Color.decode("#60A3BC"));
                        titlePanel.setPreferredSize(new Dimension((chieurong), 50));

//                        title.setForeground(Color.red);
                        for (String col : columnNames) {
                            if( col == columnNames[4] || col == columnNames[5] ){
                            JLabel l = new JLabel(col,JLabel.CENTER);
                                l.setPreferredSize(new Dimension((chieurong)/4, 50));
                                l.setFont(new Font(l.getFont().getName(), Font.BOLD, 18));
                                l.setForeground(Color.decode("#0A3D62"));
                        titlePanel.add(l);
                            }
                            else {
                                JLabel l = new JLabel(col,JLabel.CENTER);
                                l.setPreferredSize(new Dimension((chieurong)/8, 30));
                                l.setFont(new Font(l.getFont().getName(), Font.BOLD, 18));
                                l.setForeground(Color.decode("#0A3D62"));
                        titlePanel.add(l);
                            }
                        }
                this.add(titlePanel);
                
                JPanel listPanel = new JPanel();
                        listPanel.setLayout(new FlowLayout(0,0,3));
                        listPanel.setBackground(Color.white);
                        listPanel.setPreferredSize(new Dimension((chieurong), 600));

                    dsnv = new Nhanvien_BUS();
                        for (Nhanvien_DTO nv : dsnv.listnv) {
                            System.out.println(nv.getManv());
                            addNV_gui(this,nv);
                        }
    }
      
 public void control(){
        this.setPreferredSize(new Dimension(chieurong,chieucao));
        this.setLayout(new FlowLayout(0,0,0));
         JPanel Panel = new JPanel();
                        Panel.setLayout(null);
                        Panel.setBackground(Cacthuoctinh_phuongthuc_chung.light_gray);
                        Panel.setPreferredSize(new Dimension((chieurong), 50));
                   
         JButton submit = new JButton("Hoàn tất");
            submit.setBounds(chieurong-100, 0, 100, 40);
            submit.setBackground(Color.decode("#0A3D62"));
            submit.setForeground(Color.white);
                        Panel.add(submit);
this.add(Panel);
            
JPanel Pa = new JPanel();
                        Pa.setBackground(Cacthuoctinh_phuongthuc_chung.light_gray);
                        Pa.setPreferredSize(new Dimension((chieurong), 10));
this.add(Pa);
                 
                    String[] columnNames = {"MANV", "TENNV", "CHUCVU","SDT","DIACHI","EMAIL" };
                    
                    JPanel titlePanel = new JPanel();
                        titlePanel.setLayout(new FlowLayout(0,0,0));
                        titlePanel.setBackground(Color.decode("#60A3BC"));
                        titlePanel.setPreferredSize(new Dimension((chieurong), 50));

//                        title.setForeground(Color.red);
                        for (String col : columnNames) {
                            if( col == columnNames[4] || col == columnNames[5] ){
                            JLabel l = new JLabel(col,JLabel.CENTER);
                                l.setPreferredSize(new Dimension((chieurong)/4, 50));
                                l.setFont(new Font(l.getFont().getName(), Font.BOLD, 18));
                                l.setForeground(Color.decode("#0A3D62"));
                        titlePanel.add(l);
                            }
                            else {
                                JLabel l = new JLabel(col,JLabel.CENTER);
                                l.setPreferredSize(new Dimension((chieurong)/8, 30));
                                l.setFont(new Font(l.getFont().getName(), Font.BOLD, 18));
                                l.setForeground(Color.decode("#0A3D62"));
                        titlePanel.add(l);
                            }
                        }
                this.add(titlePanel);
                
                JPanel listPanel = new JPanel();
                        listPanel.setLayout(new FlowLayout(0,0,3));
                        listPanel.setBackground(Color.white);
                        listPanel.setPreferredSize(new Dimension((chieurong), 600));

                    dsnv = new Nhanvien_BUS();
                        for (Nhanvien_DTO nv : dsnv.listnv) {
                            System.out.println(nv.getManv());
                            show_control(this,nv);
                        }  
    submit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                reloadPage();
            } catch (SQLException ex) {
                Logger.getLogger(Trangnhanvien_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
    });
 }
 
public void show_control( Trangnhanvien_GUI nvGUI,Nhanvien_DTO nv) {    
   
    JPanel itemNV = new JPanel();
    itemNV.setLayout(new FlowLayout(0, 0, 0));
    itemNV.setPreferredSize(new Dimension(chieurong, 50));
    itemNV.setBackground(Color.decode("#d3eaf2"));
    itemNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#60A3BC")));
    JLabel lab1 = new JLabel(nv.getManv(), JLabel.CENTER);
    JLabel lab2 = new JLabel(nv.getTennv(), JLabel.CENTER);
    JLabel lab3 = new JLabel(nv.getChucvu(), JLabel.CENTER);
    JLabel lab4 = new JLabel(String.valueOf(nv.getSdt()), JLabel.CENTER);
    JLabel lab5 = new JLabel(nv.getDiachi(), JLabel.CENTER);
    JLabel lab6 = new JLabel(nv.getEmail(), JLabel.CENTER);
    lab1.setPreferredSize(new Dimension(chieurong / 8, 40));
    lab2.setPreferredSize(new Dimension(chieurong / 8, 40));
    lab3.setPreferredSize(new Dimension(chieurong / 8, 40));
    lab4.setPreferredSize(new Dimension(chieurong / 8, 40));
    lab5.setPreferredSize(new Dimension(chieurong / 4, 40));
    lab6.setPreferredSize(new Dimension(chieurong / 4, 40));
    itemNV.add(lab1);
    itemNV.add(lab2);
    itemNV.add(lab3);
    itemNV.add(lab4);
    itemNV.add(lab5);
    itemNV.add(lab6);
    this.add(itemNV);
    
    JPanel control = new JPanel();
    control.setVisible(false);
    control.setBounds((chieurong - 300) / 2, (chieucao - 280) / 2, chieurong, 200);
    control.setBackground(Cacthuoctinh_phuongthuc_chung.light_gray);
    control.setLayout(new FlowLayout(1, 10, 0));
    JLabel title = new JLabel("Bạn muốn thay đổi thông tin nhân viên?", JLabel.LEFT);
    title.setForeground(Color.decode("#60A3BC"));
    title.setPreferredSize(new Dimension(chieurong-294, 50)); 
    title.setFont(new Font(title.getFont().getName(), Font.BOLD, 14));
    control.add(title);
    
    // Tạo nút "Sửa"
    JButton editButton = new JButton("Sửa");
    editButton.setPreferredSize(new Dimension(80, 30));
    editButton.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
    editButton.setForeground(Color.white);
    editButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            removePanel(itemNV, control);
            UpdateNV_GUI k = new UpdateNV_GUI(nvGUI,nv);
            control.setVisible(false);
        }
    });

    // Tạo nút "Xóa"
    JButton deleteButton = new JButton("Xóa");
    deleteButton.setPreferredSize(new Dimension(80, 30));
    deleteButton.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
    deleteButton.setForeground(Color.white);
    deleteButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int r1 = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa nhân viên " + nv.getTennv() + "?", "Xóa", JOptionPane.YES_NO_OPTION);
            if (r1 == JOptionPane.YES_OPTION) {
                removePanel(itemNV, control);
                dsnv.delete(nv);
            }
        }
    });

    // Tạo nút "Hủy"
    JButton cancelButton = new JButton("Hủy");
    cancelButton.setPreferredSize(new Dimension(80, 30));
    cancelButton.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
    cancelButton.setForeground(Color.black);
    cancelButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
      
                    control.setVisible(false);
            
            getData = new JTextField[title.length-1];
            error = new JLabel[title.length];
            init(chieurong, chieucao);
        }

    });
    
    // Thêm nút "Sửa", "Xóa" và "Hủy" vào panel control
    control.add(editButton);
    control.add(deleteButton);
    control.add(cancelButton);
    control.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.decode("#60A3BC")));
    control.setVisible(false);
    this.add(control);
                  
    itemNV.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            control.setVisible(true);
            control.revalidate();
            control.repaint();
        }


        private void init(int chieurong, int chieucao) {

            setLayout(new FlowLayout(3, 0, 0));
            setPreferredSize(new Dimension(chieurong+20, chieucao));
            JPanel titleGUI_wrap = new JPanel(new BorderLayout());
            titleGUI_wrap.setPreferredSize(new Dimension(chieurong, 40));
            JLabel titleGUI = new JLabel("Thêm nhân viên".toUpperCase(), JLabel.CENTER);
            titleGUI.setFont(Cacthuoctinh_phuongthuc_chung.font_header);
            titleGUI.setPreferredSize(new Dimension(chieurong, 40));
            titleGUI_wrap.add(titleGUI, BorderLayout.CENTER);
            add(titleGUI_wrap);
            
            for (int i = 0; i < title.length; i++) {
                JPanel item = new JPanel(new FlowLayout(3, 10, 0));
                item.setPreferredSize(new Dimension(chieurong, 100));
                JLabel lb_title = new JLabel(title[i]);
                lb_title.setPreferredSize(new Dimension(chieurong, 30));
                lb_title.setFont(font_data);
                lb_title.setForeground(Cacthuoctinh_phuongthuc_chung.sky_blue);
                item.add(lb_title);
                if (i<= 3){
                getData[i] = new JTextField();
                getData[i].setPreferredSize(new Dimension(chieurong -10, 30));
                item.add(getData[i]);
                }
                else{
                    String[] positions = {"Nhân viên", "Quản lý bán hàng", "Quản lý kho","Quản lý ứng dụng"};
                        comboBox = new JComboBox<>(positions);
                        String selectedPosition = (String) comboBox.getSelectedItem();
                        item.add(comboBox);
                }
                error[i] = new JLabel("");
                error[i].setFont(new Font("Tahoma", Font.ITALIC, 14) {
                });
                error[i].setPreferredSize(new Dimension(chieurong, 20));
                error[i].setForeground(Cacthuoctinh_phuongthuc_chung.error);
                item.add(error[i]);

                add(item);
            }

            JPanel btn_wrap = new JPanel(new FlowLayout(2,10,0));

            btn_exit = new JPanel();
            cssBtn(btn_exit, "Hủy", "btn_exit");

            btn_submit = new JPanel();
            cssBtn(btn_submit, "Xác nhận", "btn_submit");
            btn_wrap.setPreferredSize(new Dimension(chieurong, (int) btn_submit.getPreferredSize().getHeight() + 20));
            btn_wrap.add(btn_exit);
            btn_wrap.add(btn_submit);
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            add(btn_wrap);
        }

        private void cssBtn(JPanel b, String text, String name) {
            JLabel t = new JLabel(text, JLabel.CENTER);
            t.setForeground(Color.WHITE);
            b.setName(name);
            b.add(t);
            b.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
            b.setPreferredSize(new Dimension(100, (int) b.getPreferredSize().getHeight()));
            b.setOpaque(true);
        }
    }
    private int chieurong, chieucao;
    private addNhanvien addNV;
    private String manv = "";
    private boolean flag_ten, flag_sdt, flag_dc, flag_email, flag_cv;
    private Trangnhanvien_GUI nvGUI;
    public addNhanvienGUI(Trangnhanvien_GUI nvGUI) {
        this.nvGUI= nvGUI;
        chieurong  = 400;
        chieucao  = 600;
        flag_ten = flag_sdt = flag_dc = flag_email = flag_cv =  false;
        init();
    }



public void addNV_gui( Trangnhanvien_GUI nvGUI,Nhanvien_DTO nv) {      
    JPanel itemNV = new JPanel();
    itemNV.setLayout(new FlowLayout(0, 0, 0));
    itemNV.setPreferredSize(new Dimension(chieurong, 50));
    itemNV.setBackground(Color.decode("#d3eaf2"));
    itemNV.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#60A3BC")));
    JLabel lab1 = new JLabel(nv.getManv(), JLabel.CENTER);
    JLabel lab2 = new JLabel(nv.getTennv(), JLabel.CENTER);
    JLabel lab3 = new JLabel(nv.getChucvu(), JLabel.CENTER);
    JLabel lab4 = new JLabel(String.valueOf(nv.getSdt()), JLabel.CENTER);
    JLabel lab5 = new JLabel(nv.getDiachi(), JLabel.CENTER);
    JLabel lab6 = new JLabel(nv.getEmail(), JLabel.CENTER);
    lab1.setPreferredSize(new Dimension(chieurong / 8, 40));
    lab2.setPreferredSize(new Dimension(chieurong / 8, 40));
    lab3.setPreferredSize(new Dimension(chieurong / 8, 40));
    lab4.setPreferredSize(new Dimension(chieurong / 8, 40));
    lab5.setPreferredSize(new Dimension(chieurong / 4, 40));
    lab6.setPreferredSize(new Dimension(chieurong / 4, 40));
    itemNV.add(lab1);
    itemNV.add(lab2);
    itemNV.add(lab3);
    itemNV.add(lab4);
    itemNV.add(lab5);
    itemNV.add(lab6);
    this.add(itemNV);
}

// Hàm xóa panel khỏi container
public void removePanel(JPanel itemNV, JPanel control) {
    this.remove(itemNV); // Xóa panel itemNV khỏi container
    this.remove(control); // Xóa panel control khỏi container
    this.revalidate(); // Cập nhật container
    this.repaint(); // Vẽ lại container để hiển thị sự thay đổi
}

// reload trang nhân viên
    public void reloadPage() throws SQLException {
        this.removeAll();
        this.init();
        revalidate();
        repaint();
    }
public void reloadPagecontrol() throws SQLException {
        this.removeAll();
        this.control();
        revalidate();
        repaint();
    }
     public static void main (String[] args) throws SQLException{
        JFrame f = new JFrame ();
        f.setSize(1200,800);
        Trangnhanvien_GUI p = new Trangnhanvien_GUI(800,400);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        try {
            JPanel btn = (JPanel) e.getSource();
            switch (btn.getName()) {
                case "btn_exit":
                    int r1 = JOptionPane.showConfirmDialog(null, "Những thông tin sẽ không được lưu sau khi thoát!\nBạn có muốn tiếp tục?", "Thoát", JOptionPane.YES_NO_OPTION);
                    if (r1 == JOptionPane.YES_OPTION) {
                        dispose();
                    } else {
                        // Thực hiện hành động khi người dùng chọn No hoặc đóng cửa sổ
                    }

                    break;
                case "btn_submit":
                    String ten = addNV.getData[0].getText();
                    String sdt = addNV.getData[1].getText();
                    String dchi = addNV.getData[2].getText();
                    String email = addNV.getData[3].getText();
                    String cv = (String) addNV.comboBox.getSelectedItem();
                    
                    Nhanvien_BUS nvBUS = new Nhanvien_BUS();
                    
                    if (ten.equals("")) {
                        addNV.error[0].setText("Không được để trống");
                    } else if (!nvBUS.checkTENNV(ten)) {
                        addNV.error[0].setText("Tên chỉ chứa chữ cái");
                    } else {
                        flag_ten = true;
                        addNV.error[0].setText("");
                    }
                    
                    if (sdt.equals("")) {
                        addNV.error[1].setText("Không được để trống");
                    } else if (!nvBUS.checkSDT(sdt)) {
                        addNV.error[1].setText("Chứa 10 kí tự số và bắt đầu là số 0");
                    } else {
                        flag_sdt = true;
                        addNV.error[1].setText("");
                    }
                    
                    if (dchi.equals("")) {
                        addNV.error[2].setText("Không được để trống");
                    } else if (!nvBUS.checkDCHI(dchi)) {
                        addNV.error[2].setText("Địa chỉ không vượt quá 250 ký tự!");
                    } else {
                        flag_dc = true;
                        addNV.error[2].setText("");
                    } 
                    
                    if (email.equals("")) {
                        addNV.error[3].setText("Không được để trống");
                    } else if (!nvBUS.checkEMAIL(email)) {
                        addNV.error[3].setText("Địa chỉ email không hợp lệ!");
                    } else {
                        flag_email = true;
                        addNV.error[3].setText("");
                    }
                    
                    if (cv.equals("")) {
                        addNV.error[4].setText("Mời chọn chức vụ");
                    } else {
                        flag_cv = true;
                        addNV.error[4].setText("");
                    }
                    
                    if (flag_ten && flag_sdt && flag_email && flag_dc && flag_cv  ) {
                        int r2 = JOptionPane.showConfirmDialog(null, "Bạn đã chắc chắn với thông tin nhập vào?", "Thêm nhà cung cấp ", JOptionPane.YES_NO_OPTION);
                        if (r2 == JOptionPane.YES_OPTION) {
                            nvBUS.add(ten, cv,  Integer.parseInt(sdt), dchi, email);
                            nvGUI.reloadPage();
                            JOptionPane.showMessageDialog(null, "Thêm nhân viên mới thành công!");
                            dispose();

                        } else {
                            // Thực hiện hành động khi người dùng chọn No hoặc đóng cửa sổ
                        }

                    }

                    break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
        try {
            JPanel btn = (JPanel) e.getSource();
            btn.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
            btn.setOpaque(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        try {
            JPanel btn = (JPanel) e.getSource();
            btn.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
            btn.setOpaque(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        Trangnhanvien_GUI nvGUI = new Trangnhanvien_GUI(1200,700);
        addNhanvienGUI k = new addNhanvienGUI(nvGUI);
    }
}


