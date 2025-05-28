package bcc.swinggame;

import javax.swing.*;
import java.awt.event.*;

public class HelloWorldExample {
    private int x = 0;
    private int y = 100;
    private final int SPEED = 5;

    public HelloWorldExample() {
        JFrame frame = new JFrame("Catch the Button!");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 

        JButton button = new JButton("Click Me!");
        button.setBounds(x, y, 100, 30); // Position the button
        frame.add(button);

        // Make sure the frame is visible AFTER components are added
        frame.setVisible(true);

        // Create the Timer after the frame is visible
        Timer timer = new Timer(30, null);

        // Add ActionListener to the Timer to move the button
        timer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                x += SPEED;
                button.setBounds(x, y, 100, 30); // Move the button
                if (x > frame.getWidth() - 100) {
                    timer.stop();
                    button.setText("Game Over");
                }
            }
        });

        // Add ActionListener to the button for win condition
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                button.setText("You Win!");
            }
        });

        timer.start(); // Start the timer
    }
}