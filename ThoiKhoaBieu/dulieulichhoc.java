/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThoiKhoaBieu;

/**
 *
 * @author Dong Viet Minh
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class dulieulichhoc {

   
    private final Connection connection;

   public dulieulichhoc(Connection connection) {
        this.connection = connection;
    }
   

    
    public void addLichHoc(LichHoc1 lichHoc) throws SQLException {
        String sql = "INSERT INTO Lichhoc1 (Malop, Tenlop, Tenmon , Giangvien, Thu, Giobd,Giokt) VALUES (?, ?, ?, ?, ?,?,?)";
         
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, lichHoc.getMaLop());
        pstmt.setString(2, lichHoc.getTenLop());
        pstmt.setString(3, lichHoc.getTemonhoc());  // Use Temonhoc here
        pstmt.setString(4, lichHoc.getGiangVien());
        pstmt.setString(5, lichHoc.getThu());  // Assuming Thu is a String
        pstmt.setTime(6, lichHoc.getGiobd());  // Use setTime for Giobd
        pstmt.setTime(7, lichHoc.getGiokt());  // Use setTime for Giokt
        pstmt.executeUpdate();
    }
    }

     public List<LichHoc1> getAllLichHoc() throws SQLException {
        List<LichHoc1> lichHocs = new ArrayList<>();
        String sql = "SELECT * FROM Lichhoc1";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                LichHoc1 lichHoc = new LichHoc1(
                    rs.getString("Malop"),
                    rs.getString("Tenlop"),
                    rs.getString("Tenmon"),
                    rs.getString("Giangvien"),
                    rs.getString("Thu"),
                    rs.getTime("Giobd"),  // Use getTime for Giobd
                    rs.getTime("Giokt")   // Use getTime for Giokt
                );
                lichHocs.add(lichHoc);
            }
        }
        return lichHocs;
    }

    public int updateLichHoc(LichHoc1 lichHoc) throws SQLException {
         String sql = "UPDATE Lichhoc1 SET Tenlop = ?,Tenmon=?,Giangvien = ?, Thu = ?, Giobd = ?, Giokt = ? WHERE Malop = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, lichHoc.getTenLop());
            pstmt.setString(2, lichHoc.getTemonhoc());
            pstmt.setString(3, lichHoc.getGiangVien());
            pstmt.setString(4, lichHoc.getThu());
            pstmt.setTime(5, lichHoc.getGiobd());  // Use setTime for Giobd
            pstmt.setTime(6, lichHoc.getGiokt()); // Use setTime for Giokt
            pstmt.setString(7, lichHoc.getMaLop());
            return pstmt.executeUpdate();
        }
    }

    public void deleteLichHoc(String Malop) throws SQLException {
        String sql = "DELETE FROM Lichhoc1 WHERE Malop = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, Malop);
            pstmt.executeUpdate();
        }
    }
    
     public List<LichHoc1> searchLichHoc(String keyword) throws SQLException {
        List<LichHoc1> listLichHoc = new ArrayList<>();
        String query = "SELECT * FROM LichHoc1 WHERE tenLop LIKE ? OR maLop LIKE ? OR Temonhoc LIKE ?OR giangVien LIKE ? OR Thu LIKE ? OR Giobd LIKE ? OR Giokt LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            String searchKeyword = "%" + keyword + "%";
            statement.setString(1, searchKeyword);
            statement.setString(2, searchKeyword);
            statement.setString(3, searchKeyword);
            statement.setString(4, searchKeyword);
            statement.setString(5, searchKeyword);
            statement.setString(6, searchKeyword);
            statement.setString(7, searchKeyword);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String maLop = resultSet.getString("maLop");
                String tenLop = resultSet.getString("tenLop");
                String Temonhoc = resultSet.getString("Tenmon ");
                String giangVien = resultSet.getString("giangVien");
                String Thu = resultSet.getString("Thu");
                Time Giobd = resultSet.getTime("Giobd"); 
                Time Giokt = resultSet.getTime("Giokt");  
                LichHoc1 lichHoc = new LichHoc1(maLop, tenLop,Temonhoc, giangVien, Thu, Giobd,Giokt);
                listLichHoc.add(lichHoc);
            }
        }
        return listLichHoc;
    }
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

  public List<String> getAllDays() throws SQLException {
    List<String> days = new ArrayList<>();
    String sql = "SELECT DISTINCT Thu FROM LichHoc1";

    try (PreparedStatement pst = connection.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {
        while (rs.next()) {
           
           days.add(rs.getString("Thu")); 
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
        throw e; 
    }

    return days;
}


}