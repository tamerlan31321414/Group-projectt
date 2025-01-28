import db.PostgresDB;
import db.interfaces.IDB;
import repositories.RecordRepository;
import repositories.interfaces.IRecordRepository;

import javax.swing.*;

public class CarGame extends JFrame {
    public CarGame() {
        setTitle("Car Game");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        IDB db = new PostgresDB("jdbc:postgresql://localhost:5432", "postgres", "210979", "cargame");

        IRecordRepository repo = new RecordRepository(db);

        GamePanel gamePanel = new GamePanel(repo);
        addKeyListener(gamePanel);
        add(gamePanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CarGame::new);
    }
}
