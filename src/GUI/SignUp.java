package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.JPasswordField;


class SignUp extends JFrame {
    private JPanel MainPanel,left, right,form;
    private JPanel p1,p2,p3,p4,p5,p6;
    private ImageIcon imageIcon;
    private JLabel imageLabel, namestore, signup, submit;

   
    public void init() {

        //this.setTitle("SignUp");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,600);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        
        MainPanel = new JPanel();
        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.X_AXIS));
            left = new JPanel();
            right = new JPanel(); 
        
        //------------------------------------- AVT & STORE'S NAME---------------------------------------------------
                left.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue); // Sử dụng constructor của Color để tạo màu mới
                left.setPreferredSize(new Dimension(300, 0));
                left.setLayout(new GridLayout(2,1));
                // ------ AVT ------
                  /*  imageIcon = new ImageIcon("vvv.jpg");
                    imageLabel = new JLabel() {
                        @Override
                            protected void paintComponent(Graphics gr) {
                            // Vẽ hình ảnh ban đầu
                            super.paintComponent(gr);
                            // tạo khunh ảnh tròn
                            Graphics2D g = (Graphics2D) gr.create();
                            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                            int diameter = Math.min(160, getHeight()); // set đường kính
                            int x = (getWidth() - diameter) / 2; // Tọa độ x của hình tròn
                            int y = (getHeight() - diameter) / 2; // Tọa độ y của hình tròn
                            g.fillOval(x, y, diameter, diameter); // Vẽ hình tròn

                            // Set hình ảnh vào hình tròn
                            Image scaledImage = imageIcon.getImage().getScaledInstance(diameter, diameter, Image.SCALE_SMOOTH);
                            g.setClip(new Ellipse2D.Float(x, y, diameter, diameter));
                            g.drawImage(scaledImage, x, y, null);
                            g.dispose();
                        }
                    };*/
//------------- XỬ LÝ SỰ KIỆN THAY ĐỔI AVT ( NẾU CÓ )
//        imageLabel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                JFileChooser fileChooser = new JFileChooser();
//                int result = fileChooser.showOpenDialog(null);
//                if (result == JFileChooser.APPROVE_OPTION) {
//                    // Lấy đường dẫn của hình ảnh mới
//                    String imagePath = fileChooser.getSelectedFile().getPath();
//                    // Cập nhật hình ảnh mới
//                    imageIcon = new ImageIcon(imagePath);
//                    // Vẽ lại nhãn
//                    imageLabel.repaint();
//                }
//            }
//        });
        
                //----------STORE LOGO-------------
                    imageLabel = new JLabel(new ImageIcon("./src/images/store_logo.png"));
                
                // -------- STORE'S NAME ---------
                    namestore = new JLabel(Cacthuoctinh_phuongthuc_chung.storeName.toUpperCase(), JLabel.CENTER);
                    namestore.setFont(new Font(Cacthuoctinh_phuongthuc_chung.font_family, Font.BOLD, 24));
                    namestore.setForeground(Color.white);
       

        // -------------------------- FORM ĐĂNG KÝ -----------------------------
            right.setPreferredSize(new Dimension(400, 0));
            right.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue); 
            right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
            // tạo p1 - điều hướng ( exit / return )
                p1 = new JPanel();
                p1.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
                    FlowLayout f = new FlowLayout();
                p1.setLayout(f);
                // RETURN
                    JLabel re = new JLabel(Cacthuoctinh_phuongthuc_chung.return_icon, JLabel.LEFT);
                    re.setBounds(10,5,60,20);
                    re.setPreferredSize(new Dimension(180, 30));
                    re.addMouseListener(new MouseAdapter() {
                        
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            // TODO Auto-generated method stub
                             dispose();
                            setVisible(false);
                           
                            LoginUI l = new LoginUI();
                       
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            // TODO Auto-generated method stub
                            JLabel x= (JLabel) e.getSource();
                            x.removeAll();
                            x.setText("quay lại");
                            x.validate();
                            x.repaint();
                        }
                        public void mouseExited(MouseEvent e) {
                            // TODO Auto-generated method stub
                            JLabel x= (JLabel) e.getSource();
                            x.removeAll();
                            x.setText("");
                            x.validate();
                            x.repaint();
                        }
                    });
                    // ------- thay thế lệnh return bằng icon ------------
