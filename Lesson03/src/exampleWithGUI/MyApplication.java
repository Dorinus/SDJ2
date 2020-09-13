package exampleWithGUI;

import exampleWithGUI.temperature.mediator.TemperatureModel;
import exampleWithGUI.temperature.mediator.TemperatureModelManager;
import exampleWithGUI.temperature.view.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {

    // Model
    TemperatureModel model = new TemperatureModelManager();

    //Threads
    Thread t1 = new Thread ( new Thermometer("t1", 15,1, model));
    Thread t2 = new Thread(new Thermometer("t2", 15,7, model));

    // View
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);


  }
}
