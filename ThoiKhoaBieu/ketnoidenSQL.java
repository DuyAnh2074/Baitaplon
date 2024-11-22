/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThoiKhoaBieu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ketnoidenSQL {
   
    private Connection conn = null;

    public dulieulichhoc createDulieuLichHoc() {
        try {
            String userName = "sa";
            String password = "123";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=blon;encrypt=true;trustServerCertificate=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, userName, password);
            return new dulieulichhoc(conn);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ket noi CSDL that bai: " + e.getMessage(), "Thong bao", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return null;
    }
public Connection getConnection() {
        return conn;
    }

   
    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
