package g58206.chess.controller;

import g58206.chess.model.GameState;
import g58206.chess.model.Model;
import g58206.chess.model.Position;
import g58206.chess.view.View;

/**
 * It's the controller of the game. Thanks to him, the View and the Model are
 * linked
 *
 * @author macie
 */
public class Controller {

    private final Model model;
    private final View view;

    /**
     * Creates the Controller
     *
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Launches the game and it displays the board. Then it asks the player to
     * move a piece and depending of the game's state, it will show an adequate
     * message. It will do this until the end of the game
     */
    public void play() {
        boolean gameIsOver = false;
        view.displayTitle();
        model.start();
        while (!gameIsOver) {
            view.displayBoard();
            view.displayPlayer();
            Position oldPos = view.askPosition();
            Position newPos = view.askPosition();
            model.movePiecePosition(oldPos, newPos);
            if (model.getGameState() == GameState.CHECK) {
                view.displayCheck();
            }
            gameIsOver = model.isGameOver();
        }
        if (model.getGameState() == GameState.CHECK_MATE) {
            view.displayMat();
            view.displayWinner();
        }
        if (model.getGameState() == GameState.STALE_MATE) {
            view.displayStaleMate();
        }
    }
}
