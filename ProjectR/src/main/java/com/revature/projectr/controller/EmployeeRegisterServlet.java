package com.revature.projectr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.projectr.model.ProjectRModelRegister;
import com.revature.projectr.repository.LoginDAO;
import com.revature.projectr.repository.ProjectRLoginPostgress;


public class EmployeeRegisterServlet extends HttpServlet{
      
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("reached ERS");
    
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
   
    LoginDAO newAccount = new ProjectRLoginPostgress();
    String firstName = req.getParameter("registerFirstName");
    String lastName = req.getParameter("registerLastName");
    String email = req.getParameter("registerEmail");
    String username = req.getParameter("registerUsername");
    String password = req.getParameter("registerPassword");
    String confirmPassword = req.getParameter("registerConfirmPassword");
    
    if (username == "" || password == "" || firstName == "" || email == "" || password == "" || confirmPassword == "") {
      req.getRequestDispatcher("WEB-INF/ProjectOneWebsite/HomePage.html").forward(req, resp);
    }
    else {
    ProjectRModelRegister register = new ProjectRModelRegister();
    register.setRegisterFirstName(firstName);
    register.setRegisterLastName(lastName);
    register.setRegisterEmail(email);
    register.setRegisterUsername(username);
    register.setRegisterPassword(password);    
    System.out.println("" + register);    
    newAccount.register(register);
    req.getRequestDispatcher("WEB-INF/ProjectOneWebsite/Employee.html").forward(req, resp);
    }    
  }
}


