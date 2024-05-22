package model;

public class Player {
    private String name;
    private int money;
    private int position;
    // Aquí podrías añadir una lista de propiedades

    public Player(String name, int initialMoney) {
        this.name = name;
        this.money = initialMoney;
        this.position = 0; // Empieza en la posición de "Salida"
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move(int steps) {
        this.position = (this.position + steps) % 40; // Tablero de 40 posiciones
    }
}