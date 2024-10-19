//Midterm Project
//Raajih Roland
//10/19/2024

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class CaveCell {
    //Attributes.
    private int row, col, depth; //Row, column, and depth attribute of cave cell.
    private boolean isPartOfEscapeRoute; //Holds true if cell is part of escape route, false if not.


    /**
     * 
     * @param row Holds the row number of the cell to be initialized.
     * @param col Holds the column number of the cell to be initialized.
     * @param depth Holds the depth of the cell to be initialized.
     * Initializes isPartOfEscapeRoute to be false.
     */
    public CaveCell(int row, int col, int depth)
    {
        this.row = row;
        this.col = col;
        this.depth = depth;
        this.isPartOfEscapeRoute = false;
    }

    /**
     * Getter for row.
     * @return the row of current cell.
     */
    public int getRow ()
    {
        return row;
    }

    /**
     * Getter for col.
     * @return the column of current cell.
     */
    public int getCol()
    {
        return col;
    }

    /**
     * Getter for depth.
     * @return the depth of current cell.
     */
    public int getDepth()
    {
        return depth;
    }

    /**
     * Getter for isPartOfEscapeRoute.
     * @return true if cell is part of escape route, false if not.
     */
    public boolean getIsPartOfEscapeRoute()
    {
        return isPartOfEscapeRoute;
    }

    /**
     * Setter for isPartOfEscapeRoute.
     * @param isPartOfEscapeRoute True if cell is part of escape route, false if not.
     */
    public void setIsPartOfEscapeRoute(boolean isPartOfEscapeRoute)
    {
        this.isPartOfEscapeRoute = isPartOfEscapeRoute;
    }
}

//Creates grid of CaveCell objects.
class CaveGrid extends JComponent {
    private final int GRID_SIZE = 10;
    private final int CELL_SIZE = 50;
    private CaveCell[][] cave;

    public CaveGrid() {
        cave = new CaveCell[GRID_SIZE][GRID_SIZE];
        setPreferredSize(new Dimension(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE)); // Set preferred size
        generateRandomCave();
    }

    public void generateRandomCave() {
        Random random = new Random();
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                int depth = random.nextInt(10) + 1; // Depth from 1 to 10.
                cave[row][col] = new CaveCell(row, col, depth);
            }
        }
        repaint(); // Redraw the grid after generating
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Calculate offsets to center the grid
        int totalGridSize = GRID_SIZE * CELL_SIZE;
        int xOffset = (getWidth() - totalGridSize) / 2;
        int yOffset = (getHeight() - totalGridSize) / 2;


        //For loops to create all CaveCells.
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                CaveCell cell = cave[row][col];
                int depth = cell.getDepth();
                int colorValue = 255 - (depth * 25); // Deeper cells are darker blue
                Color color = new Color(0, 0, colorValue); 
                g.setColor(color);
                g.fillRect(xOffset + col * CELL_SIZE, yOffset + row * CELL_SIZE, CELL_SIZE, CELL_SIZE);

                // Draw depth in white at the top-left of the cell
                g.setColor(Color.WHITE);
                g.drawString(String.valueOf(depth), xOffset +  col * CELL_SIZE + 5, yOffset + row * CELL_SIZE + 15);
            }
        }
    }
}
