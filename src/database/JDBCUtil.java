package database;

import model.SinhVien;

import java.sql.*;

public class JDBCUtil {

    public static Connection getConnection(){
        Connection c = null;

        try{
            // Đăng kí MySQL Driver với DriverManager
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Các thông số
            String url ="jdbc:mySQL://localhost:3306/quanlysinhvien";
            String username = "root" ;
            String password = "123456";

            // Tạo kết nối
            c = DriverManager.getConnection(url,username,password);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return c;
    }
    public static void closeConnection(Connection c){
        try{
            if(c!=null){
                c.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void printInfo(Connection c){
        try{
            if(c!=null){
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void insertSinhVien(SinhVien sv) {
        Connection c = getConnection();
        String sql = "INSERT INTO sinhvien (id, name, age, address, gpa) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, sv.getId());
            pst.setString(2, sv.getName());
            pst.setInt(3, sv.getAge());
            pst.setString(4, sv.getAddress());
            pst.setDouble(5, sv.getGpa());
            pst.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(c);
        }
    }

    public static void deleteSinhVien(int id) {
        Connection c = getConnection();
        String sql = "DELETE FROM sinhvien WHERE id = ?";
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(c);
        }
    }


}
