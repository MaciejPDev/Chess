package g58206.chess.model;

import g58206.chess.model.Piece.Piece;
import java.util.ArrayList;
import java.util.List;

/**
 * This class has methods which handle the board
 *
 * @author macie
 */
public class Board {

    private final Square[][] squares;

    private final int INITIAL_POS_WHITE = 1;
    private final int INITIAL_POS_BLACK = 6;

    /**
     * Creates a board which is a 2D Array of Squares and sets the attribut
     * Piece of each square to null
     */
    public Board() {
        this.squares = new Square[8][8];
        for (Square[] plateau1 : squares) {
            for (int j = 0; j < squares.length; j++) {
                plateau1[j] = new Square(null);
            }
        }
    }

    /**
     * Checks if the given position is on the board
     *
     * @param pos a position on the board
     * @return true if the board contains the position, and false otherwise
     */
    public boolean contains(Position pos) {
        return !(pos.getRow() > 7 || pos.getRow() < 0
                || pos.getColumn() > 7 || pos.getColumn() < 0);
    }

    /**
     * Sets a piece on the given postion of the board
     *
     * @param pion a Piece
     * @param pos a case on the board
     */
    public void setPiece(Piece pion, Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException(pos + " pas sur le plateau5");
        }
        squares[pos.getRow()][pos.getColumn()].setPiece(pion);
    }

    /**
     * Gets the piece at the given position
     *
     * @param pos a position on the board
     * @return the piece or null if there is no piece
     */
    public Piece getPiece(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException(pos + " pas sur le plateau4");
        }
        return squares[pos.getRow()][pos.getColumn()].getPiece();
    }

    /**
     * Returns an integer according to the color
     *
     * @param color BLACK or WHITE
     * @return 6 for BLACK or 1 for WHITE
     */
    public int getInitialPawnRow(Color color) {
        if (color == Color.BLACK) {
            return INITIAL_POS_BLACK;
        } else {
            return INITIAL_POS_WHITE;
        }
    }

    /**
     * Sets the attribut Piece of the square at the given position to null
     *
     * @param pos a position on the board
     */
    public void dropPiece(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException(pos + " pas sur le plateau3");
        }
        squares[pos.getRow()][pos.getColumn()].setPiece(null);
    }

    /**
     * Checks if the square at the given position is empty or not
     *
     * @param pos a position on the board
     * @return true if it is empty or false otherwise
     */
    public boolean isFree(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException(pos.getRow() + "," + pos.getColumn() + " pas sur le plateau2");
        }
        return squares[pos.getRow()][pos.getColumn()].isFree();
    }

    /**
     * Checks if the square at the given position contains a piece of the
     * opposite color of the one given in parameter
     *
     * @param pos a position on the board
     * @param color BLACK or WHITE
     * @return true if the color are not the same, false otherwise and false if
     * the square does not contain a piece
     */
    public boolean containsOppositeColor(Position pos, Color color) {
        if (!contains(pos)) {
            throw new IllegalArgumentException(pos + " pas sur le plateau1");
        }
        if (isFree(pos)) {
            return false;
        }
        return !squares[pos.getRow()][pos.getColumn()].getPiece().getColor().equals(color);
    }

    /**
     * Returns a list of positions occupied by the given Player
     *
     * @param player white or black
     * @return a list of positions which contains a Player's piece
     */
    public List<Position> getPositionOccupiedBy(Player player) {
        List<Position> listPos = new ArrayList<>();
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                if (!squares[i][j].isFree()) {
                    if (player.getColorPlayer() == squares[i][j].getPiece().getColor()) {
                        Position pos = new Position(i, j);
                        listPos.add(pos);
                    }
                }
            }
        }
        return listPos;
    }

    /**
     * Returns the position of the given piece
     * 
     * @param piece the piece that we are looking for
     * @return the position of the piece
     */
    public Position getPiecePosition(Piece piece) {
        Position position = null;
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                if (!squares[i][j].isFree() && squares[i][j].getPiece().equals(piece)) {
                    position = new Position(i, j);
                }
            }
        }
        return position;
    }
}
