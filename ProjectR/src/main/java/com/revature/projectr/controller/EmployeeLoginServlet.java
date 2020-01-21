package com.revature.projectr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectr.model.ProjectRModelRegister;
import com.revature.projectr.repository.LoginDAO;
import com.revature.projectr.repository.ProjectRLoginPostgress;

@WebServlet(name = "eLogin", urlPatterns = {"/eLogin"})
public class EmployeeLoginServlet extends HttpServlet {
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    
    HttpSession session = req.getSession();        
    LoginDAO empLogin = new ProjectRLoginPostgress();
    
    String username = req.getParameter("employeeUsername");
    String password = req.getParameter("employeePassword"); 
    
    ProjectRModelRegister eLogin = empLogin.userInfo(username, password);       
    session.setAttribute("eLogin", eLogin);  
    
    if (eLogin == null) {
      resp.sendRedirect("ProjectOneWebsite/EmployeeLogin.html");
    }else {        
    resp.sendRedirect("ProjectOneWebsite/Employee.html"); 
    }
    
  }
}
