package src;

import javax.swing.*;
import java.util.ArrayList;

public record GamePlayer(char playerSign, ArrayList<Integer> moves) implements Player {
    @Override
    public void makeMove(JButton chosenCell) {
        chosenCell.setText(String.valueOf(this.playerSign));
        chosenCell.setEnabled(false);
    }
}
