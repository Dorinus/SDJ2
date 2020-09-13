package temperature.model;

import java.util.ArrayList;

public class TemperatureList
{
  private ArrayList<Temperature> temperatures;

  public TemperatureList()
  {
    this.temperatures = new ArrayList<>();
  }

  public void addTemperature( Temperature temperature){
    temperatures.add(temperature);
  }

  public void removeTemperature(Temperature temperature){
    temperatures.remove(temperature);
  }

  public Temperature getTemperature(){

  }
}
