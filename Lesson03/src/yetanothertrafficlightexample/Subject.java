package yetanothertrafficlightexample;

public interface Subject {

    void addListener(TrafficLightListener lstnr);
    void removeListener(TrafficLightListener lstnr);

}
