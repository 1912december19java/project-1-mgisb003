package com.revature.projectr.repository;


import java.util.List;
import com.revature.projectr.model.ProjectRManagerLogin;
import com.revature.projectr.model.ProjectRModelRegister;
import com.revature.projectr.model.ReceiptUploadTest;

public interface LoginDAO {

  public void register(ProjectRModelRegister register);

  ProjectRManagerLogin mLogin(String username, String password);
  
  public void upload(ReceiptUploadTest upload);
  
  ProjectRModelRegister userInfo(String username, String password);
  
  public void update(ProjectRModelRegister update);

  List<ProjectRModelRegister> getAll();

}
