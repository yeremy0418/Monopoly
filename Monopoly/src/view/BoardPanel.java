package view;

import model.Board;
import model.Property;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BoardPanel extends JPanel {
    private Board board;

    public BoardPanel(Board board) {
        this.board = board;
        initialize();
    }

    private void initialize() {
        setLayout(new GridLayout(10, 10)); // Configurar el layout como 10x10

        List<Property> properties = board.getProperties();
        int propertyIndex = 0;
        int totalCells = 100;

        for (int i = 0; i < totalCells; i++) {
            if (isBorderCell(i)) {
                if (propertyIndex < properties.size()) {
                    add(createPropertyPanel(properties.get(propertyIndex)));
                    propertyIndex++;
                } else {
                    add(new JLabel(""));
                }
            } else {
                add(new JLabel("")); // Espacios vacíos en el centro
            }
        }
    }

    private boolean isBorderCell(int index) {
        int row = index / 10;
        int col = index % 10;
        return row == 0 || row == 9 || col == 0 || col == 9;
    }

    private JPanel createPropertyPanel(Property property) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(new JLabel(property.getName()));
        return panel;
    }
}