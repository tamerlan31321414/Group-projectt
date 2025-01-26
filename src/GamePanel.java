import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private final Timer timer;
    private final Road road;
    private final Car playerCar;
    private final Car obstacleCar;
    private int score = 0;
    private int speed = 10;
    private boolean gameRunning = true;

    public GamePanel() {
        road = new Road();
        playerCar = new Car(225, 500, Color.DARK_GRAY);
        obstacleCar = new Car(new Random().nextInt(400), -100, Color.RED);

        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (gameRunning) {
            road.draw(g2d, speed);
            playerCar.draw(g2d);
            obstacleCar.draw(g2d);

            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 20));
            g2d.drawString("Score: " + score, 20, 50);
        } else {
            drawGameOverScreen(g2d);
        }
    }

    private void drawGameOverScreen(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial", Font.BOLD, 40));
        g2d.drawString("Game Over", 150, 300);
        g2d.drawString("ты лузер", 165, 500);
        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        g2d.drawString("Final Score: " + score, 180, 350);

        g2d.setColor(Color.WHITE);
        g2d.drawString("Press R to Restart", 170, 400);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameRunning) {
            obstacleCar.move(0, speed);
            road.update(speed);

            if (playerCar.getBounds().intersects(obstacleCar.getBounds())) {
                gameRunning = false;
                timer.stop();
            }

            if (obstacleCar.getY() > getHeight()) {
                obstacleCar.resetPosition(new Random().nextInt(400), -100);
                score++;
                if (score % 5 == 0) {
                    speed++;
                }
            }

            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameRunning) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> playerCar.move(-20, 0);
                case KeyEvent.VK_RIGHT -> playerCar.move(20, 0);
                case KeyEvent.VK_UP -> playerCar.move(0, -20);
                case KeyEvent.VK_DOWN -> playerCar.move(0, 20);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            restartGame();
        }
    }

    private void restartGame() {
        gameRunning = true;
        playerCar.resetPosition(225, 500);
        obstacleCar.resetPosition(new Random().nextInt(400), -100);
        score = 0;
        speed = 10;
        timer.start();
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
