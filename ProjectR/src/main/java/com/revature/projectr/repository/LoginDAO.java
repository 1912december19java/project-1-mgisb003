package com.revature.projectr.repository;


import java.util.List;
import com.revature.projectr.model.ProjectRManagerLogin;
import com.revature.projectr.model.ProjectRModelRegister;
import com.revature.projectr.model.Request;

public interface LoginDAO {

  public void register(ProjectRModelRegister register);

  ProjectRManagerLogin mLogin(String username, String password);
  
  ProjectRModelRegister userInfo(String username, String password);
  
  public void sendRequest(Request request);
  
  public void answerRequest(Request request);
  
  public void update(ProjectRModelRegister update);

  List<Request> getAll(String username);

  List<Request> getAllPending();

  List<Request> getAllNotPending();

  List<ProjectRModelRegister> getAllEmployees();

}
