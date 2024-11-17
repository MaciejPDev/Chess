package g58206.chess.model;

import g58206.chess.model.Piece.Bishop;
import g58206.chess.model.Piece.King;
import g58206.chess.model.Piece.Knight;
import g58206.chess.model.Piece.Pawn;
import g58206.chess.model.Piece.Piece;
import g58206.chess.model.Piece.Queen;
import g58206.chess.model.Piece.Rook;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements ths Model interface
 *
 * @author macie
 */
public class Game implements Model {

    private final Board board;
    private final Player white;
    private final Player black;
    private Player currentPlayer;
    private King whiteKing;
    private King blackKing;
    private GameState state;

    public Game() {
        this.board = new Board();
        this.white = new Player(Color.WHITE);
        this.black = new Player(Color.BLACK);
    }

    /**
     * Getter of the game's state
     *
     * @return the game's state
     */
    @Override
    public GameState getGameState() {
        return state;
    }

    /**
     * Start the game: create the pieces and put them on the board, initialize
     * the current player to 'WHITE'.
     */
    @Override
    public void start() {
        this.currentPlayer = white;
        this.whiteKing = new King(Color.WHITE);
        this.blackKing = new King(Color.BLACK);
        this.state = GameState.PLAY;
        for (int i = 0; i < 8; i++) {
            board.setPiece(new Pawn(Color.WHITE), new Position(board.getInitialPawnRow(Color.WHITE), i));
            board.setPiece(new Pawn(Color.BLACK), new Position(board.getInitialPawnRow(Color.BLACK), i));
        }
        board.setPiece(new Rook(Color.WHITE), new Position(0, 0));
        board.setPiece(new Rook(Color.WHITE), new Position(0, 7));
        board.setPiece(new Rook(Color.BLACK), new Position(7, 0));
        board.setPiece(new Rook(Color.BLACK), new Position(7, 7));

        board.setPiece(new Knight(Color.WHITE), new Position(0, 1));
        board.setPiece(new Knight(Color.WHITE), new Position(0, 6));
        board.setPiece(new Knight(Color.BLACK), new Position(7, 1));
        board.setPiece(new Knight(Color.BLACK), new Position(7, 6));

        board.setPiece(new Bishop(Color.WHITE), new Position(0, 2));
        board.setPiece(new Bishop(Color.WHITE), new Position(0, 5));
        board.setPiece(new Bishop(Color.BLACK), new Position(7, 2));
        board.setPiece(new Bishop(Color.BLACK), new Position(7, 5));

        board.setPiece(new Queen(Color.WHITE), new Position(0, 3));
        board.setPiece(new Queen(Color.BLACK), new Position(7, 3));

        board.setPiece(whiteKing, new Position(0, 4));
        board.setPiece(blackKing, new Position(7, 4));
    }

