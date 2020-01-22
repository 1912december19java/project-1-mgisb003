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

@WebServlet(name = "mHome", urlPatterns = {"/mHome"})
public class ManagerHomePageServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
   
    HttpSession session = req.getSession();    
    ObjectMapper obj = new ObjectMapper();    
     
    String mLogin = obj.writeValueAsString(session.getAttribute("mLogin"));    
    PrintWriter out= resp.getWriter();    
    out.print(mLogin);        
    
  }  
  
}
