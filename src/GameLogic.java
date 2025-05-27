package src;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

// make this class final. It won't be subclassed (no other class can extend it) cuz we want it to be a utility class.
public final class GameLogic {
    private static final List<JButton> cells = new ArrayList<>();
    private static final GamePlayer playerX = new GamePlayer(PlayerSign.X.getSign());
    private static final GamePlayer playerO = new GamePlayer(PlayerSign.O.getSign());
    /* use a final container (box) and store the mutable current player inside it, to give it to lambda.
    Because lambda expects a final attribute (variable) or an effectively final attribute (variable) */
    private static final AtomicReference<GamePlayer> currentPlayerContainer = new AtomicReference<>(playerX);
    private static GameGUI guiRef;

    // Prevent anyone from instantiating this class
    private GameLogic() {}

    public static void init(GameGUI gui) {
        guiRef = gui;
    }

    public static void start() {
        listenToClicks();
    }

    public static List<JButton> cells() {
        return cells;
    }

    public static void addCell(JButton cell) {
        cells.add(cell);
    }

    private static void listenToClicks() {
        // Java 8+ (using method channing and .forEach)
        cells.forEach(cell -> {
            cell.addActionListener(e -> {
                // pull out the current player from the container
                GamePlayer currentPlayer = currentPlayerContainer.get();
                currentPlayer.makeMove(cell);
                // use ternary operator to switch users
                currentPlayerContainer.set((currentPlayer.playerSign() == 'X') ? playerO : playerX);
                // change the hint message according to the turn
                if (currentPlayer.playerSign() == 'X') {
                    guiRef.updateHint("O's turn");
                } else {
                    guiRef.updateHint("X's turn");
                }
            });
        });
    }
}
