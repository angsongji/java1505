
package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class Show_ChitietHD extends JPanel{
    private JPanel p1,p2,p3,p4,p5,p6,p7,p8;
     private int chieurong,chieucao;
    private Font f = new Font("Tahoma", Font.BOLD, 14);

    public Show_ChitietHD() {
        init();
    }
    public Show_ChitietHD(int chieurong,int chieucao) {
       this.chieurong=chieurong;
       this.chieucao=chieucao;
        init();
        
    }
     public void init(){
        this.setPreferredSize(new Dimension(2*chieurong/3,chieucao));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            p1 = new JPanel();
                p1.setBackground(Color.white); 
                p1.setSize(0, 120);
                p1.setLayout(new FlowLayout(1));
                    JLabel title = new JLabel("CHI TIET HOA DON", JLabel.CENTER);
                        title.setAlignmentX(Component.CENTER_ALIGNMENT);
                        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 28));
                        title.setForeground(Color.decode("#0A3D62"));
            p1.add(title);
            
            p2 = new JPanel();
                p2.setBackground(Color.white); 
                p2.setLayout(new FlowLayout(0,40,0));
                    JLabel HD = new JLabel("Hoa Don", JLabel.CENTER);
                        HD.setPreferredSize(new Dimension(150, 40));
                        HD.setFont(f);
                    JLabel maHD = new JLabel("HD001", JLabel.CENTER);
                        maHD.setPreferredSize(new Dimension(150, 40));
//                        maHD.setFont(f);
            p2.add(HD);
            p2.add(maHD);
            
            p3 = new JPanel();
                p3.setBackground(Color.white); 
                p3.setLayout(new FlowLayout(0,40,0));
                    JLabel datetime = new JLabel("Thoi Gian", JLabel.CENTER);
                        datetime.setPreferredSize(new Dimension(150, 40));
                        datetime.setFont(f);
                    JLabel date = new JLabel("23/7/2024", JLabel.CENTER);
                        date.setPreferredSize(new Dimension(150, 40));
//                        date.setFont(f);
                    JLabel time = new JLabel("12:06", JLabel.LEFT);
                        time.setPreferredSize(new Dimension(150, 40));
//                        time.setFont(f);
            p3.add(datetime);
            p3.add(date);
            p3.add(time);
            
            
            p4 = new JPanel();
                p4.setBackground(Color.white) ;
                p4.setLayout(new FlowLayout(0,40,0));
                    JLabel KH = new JLabel("Ten Khach Hang", JLabel.CENTER);
                        KH.setPreferredSize(new Dimension(150, 40));
                        KH.setFont(f);
                    JLabel tenKH = new JLabel("HiHi", JLabel.CENTER);
                        tenKH.setPreferredSize(new Dimension(150, 40));
//                        tenKH.setFont(f);
            p4.add(KH);
            p4.add(tenKH);
            
            
            p5 = new JPanel();
                p5.setBackground(Color.white);
                p5.setLayout(new FlowLayout(0,40,0));
                    JLabel NV = new JLabel("Ma Nhan Vien", JLabel.CENTER);
                        NV.setPreferredSize(new Dimension(150, 40));
                        NV.setFont(f);
                    JLabel tenNV = new JLabel("NV001", JLabel.CENTER);
                        tenNV.setPreferredSize(new Dimension(150, 40));
//                        tenNV.setFont(f);
            p5.add(NV);
            p5.add(tenNV);
           
            
            p6 = new JPanel();
                p6.setBackground(Color.white);
                p6.setPreferredSize(new Dimension(600, 280));
         
                    String[] columnNames = {"Ten SP", "size", "So luong","Gia"," Tong cong"};
                    JPanel pa = new JPanel();
                        pa.setLayout(new FlowLayout(1,10,0));
                        pa.setBackground(Color.white);
                        pa.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.decode("#60A3BC")));
                        for (String col : columnNames) {
                            JLabel l = new JLabel(col,JLabel.CENTER);
                                l.setPreferredSize(new Dimension(((chieurong*2/3)-40)/5, 40));
                                l.setFont(new Font(l.getFont().getName(), Font.BOLD, 16));
                                l.setForeground(Color.decode("#0A3D62"));
                        pa.add(l);
                        }
                p6.add(pa);
            
                    Object[][] data = {
                        { "SOMIHDKSHS","S","2","700000","1400000" },
                        { "SOMIHDJDJH","M","1","600000","600000"},
                        { "SOƠIEUBNHD","L","1","500000","500000"},
                    };
       
                        for (Object[] row : data) {
                            JPanel p = new JPanel();
                                p.setLayout(new FlowLayout(0,5,0));
                                p.setBackground(Color.white);
                            for (Object element : row) {
                                JLabel l = new JLabel((String) element,JLabel.CENTER);
                                    l.setPreferredSize(new Dimension(((chieurong*2/3)-30)/5, 40));
                                    p.add(l);
                            }
                            p6.add(p);
                        }
