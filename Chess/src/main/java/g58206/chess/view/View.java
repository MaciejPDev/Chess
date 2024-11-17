package g58206.chess.view;

import g58206.chess.model.Position;

public interface View {

    /**
     * Displays the Title and a "welcome" message
     */
    public void displayTitle();

    /**
     * Displays the board
     */
    public void displayBoard();

    /**
     * Displays the winning Player
     */
    public void displayWinner();

    /**
     * Displays a message to inform which Player has to play
     */
    public void displayPlayer();

    /**
     * Asks the Player to enter a valid position on the board
     *
     * @return the entered position
     */
    public Position askPosition();

    /**
     * Displays the given error message
     *
     * @param message a string
     */
    public void displayError(String message);

    /**
     * Displays a message to say that the current player is in a Check position
     */
    public void displayCheck();

    /**
     * Displays a message to say that there is a player is in a check mate
     * position
     */
    public void displayMat();

    /**
     * Displays a message to say that the state of the is game is stale mate and
     * informs the players that the game is a draw
     */
    public void displayStaleMate();
}
