
package ThoiKhoaBieu;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
/**
 *
 * @author This PC
 */
public class thoikhoabieu extends javax.swing.JFrame {
    private ketnoidenSQL databaseConnector;
    private dulieulichhoc lichHocDAO;
    
    PreparedStatement pst;
    ResultSet rs;
    
    public thoikhoabieu() {
        initComponents();
        databaseConnector = new ketnoidenSQL();
        
        lichHocDAO = databaseConnector.createDulieuLichHoc();
         if (lichHocDAO == null) {
            JOptionPane.showMessageDialog(this, "Không thể kết nối đến cơ sở dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("Kết nối đến cơ sở dữ liệu thành công.");
        }
        Load_Days();
    }
   
   
    
    
        private void Load_Days() {
    try {
      
        if (lichHocDAO == null) {
            JOptionPane.showMessageDialog(this, "Không thể tải dữ liệu vì kết nối thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<String> days = lichHocDAO.getAllDays(); // Assumes getAllDays returns a List<String>
      
        cboThu.removeAllItems();

        for (String day : days) {
            cboThu.addItem(day);
        }

        System.out.println("Dữ liệu đã được tải vào ComboBox.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
    
    
    
    
    
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboThu = new javax.swing.JComboBox<>();
        btnTim = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtkb = new javax.swing.JTable();
        btnthoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("THỜI KHÓA BIỂU");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Thứ:");

        cboThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy", "Chủ nhật" }));
        cboThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThuActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        tbtkb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Môn học", "Giờ bắt đầu", "Giờ kết thúc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbtkb);

        btnthoat.setText("Thoát");
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(168, 168, 168))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(64, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboThu, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnthoat, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTim)
                        .addComponent(btnthoat)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed

        try{ 
              if (lichHocDAO == null) {
        JOptionPane.showMessageDialog(this, "Chưa kết nối đến cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
              Connection con = databaseConnector.getConnection();
            String thu = (String)cboThu.getSelectedItem();
          String sql = "SELECT Tenmon, Giobd, Giokt FROM LichHoc1 WHERE Thu = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, thu);        
            rs = pst.executeQuery();
            
            DefaultTableModel DFT = (DefaultTableModel) tbtkb.getModel();
            DFT.setRowCount(0);
            
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
             
            while(rs.next()){
                 Vector<Object> row = new Vector<>();
            row.add(rs.getString("Tenmon")); 
            
            Time Giobd = rs.getTime("Giobd");
            String formattedGiobd = timeFormat.format(Giobd); 
            
            Time Giokt = rs.getTime("Giokt");
            String formattedGiokt = timeFormat.format(Giokt);
            
            row.add(rs.getString("Giobd"));   
            row.add(rs.getString("Giokt"));   
             DFT.addRow(row); 
                }
                
        }
        catch(SQLException e){
         e.printStackTrace(); // In lỗi ra console
        JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnTimActionPerformed
   
    
    private void cboThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboThuActionPerformed

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
    }//GEN-LAST:event_btnthoatActionPerformed
    
    }
    
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
            java.util.logging.Logger.getLogger(thoikhoabieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thoikhoabieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thoikhoabieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thoikhoabieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new thoikhoabieu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnthoat;
    private javax.swing.JComboBox<String> cboThu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbtkb;
    // End of variables declaration//GEN-END:variables

   
}