//// hiển thị mảng dữ liệu dưới dạng table  
//        model2 = new DefaultTableModel(data, columnNames);
//        dsSP = new JTable();
//        dsSP.setModel(model2);
//         
//        // Tính toán chiều cao của từng hàng trong bảng
//        int rowHeight = dsSP.getRowHeight();
//        int rowCount = dsSP.getRowCount();
//        int height = rowCount * rowHeight;
//        
//        // Thiết lập kích thước chiều cao của bảng dựa trên số hàng
//        if (rowCount <= 5) {
//            dsSP.setPreferredScrollableViewportSize(new Dimension(dsSP.getPreferredScrollableViewportSize().width, height));
//        } else {
//            dsSP.setPreferredScrollableViewportSize(new Dimension(dsSP.getPreferredScrollableViewportSize().width, rowCount * 3));
//        }
//        
//        JScrollPane scrollPane = new JScrollPane(dsSP);
//        p4.add(scrollPane, BorderLayout.CENTER);
//        
//        
//        // Kết nối đến cơ sở dữ liệu
//        try {
//            // Thực hiện truy vấn SQL để lấy dữ liệu
//            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ten_cua_co_so_du_lieu", "ten_nguoi_dung", "mat_khau")) {
//                // Thực hiện truy vấn SQL để lấy dữ liệu
//                String sql = "SELECT * FROM ten_bang";
//                try (Statement statement = connection.createStatement(); 
//                    ResultSet resultSet = statement.executeQuery(sql)) {
//                    // Lấy thông tin về metadata của kết quả
//                    ResultSetMetaData metaData = resultSet.getMetaData();
//                    int numberOfColumns = metaData.getColumnCount();
//                    
//                    model2 = new DefaultTableModel();
//                    
//                    // Thêm tên cột vào bảng
//                    for (int column = 1; column <= numberOfColumns; column++) {
//                        model2.addColumn(metaData.getColumnName(column));
//                    }
//
//                    // Thêm dữ liệu từ ResultSet vào bảng
//                    while (resultSet.next()) {
//                        Object[] rowData = new Object[numberOfColumns];
//                        for (int i = 0; i < numberOfColumns; i++) {
//                            rowData[i] = resultSet.getObject(i + 1);
//                        }
//                        model2.addRow(rowData);
//                    }
//                    
//                    // Đặt mô hình dữ liệu cho bảng
//                    dsSP = new JTable();
//                    dsSP.setModel(model2);
//                    // Đóng kết nối
//
//                }
//            }
//        } catch (SQLException e) {
//        }
//        
//        

            
            p7 = new JPanel();
                p7.setBackground(Color.white); 
                p7.setLayout(new FlowLayout(0,40,0));
                p7.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.decode("#60A3BC")));
                    JLabel note = new JLabel("Ghi Chu", JLabel.CENTER);
                        note.setPreferredSize(new Dimension(150, 40));
                        note.setFont(f);
                    JLabel contentnote = new JLabel("......", JLabel.CENTER);
                        contentnote.setPreferredSize(new Dimension(150, 40));
//                        contentnote.setFont(f);
            p7.add(note);
            p7.add(contentnote);
            
            
            p8 = new JPanel();
                p8.setBackground(Color.white); 
                p8.setLayout(new FlowLayout(0,40,0));
                    JLabel amountpaid = new JLabel("TONG TIEN", JLabel.CENTER);
                        amountpaid.setPreferredSize(new Dimension(150, 40));
                        amountpaid.setFont(new Font("Tahoma", Font.BOLD, 18));
                    JLabel sum = new JLabel("2500000VND", JLabel.RIGHT);
                        sum.setPreferredSize(new Dimension(500, 40));
                        sum.setFont(new Font("Tahoma", Font.BOLD, 18));
                        sum.setForeground(Color.red);
            p8.add(amountpaid);
            p8.add(sum);
            
            
            this.add(p1);
            this.add(p2);
            this.add(p3);
            this.add(p4);
            this.add(p5);
            this.add(p6);
            this.add(p7);
            this.add(p8);               
}
}
