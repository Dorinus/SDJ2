package trafficlight;

import java.beans.PropertyChangeListener;

public interface PropretyChangeSubject
{
  public void addListener(String eventName, PropertyChangeListener listener);
  public void removeListener(String eventName, PropertyChangeListener listener);

  public void addListener(PropertyChangeListener listener);
  public void removeListener(PropertyChangeListener listener);

}
