package mediator;

import model.Temperature;

public interface TemperatureModel
{
  public  void addTemperature(String id, double temperature);
  public Temperature getLastInserted();
  public Temperature getLastInserted(String id);
}
