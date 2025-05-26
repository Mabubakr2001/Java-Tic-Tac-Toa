package src;

public class App {
    public static void main(String[] args) {
        GameGUI XO_GUI = new GameGUI();
        // show the GUI to the user by making the window visible
        XO_GUI.setVisible(true);
        // Start the game logic to make the game interactive
        GameLogic.start();
    }
}
