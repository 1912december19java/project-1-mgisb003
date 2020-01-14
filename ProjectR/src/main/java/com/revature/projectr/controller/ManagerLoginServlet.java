package com.revature.projectr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.projectr.model.ProjectREmployeeLogin;
import com.revature.projectr.model.ProjectRManagerLogin;
import com.revature.projectr.repository.LoginDAO;
import com.revature.projectr.repository.ProjectRLoginPostgress;

public class ManagerLoginServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    System.out.println("Reached MLS");

  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    LoginDAO manLogin = new ProjectRLoginPostgress();
    String username = req.getParameter("managerUsername");
    String password = req.getParameter("managerPassword");
    
    ProjectRManagerLogin mLogin = new ProjectRManagerLogin(username, password);
    mLogin.setManagerUsername(username);
    mLogin.setManagerPassword(password);    
    System.out.println("" + mLogin);
    
    manLogin.mLogin(username, password);
    
  }
  

}
