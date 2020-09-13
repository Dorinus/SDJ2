package uppercase.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UppercaseViewController
{
  @FXML
  private TextField requestField;
  @FXML
  private TextField replyField;
  @FXML
  private Label errorField;
  private UppercaseViewModel viewModel;


  public void init(UppercaseViewModel uppercaseVM)
  {
    this.viewModel = uppercaseVM;
    errorField.textProperty().bind(viewModel.errorProperty());
    replyField.textProperty().bind(viewModel.replyProperty());
    requestField.textProperty().bindBidirectional(viewModel.requestProperty());
  //  replyField.setDisable(true);
  }

  @FXML
  private void onSubmitButoon(ActionEvent actionEvent)
  {
    System.out.println("Submit Pressed");
    viewModel.convert();
  }


}
