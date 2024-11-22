/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ThoiKhoaBieu;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Time;
public class Lichhocbtl extends javax.swing.JFrame {

    private ketnoidenSQL databaseConnector;
    private dulieulichhoc lichHocDAO;
    public Lichhocbtl() {
        initComponents();
        databaseConnector = new ketnoidenSQL();
        lichHocDAO = databaseConnector.createDulieuLichHoc();
        loadLichHocToTable();
       addTableMouseListener();
    }

     private void loadLichHocToTable() {
        try {
        List<LichHoc1> listLichHoc = lichHocDAO.getAllLichHoc();
        DefaultTableModel model = (DefaultTableModel) tblichhoc.getModel();
        model.setRowCount(0); // Clear the previous rows

        for (LichHoc1 lichHoc : listLichHoc) {
            model.addRow(new Object[]{
                lichHoc.getMaLop(),
                lichHoc.getTenLop(),
                lichHoc.getTemonhoc(),  // Thêm tenmonhoc vào đây
                lichHoc.getGiangVien(),
                lichHoc.getThu(),
                lichHoc.getGiobd() != null ? lichHoc.getGiobd().toString() : "",
                lichHoc.getGiokt() != null ? lichHoc.getGiokt().toString() : ""
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + e.getMessage());
    }
    }
     private void resetFields() {
    txtmalop.setText("");
    txttenlop.setText("");
    txttenmonhoc.setText("");
    txtgiangvien.setText("");
    txtthu.setText("");
    txtgiobt.setText("");
    txtgiokt.setText("");
}
     private void addTableMouseListener() {
     tblichhoc.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int selectedRow = tblichhoc.getSelectedRow();
            if (selectedRow >= 0) {
                txtmalop.setText(tblichhoc.getValueAt(selectedRow, 0).toString());
                txttenlop.setText(tblichhoc.getValueAt(selectedRow, 1).toString());
                txttenmonhoc.setText(tblichhoc.getValueAt(selectedRow, 2).toString());
                txtgiangvien.setText(tblichhoc.getValueAt(selectedRow, 3).toString());
                txtthu.setText(tblichhoc.getValueAt(selectedRow, 4).toString());
                txtgiobt.setText(tblichhoc.getValueAt(selectedRow, 5).toString());
                txtgiokt.setText(tblichhoc.getValueAt(selectedRow, 6).toString());
            }
        }
    });
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnthoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblichhoc = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txttenmonhoc = new javax.swing.JTextField();
        txtthu = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        txttenlop = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtgiokt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnsua = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtmalop = new javax.swing.JTextField();
        txtgiangvien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtgiobt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTimkiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý LớpHọc");

