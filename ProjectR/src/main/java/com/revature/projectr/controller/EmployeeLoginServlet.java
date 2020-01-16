package com.revature.projectr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.projectr.model.ProjectRModelRegister;
import com.revature.projectr.repository.LoginDAO;
import com.revature.projectr.repository.ProjectRLoginPostgress;

public class EmployeeLoginServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    System.out.println("Reached ELS");
    
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    LoginDAO empLogin = new ProjectRLoginPostgress();    
    String username = req.getParameter("employeeUsername");
    String password = req.getParameter("employeePassword");
    
    if (username == "" || password == "") {
      req.getRequestDispatcher("WEB-INF/ProjectOneWebsite/EmployeeLogin.html").forward(req, resp);
    }
    
    ProjectRModelRegister eLogin = empLogin.eLogin(username, password);
    if (eLogin == null) {
      req.getRequestDispatcher("WEB-INF/ProjectOneWebsite/EmployeeLogin.html").forward(req, resp); 
    }
    
    eLogin.setRegisterUsername(username);
    eLogin.setRegisterPassword(password);
    
    
    req.getRequestDispatcher("WEB-INF/ProjectOneWebsite/Employee.html").forward(req, resp);
    System.out.println("" + eLogin);
    
  }

}
