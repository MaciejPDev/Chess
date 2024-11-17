package g58206.chess.model.Piece;

import g58206.chess.model.Board;
import g58206.chess.model.Color;
import g58206.chess.model.Direction;
import g58206.chess.model.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class contains methods to handle the piece
 *
 * @author macie
 */
public abstract class Piece {

    private final Color color;

    /**
     * Creates an object Piece
     *
     * @param couleur color of the piece
     */
    public Piece(Color couleur) {
        this.color = couleur;
    }

    /**
     * Gets the attribut color
     *
     * @return the color of the piece
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns a list of possible moves for the piece which is on the given
     * position
     *
     * @param pos a position on the board
     * @param board the board
     * @return a list of positions on which the piece can be moved
     */
    public abstract List<Position> getPossibleMoves(Position pos, Board board);

    /**
     * Returns a list of possible moves
     *
     * @param pos a position on the board
     * @param board the board
     * @return the list of possible moves which contains also the capturing
     * moves
     */
    public List<Position> getCaptureMoves(Position pos, Board board) {
        return this.getPossibleMoves(pos, board);
    }

    /**
     * Returns the horizontal and vertical possible moves
     * 
     * @param pos the initial position of the piece
     * @param board the board
     * @return a list of positions
     */
    protected List<Position> linearMoves(Position pos, Board board) {
        List<Position> listPos = new ArrayList<>();
        listPos = this.moves(pos, board, Direction.N, listPos);
        listPos = this.moves(pos, board, Direction.S, listPos);
        listPos = this.moves(pos, board, Direction.W, listPos);
        listPos = this.moves(pos, board, Direction.E, listPos);
        return listPos;
    }

    /**
     * Returns the diagonal possible moves
     * 
     * @param pos the initial position of the piece
     * @param board the board
     * @return a list of positions
     */
    protected List<Position> diagonalMoves(Position pos, Board board) {
        List<Position> listPos = new ArrayList<>();
        listPos = this.moves(pos, board, Direction.NW, listPos);
        listPos = this.moves(pos, board, Direction.SW, listPos);
        listPos = this.moves(pos, board, Direction.NE, listPos);
        listPos = this.moves(pos, board, Direction.SE, listPos);
        return listPos;
    }

    /**
     * Returns all the possible moves in one direction
     * 
     * @param pos the position of the piece
     * @param board the board
     * @param dir the direction in which it will check the possible moves
     * @param listPos the list of positions
     * @return 
     */
    private List<Position> moves(Position pos, Board board, Direction dir, List<Position> listPos) {
        Position posNext = pos.next(dir);
        while (board.contains(posNext) && board.isFree(posNext)) {
            listPos.add(posNext);
            posNext = posNext.next(dir);
        }
        if (board.contains(posNext) && board.containsOppositeColor(posNext, this.getColor())) {
            listPos.add(posNext);
        }
        return listPos;
    }

    //////////////////////////////////EQUALS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piece other = (Piece) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }
}
