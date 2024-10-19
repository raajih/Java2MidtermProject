//Midterm Project
//Raajih Roland
//10/17/2024

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  

public class CaveDiver extends JFrame {
    
    /**
     * Constructor that creates border layout with title, grid, buttons, and text field.
     */
    public CaveDiver() 
    {
        //Sets title, size, and layout.
        setTitle("Cave Diver");
        setSize(600, 600);
        setLayout(new BorderLayout());

        //Top label.
        JLabel titleLabel = new JLabel("Diver begins in top left corner and ends in the bottom right corner.", SwingConstants.CENTER);
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

                    // Reset escape routes before attempting to find a new one
                    caveGrid.resetEscapeRoutes();


                    // Call method to start escape route calculation
                    boolean escapeFound = caveGrid.findEscapeRoute(0, 0, 20, diverDepth); // Start at (0,0) with 20 air remaining

                    // Check if an escape route was found
                    if (!escapeFound) 
                    {
                        JOptionPane.showMessageDialog(CaveDiver.this, "No escape route available.");
                    } 
                    

                    // Repaint the cave grid to show the escape route
                    caveGrid.repaint();
                }
            }
        });
        
        //When new cave button is pressed.
        newCaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caveGrid.generateRandomCave(); // Regenerate the cave grid
                
            }
        });
               
        //End of action listeners. ================================
         
    }

    public static void main(String[] args) 
    {
        new CaveDiver();

    }
}