import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class CarGame extends JFrame implements ActionListener, KeyListener {
    public class Jrame {


    }
    private Timer timer;
    private int playerX = 400;
    private int playerY = 500;
    private int obstacleX;
    private int obstacleY = -100;
    private int score = 0;
    private boolean gameRunning = true;

    public CarGame() {
        setTitle("Car Game");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        addKeyListener(this);
        obstacleX = new Random().nextInt(400);
        timer = new Timer(20, this);
        timer.start();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (gameRunning) {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, 500, 700);

            // Рисуем машину игрока
            g.setColor(Color.BLUE);
            g.fillRect(playerX, playerY, 50, 100);


            g.setColor(Color.RED);
            g.fillRect(obstacleX, obstacleY, 50, 100);


            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Score: " + score, 20, 50);
        } else {

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 500, 700);
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over", 150, 300);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Final Score: " + score, 180, 350);



        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameRunning) {
            obstacleY += 20;

            if (new Rectangle(playerX, playerY, 50, 100).intersects(new Rectangle(obstacleX, obstacleY, 50, 100))) {
                gameRunning = false;
                timer.stop();
            }

            if (obstacleY > 700) {
                obstacleY = -100;
                obstacleX = new Random().nextInt(400);
                score++;
            }

            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameRunning) {

            if (e.getKeyCode() == KeyEvent.VK_LEFT && playerX > 0) {
                playerX -= 20;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && playerX < 450) {
                playerX += 20;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarGame game = new CarGame();
            game.setVisible(true);
        });
    }
}