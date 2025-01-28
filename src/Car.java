import java.awt.*;

public class Car {
    private int x, y;
    private final Color color;

    public Car(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRoundRect(x, y, 50, 100, 15, 15);


        g2d.setColor(new Color(0, 0, 0, 50));
        g2d.fillRoundRect(x + 5, y + 10, 40, 80, 15, 15);


        g2d.setColor(Color.CYAN);
        g2d.fillRoundRect(x + 10, y + 10, 30, 20, 10, 10);
        g2d.setColor(new Color(255, 255, 255, 50));
        g2d.fillRoundRect(x + 15, y + 12, 15, 10, 8, 8);

        g2d.setColor(Color.BLACK);
        g2d.fillOval(x - 5, y + 15, 15, 15);
        g2d.fillOval(x - 5, y + 70, 15, 15);
        g2d.fillOval(x + 40, y + 15, 15, 15);
        g2d.fillOval(x + 40, y + 70, 15, 15);

        g2d.setColor(Color.GRAY);
        g2d.fillOval(x - 2, y + 18, 10, 10);
        g2d.fillOval(x - 2, y + 73, 10, 10);
        g2d.fillOval(x + 38, y + 18, 10, 10);
        g2d.fillOval(x + 38, y + 73, 10, 10);

        
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(x + 5, y - 5, 10, 10);
        g2d.fillOval(x + 35, y - 5, 10, 10);

        
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRoundRect(x + 20, y + 50, 10, 5, 5, 5);


        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(x - 10, y + 30, 5, 15);
        g2d.fillRect(x + 55, y + 30, 5, 15);


        g2d.setColor(new Color(255, 255, 255, 150));
        g2d.fillOval(x + 7, y - 8, 5, 5);
        g2d.fillOval(x + 37, y - 8, 5, 5);
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void resetPosition(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 100);
    }
}
