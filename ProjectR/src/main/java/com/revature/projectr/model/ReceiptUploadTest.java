package com.revature.projectr.model;

public class ReceiptUploadTest {
  
  String blob;
  
  

  public ReceiptUploadTest(String blob) {
    super();
    this.blob = blob;
  }

  public String getBlob() {
    return blob;
  }

  public void setBlob(String blob) {
    this.blob = blob;
  }

  @Override
  public String toString() {
    return "ReceiptUploadTest [blob=" + blob + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((blob == null) ? 0 : blob.hashCode());
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
    ReceiptUploadTest other = (ReceiptUploadTest) obj;
    if (blob == null) {
      if (other.blob != null)
        return false;
    } else if (!blob.equals(other.blob))
      return false;
    return true;
  }
  
  
  

}
