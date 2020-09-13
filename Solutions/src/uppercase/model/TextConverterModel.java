package uppercase.model;

import java.util.ArrayList;
import java.util.List;

public class TextConverterModel implements TextConverter {

    private ArrayList<String> list;


    @Override
    public String toUppercase(String text) {
        return text.toUpperCase();
    }

    @Override
    public void addLog(String log)
    {
        list.add(log);
    }

    public List<String> getLog(){
        return list;
    }

    public int getLogSize(){
        return  list.size();
    }

}


