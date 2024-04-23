package GUI;

import BUS.TaiKhoanBUS;
import DTO.TaiKhoanDTO;
import GUI.ThongBao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class TaiKhoanGUI extends JPanel implements MouseListener {

    TaiKhoanBUS tkBUS = new TaiKhoanBUS();
    ArrayList<TaiKhoanDTO> dstk = new ArrayList<TaiKhoanDTO>();
    TaiKhoanDTO selectedTK = new TaiKhoanDTO();
    int yes =0;
    ThongBao t;

    JPanel pnHead;
    JPanel pnContentParent;
    JPanel[] pnContent;
    private int width, height;
    private Color normal = Color.decode("#0A3D62");
    Color hover = Color.decode("#60A3BC");

    Font font = new Font("Tahoma", Font.BOLD, 13);
    Font font_family = new Font("Tahoma", Font.PLAIN, 12);
    String[] thuocTinh = {"Mã nhân viên", "Username", "Password", "Ngày tạo", "Mã Quyền", "Tình Trạng", "Action"};

    public TaiKhoanGUI() {
        dstk = tkBUS.getDsTK();//truyen du lieu vao lop GUI
    }

    public TaiKhoanGUI(int width, int height) {
        this.width = width;
        this.height = height;

        dstk = tkBUS.getDsTK();//truyen du lieu vao lop GUI

        init(width, height);
    }

    public TaiKhoanDTO getSelectedTK() {
        return selectedTK;
    }

    public void set(){
        yes = 1;
        t.initCapNhat();
        t.setVisible(true);
    }
    
    public void add(){
        t.initThem();
        t.setVisible(true);
    }
    public void init(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new BorderLayout());

        pnHead = new JPanel();
        pnHead.setLayout(new GridLayout(1, 7));
        pnHead.setPreferredSize(new Dimension(width - 450, 35));
        Border borderBottom = BorderFactory.createMatteBorder(0, 0, 2, 0, normal);
        pnHead.setBorder(borderBottom);

        JLabel[] lblHead = new JLabel[thuocTinh.length];
        for (int i = 0; i < lblHead.length; i++) {
            lblHead[i] = new JLabel(thuocTinh[i], JLabel.CENTER);
            lblHead[i].setFont(font);
            pnHead.add(lblHead[i]);
            pnHead.setBackground(Color.decode("#FFFFFF"));
            pnHead.setOpaque(true);
        }

        pnContentParent = new JPanel(new GridLayout(dstk.size(), 1));
        borderBottom = BorderFactory.createMatteBorder(0, 0, 1, 0, normal);

        pnContent = new JPanel[dstk.size()];
        for (int i = 0; i < dstk.size(); i++) {
            final int id = i;
            pnContent[i] = new JPanel();
            pnContent[i].setLayout(new GridLayout(1, 7));
            pnContent[i].setPreferredSize(new Dimension(width - 450, 30));
            pnContent[i].setBorder(borderBottom);
            pnContent[i].setBackground(Color.decode("#FFFFFF"));
            pnContent[i].setOpaque(true);
            JLabel[] lblContent = new JLabel[thuocTinh.length];

            String[] value;

            value = new String[]{dstk.get(i).getMaNV(), dstk.get(i).getUsername(), dstk.get(i).getPassword(),
                dstk.get(i).getNgayTao(), dstk.get(i).getMaQuyen(), (dstk.get(i).getState() == 1) ? "Đang hoạt động" : "Đã khoá"};

            for (int j = 0; j < thuocTinh.length - 1; j++) {
                final int index = j;
                lblContent[j] = new JLabel(value[j], JLabel.CENTER);
                lblContent[j].setForeground(normal);
                lblContent[j].setFont(font_family);
                lblContent[0].setFont(new Font("Tahoma", Font.BOLD, 12));
                pnContent[i].add(lblContent[j]);
            }

            ImageIcon icon = new ImageIcon("./src/images/User-Lock.png");

            Image scaledImage = icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(scaledImage);
            lblContent[lblContent.length - 1] = new JLabel(resizedIcon, JLabel.CENTER);
            lblContent[lblContent.length - 1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            pnContent[i].add(lblContent[lblContent.length - 1]);
            pnContent[i].addMouseListener(this);
            pnContentParent.add(pnContent[i]);

            lblContent[lblContent.length - 1].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (dstk.get(id).getState() == 1) {
                        JPanel panel = new JPanel();
                        panel.setForeground(Color.RED); // Thiết lập màu chữ cho header

                        int result = JOptionPane.showConfirmDialog(panel, "Bạn có chắc chắn muốn khoá user này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            dstk.get(id).setState(0);
                            lblContent[lblContent.length - 2].setText("Đã khoá");
                        }

                    } else {
                        int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn mở khoá cho user này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            dstk.get(id).setState(1);
                            lblContent[lblContent.length - 2].setText("Đang hoạt động");
                        }
                    }
                    tkBUS.set(dstk.get(id));
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    lblContent[lblContent.length - 1].setBackground(Color.LIGHT_GRAY);
                    lblContent[lblContent.length - 1].setOpaque(true);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    lblContent[lblContent.length - 1].setBackground(null);
                }
            });
        }
        JScrollPane scrollPane = new JScrollPane(pnContentParent);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(pnHead, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        t = new ThongBao(450, height);
//        this.add(t, BorderLayout.EAST);
//        add();
//        t.setVisible(false);
//       
        this.add(mainPanel, BorderLayout.CENTER);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel pn = (JPanel) e.getSource();
        for (int i = 0; i < dstk.size(); i++) {
            if (pn == pnContent[i]) {
                selectedTK = dstk.get(i);
//               this.yes=1;
            Container container = getParent(); // Lấy container chứa JPanel hiện tại
            container.remove(this); // Loại bỏ JPanel khỏi container
//            t = new ThongBao(450, height);
            t.selectedTK= this.selectedTK;
            if(yes==1){
                t.set();
            }
            
//            t.initCapNhat();
//            System.out.println(t.selectedTK.getMaNV());
            container.add(this, BorderLayout.CENTER);
//            container.add(t, BorderLayout.EAST);
            container.revalidate(); // Cập nhật lại container
            container.repaint();
            }
        }

//        System.out.println(selectedTK.getMaNV());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JPanel pn = (JPanel) e.getSource();
        for (int i = 0; i < dstk.size(); i++) {
            if (pn == pnContent[i]) {
                pnContent[i].setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JPanel pn = (JPanel) e.getSource();
        for (int i = 0; i < dstk.size(); i++) {
            if (pn == pnContent[i]) {
                pnContent[i].setBackground(Color.decode("#FFFFFF"));
            }
        }
    }

    public static void main(String[] args) {
        TaiKhoanGUI t = new TaiKhoanGUI(800, 600);
        t.set();
        t.getPreferredSize();
        JFrame f = new JFrame();
        f.add(t);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 600);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

}
