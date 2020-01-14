package com.revature.projectr.model;

public class ProjectREmployeeLogin {
  
  private String employeeUsername;
  private String employeePassword;
  
  public ProjectREmployeeLogin(String employeeUsername,String employeePassword) {
    this.employeePassword = employeePassword;
    this.employeeUsername = employeeUsername;
  }

  public String getEmployeeUsername() {
    return employeeUsername;
  }

  public void setEmployeeUsername(String employeeUsername) {
    this.employeeUsername = employeeUsername;
  }

  public String getEmployeePassword() {
    return employeePassword;
  }

  public void setEmployeePassword(String employeePassword) {
    this.employeePassword = employeePassword;
  }

  @Override
  public String toString() {
    return "ProjectREmployeeLogin [employeeUsername=" + employeeUsername + ", employeePassword="
        + employeePassword + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((employeePassword == null) ? 0 : employeePassword.hashCode());
    result = prime * result + ((employeeUsername == null) ? 0 : employeeUsername.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ProjectREmployeeLogin other = (ProjectREmployeeLogin) obj;
    if (employeePassword == null) {
      if (other.employeePassword != null)
        return false;
    } else if (!employeePassword.equals(other.employeePassword))
      return false;
    if (employeeUsername == null) {
      if (other.employeeUsername != null)
        return false;
    } else if (!employeeUsername.equals(other.employeeUsername))
      return false;
    return true;
  }  

}
