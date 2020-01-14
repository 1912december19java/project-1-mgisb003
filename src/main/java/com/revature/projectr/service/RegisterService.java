package com.revature.projectr.service;

import com.revature.projectr.model.ProjectREmployeeLogin;
import com.revature.projectr.model.ProjectRManagerLogin;
import com.revature.projectr.model.ProjectRModelRegister;
import com.revature.projectr.repository.LoginDAO;


public class RegisterService {
  
private LoginDAO loginDao;
  
  public RegisterService(LoginDAO loginDao) {
    this.loginDao = loginDao;
  }
  
  public void register(ProjectRModelRegister register) {  
    loginDao.register(register);
  }
  
  ProjectREmployeeLogin eLogin(String username, String password) {
    return loginDao.eLogin(username, password);
  }
  
  ProjectRManagerLogin mLogin(String username, String password) {
    return loginDao.mLogin(username, password);
  }
  
}