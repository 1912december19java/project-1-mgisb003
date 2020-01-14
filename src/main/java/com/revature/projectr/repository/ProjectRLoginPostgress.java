package com.revature.projectr.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.projectr.model.ProjectREmployeeLogin;
import com.revature.projectr.model.ProjectRManagerLogin;
import com.revature.projectr.model.ProjectRModelRegister;

public class ProjectRLoginPostgress implements LoginDAO {


  private static Connection conn;

  static {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    }
  
    try {
      conn = DriverManager.getConnection(
          "jdbc:postgresql://database-1.cbu886n5wmpw.us-east-1.rds.amazonaws.com:5432/postgres",
          "postgres", "Krelthor1!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  @Override
  public void register(ProjectRModelRegister register) {
    PreparedStatement stmt = null;
    while (true) {
      try {
        stmt = conn.prepareStatement(
            "INSERT INTO employeeregister(firstname,lastname,email,username,passcode) VALUES (?,?,?,?,?)");
        stmt.setString(1, register.getRegisterFirstName());
        stmt.setString(2, register.getRegisterLastName());
        stmt.setString(3, register.getRegisterEmail());
        stmt.setString(4, register.getRegisterUsername());
        stmt.setString(5, register.getRegisterPassword());
        stmt.execute();
        break;
      } catch (SQLException e) {
        System.out.println("Username is already in use: ");
        break;
      }
    }
  }

  @Override
  public ProjectRManagerLogin mLogin(String username, String password) {    
    ProjectRManagerLogin out = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = conn.prepareStatement("SELECT * FROM managerLogin WHERE username = ?,passcode = ? ");
      stmt.setString(1, username);
      stmt.setString(2, password);
      stmt.execute();
      if (stmt.execute()) {
        rs = stmt.getResultSet();
      }
      while (rs.next()) {
        out = new ProjectRManagerLogin(rs.getString("username"), rs.getString("passcode"));
      }
    } catch (SQLException e) {

    }
    return out;
  }

  @Override
  public ProjectREmployeeLogin eLogin(String username, String password) {
    ProjectREmployeeLogin out = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = conn.prepareStatement("SELECT * FROM employeeLogin WHERE username = ?,passcode = ? ");
      stmt.setString(1, username);
      stmt.setString(2, password);
      stmt.execute();
      if (stmt.execute()) {
        rs = stmt.getResultSet();
      }
      while (rs.next()) {
        out = new ProjectREmployeeLogin(rs.getString("username"), rs.getString("passcode"));
      }
    } catch (SQLException e) {

    }
    return out;
  }

}

