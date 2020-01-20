package com.revature.projectr.model;

public class ProjectRAccount {
  
  private String FirstName;
  private String LastName;
  private String Email;
  private String Username;
  private String Password;
  
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((Email == null) ? 0 : Email.hashCode());
    result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
    result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
    result = prime * result + ((Password == null) ? 0 : Password.hashCode());
    result = prime * result + ((Username == null) ? 0 : Username.hashCode());
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
    ProjectRAccount other = (ProjectRAccount) obj;
    if (Email == null) {
      if (other.Email != null)
        return false;
    } else if (!Email.equals(other.Email))
      return false;
    if (FirstName == null) {
      if (other.FirstName != null)
        return false;
    } else if (!FirstName.equals(other.FirstName))
      return false;
    if (LastName == null) {
      if (other.LastName != null)
        return false;
    } else if (!LastName.equals(other.LastName))
      return false;
    if (Password == null) {
      if (other.Password != null)
        return false;
    } else if (!Password.equals(other.Password))
      return false;
    if (Username == null) {
      if (other.Username != null)
        return false;
    } else if (!Username.equals(other.Username))
      return false;
    return true;
  }


  @Override
  public String toString() {
    return "ProjectRAccount [FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email
        + ", Username=" + Username + ", Password=" + Password + "]";
  }


  public String getFirstName() {
    return FirstName;
  }


  public void setFirstName(String firstName) {
    FirstName = firstName;
  }


  public String getLastName() {
    return LastName;
  }


  public void setLastName(String lastName) {
    LastName = lastName;
  }


  public String getEmail() {
    return Email;
  }


  public void setEmail(String email) {
    Email = email;
  }


  public String getUsername() {
    return Username;
  }


  public void setUsername(String username) {
    Username = username;
  }


  public String getPassword() {
    return Password;
  }


  public void setPassword(String password) {
    Password = password;
  }


  public ProjectRAccount(String firstName, String lastName, String email, String username,
      String password) {    
    this.FirstName = firstName;
    this.LastName = lastName;
    this.Email = email;
    this.Username = username;
    this.Password = password;
  }

}
