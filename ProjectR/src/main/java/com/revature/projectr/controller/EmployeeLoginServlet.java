package com.revature.projectr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.projectr.model.ProjectREmployeeLogin;

public class EmployeeLoginServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    System.out.println("Reached ELS");
    
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    
    String username = req.getParameter("employeeUsername");
    String password = req.getParameter("employeePassword");
    
    ProjectREmployeeLogin eLogin = new ProjectREmployeeLogin(username, password);
    eLogin.setEmployeeUsername(username);
    eLogin.setEmployeePassword(password);
    
    System.out.println("" + eLogin);
    
  }

}
