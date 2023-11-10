import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Máy tính");
        JPanel panel = new JPanel(new BorderLayout());

        JTextField soLuongField = new JTextField(16); // Tăng size ô nhập data
        JTextField donGiaField = new JTextField(16);
        JTextField thanhTienField = new JTextField(16);
        thanhTienField.setEditable(false);

        // Tăng size chữ cho nhãn
        JLabel headerLabel = new JLabel("Bạn hãy nhập vào số lượng và đơn giá:");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 36));
        panel.add(headerLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        centerPanel.add(new JLabel("Số lượng:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        centerPanel.add(soLuongField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        centerPanel.add(new JLabel("Đơn giá:"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        centerPanel.add(donGiaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(new JLabel("Thành tiền:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(thanhTienField, gbc);

        
        Font textFieldFont = new Font("Arial", Font.PLAIN, 15); // Tăng size chữ
        soLuongField.setFont(textFieldFont);
        donGiaField.setFont(textFieldFont);
        thanhTienField.setFont(textFieldFont);

        panel.add(centerPanel, BorderLayout.CENTER);

        donGiaField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double donGia = Double.parseDouble(donGiaField.getText());
                    double soLuong = Double.parseDouble(soLuongField.getText());
                    int thanhTien = (int) (donGia * soLuong);
                    thanhTienField.setText(String.valueOf(thanhTien));
                } catch (NumberFormatException ex) {
                    thanhTienField.setText("Dữ liệu không hợp lệ");
                }
            }
        });

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
