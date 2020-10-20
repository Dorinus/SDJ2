package client.view.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController
{
  @FXML
  private Label loginResultLabel;
  @FXML
  private TextField usernameTextField;
  @FXML
  private TextField passwordTextField;
  private LoginVM loginVM;


  public void init(LoginVM loginVM)
  {
    this.loginVM =loginVM;
    usernameTextField.textProperty().bindBidirectional(loginVM.usernameProperty());
    passwordTextField.textProperty().bindBidirectional(loginVM.passwordProperty());
    loginResultLabel.textProperty().bind(loginVM.loginResponseProperty());

    loginVM.loginResponseProperty().addListener((observableValue, s, t1) -> onLoginResult(t1));
  }

  private void onLoginResult(String t1)
  {
    if(t1.equals("OK")){
      System.out.println("Swap to lobby view");
    }
  }

  public void onLoginButton(ActionEvent actionEvent)
  {
    loginVM.login();
  }

  public void onRegisterButton(ActionEvent actionEvent)
  {

  }



}
