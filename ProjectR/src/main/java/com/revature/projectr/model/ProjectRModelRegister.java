package com.revature.projectr.model;

public class ProjectRModelRegister {
  
  private String registerFirstName;
  private String registerLastName;
  private String registerEmail;
  private String registerUsername;
  private String registerPassword;
  
  
  public ProjectRModelRegister() {
    super();
        
  }

  public String getRegisterFirstName() {
    return registerFirstName;
  }

  public void setRegisterFirstName(String registerFirstName) {
    this.registerFirstName = registerFirstName;
  }

  public String getRegisterLastName() {
    return registerLastName;
  }

  public void setRegisterLastName(String registerLastName) {
    this.registerLastName = registerLastName;
  }

  public String getRegisterEmail() {
    return registerEmail;
  }

  public void setRegisterEmail(String registerEmail) {
    this.registerEmail = registerEmail;
  }

  public String getRegisterUsername() {
    return registerUsername;
  }

  public void setRegisterUsername(String registerUsername) {
    this.registerUsername = registerUsername;
  }

  public String getRegisterPassword() {
    return registerPassword;
  }

  public void setRegisterPassword(String registerPassword) {
    this.registerPassword = registerPassword;
  }


  @Override
  public String toString() {
    return "ProjectRModel [registerFirstName=" + registerFirstName + ", registerLastName="
        + registerLastName + ", registerEmail=" + registerEmail + ", registerUsername="
        + registerUsername + ", registerPassword=" + registerPassword + ", registerConfirmPassword="
        + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;      
    result = prime * result + ((registerEmail == null) ? 0 : registerEmail.hashCode());
    result = prime * result + ((registerFirstName == null) ? 0 : registerFirstName.hashCode());
    result = prime * result + ((registerLastName == null) ? 0 : registerLastName.hashCode());
    result = prime * result + ((registerPassword == null) ? 0 : registerPassword.hashCode());
    result = prime * result + ((registerUsername == null) ? 0 : registerUsername.hashCode());
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
    ProjectRModelRegister other = (ProjectRModelRegister) obj;
    if (registerEmail == null) {
      if (other.registerEmail != null)
        return false;
    } else if (!registerEmail.equals(other.registerEmail))
      return false;
    if (registerFirstName == null) {
      if (other.registerFirstName != null)
        return false;
    } else if (!registerFirstName.equals(other.registerFirstName))
      return false;
    if (registerLastName == null) {
      if (other.registerLastName != null)
        return false;
    } else if (!registerLastName.equals(other.registerLastName))
      return false;
    if (registerPassword == null) {
      if (other.registerPassword != null)
        return false;
    } else if (!registerPassword.equals(other.registerPassword))
      return false;
    if (registerUsername == null) {
      if (other.registerUsername != null)
        return false;
    } else if (!registerUsername.equals(other.registerUsername))
      return false;
    return true;
  }
  
}
