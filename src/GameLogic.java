package src;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
    private static final AtomicReference<GamePlayer> currentPlayerContainer = new AtomicReference<>(playerX);
    private static GameGUI guiRef;

    private GameLogic() {}

    public static void initialize(GameGUI gui) {
        guiRef = gui;
    }

    public static void start() {
        listenToClicks();
    }

    public static void addCell(JButton cell) {
        cells.add(cell);
    }

    private static void listenToClicks() {
        cells.forEach(cell -> {
            cell.addActionListener(e -> {
                GamePlayer currentPlayer = currentPlayerContainer.get();
                currentPlayer.makeMove(cell);
                int index = (int) ((JButton) e.getSource()).getClientProperty("index");
                currentPlayer.moves().add(index);
                checkWinner(currentPlayer.moves());
            });
        });
        guiRef.resetBtn().addActionListener(e -> resetGame());
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
                    cells.forEach(cell -> {
                        if (cell.isEnabled()) {
                            cell.setEnabled(false);
                        }
                    });
                    return;
                }
            }
        }
        switchTurns();
    }

    private static void switchTurns() {
        GamePlayer currentPlayer = currentPlayerContainer.get();
        currentPlayerContainer.set((currentPlayer.playerSign() == 'X') ? playerO : playerX);
        if (currentPlayer.playerSign() == 'X') {
            guiRef.updateHint("O's turn");
        } else {
            guiRef.updateHint("X's turn");
        }
    }

    private static void resetGame() {
        cells.forEach(cell -> {
            cell.setText("");
            cell.setEnabled(true);
        });
        playerX.moves().clear();
        playerO.moves().clear();
        currentPlayerContainer.set(playerX);
        guiRef.updateHint("X's turn");
    }
}
