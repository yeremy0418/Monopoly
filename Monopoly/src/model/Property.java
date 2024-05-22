package model;

public class Property {
    private String name;
    private int price;
    private int rent;
    private Player owner;

    public Property(String name, int price, int rent) {
        this.name = name;
        this.price = price;
        this.rent = rent;
        this.owner = null;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rent=" + rent +
                ", owner=" + (owner != null ? owner.getName() : "None") +
                '}';
    }
}