//        String imagePath1 = "C:/Users/jofob/Downloads/re.png";
//        ImageIcon icon1 = new ImageIcon(imagePath1);
//        if (icon1.getImage() == null) {
//            System.err.println("Không thể tìm thấy hình ảnh: " + imagePath1);
//            return;
//        }
//        BufferedImage image1 = new BufferedImage(icon1.getIconWidth(), icon1.getIconHeight(), BufferedImage.TYPE_INT_RGB);
//        Graphics g1 = image1.createGraphics();
//        icon1.paintIcon(null, g, 0, 0);
//        g1.dispose();
//        // Tùy chỉnh kích thước của hình ảnh
//        int scaledWidth1 = 40;
//        int scaledHeight1 = 60; 
//        Image scaledImage1 = image1.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
//        // Tạo mới ImageIcon từ hình ảnh đã thu nhỏ
//        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
//        // Thiết lập icon từ hình ảnh đã thu nhỏ
//        re.setIcon(scaledIcon1);

                //EXIT
                    JLabel e = new JLabel(Cacthuoctinh_phuongthuc_chung.exit_icon,JLabel.RIGHT );
                    e.setBounds(340,5,40,20);
                    e.setPreferredSize(new Dimension(180, 30));
                    e.addMouseListener(new MouseAdapter() {
                        
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            // TODO Auto-generated method stub
                            System.exit(0);
                       
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            // TODO Auto-generated method stub
                            JLabel x= (JLabel) e.getSource();
                            x.removeAll();
                            x.setText("đóng");
                            x.validate();
                            x.repaint();
                        }
                        public void mouseExited(MouseEvent e) {
                            // TODO Auto-generated method stub
                            JLabel x= (JLabel) e.getSource();
                            x.removeAll();
                            x.setText("");
                            x.validate();
                            x.repaint();
                        }
                    });
                        // ------- thay thế lệnh exit bằng icon ------------
