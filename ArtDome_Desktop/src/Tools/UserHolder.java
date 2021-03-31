/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entities.User;

/**
 *
 * @author asus
 */
public final class UserHolder {
  
  private User user;
  private final static UserHolder INSTANCE = new UserHolder();
  
  private UserHolder() {}
  
  public static UserHolder getInstance()
    {   return INSTANCE;
    }
  
  public void setUser(User u) {
    this.user = u;
  }
  
  public User getUser() {
    return this.user;
  }
}
