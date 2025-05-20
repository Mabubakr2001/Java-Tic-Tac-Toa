package src;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GameGUI extends JFrame {
    public GameGUI() {
        // inherit the title field.
        super("Tic-Tac-Toa Game");
        // set the size of the window when calling the constructor
        this.setSize(560, 560);
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
        // add the components to the GUI
        this.addComponents();
    }

    private void addComponents() {
        this.createLabel();
    }

    private void createLabel() {
        // Create a JLabel component to display the "Tic-Tac-Toa" title on the window
        JLabel title = new JLabel("Tic-Tac-Toa");
        // set the font of the title label to make it bold and readable with a larger size
        title.setFont(new Font("Dialog", Font.BOLD, 30));
        // Align the label text horizontally to the center within its container
        title.setHorizontalAlignment(SwingConstants.CENTER);
        // set the boundaries of the component to position it correctly within its container (GUI window)
        title.setBounds(0, 10, 540, 39);
        // add the label component
        this.add(title);
    }

    private void createBoard() {

    }
}
