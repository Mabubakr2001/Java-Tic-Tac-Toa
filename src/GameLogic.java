package src;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

// make this class final. It won't be subclassed (no other class can extend it) cuz we want it to be a utility class.
public final class GameLogic {
    private static final List<JButton> cells = new ArrayList<>();
    private static final List<List<Integer>> WINNING_PATTERNS = List.of(
            List.of(0, 1, 2),
            List.of(2, 5, 8),
            List.of(6, 7, 8),
            List.of(0, 3, 6),
            List.of(3, 4, 5),
            List.of(0, 4, 8),
            List.of(2, 4, 6),
            List.of(1, 4, 7)
    );
    private static final GamePlayer playerX = new GamePlayer(PlayerSign.X.getSign(), new ArrayList<>());
    private static final GamePlayer playerO = new GamePlayer(PlayerSign.O.getSign(), new ArrayList<>());
    /* use a final container (box) and store the mutable current player inside it, to give it to lambda.
    Because lambda expects a final attribute (variable) or an effectively final attribute (variable) */
    private static final AtomicReference<GamePlayer> currentPlayerContainer = new AtomicReference<>(playerX);
    // keep a reference for the view, to make the GUI updates itself when the user applying the logic
    private static GameGUI guiRef;

    // Prevent anyone from instantiating this class
    private GameLogic() {}

    public static void initialize(GameGUI gui) {
        // this will inject the GameGUI instance that the GameLogic can manipulate it
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
                switchTurns();
            });
        });
    }

    private static void switchTurns() {
        GamePlayer currentPlayer = currentPlayerContainer.get();
        // use ternary operator to switch users
        currentPlayerContainer.set((currentPlayer.playerSign() == 'X') ? playerO : playerX);
        if (currentPlayer.playerSign() == 'X') {
            guiRef.updateHint("O's turn");
        } else {
            guiRef.updateHint("X's turn");
        }
    }

    private static void checkWinner(ArrayList<Integer> currentPlayerMoves) {
        if (currentPlayerMoves.size() >= 3) {
            for (List<Integer> currentPattern : WINNING_PATTERNS) {
                if (currentPlayerMoves.containsAll(currentPattern)) {
                    if (currentPlayerContainer.get().playerSign() == 'X') {
                        guiRef.updateHint("Player X wins!");
                    } else {
                        guiRef.updateHint("Player O wins!");
                    }
                    return;
                }
            }
        }
        switchTurns();
    }
}
