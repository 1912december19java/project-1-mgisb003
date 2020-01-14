package com.revature.projectr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectr.model.ProjectRModelRegister;
import com.revature.projectr.repository.LoginDAO;
import com.revature.projectr.repository.ProjectRLoginPostgress;
import com.revature.projectr.service.RegisterService;


public class EmployeeRegisterServlet extends HttpServlet{
  
  private ObjectMapper om;
  private RegisterService registerService;
  
  @Override
  public void init() throws ServletException {
    this.registerService =  new RegisterService(new ProjectRLoginPostgress());
    this.om = new ObjectMapper();
    super.init();
  }
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("reached ERS");
    
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//    System.out.println("URI: " + req.getRequestURI());
//    String[] tokens = req.getRequestURI().split("/");
//    
//    switch(tokens[2]) {
//    case "register":
//      ProjectRModelRegister newUser = om.readValue(req.getReader(), ProjectRModelRegister.class);
//      System.out.println(newUser);
//      registerService.register(newUser);
//      break;
//      default:
//      resp.setStatus(404);
//        
//  }
//}

    
    
    
    LoginDAO newAccount = new ProjectRLoginPostgress();
    String firstName = req.getParameter("registerFirstName");
    String lastName = req.getParameter("registerLastName");
    String email = req.getParameter("registerEmail");
    String username = req.getParameter("registerUsername");
    String password = req.getParameter("registerPassword");
    String confirmPassword = req.getParameter("registerConfirmPassword");
    
    ProjectRModelRegister register = new ProjectRModelRegister();
    register.setRegisterFirstName(firstName);
    register.setRegisterLastName(lastName);
    register.setRegisterEmail(email);
    register.setRegisterUsername(username);
    register.setRegisterPassword(password);
    
    System.out.println("" + register);
    
    newAccount.register(register);
    
  }
  }


