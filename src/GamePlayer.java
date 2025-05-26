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

// create a record that will have a playerSign private final field
public record GamePlayer(char playerSign) implements Player {
    @Override
    public void makeMove(JButton chosenCell) {
        chosenCell.setText(String.valueOf(this.playerSign));
        chosenCell.setEnabled(false); // Optional: prevent clicking again
    }
}
