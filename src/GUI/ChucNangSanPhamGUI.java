package GUI;

import BUS.loaiSPBUS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboPopup;

public class ChucNangSanPhamGUI extends JFrame implements MouseListener {

    private JPanel pnHeader, pnContent;
    JPanel pnThaoTac;
    private JLabel exit, lblThem, lblHuy, lblSua, lblXoa;
    private JPanel anhSP;
    private JLabel imageNameLabel; // hiển thị tên ảnh đã chọn
    private JLabel imageLabel; // jlabel chứa ảnh
    JComboBox<String> cbxMaLoai, cbxMaSize;
    JTextField txtMaSP, txtTenSP, txtDonGia, txtSoLuong;

    int width, height;
    int height_row = 30;

    private Color normal = Color.decode("#0A3D62");
    Color hover = Color.decode("#60A3BC");
    Color tieude = Color.decode("#60A3BC");
    Color chu = Color.decode("#FFFFFF"); //mau chu cua 2 nút huy, them
    Font font_tieude = new Font("Tahoma", Font.BOLD, 18);
    Font font = new Font("Tahoma", Font.BOLD, 13);
    Font font_family = new Font("Tahoma", Font.PLAIN, 12);

    public ChucNangSanPhamGUI(int width, int height) {
        this.width = width;
        this.height = height;
        init();
    }

