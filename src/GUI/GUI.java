package GUI;

import javax.swing.*;
import java.awt.*;

import Stock.Store;

public class GUI implements Runnable {

    static Store store;

    @Override
    public void run() {
        JFrame frame = new JFrame(store.getName());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Hello, world!"));
        frame.add(new JButton("Press me!"));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        store = Store.getInstance();
        GUI gui = new GUI();
        SwingUtilities.invokeLater(gui);
    }

}