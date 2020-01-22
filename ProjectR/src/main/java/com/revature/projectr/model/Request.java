package com.revature.projectr.model;

public class Request {
  
  Integer id;
  String eUser;
  String blob;
  Boolean decision;
  String manUser;
  String amount;  

  public Request() {
    super();
  }

  public Request(Integer id, String eUser, String blob, Boolean decision, String manUser,
      String amount) {
    super();
    this.id = id;
    this.eUser = eUser;
    this.blob = blob;
    this.decision = decision;
    this.manUser = manUser;
    this.amount = amount;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String geteUser() {
    return eUser;
  }

  public void seteUser(String eUser) {
    this.eUser = eUser;
  }

  public String getBlob() {
    return blob;
  }

  public void setBlob(String blob) {
    this.blob = blob;
  }

  public Boolean getDecision() {
    return decision;
  }

  public void setDecision(Boolean decision) {
    this.decision = decision;
  }

  public String getManUser() {
    return manUser;
  }

  public void setManUser(String manUser) {
    this.manUser = manUser;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Request [id=" + id + ", eUser=" + eUser + ", blob=" + blob + ", decision=" + decision
        + ", manUser=" + manUser + ", amount=" + amount + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((blob == null) ? 0 : blob.hashCode());
    result = prime * result + ((decision == null) ? 0 : decision.hashCode());
    result = prime * result + ((eUser == null) ? 0 : eUser.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((manUser == null) ? 0 : manUser.hashCode());
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
    Request other = (Request) obj;
    if (amount == null) {
      if (other.amount != null)
        return false;
    } else if (!amount.equals(other.amount))
      return false;
    if (blob == null) {
      if (other.blob != null)
        return false;
    } else if (!blob.equals(other.blob))
      return false;
    if (decision == null) {
      if (other.decision != null)
        return false;
    } else if (!decision.equals(other.decision))
      return false;
    if (eUser == null) {
      if (other.eUser != null)
        return false;
    } else if (!eUser.equals(other.eUser))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (manUser == null) {
      if (other.manUser != null)
        return false;
    } else if (!manUser.equals(other.manUser))
      return false;
    return true;
  }
  
  

}