package uppercase.core;

import uppercase.view.UppercaseViewModel;

public class ViewModelFactory
{
  private UppercaseViewModel uppercaseVM;
  private  ModelFactory mf;

  public ViewModelFactory( ModelFactory modelFactory)
  {
    this.mf = modelFactory;
  }

  public UppercaseViewModel getUppercaseVM()
  {
    if(uppercaseVM==null) {
      uppercaseVM = new UppercaseViewModel(mf.getTextConverter());
    }
      return uppercaseVM;

  }
}
