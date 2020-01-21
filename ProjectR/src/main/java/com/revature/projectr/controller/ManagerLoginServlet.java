package com.revature.projectr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.projectr.model.ProjectRManagerLogin;
import com.revature.projectr.repository.LoginDAO;
import com.revature.projectr.repository.ProjectRLoginPostgress;

@WebServlet(name = "mLogin", urlPatterns = {"/mLogin"})
public class ManagerLoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    System.out.println("Reached MLS");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    HttpSession session = req.getSession();
    LoginDAO manLogin = new ProjectRLoginPostgress();

    String username = req.getParameter("managerUsername");
    String password = req.getParameter("managerPassword");

    ProjectRManagerLogin mLogin = manLogin.mLogin(username, password);

    session.setAttribute("mLogin", mLogin);

    if (mLogin == null) {
      resp.sendRedirect("ProjectOneWebsite/ManagerLogin.html");
    } else {
      resp.sendRedirect("ProjectOneWebsite/Manager.html");
    }
  }
}
