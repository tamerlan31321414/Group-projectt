import java.awt.*;

public class Truck extends Car {
    private static final int TRUCK_HEALTH = 150;
    private static final int WHEEL_SIZE = 26;

    public Truck(int x, int y, Color color) {
        super(x, y, color, TRUCK_HEALTH);
    }

    @Override
    public void drive() {
        System.out.println("The truck is hauling heavy cargo across rough terrain.");
    }

    @Override
    public String getType() {
        return "Truck";
    }

    @Override
    public void draw(Graphics2D g2d) {
        drawBody(g2d);
        drawWheels(g2d);
        drawHeadlights(g2d);
        drawExhaust(g2d);
        drawHealthBar(g2d);
    }

    private void drawBody(Graphics2D g2d) {
        g2d.setColor(new Color(0, 153, 76)); // Tractor green body
        g2d.fillRoundRect(x, y, 100, 150, 20, 20);
    }

    private void drawWheels(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x - 15, y + 120, WHEEL_SIZE, WHEEL_SIZE);
        g2d.fillOval(x + 70, y + 120, WHEEL_SIZE, WHEEL_SIZE);

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillOval(x - 10, y + 125, WHEEL_SIZE - 6, WHEEL_SIZE - 6);
        g2d.fillOval(x + 75, y + 125, WHEEL_SIZE - 6, WHEEL_SIZE - 6);
    }

    private void drawHeadlights(Graphics2D g2d) {
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(x + 5, y + 10, 12, 12);
        g2d.fillOval(x + 80, y + 10, 12, 12);
    }

    private void drawExhaust(Graphics2D g2d) {
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(x + 90, y + 30, 10, 40);
    }

    private void drawHealthBar(Graphics2D g2d) {
        int barWidth = 100;
        int barHeight = 10;
        int barX = x;
        int barY = y - 15;

        Color barColor = health > 60 ? Color.GREEN : health > 30 ? Color.YELLOW : Color.RED;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(barX - 2, barY - 2, barWidth + 4, barHeight + 4);

        g2d.setColor(barColor);
        g2d.fillRect(barX, barY, (int) ((double) health / TRUCK_HEALTH * barWidth), barHeight);
    }
}