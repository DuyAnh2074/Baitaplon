/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThoiKhoaBieu;

/**
 *
 * @author Dong Viet Minh
 */
import java.sql.Time;
public class LichHoc1 {
      private String MaLop;
    private String TenLop;
    private String Tenmon;
    private String GiangVien;
    private String Thu;
    private Time Giobd;
    private Time Giokt;

    // Constructor
    public LichHoc1(String MaLop, String TenLop, String Tenmon, String GiangVien, String Thu, Time Giobd, Time Giokt) {
        this.MaLop = MaLop;
        this.TenLop = TenLop;
        this.Tenmon = Tenmon;
        this.GiangVien = GiangVien;
        this.Thu = Thu;
        this.Giobd = Giobd;
        this.Giokt = Giokt;
    }

    public LichHoc1(String Thu) {
        this.Thu = Thu;
    }
 public String getThu() {
        return Thu;
    }

    public void setThu(String Thu) {
        this.Thu = Thu;
    }
    // Getters and setters
    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String TenLop) {
        this.TenLop = TenLop;
    }

    public String getTemonhoc() {
        return Tenmon;
    }

    public void setTemonhoc(String Tenmon) {
        this.Tenmon = Tenmon;
    }

    public String getGiangVien() {
        return GiangVien;
    }

    public void setGiangVien(String GiangVien) {
        this.GiangVien = GiangVien;
    }

   

    public Time getGiobd() {
        return Giobd;
    }

    public void setGiobd(Time Giobd) {
        this.Giobd = Giobd;
    }

    public Time getGiokt() {
        return Giokt;
    }

    public void setGiokt(Time Giokt) {
        this.Giokt = Giokt;
    }
}
