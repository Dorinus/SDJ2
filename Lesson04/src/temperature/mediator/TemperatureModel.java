package temperature.mediator;

import temperature.model.Temperature;

public interface TemperatureModel
{
  public void addTemperature(String id, double temperature);
  public Temperature getLastInsertedTemperature();
  public Temperature getLastInsertedTemperature(String id);

}
