package src;
import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame {
    public GameGUI() {
        // inherit the title field.
        super("Tic-Tac-Toa Game");
        // set the size of the window when calling the constructor
        this.setSize(495, 650);
        // make the window non-resizable when calling the constructor
        this.setResizable(false);
        /* Set the layout manager of the container (window) to null to have full control over the
        child components' positioning and sizing */
        this.setLayout(null);
        // set the default close operation when the user exits the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        /* set the position of the window relative to null to center it on the screen,
        regardless of any other component. */
        this.setLocationRelativeTo(null);
        // add the components to the GUI window
        this.addComponents();
    }

    private void addComponents() {
        this.addLabel();
        this.addBoard();
    }

    private void addLabel() {
        // Create a JLabel component to display the "Tic-Tac-Toa" title on the window
        JLabel title = new JLabel("Tic-Tac-Toa");
        // set the font of the title label to make it bold and readable with a larger size
        title.setFont(new Font("Dialog", Font.BOLD, 30));
        // Align the label text horizontally to the center within its container
        title.setHorizontalAlignment(SwingConstants.CENTER);
        // set the boundaries of the component to position it correctly within its container (GUI window)
        title.setBounds(0, 10, 495, 39);
        // add the label component
        this.add(title);
    }

    private void addBoard() {
        int cellsNum = 9;
        int rowCells = 3;
        int i = 0;
        int j = 0;
        int cellWidth = 165;
        int cellHeight = 140;
        int xAxis = 0;
        int yAxis = 60;
        while (i < cellsNum) {
            if (j == rowCells) {
                j = 0;
                yAxis = yAxis + cellHeight;
                xAxis = 0;
            }
            // Create the button component
            JButton button = new JButton();
            // Set position and size (x, y, width, height)
            button.setBounds(xAxis, yAxis, cellWidth, cellHeight);
            // Make future X/O look big
            button.setFont(new Font("Dialog", Font.BOLD, 32));
            // Remove focus border
            button.setFocusPainted(false);
            // make the background transparent
            button.setContentAreaFilled(false);
            // make a black border around the cell
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Black border
            // add the button component to the GUI window
            this.add(button);
            xAxis = xAxis + cellWidth;
            i++;
            j++;
        }
    }
}
