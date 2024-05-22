package view;

import javax.swing.*;
import java.awt.*;
import model.Board;
import model.Game;

public class MainWindow extends JFrame {
    private Game game;
    private BoardPanel boardPanel;
    private PlayerPanel playerPanel;

    public MainWindow(Game game) {
        this.game = game;
        this.boardPanel = new BoardPanel(game.getBoard());
        this.playerPanel = new PlayerPanel(game);

        setLayout(new BorderLayout());
        add(boardPanel, BorderLayout.CENTER);
        add(playerPanel, BorderLayout.EAST);

        setTitle("Monopoly");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public PlayerPanel getPlayerPanel() {
        return playerPanel;
    }
    
    public MainWindow(Board board) {
        setTitle("Game Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        BoardPanel boardPanel = new BoardPanel(board);
        add(boardPanel);
    }
}