package org.example.db;
import org.example.models.Vacancy;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

public class DBRepository {
    private static Connection conn = null;
    private static final String URL = "jdbc:sqlite:D:\\Thesameprojecttry6\\test.db";
    public static void connect() {
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void createTableVacancy(){
        String sql = "Create table if not exists players (\n"
                +"id integer Primary key";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            System.out.println("table blank created");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void saveVacancies(List<Vacancy> vacancies){
        String sql = "INSERT INTO vacancyentity VALUES(?,?,?,?,?,?,?)";
        var i = 10;
        for (var vacancy : vacancies){
            try(Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmtn = conn.prepareStatement(sql)){
                pstmtn.setInt(1,i++);
                pstmtn.setString(2,vacancy.getName());
                pstmtn.setString(3,vacancy.getDescription());
                pstmtn.setBoolean(4,vacancy.isPremium());
                pstmtn.setString(5,vacancy.getEmployerName());
                pstmtn.setDouble(6,vacancy.getSalary());
                pstmtn.setString(7,vacancy.getAreaName());
                pstmtn.executeUpdate();
                System.out.println("vacancy "+vacancy.getName()+"added");
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void returnVacansies(){
        String sql = "Select name, FROM vacancies";
        var res = new HashMap<String,Integer>();
        try(Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                res.put(rs.getString("name"),rs.getInt("count"));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
