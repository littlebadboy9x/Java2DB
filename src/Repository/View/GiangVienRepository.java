/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.View;

import Repository.DBConnect;
import Repository.Domain.GiangVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Viet Vuong
 */
public class GiangVienRepository {

    public List<GiangVien> getAll() {
        String query = """
                       SELECT [ma]
                             ,[ten]
                             ,[loai]
                             ,[tuoi]
                             ,[bac]
                             ,[gioi_tinh]
                         FROM [dbo].[giang_vien]
                       """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<GiangVien> lists = new ArrayList<>();
            while (rs.next()) {
                GiangVien gv
                        = new GiangVien(rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getInt(4),
                                rs.getInt(5),
                                rs.getInt(6));
                lists.add(gv);
            }
            return lists;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean them(GiangVien gv) {
        String query = """
                   INSERT INTO [dbo].[giang_vien]
                              ([ma]
                              ,[ten]
                              ,[loai]
                              ,[tuoi]
                              ,[bac]
                              ,[gioi_tinh])
                   VALUES (?, ?, ?, ?, ?, ?)
                   """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, gv.getMa());
            ps.setString(2, gv.getTen());
            ps.setString(3, gv.getLoai());
            ps.setInt(4, gv.getTuoi());
            ps.setInt(5, gv.getBac());
            ps.setBoolean(6, gv.getGioiTinh() == 1); // Nam == 1 : Nữ == 0

            int rowsAffected = ps.executeUpdate(); // Lấy số lượng bản ghi bị ảnh hưởng
            return rowsAffected > 0; // Trả về true nếu có ít nhất một bản ghi được thêm
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi để dễ dàng gỡ lỗi
            return false; // Trả về false nếu có lỗi xảy ra
        }
    }

    public Boolean xoa(String maGV) {
        int check = 0;
        String query = """
               DELETE FROM [dbo].[giang_vien]
               WHERE [ma] = ?
               """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, maGV);
            check = ps.executeUpdate(); // Thực hiện câu lệnh xóa
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false; // Trả về false nếu có lỗi xảy ra
        }
        return check > 0; // Trả về true nếu xóa thành công, false nếu không
    }

    public Boolean update(GiangVien gv) {
        int check = 0;
        String query = """
               UPDATE [dbo].[giang_vien]
                  SET ,[ten] = ?
                     ,[loai] = ?
                     ,[tuoi] = ?
                     ,[bac] = ?
                     ,[gioi_tinh] = ?
                WHERE [ma] = ?
               """;
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, gv.getTen());
            ps.setString(2, gv.getLoai());
            ps.setInt(3, gv.getTuoi());
            ps.setInt(4, gv.getBac());
            ps.setInt(5, gv.getGioiTinh());
            ps.setString(6, gv.getMa());
            check = ps.executeUpdate(); // Thực hiện câu lệnh cập nhật

        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false; // Trả về false nếu có lỗi xảy ra
        }
        return check > 0; // Trả về true nếu cập nhật thành công, false nếu không
    }
}
