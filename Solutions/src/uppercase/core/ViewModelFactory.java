package uppercase.core;

import uppercase.view.log.LogViewModel;
import uppercase.view.uppercase.UppercaseViewModel;

public class ViewModelFactory {

    private final ModelFactory mf;
    private UppercaseViewModel uppercaseViewModel;
    private LogViewModel logVM;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
    }

    public UppercaseViewModel getUppercaseViewModel() {
        if (uppercaseViewModel == null)
            uppercaseViewModel = new UppercaseViewModel(mf.getTextConverter());
        return uppercaseViewModel;
    }

    public LogViewModel getLogViewModel(){
        if(logVM == null)
            logVM = new LogViewModel(mf.getTextConverter());
        return logVM;
    }
}
