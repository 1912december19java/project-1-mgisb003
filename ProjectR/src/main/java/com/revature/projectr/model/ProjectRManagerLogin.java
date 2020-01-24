package com.revature.projectr.model;

public class ProjectRManagerLogin {

  private String managerUsername;
  private String managerPassword;

  public ProjectRManagerLogin() {
    super();
  }

  public ProjectRManagerLogin(String managerUsername,String managerPassword) {
    this.managerPassword = managerPassword;
    this.managerUsername = managerUsername;
  }

  public String getManagerUsername() {
    return managerUsername;
  }

  public void setManagerUsername(String managerUsername) {
    this.managerUsername = managerUsername;
  }

  public String getManagerPassword() {
    return managerPassword;
  }

  public void setManagerPassword(String managerPassword) {
    this.managerPassword = managerPassword;
  }

  @Override
  public String toString() {
    return "ProjectRManagerLogin [managerUsername=" + managerUsername + ", managerPassword="
        + managerPassword + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((managerPassword == null) ? 0 : managerPassword.hashCode());
    result = prime * result + ((managerUsername == null) ? 0 : managerUsername.hashCode());
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
    ProjectRManagerLogin other = (ProjectRManagerLogin) obj;
    if (managerPassword == null) {
      if (other.managerPassword != null)
        return false;
    } else if (!managerPassword.equals(other.managerPassword))
      return false;
    if (managerUsername == null) {
      if (other.managerUsername != null)
        return false;
    } else if (!managerUsername.equals(other.managerUsername))
      return false;
    return true;
  }
}
