package com.revature.projectr.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.projectr.model.ProjectRAccount;
import com.revature.projectr.model.ProjectRManagerLogin;
import com.revature.projectr.model.ProjectRModelRegister;
import com.revature.projectr.model.ReceiptUploadTest;

public class ProjectRLoginPostgress implements LoginDAO {


  private static Connection conn;

  static {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    }

    try {
      conn = DriverManager.getConnection(System.getenv("urlString"), System.getenv("username"),
          System.getenv("password"));
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
            "INSERT INTO employeeRegister(firstname,lastname,email,username,passcode) VALUES (?,?,?,?,?)");
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
      stmt =
          conn.prepareStatement("SELECT * FROM managerLogin WHERE username = ? AND passcode = ?");
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
  public void upload(ReceiptUploadTest upload) {
    PreparedStatement stmt = null;
    while (true) {
      try {
        stmt = conn.prepareStatement("INSERT INTO receipt(receipt) VALUES (?)");
        stmt.setString(1, upload.getBlob());
        stmt.execute();

        break;
      } catch (SQLException e) {
        System.out.println("Username is already in use: ");
        break;
      }
    }
  }

  @Override
  public ProjectRAccount userInfo(String username, String password) {
    ProjectRAccount out = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = conn
          .prepareStatement("SELECT * FROM employeeRegister WHERE username = ? AND passcode = ?");
      stmt.setString(1, username);
      stmt.setString(2, password);
      stmt.execute();
      if (stmt.execute()) {
        rs = stmt.getResultSet();
      }
      while (rs.next()) {
        out = new ProjectRAccount(rs.getString("firstname"), rs.getString("lastname"),
            rs.getString("email"), rs.getString("username"), rs.getString("passcode"));
      }
    } catch (SQLException e) {
    }
    return out;
  }

  @Override
  public void update(ProjectRAccount update, String username) {
    PreparedStatement stmt = null;
    try {
      stmt = conn.prepareStatement(
          "UPDATE employeeRegister SET firstname = ?,lastname = ?,username = ?,email = ?,passcode = ? WHERE username = ?");
      stmt.setString(1, update.getFirstName());
      stmt.setString(2, update.getLastName());
      stmt.setString(3, update.getUsername());
      stmt.setString(4, update.getEmail());
      stmt.setString(5, update.getPassword());
      stmt.setString(6, username);
      stmt.execute();
    } catch (SQLException e) {
    }
  }


}


