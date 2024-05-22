package model;

import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private int currentPlayerIndex;

    public Game(List<Player> players) {
        this.players = players;
        this.board = new Board();
        this.currentPlayerIndex = 0;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void movePlayer(Player player, int roll) {
        int newPosition = (player.getPosition() + roll) % board.getProperties().size();
        player.setPosition(newPosition);

        Property property = board.getProperty(newPosition);
        if (property != null) {
            handlePropertyLanding(player, property);
        }
    }

    public void handlePropertyLanding(Player player, Property property) {
        if (property.getOwner() == null) {
            offerToBuyProperty(player, property);
        } else if (!property.getOwner().equals(player)) {
            payRent(player, property);
        }
    }

    public void offerToBuyProperty(Player player, Property property) {
        int price = property.getPrice();
        if (player.getMoney() >= price) {
            // Aquí puedes agregar la lógica para preguntar al jugador si quiere comprar la propiedad
            player.setMoney(player.getMoney() - price);
            property.setOwner(player);
        }
    }

    public void payRent(Player player, Property property) {
        int rent = property.getRent();
        Player owner = property.getOwner();

        if (player.getMoney() >= rent) {
            player.setMoney(player.getMoney() - rent);
            owner.setMoney(owner.getMoney() + rent);
        } else {
            // Manejar el caso donde el jugador no puede pagar el alquiler (por ejemplo, bancarrota)
            player.setMoney(0);
            // Lógica adicional para manejar la bancarrota (por ejemplo, eliminar al jugador del juego) puede ser agregada aquí
        }
    }

    public void rollDiceAndMove() {
        Player currentPlayer = getCurrentPlayer();
        int diceRoll = (int) (Math.random() * 6) + 1;
        movePlayer(currentPlayer, diceRoll);
    }
}