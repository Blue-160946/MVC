package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class Student_Model {
    private String url = "jdbc:mysql://localhost:3306/school_db";
    private String username = "root";
    private String password = "";
    private Connection connection;

    public Student_Model() {

        try {
            // โหลด MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // สร้างการเชื่อมต่อกับฐานข้อมูล
            connection = DriverManager.getConnection(url, username, password);

            //System.out.println("Connection to database established successfully!");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        }
    }

    public void add_student(String studentId, String firstName, String lastName) {
        try {
            String sql = "INSERT INTO student (student_id, first_name, last_name) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentId);
            statement.setString(2, firstName);
            statement.setString(3, lastName);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student added successfully!");
                System.out.println("");
            } else {
                System.out.println("Failed to add student.");
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public void delete_student(String studentId) {
        try {
            String sql = "DELETE FROM student WHERE student_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student delete successfully!");
                System.out.println("");
            } else {
                System.out.println("Failed to delete student.");
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public List<String> view_student() {
        List<String> students = new ArrayList<>();
        try {
            String sql = "SELECT * FROM student";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String studentId = resultSet.getString("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                students.add("Student ID: " + studentId + ", Firstname: " + firstName + ", Lastname: " + lastName);
            }
        } 
        catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return students;
    }
}