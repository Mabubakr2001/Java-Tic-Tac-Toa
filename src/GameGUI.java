package src;
import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame {
    private JLabel hintMessage;
    private JButton resetBtn;

    public GameGUI() {
        super("X/O Game");
        this.setSize(495, 650);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addComponents();
    }

    private void addComponents() {
        this.addLabel();
        this.addBoard();
        this.addHint();
        this.addResetBtn();
    }

    private void addLabel() {
        JLabel title = new JLabel("X / O");
        title.setFont(new Font("Dialog", Font.BOLD, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(0, 10, 495, 39);
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
            JButton button = new JButton();
            button.setBounds(xAxis, yAxis, cellWidth, cellHeight);
            button.setFont(new Font("Dialog", Font.BOLD, 80));
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button.putClientProperty("index", i);
            this.add(button);
            GameLogic.addCell(button);
            xAxis = xAxis + cellWidth;
            i++;
            j++;
        }
    }

    private void addHint() {
        this.hintMessage = new JLabel("X's turn");
        this.hintMessage.setFont(new Font("Dialog", Font.BOLD, 30));
        this.hintMessage.setHorizontalAlignment(SwingConstants.CENTER);
        this.hintMessage.setBounds(0, 495, 495, 39);
        this.add(hintMessage);
    }

    public void updateHint(String newHint) {
        this.hintMessage.setText(newHint);
    }

    private void addResetBtn() {
        this.resetBtn = new JButton("Reset Game");
        this.resetBtn.setFont(new Font("Dialog", Font.BOLD, 18));
        this.resetBtn.setContentAreaFilled(false);
        this.resetBtn.setBounds(167, 545, 160, 42);
        this.resetBtn.setFocusPainted(false);
        this.add(resetBtn);
    }

    public JButton resetBtn() {
        return this.resetBtn;
    }
}
