package GUI;

import javax.swing.*;
import java.awt.*;

public class DoubleClickExample {
    private static boolean isEditingEnabled = false;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Object[][] data = {{"Row 1, Col 1", "Row 1, Col 2"},
                           {"Row 2, Col 1", "Row 2, Col 2"}};
        String[] columns = {"Column 1", "Column 2"};
        JTable table;
        table = new JTable(data, columns){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return isEditingEnabled;
            }
            
        };

        JButton editButton = new JButton("Edit Cell");
        editButton.addActionListener(e -> {
            switch(editButton.getText()){
                case "Edit Cell":
                                editButton.setText("Finish");
                    isEditingEnabled = true;
                    break;
                case "Finish":
                    editButton.setText("Edit Cell");
                     isEditingEnabled = false;
                    break;
            }

            // Start editing cell at row 0, column 0
            
        });

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(editButton, BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
//table.addMouseListener(new MouseAdapter() {
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        if (e.getClickCount() == 2) { // Nếu double-click
//            int row = table.getSelectedRow();
//            int col = table.getSelectedColumn();
//            table.editCellAt(row, col); // Bắt đầu chỉnh sửa ô được chọn
//        }
//    }
//});