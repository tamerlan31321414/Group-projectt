import java.awt.*;

public class Sedan extends Car {
    public Sedan(int x, int y, Color color) {
        super(x, y, color, 100);
    }

    @Override
    public void drive() {
        System.out.println("Driving a Sedan");
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
