package view;

import javax.swing.*;
import java.awt.*;
import model.Game;
import model.Player;

public class PlayerPanel extends JPanel {
    private Game game;
    private JLabel[] playerLabels;

    public PlayerPanel(Game game) {
        this.game = game;
        setLayout(new GridLayout(game.getPlayers().size(), 1));
        playerLabels = new JLabel[game.getPlayers().size()];

        for (int i = 0; i < game.getPlayers().size(); i++) {
            Player player = game.getPlayers().get(i);
            playerLabels[i] = new JLabel(player.getName() + ": $" + player.getMoney() + " - Posición: " + player.getPosition());
            add(playerLabels[i]);
        }
    }

    public void updatePlayerInfo() {
        for (int i = 0; i < game.getPlayers().size(); i++) {
            Player player = game.getPlayers().get(i);
            playerLabels[i].setText(player.getName() + ": $" + player.getMoney() + " - Posición: " + player.getPosition());
        }
    }
}