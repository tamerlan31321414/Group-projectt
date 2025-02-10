import db.PostgresDB;
import db.interfaces.IDB;
import repositories.RecordRepository;
import repositories.interfaces.IRecordRepository;
import repositories.interfaces.User;

import javax.swing.*;

public class CarGame extends JFrame {
    private User currentUser;
    private IRecordRepository repository;

    public CarGame() {
        setTitle("Car Game");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        IDB db = new PostgresDB("jdbc:postgresql://localhost:5432", "postgres", "210979", "cargame");
        repository = new RecordRepository(db);

        getUserInput();

        GamePanel gamePanel = new GamePanel(repository);
        addKeyListener(gamePanel);
        add(gamePanel);
        setVisible(true);
    }

    private void getUserInput() {
        String name = JOptionPane.showInputDialog(this, "Enter your name:", "Welcome", JOptionPane.QUESTION_MESSAGE);

        if (name != null && !name.trim().isEmpty()) {
            currentUser = repository.saveUser(new User(name));
        } else {
            JOptionPane.showMessageDialog(this, "Name cannot be empty. Please try again", "Error", JOptionPane.ERROR_MESSAGE);
            getUserInput();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarGame());
    }
}
