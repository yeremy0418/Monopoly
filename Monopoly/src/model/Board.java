package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Property> properties;

    public Board() {
        properties = new ArrayList<>();
        initializeProperties();
    }

    private void initializeProperties() {
        properties.add(new Property("Mediterranean Avenue", 60, 2));
        properties.add(new Property("Baltic Avenue", 60, 4));
        properties.add(new Property("Oriental Avenue", 100, 6));
        properties.add(new Property("Vermont Avenue", 100, 6));
        properties.add(new Property("Connecticut Avenue", 120, 8));
        properties.add(new Property("St. Charles Place", 140, 10));
        properties.add(new Property("States Avenue", 140, 10));
        properties.add(new Property("Virginia Avenue", 160, 12));
        properties.add(new Property("St. James Place", 180, 14));
        properties.add(new Property("Tennessee Avenue", 180, 14));
        properties.add(new Property("New York Avenue", 200, 16));
        properties.add(new Property("Kentucky Avenue", 220, 18));
        properties.add(new Property("Indiana Avenue", 220, 18));
        properties.add(new Property("Illinois Avenue", 240, 20));
        properties.add(new Property("Atlantic Avenue", 260, 22));
        properties.add(new Property("Ventnor Avenue", 260, 22));
        properties.add(new Property("Marvin Gardens", 280, 24));
        properties.add(new Property("Pacific Avenue", 300, 26));
        properties.add(new Property("North Carolina Avenue", 300, 26));
        properties.add(new Property("Pennsylvania Avenue", 320, 28));
        properties.add(new Property("Park Place", 350, 35));
        properties.add(new Property("Boardwalk", 400, 50));
        // Agrega más propiedades según sea necesario
    }

    public List<Property> getProperties() {
        return properties;
    }

    public Property getProperty(int position) {
        if (position >= 0 && position < properties.size()) {
            return properties.get(position);
        }
        return null;
    }
}