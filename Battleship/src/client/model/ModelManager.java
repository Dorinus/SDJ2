package client.model;

import client.networking.Client;
import shared.EventType;
import shared.datatransfer.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
  private Client client;
  private User loggedInUser;
  private PropertyChangeSupport support;


  public ModelManager(Client client)
  {
    this.client= client;
    client.addPropretyChangeListener(EventType.LOGIN_RESULT.toString(), this::onLoginResult);
    support = new PropertyChangeSupport(this);
  }

  private void onLoginResult(PropertyChangeEvent event)
  {
    String loginResult = (String) event.getNewValue();
    System.out.println("Result reveive in model: " + loginResult );
    if(!"OK".equals(loginResult)){
      loggedInUser = null;
    }

    support.firePropertyChange(EventType.LOGIN_RESULT.toString(),null, loginResult);
  }

  @Override public void login(String username, String pasword)
  {
    loggedInUser = new User(username, pasword  );
    client.login(loggedInUser);
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
