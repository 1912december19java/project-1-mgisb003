package com.revature.projectr.repository;


import com.revature.projectr.model.ProjectRManagerLogin;
import com.revature.projectr.model.ProjectRModelRegister;

public interface LoginDAO {

  public void register(ProjectRModelRegister register);

  ProjectRModelRegister eLogin(String username, String password);

  ProjectRManagerLogin mLogin(String username, String password);

}
