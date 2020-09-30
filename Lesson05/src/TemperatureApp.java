import external.Thermometer1;
import javafx.application.Application;
import javafx.stage.Stage;

public class TemperatureApp extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    Thermometer1 thermometer1 = new Thermometer1("T1", 15, 0);
    Thread thermThread = new Thread();

    thermThread.setDaemon(true);
    thermThread.start();
  }
}
