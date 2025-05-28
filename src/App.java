package src;

public class App {
    public static void main(String[] args) {
        GameGUI XO_GUI = new GameGUI();
        // show the GUI to the user by making the window visible
        XO_GUI.setVisible(true);
        // Pass the View (GUI) to the Model (logic)
        GameLogic.initialize(XO_GUI);
        // Start the logic of the game to make it interactive
        GameLogic.start();
    }
}
