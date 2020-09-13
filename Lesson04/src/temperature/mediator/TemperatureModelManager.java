package temperature.mediator;

import temperature.model.Temperature;
import temperature.model.TemperatureList;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;

  public TemperatureModelManager(TemperatureList temperatureList)
  {
    this.temperatureList = temperatureList;
  }



  @Override public void addTemperature(String id, double temperature)
  {
    temperatureList.addTemperature(new Temperature(temperature, id));
  }

  @Override public Temperature getLastInsertedTemperature()
  {
    return temperatureList.
  }

  @Override public Temperature getLastInsertedTemperature(String id)
  {
    return null;
  }
}