//        String imagePath2 = "C:/Users/jofob/Downloads/re.png";
//        ImageIcon icon2 = new ImageIcon(imagePath2);
//        if (icon2.getImage() == null) {
//            System.err.println("Không thể tìm thấy hình ảnh: " + imagePath);
//            return;
//        }
//        BufferedImage image2 = new BufferedImage(icon2.getIconWidth(), icon2.getIconHeight(), BufferedImage.TYPE_INT_RGB);
//        Graphics g2 = image.createGraphics();
//        icon2.paintIcon(null, g, 0, 0);
//        g2.dispose();
//        // Tùy chỉnh kích thước của hình ảnh
//        int scaledWidth = 40;
//        int scaledHeight = 60; 
//        Image scaledImage2 = image2.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
//        // Tạo mới ImageIcon từ hình ảnh đã thu nhỏ
//        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
//        // Thiết lập icon từ hình ảnh đã thu nhỏ
//        e.setIcon(scaledIcon2);

                    p1.add(re);
                    p1.add(e);
        
        
            // tạo p2 - label ( Đăng ký )
                p2 = new JPanel();
                p2.setLayout( new BoxLayout(p2, BoxLayout.Y_AXIS));
                p2.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
                    signup = new JLabel("Đăng ký", SwingConstants.CENTER);
                    signup.setAlignmentX(Component.CENTER_ALIGNMENT);
                    signup.setFont(new Font(Cacthuoctinh_phuongthuc_chung.font_family, Font.BOLD, 30));
                    signup.setForeground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
                    Component verticalStrut1 = Box.createVerticalStrut(40);
                    Component verticalStrut2 = Box.createVerticalStrut(30);
                    p2.add( verticalStrut2 ); 
                    p2.add(signup);
                    p2.add( verticalStrut1 );
        
        
            // tạo p3 - tên đăng nhập
                p3 = new JPanel();
                p3.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
                    JPanel p = new JPanel();
                    p.setPreferredSize(new Dimension(400, 80));
                    p.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
                        JLabel username = new JLabel("Tên đăng nhập:", JLabel.CENTER);
                        username.setPreferredSize(new Dimension(150, 30));
                        username.setFont(new Font(Cacthuoctinh_phuongthuc_chung.font_family,Font.BOLD, 14));
                        username.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
                        username.setOpaque(true);
                        username.setForeground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
                        JTextField inpname = new JTextField();
                        inpname.setPreferredSize(new Dimension(200, 30));
                        JLabel warning1 = new JLabel("*Không được để trống!", JLabel.RIGHT);
                        warning1.setPreferredSize(new Dimension(200, 30));
                        warning1.setForeground(Cacthuoctinh_phuongthuc_chung.error);
                    p.add(username);
                    p.add(inpname);
                    p.add(warning1);
                p3.add(p);     
        
            // tạo p4 - mật khẩu
                p4 = new JPanel();
                p4.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
                    JPanel q = new JPanel();
                    q.setPreferredSize(new Dimension(400, 80));
                    q.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
                        JLabel password = new JLabel("Mật khẩu:", JLabel.CENTER);
                        password.setPreferredSize(new Dimension(150, 30));
                        password.setFont(new Font(Cacthuoctinh_phuongthuc_chung.font_family, Font.BOLD, 14));
                        password.setForeground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
                        JPasswordField pass = new JPasswordField();
                        pass.setPreferredSize(new Dimension(200, 30));
                        JLabel warning2 = new JLabel("*Không được để trống!!", JLabel.RIGHT);
                        warning2.setPreferredSize(new Dimension(200, 30));
                        warning2.setForeground(Cacthuoctinh_phuongthuc_chung.error);
                    q.add(password);
                    q.add(pass);
                    q.add(warning2);
                p4.add(q);
        
            // tạo p5 - nhập lại mk
                p5 = new JPanel();
                p5.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
                    JPanel r = new JPanel();
                    r.setPreferredSize(new Dimension(420, 80));
                    r.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
                        JLabel repassword = new JLabel("Nhập lại mật khẩu:", JLabel.LEFT);
                        repassword.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
                        repassword.setFont(new Font(Cacthuoctinh_phuongthuc_chung.font_family, Font.BOLD, 14));
                        repassword.setPreferredSize(new Dimension(150, 30));
                        repassword.setOpaque(true);
                        repassword.setForeground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
                        JPasswordField repass = new JPasswordField();
                        repass.setPreferredSize(new Dimension(200, 30));
                        JLabel warning3 = new JLabel("*Không được để trống!", JLabel.RIGHT);
                        warning3.setPreferredSize(new Dimension(200, 30));
                        warning3.setForeground(Cacthuoctinh_phuongthuc_chung.error);
                    r.add(repassword);
                    r.add(repass);
                    r.add(warning3);
                p5.add(r);
        
        
            // tạo p6 - click xác nhận
                p6 = new JPanel();
                    JLabel submit = new JLabel("Xác nhận".toUpperCase(), JLabel.CENTER);
                    submit.setPreferredSize(new Dimension(100, 40));
                    submit.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
                    submit.setForeground(Color.WHITE);
                    submit.setOpaque(true);
                    MouseListener mouseListener = new MouseListener() {
                        @Override
                            public void mouseClicked(MouseEvent e) {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }

                        @Override
                            public void mousePressed(MouseEvent e) {
                                submit.setBackground(Color.WHITE);
                                submit.setForeground(Color.GRAY);
                                submit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                                System.out.println("Mouse Pressed"); 
                            }
                         @Override
                            public void mouseReleased(MouseEvent e) {
                                submit.setBackground(Color.BLACK);
                                submit.setForeground(Color.WHITE);
                                submit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                                System.out.println("mouse Released"); 
                            }
                         @Override
                            public void mouseEntered(MouseEvent e) {
                                submit.setBackground(Color.WHITE);
                                submit.setForeground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
                                //submit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                                System.out.println("mouse Entered"); 
                            }
                         @Override
                            public void mouseExited(MouseEvent e) {
                                submit.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
                                submit.setForeground(Color.WHITE);
                                //submit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                                System.out.println("mouse Exited"); 
                            }
                        }  ;
                    submit.addMouseListener( mouseListener);  
                    Component verticalStrut = Box.createVerticalStrut(30);
                    p6.add(verticalStrut);
                    p6.add(submit);
                    p6.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);

        // Thêm nhãn vào frame
        left.add(imageLabel);
        left.add(namestore);
        right.add(p1);
        right.add(p2);
        right.add(p3);
        right.add(p4);
        right.add(p5);
        right.add(p6);
        
        MainPanel.add(left);
        MainPanel.add(right); 
        this.add(MainPanel);
        this.setVisible(true);
    }

 
    public SignUp() {
        init();
    }
        
    public static void main(String []args){
    SignUp s= new SignUp();
    }
}
