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
import com.revature.projectr.model.ProjectRModelRegister;
import com.revature.projectr.model.Request;
import com.revature.projectr.repository.LoginDAO;
import com.revature.projectr.repository.ProjectRLoginPostgress;

@WebServlet(name = "pReqE", urlPatterns = {"/pReqE"})
public class EmpProcReqServlet extends HttpServlet{
  
  private static ObjectMapper obj = new ObjectMapper();
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    HttpSession session = req.getSession();
    LoginDAO empDao = new ProjectRLoginPostgress();       
    List<Request> procList = new ArrayList<Request>(); 
    
    ProjectRModelRegister eInfo = (ProjectRModelRegister) session.getAttribute("eLogin");      

    procList = empDao.getAllNotPending(eInfo.getRegisterUsername());
    String pListJson = obj.writeValueAsString(procList);
    PrintWriter out = resp.getWriter();
    out.print(pListJson);
  }

}
