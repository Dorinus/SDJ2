package yetanothertrafficlightexample;

//import trafficlightevent.PropertyChangeSubject;

public class Taxi implements TrafficLightListener{

    private int id;

    public Taxi(int id) {
        this.id = id;
    }

    public void lightChanged(String evt) {
        if("GREEN".equals(evt)) {
            System.out.println("Taxi " + id + " drives");
        } else if("RED".equals(evt)) {
            System.out.println("Taxi " + id + " stops");
        }
    }

    @Override
    public void update(String currentLight) {
        lightChanged(currentLight);
    }
}


