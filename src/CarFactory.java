import java.awt.*;

public class CarFactory {
    private static CarFactory instance;

    private CarFactory() {}

    public static CarFactory getInstance() {
        if (instance == null) {
            instance = new CarFactory();
        }
        return instance;
    }

    public Car createCar(String type) {
        switch (type) {
            case "Sedan":
                return new Sedan(225, 500, Color.DARK_GRAY);
            case "SUV":
                return new SUV(225, 500, Color.GREEN);
            case "Truck":
                return new Truck(225, 500, Color.BLUE);
            default:
                return new Sedan(225, 500, Color.DARK_GRAY);
        }
    }
}
