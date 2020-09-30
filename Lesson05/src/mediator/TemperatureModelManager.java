package mediator;

import model.Temperature;
import model.TemperatureList;

public class TemperatureModelManager implements TemperatureModel
{

  private TemperatureList temperatureList;


  @Override public void addTemperature(String id, double temperature)
  {

  }

  @Override public Temperature getLastInserted()
  {
    return null;
  }

  @Override public Temperature getLastInserted(String id)
  {
    return null;
  }

}
