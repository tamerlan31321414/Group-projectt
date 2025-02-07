import java.awt.*;

public class Health {
    private int health;

    public Health(int initialHealth) {
        this.health = initialHealth;
    }

    public int getHealth() {
        return health;
    }

    public void decreaseHealth(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    public void resetHealth(int initialHealth) {
        health = initialHealth;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(20, 70, health * 2, 20);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Health: " + health, 20, 120);
    }
}
