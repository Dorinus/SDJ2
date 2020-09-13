package yetanothertrafficlightexample;

import java.util.ArrayList;
import java.util.List;

public class TrafficLight implements Subject{

    private String[] lights = {"GREEN", "YELLOW", "RED", "YELLOW"};
    private int count = 2;
    private String currentLight;

    private List<TrafficLightListener> listeners;

    public TrafficLight() {
        listeners = new ArrayList<>();
        currentLight = lights[count];
    }

    public void start() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            count = (++count) % 4;
            currentLight = lights[count];
            System.out.println("\nLight is " + currentLight);
            updateListeners(currentLight);
        }
    }

    private void updateListeners(String currentLight) {
        for (TrafficLightListener listener : listeners) {
            listener.update(currentLight);
        }
    }

    public void addListener(TrafficLightListener lstnr) {
        listeners.add(lstnr);
    }

    public void removeListener(TrafficLightListener lstnr) {
        listeners.remove(lstnr);
    }
}
