package com.rohit.springbootjdbc.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
public class MyService {

    @Autowired
    JdbcTemplate jdbcTemplate;



    public Employee registerService(Employee employee) {
        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into employee(name, email, mobile, password) values(?,?, ?, ?)");
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getMobile());
            ps.setString(4, employee.getPassword());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee Registered Successfully");
            }
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
//            String sql = "insert into employee(name, email, mobile, password) values(?,?, ?, ?)";
//            int update = jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getMobile(), employee.getPassword());
//
//            System.out.println(update);
//            if (update > 0) {
//                System.out.println("Employee Registered Successfully");
//            }
//            return employee;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



        return null;
    }

    public Employee loginService(Employee employee) {

//        try {
//            Connection connection = jdbcTemplate.getDataSource().getConnection();
//            PreparedStatement ps = connection.prepareStatement("select * from employee where email  = ? and password = ?");
//            ps.setString(1, employee.getEmail());
//            ps.setString(2, employee.getPassword());
//            ResultSet resultSet = ps.executeQuery();
//            if (resultSet.next()) {
//                employee.setEmail(resultSet.getString("email"));
//                employee.setPassword(resultSet.getString("password"));
//                employee.setMobile(resultSet.getString("mobile"));
//                employee.setName(resultSet.getString("name"));
//                return employee;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            String sql = "select * from employee where email  = ? and password = ?";
            Employee employee1 = jdbcTemplate.query(
                    sql,
                    new Object[]{employee.getEmail(), employee.getPassword()},
                    rs -> {
                        if (rs.next()) {
                            Employee emp = new Employee();
                            emp.setId(rs.getInt("id"));
                            emp.setEmail(rs.getString("email"));
                            emp.setPassword(rs.getString("password"));
                            emp.setName(rs.getString("name"));
                            System.out.println(emp.toString());
                            return emp;
                        }
                        return null;
                    });
            return employee1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        return null;
    }


}
