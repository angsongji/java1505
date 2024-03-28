package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class TrangTaiKhoan extends JPanel {

    ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
    JPanel pnHead;
    JPanel[] pnContent;
    private int width, height;
    private Color normal = Color.decode("#0A3D62");
    Font font = new Font("Segoe UI", Font.BOLD, 12);

    String[] thuocTinh = {"Mã nhân viên", "Username", "Password", "Ngày tạo", "Mã Quyền", "Tình Trạng", "Action"};

    public TrangTaiKhoan(int width, int height) {
        this.width=width;
        this.height=height;
        initDSTK();
        init(width, height);
    }

    public void initDSTK() {
        dstk.add(new TaiKhoan("MANV001", "Thanh123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV002", "Phuong123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV003", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV004", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV005", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV006", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV007", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV008", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV009", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV010", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV011", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV012", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV013", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV014", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV015", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV016", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
        dstk.add(new TaiKhoan("MANV017", "An123", "123456", "12/12/2023", "AD", "Đang hoạt động"));
    }


    public void init(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        pnHead = new JPanel();
        pnHead.setLayout(new GridLayout(1, 7, 10, 0));
        pnHead.setPreferredSize(new Dimension(width, 30));
        Border borderBottom = BorderFactory.createMatteBorder(0, 0, 2, 0, normal);
        pnHead.setBorder(borderBottom);

        JLabel[] lblHead = new JLabel[thuocTinh.length];
        for (int i = 0; i < lblHead.length; i++) {
            lblHead[i] = new JLabel(thuocTinh[i], JLabel.CENTER);
            lblHead[i].setFont(font);
            pnHead.add(lblHead[i]);
        }

        this.add(pnHead);

        borderBottom = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#60A3BC"));
        pnContent = new JPanel[dstk.size()];
        for (int i = 0; i < dstk.size(); i++) {
            final int id = i;
            pnContent[i] = new JPanel();
            pnContent[i].setLayout(new GridLayout(1, 7, 10, 0));
            pnContent[i].setPreferredSize(new Dimension(width, 30));

            pnContent[i].setBorder(borderBottom);
            JLabel[] lblContent = new JLabel[thuocTinh.length];

            String[] value;

            value = new String[]{dstk.get(i).getMaNV(), dstk.get(i).getUsername(), dstk.get(i).getPassword(),
                dstk.get(i).getNgayTao(), dstk.get(i).getMaQuyen(), dstk.get(i).getState()};

            for (int j = 0; j < thuocTinh.length - 1; j++) {
                final int index = j;
                lblContent[j] = new JLabel(value[j], JLabel.CENTER);
                lblContent[j].setForeground(normal);
                lblContent[0].setFont(font);
                pnContent[i].add(lblContent[j]);

                lblContent[j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println(lblContent[index].getText());
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        lblContent[index].setBackground(Color.LIGHT_GRAY);
                        lblContent[index].setOpaque(true);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        lblContent[index].setBackground(null);
                    }
                });

            }

            ImageIcon icon = new ImageIcon("./src/images/User-Lock.png");

            Image scaledImage = icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(scaledImage);
            lblContent[lblContent.length - 1] = new JLabel(resizedIcon, JLabel.CENTER);
            lblContent[lblContent.length - 1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            pnContent[i].add(lblContent[lblContent.length - 1]);
            this.add(pnContent[i]);

            lblContent[lblContent.length - 1].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (dstk.get(id).getState().equalsIgnoreCase("Đang hoạt động")) {
                        dstk.set(id, new TaiKhoan("Đã khoá"));
                        lblContent[lblContent.length - 2].setText("Đã khoá");
                        
                    } else {
                        dstk.set(id, new TaiKhoan("Đang hoạt động"));
                        lblContent[lblContent.length - 2].setText("Đang hoạt động");
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
                    lblContent[lblContent.length - 1].setBackground(Color.LIGHT_GRAY);
                    lblContent[lblContent.length - 1].setOpaque(true);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    lblContent[lblContent.length - 1].setBackground(null);
                }
            });

        }
    }

}
