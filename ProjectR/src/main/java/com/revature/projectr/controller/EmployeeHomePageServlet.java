package com.revature.projectr.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "eHome", urlPatterns = {"/eHome"})
public class EmployeeHomePageServlet extends HttpServlet {
  
  private static ObjectMapper obj = new ObjectMapper();
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    HttpSession session = req.getSession();        
    String eLogin = obj.writeValueAsString(session.getAttribute("eLogin"));    
    PrintWriter out= resp.getWriter();    
    out.print(eLogin);    
           
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {  
    
    HttpSession session = req.getSession();
    LoginDAO user = new ProjectRLoginPostgress();
    ProjectRModelRegister updateInfo = new ProjectRModelRegister(); 
    
    updateInfo = obj.readValue(req.getReader(), ProjectRModelRegister.class);   
    ProjectRModelRegister legacyInfo = (ProjectRModelRegister) session.getAttribute("eLogin");    
    updateInfo.setRegisterUsername(legacyInfo.getRegisterUsername());
     
    user.update(updateInfo);
    session.setAttribute("eLogin", updateInfo);
       
  }
}