package src;

public class App {
    public static void main(String[] args) {
        GameGUI XO_GUI = new GameGUI();
        // show the GUI to the user by making the window visible
        XO_GUI.setVisible(true);
        // Inject the GUI instance into GameLogic
        GameLogic.init(XO_GUI);
        // Start the logic of the game to make it interactive
        GameLogic.start();
    }
}
