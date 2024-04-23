/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.sql.ResultSet;
import javax.swing.JPanel;
import DTO.chitietquyenDTO;
import DTO.chucnangDTO;
import DAO.chitietquyenDAO;
import BUS.chitietquyenBUS;
import BUS.chucnangBUS;
import DTO.quyenDTO;
import BUS.quyenBUS;
import DAO.ConnectDataBase;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author hp
 */
public class phanquyen extends JPanel implements MouseListener {

    private int ccao, crong;
    private JTable table;
    private Font font_data = new Font("Tahoma", Font.PLAIN, 14);
    private DefaultTableModel tableModel;
    private JPanel JP_listNameQuyen;
    private JPanel JP_selectedQuyen;
    private String[] columnNames = {"", "Xem", "Thêm", "Xóa", "Sửa"};
    private quyenDTO currentQuyen;
    private ArrayList<quyenDTO> listQuyen;
    private ArrayList<chucnangDTO> listChucnang;
    private JPanel JP_quyenSelected;

    public phanquyen(int crong, int ccao) {
        this.ccao = ccao;
        this.crong = crong;
        currentQuyen = new quyenDTO("QQLHT", "Quyền quản lí hệ thống");
        init();
    }

    private void init() {
        //danh sach btn quyen

        quyenBUS qBUS = new quyenBUS();
        listQuyen = qBUS.getList();
        JP_listNameQuyen = new JPanel(new FlowLayout(3));
        for (quyenDTO i : listQuyen) {
            JPanel btn_quyen = new JPanel(new BorderLayout());
            JLabel title_quyen = new JLabel(i.getTENQUYEN(), JLabel.CENTER);
            btn_quyen.setPreferredSize(new Dimension((int) title_quyen.getPreferredSize().getWidth() + 50, (int) title_quyen.getPreferredSize().getHeight() + 20));
            btn_quyen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            if(i.getMAQUYEN().equals(currentQuyen.getMAQUYEN())){
                title_quyen.setForeground(Cacthuoctinh_phuongthuc_chung.sky_blue);
            btn_quyen.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
            btn_quyen.setOpaque(true);
            JP_quyenSelected = btn_quyen;
            }else{
                title_quyen.setForeground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
            btn_quyen.setBackground(Cacthuoctinh_phuongthuc_chung.second_gray);
            btn_quyen.setOpaque(true);
            }
            

            title_quyen.setFont(new Font("Tahoma", Font.BOLD, 15));
            btn_quyen.setName(i.toString());
            btn_quyen.add(title_quyen, BorderLayout.CENTER);
            btn_quyen.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    
                     ((JLabel)JP_quyenSelected.getComponents()[0]).setForeground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
            JP_quyenSelected.setBackground(Cacthuoctinh_phuongthuc_chung.second_gray);
            JP_quyenSelected.setOpaque(true);
                    
                    JPanel btn = (JPanel) e.getSource();
                    ((JLabel)btn.getComponents()[0]).setForeground(Cacthuoctinh_phuongthuc_chung.sky_blue);
                    btn.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
            btn.setOpaque(true);
            JP_quyenSelected = btn;
                    repaintDataInTable(btn.getName());
                    Component[] components = JP_selectedQuyen.getComponents();
                    JLabel p = (JLabel) components[0];
                    p.setText(currentQuyen.getTENQUYEN().toUpperCase());
                }
            });
            JP_listNameQuyen.add(btn_quyen);
        }

        JP_selectedQuyen = new JPanel(new BorderLayout());
        JLabel nameSelectedQuyen = new JLabel(currentQuyen.getTENQUYEN().toUpperCase(), JLabel.CENTER);
        nameSelectedQuyen.setFont(new Font("Tahoma", Font.PLAIN, 17));
        JP_selectedQuyen.setPreferredSize(new Dimension(crong, (int) nameSelectedQuyen.getPreferredSize().getHeight() + 20));
        JP_selectedQuyen.setBackground(Color.WHITE);
        JP_selectedQuyen.setOpaque(true);
        JP_selectedQuyen.add(nameSelectedQuyen, BorderLayout.CENTER);

        chucnangBUS cnBUS = new chucnangBUS();
        listChucnang = cnBUS.getList();
        //Tiêu đề cột dọc
        // Tạo đối tượng DefaultTableModel với dữ liệu và tên cột
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames);

        table = new JTable(tableModel);
        addDataInTable();

        // css cho Header cua Table
        cssHeaderTable(table.getTableHeader());
        //css cho rows cua table
        cssDataTable();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(crong, ccao));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        // Tạo JFrame và thêm JScrollPane vào giao diện
        setLayout(new FlowLayout(3));
        add(JP_listNameQuyen);
        add(JP_selectedQuyen);
        add(scrollPane);
    }

    private void addDataInTable() {
        Vector data;
        tableModel.setRowCount(0);

        chitietquyenDAO ctqDAO = new chitietquyenDAO();
        for (chucnangDTO i : listChucnang) {
            data = new Vector();
            data.add(i.getTENCHUCNANG());
            for (String hd : columnNames) {
                if (!hd.equals("")) {
                    if (ctqDAO.seach(new chitietquyenDTO(currentQuyen.getMAQUYEN(), i.getMACHUCNANG(), hd))) {
                        data.add("X");
                    } else {
                        data.add(" ");
                    }
                }
            }
            tableModel.addRow(data);
        }
        table.setModel(tableModel);
    }

    private void repaintDataInTable(String mq) {
        quyenDTO new_quyen = new quyenDTO(mq);
        currentQuyen.setMAQUYEN(new_quyen.getMAQUYEN());
        currentQuyen.setTENQUYEN(new_quyen.getTENQUYEN());
        chitietquyenDAO ctqDAO = new chitietquyenDAO();
        TableModel model = table.getModel();
        for (int i = 0; i < listChucnang.size(); i++) {
            for (int j = 1; j < columnNames.length; j++) {
                if (ctqDAO.seach(new chitietquyenDTO(currentQuyen.getMAQUYEN(), listChucnang.get(i).getMACHUCNANG(), columnNames[j]))) {
                    model.setValueAt("X", i, j);
                } else {
                    model.setValueAt("", i, j);
                }
            }
        }
    }

    private void cssHeaderTable(JTableHeader header) {
        header.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);
        header.setForeground(Cacthuoctinh_phuongthuc_chung.sky_blue);
        header.setFont(new Font("Tahoma", Font.BOLD, 15));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
    }

    private void cssDataTable() {
        table.setRowHeight(35);//chieo cao cua hang
        table.setFont(font_data);//font cho dât trong table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER); // Căn giữa dữ liệu trong các ô
        table.setDefaultRenderer(Object.class, centerRenderer);
    }

    public static void main(String[] args) {
        int cao = 600, rong = 1000;
        phanquyen h = new phanquyen(rong, cao);
        JFrame frame = new JFrame("JTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.add(h, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel btn = (JPanel) e.getSource();
        btn.setBackground(Color.red);
        btn.setOpaque(true);
        System.out.println(btn.getName());
//        this.MAQUYEN= btn.getName();
//        addDataInTable();
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
