package client.view.login;

import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.EventType;

import java.beans.PropertyChangeEvent;

public class LoginVM
{
  private StringProperty username, password, loginResponse;
  private Model model;

  public LoginVM( Model model)
  {
    this.model = model;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    this.loginResponse = new SimpleStringProperty();
    model.addPropretyChangeListener(EventType.LOGIN_RESULT.toString(),this::onLoginResponse);
  }


  private void onLoginResponse(PropertyChangeEvent event)
  {
    String result = (String) event.getNewValue();
    Platform.runLater(()->loginResponse.set(result));
    loginResponse.set(result);

  }

  public StringProperty loginResponseProperty()
  {
    return loginResponse;
  }


  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty passwordProperty()
  {
    return password;
  }

  public void login()
  {
    System.out.println(username.get());
    System.out.println(password.get());
    model.login(username.get(), password.get());
  }
}
