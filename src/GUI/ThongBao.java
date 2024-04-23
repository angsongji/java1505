package GUI;

import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ThongBao extends JPanel implements MouseListener {

    TaiKhoanBUS tkBUS = new TaiKhoanBUS();
    ArrayList<TaiKhoanDTO> dstk = new ArrayList<TaiKhoanDTO>();
    TaiKhoanDTO selectedTK = new TaiKhoanDTO();

    JPanel pnHeader, pnContent, pnChucNang;
    JLabel exit;
    JTextField txt[];
    JPasswordField pwfMK; //mật khẩu
    JComboBox<String> cbxMaQuyen;
    JLabel[] lbltext;
    JLabel[] blbThongbao;
    JLabel lblHuy, lblThem, lblCapNhat, lblXoa; //nút thêm, lưu, huy
    String[] text = {"Mã nhân viên", "Username", "Password", "Mã quyền"};

    Color tieude = Color.decode("#60A3BC");
    Color normal = Color.decode("#0A3D62");
    Color chu = Color.decode("#FFFFFF"); //mau chu cua 2 nút huy, them
    Font font_tieude = new Font("Tahoma", Font.BOLD, 18);
    Font font = new Font("Tahoma", Font.BOLD, 15);
    Font font_family = new Font("Tahoma", Font.PLAIN, 12);

    public TaiKhoanDTO getSelectedTK() {
        return selectedTK;
    }

    public void setSelectedTK(TaiKhoanDTO selectedTK) {
        this.selectedTK = selectedTK;
    }

    public ThongBao() {
    }

    public ThongBao(int width, int height) {
        dstk = tkBUS.getDsTK();

        init(width, height);
        lbltext = new JLabel[4];
        for (int i = 0; i < lbltext.length; i++) {
            lbltext[i] = new JLabel(text[i]);
            lbltext[i].setFont(font);
            lbltext[i].setForeground(normal);
        }

        txt = new JTextField[2];
        for (int i = 0; i < txt.length; i++) {
            txt[i] = new JTextField();
            txt[i].setFont(font_family);
            txt[i].setBorder(new EmptyBorder(0, 5, 0, 5));
            txt[i].setPreferredSize(new Dimension(150, 20));
        }
        initContent();
        pnContent.add(pnChucNang);

        //Chuc nang
        lblHuy = new JLabel("Huỷ", JLabel.CENTER);
        lblHuy.setPreferredSize(new Dimension(80, 30));
        lblHuy.setForeground(chu);
        lblHuy.setFont(font);
        lblHuy.setBackground(normal);
        lblHuy.setOpaque(true);

    }

    public void init(int width, int height) {
        this.setLayout(new BorderLayout());
        this.setSize(width, height);

        pnHeader = new JPanel();
        pnHeader.setLayout(new BorderLayout());
        pnHeader.setPreferredSize(new Dimension(width, 36));
        pnHeader.setBackground(Color.decode("#60A3BC"));
        pnHeader.setOpaque(true);
        ImageIcon icon = new ImageIcon("./src/images/exit_icon.png");
        exit = new JLabel(icon, JLabel.CENTER);
        exit.setPreferredSize(new Dimension((int) pnHeader.getPreferredSize().getHeight(),
                (int) pnHeader.getPreferredSize().getHeight()));
        exit.setBackground(Color.red);
        exit.setOpaque(true);
        exit.addMouseListener(this);
        pnHeader.add(exit, BorderLayout.EAST);
        this.add(pnHeader, BorderLayout.NORTH);

        pnChucNang = new JPanel();
        pnChucNang.setLayout(new FlowLayout(1, 20, 20));
        pnChucNang.setPreferredSize(new Dimension(width, 50));

        pnContent = new JPanel();
        pnContent.setLayout(new FlowLayout());
        pnContent.setPreferredSize(new Dimension(width, height));
        this.add(pnContent, BorderLayout.CENTER);

//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//        this.setLocationRelativeTo(null);
    }

    private void initContent() {
        //Mã quyền
        cbxMaQuyen = new JComboBox<>();
//        for(int i=0; i<dstk.size();i++){
        //truyền dữ liệu của bảng quyền vô
//        }
        cbxMaQuyen.addItem("AD");
        cbxMaQuyen.addItem("QNV");
        cbxMaQuyen.addItem("QQLHT");
        cbxMaQuyen.addItem("QQLK");
        cbxMaQuyen.addItem("QQLBH");

        //----------------Mật khẩu-------------------------------------
        pwfMK = new JPasswordField();
        pwfMK.setPreferredSize(new Dimension(130, 30));
        pwfMK.setBorder(new EmptyBorder(0, 5, 0, 5));
        ImageIcon icon = new ImageIcon("D:/thanh phuong/images/eye-off-icon.png");
        Image scaledImage = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        JLabel lbl = new JLabel(resizedIcon, JLabel.CENTER);

        JPanel pnMK = new JPanel();
        pnMK.setPreferredSize(new Dimension(150, 20));
        pnMK.setBackground(Color.WHITE);
        pnMK.setOpaque(true);
        pnMK.setLayout(new BorderLayout());
        pnMK.add(pwfMK, BorderLayout.WEST);
        pnMK.add(lbl, BorderLayout.EAST);
        //-------------------------------------------------------------------
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.ipadx = 5;
        gbc.ipady = 5;
//        gbc.gridheight = 2;
        for (int i = 0; i < lbltext.length; i++) {
            gbc.gridy = i;
            gbc.gridx = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel.add(lbltext[i], gbc);
        }
//        gbc.gridheight = 1;
        for (int i = 0; i < txt.length; i++) {
            gbc.gridy = i;
            gbc.gridx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel.add(txt[i], gbc);
        }

        gbc.gridy = lbltext.length - 2;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(pnMK, gbc);

        gbc.gridy = lbltext.length - 1;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(cbxMaQuyen, gbc);

        pnContent.add(panel);
    }

    public void initThem() {
        JLabel title = new JLabel("Thêm tài khoản", JLabel.CENTER);
        title.setFont(font_tieude);
        title.setBorder(new EmptyBorder(0, 20, 0, 0));
        pnHeader.add(title, BorderLayout.WEST);

        lblThem = new JLabel("Thêm", JLabel.CENTER);
        lblThem.setPreferredSize(new Dimension(80, 30));
        lblThem.setForeground(Color.WHITE);
        lblThem.setFont(font);
        lblThem.setBackground(normal);
        lblThem.setOpaque(true);
        pnChucNang.add(lblThem);
        pnChucNang.add(lblHuy);

    }

    public void initCapNhat() {
        JLabel title = new JLabel("Cập nhật tài khoản", JLabel.CENTER);
        title.setFont(font_tieude);
        title.setBorder(new EmptyBorder(0, 20, 0, 0));
        pnHeader.add(title, BorderLayout.WEST);
        set();

        lblCapNhat = new JLabel("Lưu", JLabel.CENTER);
        lblCapNhat.setPreferredSize(new Dimension(80, 30));
        lblCapNhat.setForeground(chu);
        lblCapNhat.setFont(font);
        lblCapNhat.setBackground(normal);
        lblCapNhat.setOpaque(true);
        pnChucNang.add(lblCapNhat);
        pnChucNang.add(lblHuy);

    }

    public void set() {
        txt[0].setText(selectedTK.getMaNV());
        txt[0].setEditable(false);
        txt[1].setText(selectedTK.getUsername());
        pwfMK.setText(selectedTK.getPassword());
        cbxMaQuyen.setSelectedItem(selectedTK.getMaQuyen());
        System.out.println(selectedTK.getMaNV());
    }

    private void initXoa() {

    }

    private void checkEmpty() {
//        if()
    }

    public static void main(String[] args) {
        ThongBao t = new ThongBao(450, 500);
//        t.initThem();
        t.initCapNhat();
//            t.initXoa();
        JFrame f = new JFrame();
//        JScrollPane scrollPane = new JScrollPane(t);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        f.add(t);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(450, 500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel lbl = (JLabel) e.getSource();
        if (lbl == exit) {
            Container container = getParent(); // Lấy container chứa JPanel hiện tại
            container.remove(this); // Loại bỏ JPanel khỏi container
            container.revalidate(); // Cập nhật lại container
            container.repaint(); // Vẽ lại
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
