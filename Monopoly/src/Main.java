import model.Board;
import model.Game;
import model.Player;
import view.MainWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();


        Game game = new Game(players);
        Board board = game.getBoard();

        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow(board);
            mainWindow.setVisible(true);
        });
    }
}