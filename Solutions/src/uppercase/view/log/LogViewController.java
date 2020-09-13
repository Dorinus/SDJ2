package uppercase.view.log;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import uppercase.core.ViewHandler;

public class LogViewController
{
  @FXML
  private ListView<String> logList;
  // aici


  private LogViewModel viewModel;
  private ViewHandler viewHandler;

  public LogViewController(LogViewModel viewModel, ViewHandler viewHandler)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }


}
