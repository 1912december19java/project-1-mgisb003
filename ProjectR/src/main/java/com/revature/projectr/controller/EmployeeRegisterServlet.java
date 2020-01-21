package com.revature.projectr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.projectr.model.ProjectRModelRegister;
import com.revature.projectr.repository.LoginDAO;
import com.revature.projectr.repository.ProjectRLoginPostgress;

@WebServlet(name = "register", urlPatterns = {"/register"})
public class EmployeeRegisterServlet extends HttpServlet{
      
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("reached ERS");
    
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    HttpSession session = req.getSession();
   
    LoginDAO newAccount = new ProjectRLoginPostgress();
    String firstName = req.getParameter("registerFirstName");
    String lastName = req.getParameter("registerLastName");
    String email = req.getParameter("registerEmail");
    String username = req.getParameter("registerUsername");
    String password = req.getParameter("registerPassword");
   
    
  
    ProjectRModelRegister register = new ProjectRModelRegister();  
    
    register.setRegisterFirstName(firstName);
    register.setRegisterLastName(lastName);
    register.setRegisterEmail(email);
    register.setRegisterPassword(password);
    register.setRegisterUsername(username);
    newAccount.register(register);
    session.setAttribute("register", register);    
    
    resp.sendRedirect("ProjectOneWebsite/EmployeeLogin.html");
//    req.getRequestDispatcher("WEB-INF/ProjectOneWebsite/EmployeeLogin.html").forward(req, resp);
    }    
  }