        btnthoat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnthoat.setText("Thoát");
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        tblichhoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã lớp", "Tên lớp", "Tên môn học", "Giảng viên", "Thứ", "Giờ bắt đầu", "Giờ kết thúc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblichhoc);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setText("Quản Lý Lớp Học");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin lớp học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12))); // NOI18N

        txttenmonhoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenmonhocActionPerformed(evt);
            }
        });

        jLabel4.setText("Thứ:");

        jLabel1.setText("Mã lớp:");

        jLabel3.setText("Giảng viên:");

        jLabel5.setText("Giờ bắt đầu:");

        btnsua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnthem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnxoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên môn học:");

        jLabel8.setText("Tên Lớp:");

        txtgiangvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgiangvienActionPerformed(evt);
            }
        });

        jLabel9.setText("Giờ kết thúc:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(btnthem)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(59, 59, 59)
                                    .addComponent(btnsua)
                                    .addGap(48, 48, 48)
                                    .addComponent(btnxoa))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtgiokt, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtgiobt)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(35, 35, 35)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtthu)
                                .addComponent(txtgiangvien)
                                .addComponent(txttenmonhoc)
                                .addComponent(txttenlop)
                                .addComponent(txtmalop)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtmalop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttenlop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttenmonhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtgiangvien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtthu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtgiobt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtgiokt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnsua)
                    .addComponent(btnxoa))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12))); // NOI18N

        jLabel7.setText("Tìm Kiếm:");

        txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(419, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(318, 318, 318)
                .addComponent(btnthoat)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnthoat))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        String MaLop = txtmalop.getText();
       String TenLop = txttenlop.getText();
       String Tenmon = txttenmonhoc.getText();
       String GiangVien = txtgiangvien.getText();
       String Thu = txtthu.getText();
      String Giobd = txtgiobt.getText();
      String Giokt = txtgiokt.getText();
    if (MaLop.isEmpty() || TenLop.isEmpty() || Tenmon .isEmpty() || GiangVien.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm thông tin lớp học này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }
    try {
        LichHoc1 lichHoc = new LichHoc1(MaLop , TenLop, Tenmon , GiangVien, Thu , Time.valueOf(Giobd), Time.valueOf(Giokt));
        lichHocDAO.addLichHoc(lichHoc); 
        loadLichHocToTable(); 
        resetFields(); 
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnthemActionPerformed
     
    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
     String MaLop = txtmalop.getText();
       String TenLop = txttenlop.getText();
       String Tenmon = txttenmonhoc.getText();
       String GiangVien = txtgiangvien.getText();
       String Thu = txtthu.getText();
       String giobdText = txtgiobt.getText();
     String gioktText = txtgiokt.getText();
    if (MaLop.isEmpty() || TenLop.isEmpty() || Tenmon.isEmpty() || GiangVien.isEmpty() || Thu.isEmpty() || giobdText.isEmpty() || gioktText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
        return;
    }
    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa thông tin lớp học này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }
    try {
         SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Time Giobd = new Time(timeFormat.parse(giobdText).getTime());
        Time Giokt = new Time(timeFormat.parse(gioktText).getTime());
        LichHoc1 updatedLichHoc = new LichHoc1(MaLop, TenLop, Tenmon , GiangVien, Thu, Giobd, Giokt);
        lichHocDAO.updateLichHoc(updatedLichHoc);
        JOptionPane.showMessageDialog(this, "Cập nhật lớp học thành công");
        loadLichHocToTable();  
        resetFields();  
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi chuyển đổi thời gian: " + e.getMessage());
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật lớp học: " + e.getMessage());
    }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
         String MaLop = txtmalop.getText();
    if (MaLop.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn lớp học để xóa.");
        return;
    }
    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa lớp học này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return; 
    }
    try {
        lichHocDAO.deleteLichHoc(MaLop);
        JOptionPane.showMessageDialog(this, "Xóa lớp học thành công");
        loadLichHocToTable(); 
        resetFields();  
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi xóa lớp học: " + e.getMessage());
    }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed

         int confirm = JOptionPane.showConfirmDialog(this, 
        "Bạn có chắc chắn muốn thoát không?", 
        "Xác nhận thoát", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);
    if (confirm == JOptionPane.YES_OPTION) {
        GiaoDien gd = new GiaoDien();
        gd.setVisible(true);
        this.dispose();
    }
    }//GEN-LAST:event_btnthoatActionPerformed
     private void searchLichHoc(String keyword) {
      try {
        List<LichHoc1> listLichHoc = lichHocDAO.getAllLichHoc();
        DefaultTableModel model = (DefaultTableModel) tblichhoc.getModel();
        model.setRowCount(0);  
        keyword = keyword.toLowerCase();  

        for (LichHoc1 lichHoc : listLichHoc) {
            // Kiểm tra từng trường xem có chứa từ khóa tìm kiếm không
            if (lichHoc.getMaLop().toLowerCase().contains(keyword) ||
                lichHoc.getTenLop().toLowerCase().contains(keyword) ||
                lichHoc.getTemonhoc().toLowerCase().contains(keyword) ||
                lichHoc.getGiangVien().toLowerCase().contains(keyword) ||
                lichHoc.getThu().contains(keyword) ||
                lichHoc.getGiobd().toString().contains(keyword) ||
                lichHoc.getGiokt().toString().contains(keyword)) {
                model.addRow(new Object[]{
                    lichHoc.getMaLop(),
                    lichHoc.getTenLop(),
                    lichHoc.getTemonhoc(),
                    lichHoc.getGiangVien(),
                    lichHoc.getThu(),
                    lichHoc.getGiobd(),
                    lichHoc.getGiokt()
                });
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm dữ liệu: " + e.getMessage());
    }
}

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
         String keyword = txtTimkiem.getText().trim().toLowerCase();
         searchLichHoc(keyword);
         txtTimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyReleased(java.awt.event.KeyEvent evt) {
        String keyword = txtTimkiem.getText().toLowerCase();
        searchLichHoc(keyword);
    }
});
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void txtgiangvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgiangvienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgiangvienActionPerformed

    private void txttenmonhocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenmonhocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenmonhocActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lichhocbtl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lichhocbtl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lichhocbtl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lichhocbtl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lichhocbtl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthoat;
    private javax.swing.JButton btnxoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblichhoc;
    private javax.swing.JTextField txtTimkiem;
    private javax.swing.JTextField txtgiangvien;
    private javax.swing.JTextField txtgiobt;
    private javax.swing.JTextField txtgiokt;
    private javax.swing.JTextField txtmalop;
    private javax.swing.JTextField txttenlop;
    private javax.swing.JTextField txttenmonhoc;
    private javax.swing.JTextField txtthu;
    // End of variables declaration//GEN-END:variables
}
