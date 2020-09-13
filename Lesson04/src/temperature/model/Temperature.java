package temperature.model;

public class Temperature
{
  private double temp;
  private DateTime dateTime;
  private String id;

  public Temperature(double temp, String id)
  {
    this.temp = temp;
    this.id = id;
  }

  public double getTemp()
  {
    return temp;
  }

  public DateTime getDateTime()
  {
    return dateTime;
  }

  public void setTemp(int temp)
  {
    this.temp = temp;
  }

  public void setDateTime(DateTime dateTime)
  {
    this.dateTime = dateTime;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }
}
