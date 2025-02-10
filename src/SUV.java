import java.awt.*;

public class SUV extends Car {
    private static final int SUV_HEALTH = 100;
    private static final int WHEEL_SIZE = 20;

    public SUV(int x, int y, Color color) {
        super(x, y, color, SUV_HEALTH);
    }

    @Override
    public void drive() {
        System.out.println("The SUV is driving off-road with high clearance.");
    }

    @Override
    public String getType() {
        return "SUV";
    }

    @Override
    public void draw(Graphics2D g2d) {
        drawBody(g2d);
        drawWheels(g2d);
        drawHeadlights(g2d);
        drawWindows(g2d);
        drawHealthBar(g2d);
    }

    private void drawBody(Graphics2D g2d) {
        g2d.setColor(new Color(0, 128, 255));
        g2d.fillRoundRect(x, y, 70, 130, 20, 20);
    }

    private void drawWheels(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x - 10, y + 110, WHEEL_SIZE, WHEEL_SIZE);
        g2d.fillOval(x + 55, y + 110, WHEEL_SIZE, WHEEL_SIZE);

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillOval(x - 5, y + 115, WHEEL_SIZE - 6, WHEEL_SIZE - 6);
        g2d.fillOval(x + 60, y + 115, WHEEL_SIZE - 6, WHEEL_SIZE - 6);
    }

    private void drawHeadlights(Graphics2D g2d) {
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(x + 5, y - 10, 12, 12);
        g2d.fillOval(x + 50, y - 10, 12, 12);
    }

    private void drawWindows(Graphics2D g2d) {
        g2d.setColor(new Color(255, 223, 0, 180));
        g2d.fillRoundRect(x + 10, y + 15, 50, 30, 15, 15);
        g2d.fillRoundRect(x + 10, y + 50, 50, 30, 15, 15);
    }

    private void drawHealthBar(Graphics2D g2d) {
        int barWidth = 70;
        int barHeight = 8;
        int barX = x;
        int barY = y - 15;

        Color barColor = health > 60 ? Color.GREEN : health > 30 ? Color.YELLOW : Color.RED;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(barX - 2, barY - 2, barWidth + 4, barHeight + 4);

        g2d.setColor(barColor);
        g2d.fillRect(barX, barY, (int) ((double) health / SUV_HEALTH * barWidth), barHeight);
    }
}
