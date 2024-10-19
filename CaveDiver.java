//Midterm Project
//Raajih Roland
//10/17/2024

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class CaveDiver extends JFrame {
    
    public CaveDiver() 
    {
        //Sets title, size, and layout.
        setTitle("Cave Diver");
        setSize(600, 600);
        setLayout(new BorderLayout());

        //Top label.
        JLabel titleLabel = new JLabel("Underwater Cave", SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);//Places title label at the top.

        //Sets grid of CaveCells into the center of the layout.
        CaveGrid caveGrid = new CaveGrid();
        add(caveGrid, BorderLayout.CENTER);
        
        // Bottom panel with buttons and text field.
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

        // Set default close operation.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Add action listeners. ==========================================
        escapeButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String depthInput = depthField.getText();

                //If there is no input for depth rating or if it isn't numbers.
                if (depthInput.isEmpty() || !depthInput.matches("\\d+"))
                {
                    JOptionPane.showMessageDialog(CaveDiver.this, "Please enter a valid number for diver depth.");
                }
                else 
                {
                    int diverDepth = Integer.parseInt(depthInput);
                    // Call method to start escape route calculation
                    System.out.println("Escape attempt with diver depth: " + diverDepth);
                }
            }
        });
                
         
    }

    public static void main(String[] args) 
    {
        new CaveDiver();

    }
}