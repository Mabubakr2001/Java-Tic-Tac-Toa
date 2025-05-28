package src;

//public final class GamePlayer implements Player{
//    private final char playerSign;
//
//    public GamePlayer(char playerSign) {
//        this.playerSign = playerSign;
//    }
//
//    public char playerSign() {
//        return this.playerSign;
//    }
//
//    @Override
//    public void makeMove(char playerSign) {
//        System.out.println(playerSign + " is making a move!");
//    }
//}

import javax.swing.*;
import java.util.ArrayList;

// create a record that will have a playerSign private final field
public record GamePlayer(char playerSign, ArrayList<Integer> moves) implements Player {
    @Override
    public void makeMove(JButton chosenCell) {
        chosenCell.setText(String.valueOf(this.playerSign));
        chosenCell.setEnabled(false); // Optional: prevent clicking again
    }
}
