package g58206.chess.main;

import g58206.chess.controller.Controller;
import g58206.chess.model.Game;
import g58206.chess.model.Model;
import g58206.chess.view.TextView;

/**
 * This class creates a game and launch it
 *
 * @author macie
 */
public class Main {

    /**
     * Creates a game and launches it
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Model game = new Game();
        Controller controller = new Controller(game, new TextView(game));
        controller.play();
    }
}
