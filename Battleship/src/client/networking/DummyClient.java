package client.networking;

import shared.EventType;
import shared.datatransfer.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class DummyClient implements Client
{
  private List<User>   users = new ArrayList<>();
  private PropertyChangeSupport support;

  public DummyClient()
  {
    users.add(new User("Dorin","123"));
    users.add(new User("Van", "dam"));
    support = new PropertyChangeSupport(this);
  }

  @Override public void login(User user)
  {

    System.out.println("Client: "+user);
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

    support.firePropertyChange(EventType.LOGIN_RESULT.toString(),null,result);

  }

  @Override public void addPropretyChangeListener(String name, PropertyChangeListener listener)
  {
    if(name==null){
      addPropretyChangeListener(listener);
    } else {
      support.addPropertyChangeListener(name,listener);
    }

  }

  @Override public void addPropretyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropretyChangeListener(String name, PropertyChangeListener listener)
  {
    if(name==null){
      removePropretyChangeListener(listener);  //why no support
    } else {
      support.removePropertyChangeListener(name, listener);
    }
  }

  @Override public void removePropretyChangeListener(PropertyChangeListener listener)
  {

    support.removePropertyChangeListener(listener);
  }
}