    public void init() {
        this.setSize(width, height);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setUndecorated(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    public void initPnHead() {
        pnHeader = new JPanel();
        pnHeader.setLayout(new BorderLayout());
        pnHeader.setPreferredSize(new Dimension(width, 36));
        pnHeader.setBackground(Color.decode("#60A3BC"));
        pnHeader.setOpaque(true);

        ImageIcon icon = new ImageIcon("./src/images/exit_icon.png");
        exit = new JLabel(icon, JLabel.CENTER);
        exit.setPreferredSize(new Dimension(36, 36));
        exit.setBackground(Color.RED);
        exit.setOpaque(true);
        exit.addMouseListener(this);
        exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        pnHeader.add(exit, BorderLayout.EAST);
        this.add(pnHeader, BorderLayout.NORTH);
    }

    private void initContent() {
        // Tạo panel chính và đặt bố cục theo chiều dọc (Y_AXIS)
        pnContent = new JPanel();
        pnContent.setLayout(new BoxLayout(pnContent, BoxLayout.Y_AXIS));
        pnContent.setPreferredSize(new Dimension(width, height)); // Kích thước cố định cho panel chính
        pnContent.add(Box.createRigidArea(new Dimension(0, 10))); // Tạo khoảng cách giữa các hàng

        // Tạo JPanel để hiển thị hình ảnh
        anhSP = new JPanel();
        anhSP.setMinimumSize(new Dimension(200, 250));
        anhSP.setPreferredSize(new Dimension(200, 250)); // Đặt kích thước cố định cho panel ảnh
        anhSP.setMaximumSize(new Dimension(200, 250));
        anhSP.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Tạo viền
        imageLabel = new JLabel(); // Để hiển thị hình ảnh
        anhSP.add(imageLabel); // Thêm vào panel

        // Tạo JLabel để hiển thị tên hình ảnh đã chọn
        imageNameLabel = new JLabel("No image selected", JLabel.CENTER); // Mặc định là không có hình ảnh được chọn
        imageNameLabel.setPreferredSize(new Dimension(200, 30)); // Đặt kích thước cố định để tránh bị dịch chuyển

        // Tạo JButton để chọn hình ảnh
        JButton chooseImageButton = new JButton("Choose File");
        chooseImageButton.setPreferredSize(new Dimension(100, 30)); // Đặt kích thước cố định cho nút
        chooseImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setAcceptAllFileFilterUsed(false); // Không chấp nhận tất cả các loại tệp
                fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "gif"));

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    imageNameLabel.setText("Selected Image: " + selectedFile.getName()); // Hiển thị tên tệp

                    // Tạo ImageIcon từ tệp và đặt kích thước phù hợp
                    ImageIcon icon = new ImageIcon(selectedFile.getPath());
                    Image scaledImage = icon.getImage().getScaledInstance(174, 210, Image.SCALE_SMOOTH); // Đặt kích thước cố định
                    imageLabel.setIcon(new ImageIcon(scaledImage)); // Đặt hình ảnh vào JLabel

                    // Cập nhật giao diện
                    revalidate();
                    repaint();
                }
            }
        });

        // Thiết lập alignment
        anhSP.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        chooseImageButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Thêm các thành phần vào pnContent
        pnContent.add(anhSP);
        pnContent.add(Box.createRigidArea(new Dimension(0, 5))); // Khoảng cách giữa các thành phần
        pnContent.add(imageNameLabel);
        pnContent.add(Box.createRigidArea(new Dimension(0, 5))); // Khoảng cách
        pnContent.add(chooseImageButton);
        pnContent.add(Box.createRigidArea(new Dimension(0, 20))); // Tạo khoảng cách giữa các hàng

        //--------------- Tạo combobox cbxMaLoai ------------------------
        loaiSPBUS maLoai = new loaiSPBUS();
        cbxMaLoai = new JComboBox<>();
        cbxMaLoai.setMinimumSize(new Dimension(200, height_row));
        cbxMaLoai.setPreferredSize(new Dimension(200, height_row));
        cbxMaLoai.setMaximumSize(new Dimension(200, height_row));
        for (int i = 0; i < 5; i++) {
            cbxMaLoai.addItem(maLoai.getList().get(i).getMALOAI());
        }
        cbxMaLoai.setSelectedIndex(0);
        
        // ----------Tạo ScrollPane cho combobox cbxMaLoai -------//
        cbxMaLoai.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                JComboBox combo = (JComboBox) e.getSource();
                BasicComboPopup popup = (BasicComboPopup) combo.getUI().getAccessibleChild(combo, 0);
                JScrollPane scrollPane = (JScrollPane) popup.getComponent(0);

                // Đặt kích thước cuộn
                scrollPane.setPreferredSize(new Dimension(100, 100)); // Chiều cao tối đa của popup
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                // Không cần xử lý gì ở đây
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                // Không cần xử lý gì ở đây
            }
        });

        //------------------- Tạo combobox cbxMaSize ---------------------------
        cbxMaSize = new JComboBox<>();
        cbxMaSize.setMinimumSize(new Dimension(200, height_row));
        cbxMaSize.setPreferredSize(new Dimension(200, height_row));
        cbxMaSize.setMaximumSize(new Dimension(200, height_row));
        for (int i = 0; i < 10; i++) {
            cbxMaSize.addItem(i + 1 + "");
        }
        cbxMaSize.setSelectedIndex(0);

        // ----------Tạo ScrollPane cho combobox cbxMaSize -------//
        cbxMaSize.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                JComboBox combo = (JComboBox) e.getSource();
                BasicComboPopup popup = (BasicComboPopup) combo.getUI().getAccessibleChild(combo, 0);
                JScrollPane scrollPane = (JScrollPane) popup.getComponent(0);

                // Đặt kích thước cuộn
                scrollPane.setPreferredSize(new Dimension(100, 100)); // Chiều cao tối đa của popup
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                // Không cần xử lý gì ở đây
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                // Không cần xử lý gì ở đây
            }
        });

        //------------------- thông tin cần chỉnh sửa --------------------------
        String thuocTinh[] = {"Mã loại:", "Mã sản phẩm:", "Tên sản phẩm:", "Đơn giá:", "Số lượng:", "Mã size:"};
        //------------ Mã loại -----------------
        JPanel panelcon1 = new JPanel();
        panelcon1.setLayout(new GridLayout(1, 1, 10, 10));
        panelcon1.setPreferredSize(new Dimension(300, height_row));
        panelcon1.setMaximumSize(new Dimension(300, height_row));
        JLabel lbl1 = new JLabel(thuocTinh[0], JLabel.LEFT);
        lbl1.setFont(font);
        lbl1.setPreferredSize(new Dimension(100, height_row)); // Kích thước cố định

        panelcon1.add(lbl1);
        panelcon1.add(cbxMaLoai);
        pnContent.add(panelcon1);
        pnContent.add(Box.createRigidArea(new Dimension(0, 10))); // Tạo khoảng cách giữa các hàng

        //------------------- thông tin còn lại-----------------
        for (int i = 1; i < 5; i++) {
            JPanel panelcon = new JPanel();
            panelcon.setLayout(new GridLayout(1, 1, 10, 10)); // Mỗi hàng có 7 cột, khoảng cách 10px
            JLabel lbl = new JLabel(thuocTinh[i], JLabel.LEFT);
            lbl.setPreferredSize(new Dimension(100, height_row)); // Kích thước cố định
            lbl.setFont(font);
            JTextField txt = new JTextField();
            txt.setMinimumSize(new Dimension(200, height_row)); // Kích thước cố định
            txt.setPreferredSize(new Dimension(200, height_row)); // Kích thước cố định
            txt.setMaximumSize(new Dimension(200, height_row)); // Kích thước cố định
            panelcon.add(lbl);
            panelcon.add(txt);

            panelcon.setPreferredSize(new Dimension(300, height_row)); // Giữ chiều cao cố định
            panelcon.setMaximumSize(new Dimension(300, height_row));
            pnContent.add(panelcon); // Thêm vào panel chính
            pnContent.add(Box.createRigidArea(new Dimension(0, 10))); // Tạo khoảng cách giữa các hàng
        }

        //-------------------------- Mã size ------------------------------------
        JPanel panelcon2 = new JPanel();
        panelcon2.setLayout(new GridLayout(1, 1, 10, 10));
        panelcon2.setPreferredSize(new Dimension(300, height_row));
        panelcon2.setMaximumSize(new Dimension(300, height_row));
        JLabel lbl2 = new JLabel(thuocTinh[5], JLabel.LEFT);
        lbl2.setPreferredSize(new Dimension(100, height_row)); // Kích thước cố định
        lbl2.setFont(font);
        panelcon2.add(lbl2);
        panelcon2.add(cbxMaSize);
        pnContent.add(panelcon2);
        pnContent.add(Box.createRigidArea(new Dimension(0, 10))); // Tạo khoảng cách giữa các hàng

        // Thêm pnContent vào JPanel chính
        this.add(pnContent, BorderLayout.CENTER); // Thêm panel chính vào JFrame hoặc JPanel cha

        //-------------------- các nút thêm, sửa, xoá --------------------------
        pnThaoTac = new JPanel();
        pnThaoTac.setLayout(new FlowLayout());
        lblHuy = new JLabel("Huỷ", JLabel.CENTER);
        lblHuy.setPreferredSize(new Dimension(80, 30));
        lblHuy.setForeground(chu);
        lblHuy.setFont(font);
        lblHuy.setBackground(normal);
        lblHuy.setOpaque(true);
        lblHuy.addMouseListener(this);
        lblHuy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }

    //--------------------- Thao tac ---------------------------------------
    public void initThem() {
        JLabel title = new JLabel("Thêm sản phẩm", JLabel.CENTER);
        title.setFont(font_tieude);
        title.setBorder(new EmptyBorder(0, 20, 0, 0));
        pnHeader.add(title, BorderLayout.WEST);

        lblThem = new JLabel("Thêm", JLabel.CENTER);
        lblThem.setPreferredSize(new Dimension(80, 30));
        lblThem.setForeground(Color.WHITE);
        lblThem.setFont(font);
        lblThem.setBackground(normal);
        lblThem.setOpaque(true);
        lblThem.addMouseListener(this);
        lblThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnThaoTac.add(lblThem);
        pnThaoTac.add(lblHuy);
        pnContent.add(pnThaoTac);
    }

    public void initSua() {
        JLabel title = new JLabel("Cập nhật tài khoản", JLabel.CENTER);
        title.setFont(font_tieude);
        title.setBorder(new EmptyBorder(0, 20, 0, 0));
        pnHeader.add(title, BorderLayout.WEST);
        cbxMaLoai.setEnabled(false);
//        setTT();
        lblSua = new JLabel("Lưu", JLabel.CENTER);
        lblSua.setPreferredSize(new Dimension(80, 30));
        lblSua.setForeground(chu);
        lblSua.setFont(font);
        lblSua.setBackground(normal);
        lblSua.setOpaque(true);
        lblSua.addMouseListener(this);
        lblSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnThaoTac.add(lblSua);
        pnThaoTac.add(lblHuy);

    }
//-------------------------------- Hàm xử lý --------------------------------------
    public void AddSP(){
        String maLString = (String) cbxMaLoai.getSelectedItem();
        String maString = (String)cbxMaSize.getSelectedItem();
        String maSP = txtMaSP.getText();
        String tenSP = txtTenSP.getText();
        double donGia = Double.parseDouble(txtDonGia.getText());
        double thanhTien = Double.parseDouble(txtDonGia.getText());
        
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel lbl = (JLabel) e.getSource();
        if (lbl == exit || lbl == lblHuy) {
            this.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Không cần triển khai
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Không cần triển khai
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Không cần triển khai
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Không cần triển khai
    }

    public static void main(String[] args) {
        ChucNangSanPhamGUI gui = new ChucNangSanPhamGUI(600, 700);
        gui.initPnHead();
        gui.initContent();
        gui.initThem();
    }
}
