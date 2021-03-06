package server.dataaccess;

import shared.datatransfer.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUsers implements UserHome
{
  private List<User> users;

  public InMemoryUsers()
  {
    this.users = new ArrayList<>();
    users.add(new User("Dorin","123"));
    users.add(new User("Van", "dam"));
  }

  @Override public String validateUser(User user)
  {
    String result = "";
    boolean userFound= false;
    for(User u: users){
      if(u.getUsername().equals(user.getUsername())){
        if(u.getPassword().equals(user.getPassword())){
          result = "OK";
        } else {
          result  = "Incorrect Password";
        }
        userFound = true;
      }
    }
    if(!userFound){
      result = "User not found";
    }
    return result;
  }
}
