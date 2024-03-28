
package GUI;

import java.awt.*;
import javax.swing.*;


public class ThongTinTaiKhoan extends JPanel {
    private JPanel pnContent;
    private JLabel headerTitle;
    private JTextField txtNameNV,txtChucVuNV,txtUsername,txtOldPassword,txtNewPassword,txtNgayTao;
    private JLabel[] lbltext= new JLabel[5];
    private String[] text ={"Tên nhân viên","Chức vụ","Tên đăng nhập","Thay đổi mật khẩu","Ngày tạo tài khoản"};
    
    private Color normal = Color.decode("#0A3D62");
    Font font = new Font("Segoe UI", Font.BOLD, 16);
    Font fontHeader = new Font("Segoe UI", Font.BOLD, 20);
    private int chieurong,chieucao;//Oanh them
    private Color backGroundColor;
    public ThongTinTaiKhoan(String txtNameNV, String txtChucVuNV, String txtUsername, String txtOldPassword, String txtNewPassword, String txtNgayTao,int chieurong,int chieucao,Color backG_thisJPanel) {
        this.txtNameNV = new JTextField(txtNameNV);
        this.txtChucVuNV = new JTextField(txtChucVuNV);
        this.txtUsername = new JTextField(txtUsername);
        this.txtOldPassword =  new JPasswordField(txtOldPassword,6);
        this.txtNewPassword = new JPasswordField(txtNewPassword,6);
        this.txtNgayTao = new JTextField(txtNgayTao);
        this.chieurong=chieurong;
        this.chieucao=chieucao;
        this.backGroundColor=backG_thisJPanel;
        init();
        showGridBagLayoutDemo();
    }
    
    
    public ThongTinTaiKhoan(){
        init();
        showGridBagLayoutDemo();
    }
    
    public void init(){
        this.setPreferredSize(new Dimension(chieurong,chieucao));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(backGroundColor);
        this.setOpaque(true);
        JPanel wrap_headerTitle= new JPanel(new FlowLayout());//them cai nay de chinh headerTitle center
        wrap_headerTitle.setPreferredSize(new Dimension(chieurong,10));
        wrap_headerTitle.setBackground(backGroundColor);
        wrap_headerTitle.setOpaque(true);
        headerTitle = new JLabel("Thông tin tài khoản",JLabel.CENTER);
        headerTitle.setForeground(normal);
        headerTitle.setFont(fontHeader);
        wrap_headerTitle.add(headerTitle);

        
        this.add(wrap_headerTitle);
        this.add(Box.createVerticalStrut(20));//tạo khoảng cách giữa các thành phần theo chiều dọc
        
        pnContent = new JPanel();
        pnContent.setLayout(new FlowLayout());
        pnContent.setBackground(backGroundColor);
        pnContent.setOpaque(true);
        //pnContent.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        this.add(pnContent); 
        
        for(int i=0; i< lbltext.length;i++){
            lbltext[i]= new JLabel(text[i]);
            lbltext[i].setFont(font);
            lbltext[i].setForeground(normal);
        }
        
    }
    
    private void showGridBagLayoutDemo(){
        JPanel panel = new JPanel();
        panel.setSize(chieucao, chieucao);
        panel.setBackground(backGroundColor);
        panel.setOpaque(true);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.ipadx = 5;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lbltext[0], gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtNameNV, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lbltext[1], gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtChucVuNV, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lbltext[2], gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtUsername, gbc);
        
        // Label "Thay đổi mật khẩu"
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 2; // Thay đổi độ cao của thành phần thành 2 hàng
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lbltext[3], gbc);

        // TextField "Mật khẩu cũ"
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 1; // Trả lại độ cao của thành phần về 1 hàng
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtOldPassword, gbc);

        // TextField "Mật khẩu mới"
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtNewPassword, gbc);

        // Label "Ngày tạo tài khoản" và TextField tương ứng
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lbltext[4], gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtNgayTao, gbc);

        pnContent.add(panel);
     }
    
}
