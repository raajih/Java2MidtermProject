//Midterm Project
//Raajih Roland
//10/17/2024

import javax.swing.*;
import java.awt.*;

public class CaveDiver extends JFrame {
    
    public CaveDiver() 
    {
        //Sets title, size, and layout
        setTitle("Cave Diver");
        setSize(600, 600);
        setLayout(new BorderLayout());

        //Top label
        JLabel titleLabel = new JLabel("Underwater Cave", SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);//Places title label at the top

        //PLACEHOLDER WILL BE CHANGED====================================
        JPanel placeholder = new JPanel();
        placeholder.setBackground(Color.LIGHT_GRAY);
        add(placeholder, BorderLayout.CENTER);
        //=================================================================
        // Bottom panel with buttons and text field
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        JLabel depthLabel = new JLabel("Set Diver Depth: ");
        JTextField depthField = new JTextField(5);
        JButton escapeButton = new JButton("Escape");
        JButton newCaveButton = new JButton("New Cave");

        bottomPanel.add(depthLabel);
        bottomPanel.add(depthField);
        bottomPanel.add(escapeButton);
        bottomPanel.add(newCaveButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

    public static void main(String[] args) 
    {
        new CaveDiver();

    }
}