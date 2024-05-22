package controller;

import java.awt.BorderLayout;
import model.Game;
import model.Player;
import view.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private Game game;
    private MainWindow mainWindow;

    public GameController(Game game, MainWindow mainWindow) {
        this.game = game;
        this.mainWindow = mainWindow;
        setupListeners();
    }

    private void setupListeners() {
        // Añadir listeners para los botones del tablero y otras interacciones
        JButton rollDiceButton = new JButton("Roll Dice");
        rollDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        mainWindow.add(rollDiceButton, BorderLayout.SOUTH);
    }

    private void rollDice() {
        Player currentPlayer = game.getCurrentPlayer();
        int diceRoll = (int) (Math.random() * 6) + 1;
        currentPlayer.move(diceRoll);

        // Lógica adicional para manejar la casilla en la que el jugador ha caído
        mainWindow.getPlayerPanel().updatePlayerInfo();
        game.nextTurn();
    }
}