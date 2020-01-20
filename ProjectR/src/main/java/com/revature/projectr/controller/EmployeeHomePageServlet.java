package com.revature.projectr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectr.model.ProjectRAccount;
import com.revature.projectr.repository.LoginDAO;
import com.revature.projectr.repository.ProjectRLoginPostgress;

@WebServlet(name = "eHome", urlPatterns = {"/eHome"})
public class EmployeeHomePageServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    HttpSession session = req.getSession();    
    ObjectMapper obj = new ObjectMapper();
     
    String eLogin = obj.writeValueAsString(session.getAttribute("eLogin"));
    PrintWriter out= resp.getWriter();    
    out.print(eLogin);    
    
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {  
  
   
   LoginDAO user = new ProjectRLoginPostgress();
   String username = req.getParameter("employeeUsername");
   String newFirstName= req.getParameter("updateFirstName");
   String newLastName= req.getParameter("updateLastName");
   String newUsername= req.getParameter("updateUsername");
   String newEmail= req.getParameter("updateEmail");
   String newPassword= req.getParameter("updatePassword");
   
   ProjectRAccount updateInfo = new ProjectRAccount(newFirstName, newLastName, newEmail, newUsername, newPassword);
   
   user.update(updateInfo, username);
   
   System.out.println(updateInfo);
   
  }
}