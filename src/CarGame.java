import javax.swing.*;

public class CarGame extends JFrame {
    public CarGame() {
        setTitle("Car Game");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        GamePanel gamePanel = new GamePanel();
        addKeyListener(gamePanel);
        add(gamePanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CarGame::new);
    }
}
