package src;

public class App {
    public static void main(String[] args) {
        GameGUI XO_GUI = new GameGUI();
        XO_GUI.setVisible(true);
        GameLogic.initialize(XO_GUI);
        GameLogic.start();
    }
}