    /**
     * Get the piece of the board located on a given position
     *
     * @param pos the position
     * @return the piece located at P
     * @throws IllegalArgumentException pos is not located on the board.
     */
    @Override
    public Piece getPiece(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException(pos + "pas sur le plateau");
        }
        return board.getPiece(pos);
    }

    /**
     * Getter for the current player.
     *
     * @return the current player.
     */
    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Getter for the second player.
     *
     * @return the player that is waiting
     */
    @Override
    public Player getOppositePlayer() {
        return new Player(this.currentPlayer.getColorPlayer().opposite());
    }

    /**
     * Check if the square at the given position is occupied by a piece of the
     * current player.
     *
     * @param pos the postion
     * @return true if the position is occupied by a piece of the current
     * player, false otherwise.
     * @throws IllegalArgumentException if the position is not located on the
     * board.
     */
    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException(pos + "pas sur le plateau");
        }
        return board.getPiece(pos).getColor() == currentPlayer.getColorPlayer();
    }

    /**
     * Moves a piece from one position of the chess board to another one if the
     * move is valid. If the game is not over, change the current player.
     * Depends on the situation, it will change the state of the game.
     *
     * @param oldPos the current position
     * @param newPos the new position of the board where to put the piece
     * @throws IllegalArgumentException if 1) oldPos or newPos are not located
     * on the board 2) oldPos does not contain a piece 3) the piece does not
     * belong to the current player 4) the move is not valid for the piece
     * located at position oldPos
     */
    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        try {
            if (!board.contains(oldPos) || !board.contains(newPos)) {
                throw new IllegalArgumentException("l'une des position n'est pas sur le plateau6");
            }
            if (board.isFree(oldPos)) {
                throw new IllegalArgumentException("Cette pièce n'existe pas");
            }
            if (!isCurrentPlayerPosition(oldPos)) {
                throw new IllegalArgumentException(" cette piece ne vous appartien pas");
            }
            if (!board.getPiece(oldPos).getPossibleMoves(oldPos, board).contains(newPos)) {
                throw new IllegalArgumentException("impossible move");
            }
            if (isValidMove(oldPos, newPos)) {
                board.dropPiece(newPos);
                board.setPiece(board.getPiece(oldPos), newPos);
                board.dropPiece(oldPos);
                if (!isGameOver()) {
                    currentPlayer = this.getOppositePlayer();
                }
            }
            if (this.currentPlayer.getColorPlayer() == Color.BLACK) {
                stateChanger(blackKing);
            } else {
                stateChanger(whiteKing);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Change the state of the game
     *
     * @param king the king of the current player
     */
    private void stateChanger(Piece king) {
        if (getCapturePositions(this.getOppositePlayer()).contains(board.getPiecePosition(king))) {
            if (haveValidMove()) {
                state = GameState.CHECK;
            } else {
                state = GameState.CHECK_MATE;
            }
        } else {
            if (haveValidMove()) {
                state = GameState.PLAY;
            } else {
                state = GameState.STALE_MATE;
            }
        }
    }

    /**
     * Check if the game is over or not
     *
     * @return true if the game is over, false otherwise.
     */
    @Override
    public boolean isGameOver() {
        return state == GameState.CHECK_MATE || state == GameState.STALE_MATE;
    }

    /**
     * Checks if the current player has at least one valid move
     *
     * @return true if the player has at least one valid move, false otherwise
     */
    private boolean haveValidMove() {
        for (int i = 0; i < board.getPositionOccupiedBy(this.currentPlayer).size(); i++) {
            for (Position possibleMove : getPossibleMoves(board.getPositionOccupiedBy(this.currentPlayer).get(i))) {
                if (isValidMove(board.getPositionOccupiedBy(this.currentPlayer).get(i), possibleMove)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get the possible moves for the piece located at the specified position.
     *
     * @param position the position of the piece
     * @return the liste of admissible positions.
     */
    @Override
    public List<Position> getPossibleMoves(Position position) {
        return board.getPiece(position).getPossibleMoves(position, board);
    }

    /**
     * Checks if the move from the old position to the new one is valid
     *
     * @param oldPos the old position of the piece
     * @param newPos the new position of the piece
     * @throws IllegalArgumentException if 1) there is no piece on the old
     * position 2) the move is not possible
     * @return true if the move is valid and false if it's not;
     */
    @Override
    public boolean isValidMove(Position oldPos, Position newPos) {
        if (board.isFree(oldPos)) {
            throw new IllegalArgumentException("Cette pièce n'existe pas");
        }
        if (!board.getPiece(oldPos).getPossibleMoves(oldPos, board).contains(newPos)) {
            throw new IllegalArgumentException("Ce mouvement n'est pas possible");
        }
        boolean isValid = true;
        boolean havePiece = false;
        Piece piece = null;
        /**
         * if there is a piece on the new position, we will hold it and then
         * replace it after the simulation
         */
        if (!board.isFree(newPos)) {
            piece = board.getPiece(newPos);
            havePiece = true;
        }
        board.setPiece(board.getPiece(oldPos), newPos);
        board.dropPiece(oldPos);
        if (getCurrentPlayer().getColorPlayer() == Color.WHITE) {
            if (getCapturePositions(getOppositePlayer()).contains(board.getPiecePosition(whiteKing))) {
                isValid = false;
            }
        } else {
            if (getCapturePositions(getOppositePlayer()).contains(board.getPiecePosition(blackKing))) {
                isValid = false;
            }
        }
        board.setPiece(board.getPiece(newPos), oldPos);
        board.dropPiece(newPos);
        if (havePiece) {
            board.setPiece(piece, newPos);
        }
        return isValid;
    }

    /**
     * Gets all the positions on which the given player can capture an
     * opponent's piece
     *
     * @param player the player
     * @return a list of positions
     */
    private List<Position> getCapturePositions(Player player) {
        List<Position> capList = new ArrayList<>();
        List<Position> pieceList = board.getPositionOccupiedBy(player);
        List<Position> allMoves = new ArrayList<>();
        for (int i = 0; i < pieceList.size(); i++) {
            allMoves.addAll(board.getPiece(pieceList.get(i)).getPossibleMoves(pieceList.get(i), board));
        }
        for (int i = 0; i < allMoves.size(); i++) {
            if (!board.isFree(allMoves.get(i)) && board.getPiece(allMoves.get(i)).getColor() != player.getColorPlayer()) {
                capList.add(allMoves.get(i));
            }
        }
        return capList;
    }
}
