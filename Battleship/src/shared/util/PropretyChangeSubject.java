package shared.util;

import java.beans.PropertyChangeListener;

public interface PropretyChangeSubject
{
  public void addPropretyChangeListener(String name, PropertyChangeListener listener);
  public void addPropretyChangeListener(PropertyChangeListener listener);
  public void removePropretyChangeListener(String name, PropertyChangeListener listener);
  public void removePropretyChangeListener(PropertyChangeListener listener);

}
