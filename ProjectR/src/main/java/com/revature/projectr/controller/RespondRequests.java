package com.revature.projectr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectr.model.ProjectRManagerLogin;
import com.revature.projectr.model.Request;
import com.revature.projectr.repository.LoginDAO;
import com.revature.projectr.repository.ProjectRLoginPostgress;

@WebServlet(name = "rRequest", urlPatterns = {"/rRequest"})
public class RespondRequests extends HttpServlet {
  
  private static ObjectMapper obj = new ObjectMapper();
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
           
    LoginDAO manDao = new ProjectRLoginPostgress();       
    List<Request> pendingList = new ArrayList<Request>();
    
    pendingList = manDao.getAllPending();    
    
    String pListJson = obj.writeValueAsString(pendingList);
    PrintWriter out = resp.getWriter();
    out.print(pListJson);
    
  }  
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
   
    LoginDAO manDao = new ProjectRLoginPostgress();
    Request manOne = new Request();
    HttpSession session = req.getSession();
    
    ProjectRManagerLogin man = (ProjectRManagerLogin) session.getAttribute("mLogin");
    man = obj.readValue(req.getReader(), ProjectRManagerLogin.class);

    man.setManagerUsername(man.getManagerUsername());
    manDao.answerRequest(manOne);
  }

}
