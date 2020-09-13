package yetanothertrafficlightexample;

public class RunTrafficLightExample {

    public static void main(String[] args) throws InterruptedException {
        Car c1 = new Car(1);
        Car c2 = new Car(2);
        Car c3 = new Car(3);
        Car c4 = new Car(4);

        TrafficLight tf = new TrafficLight();

        tf.addListener(c1);
        tf.addListener(c2);
        tf.addListener(c3);
        tf.addListener(c4);
        tf.addListener(new Taxi(1));
        tf.addListener(new Taxi(2));

        tf.start();
    }
}
