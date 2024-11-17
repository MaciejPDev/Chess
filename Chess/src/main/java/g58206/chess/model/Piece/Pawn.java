package g58206.chess.model.Piece;

import g58206.chess.model.Board;
import g58206.chess.model.Color;
import g58206.chess.model.Direction;
import g58206.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * This class creates a new Piece which is the pawn and contains the methods to
 * handle it
 *
 */
public class Pawn extends Piece {

    /**
     * Creates a pawn
     * 
     * @param color the color of the piece
     */
    public Pawn(Color color) {
        super(color);
    }

    /**
     * Returns the possible moves for the pawn
     * 
     * @param pos the position of the piece
     * @param board the board
     * @return a list of possible moves
     */
    @Override
    public List<Position> getPossibleMoves(Position pos, Board board) {
        List<Position> listPos = new ArrayList<>();
        Direction dir;
        if (board.contains(pos)) {
            Color col = board.getPiece(pos).getColor();
            if (col == Color.BLACK) {
                dir = Direction.S;
            } else {
                dir = Direction.N;
            }
            //If possible adds the simple move
            if (firstCaseFree(pos, board, dir)) {
                listPos.add(pos.next(dir));
                //If possible adds the double move 
                if (isFirstMove(pos, board) && secondCaseFree(pos, board, dir)) {
                    listPos.add(pos.next(dir).next(dir));
                }
            }
        }
        listPos.addAll(this.getCaptureMoves(pos, board));
        return listPos;
    }

    /**
     * A pawn can capture an another one if this one is placed one case forward
     * and on the left or on the right. This method does it and adds the
     * possibles moves to the list of possibles moves
     *
     * @param pos the position of the pawn
     * @param board the board
     * @return the modified list
     */
    @Override
    public List<Position> getCaptureMoves(Position pos, Board board) {
        List<Position> ListPos = new ArrayList<>();
        if (this.getColor() == Color.BLACK) {
            if (board.contains(pos.next(Direction.SW)) && board.containsOppositeColor(pos.next(Direction.SW), this.getColor())) {
                ListPos.add(pos.next(Direction.SW));
            }
            if (board.contains(pos.next(Direction.SE)) && board.containsOppositeColor(pos.next(Direction.SE), this.getColor())) {
                ListPos.add(pos.next(Direction.SE));
            }
        } else {
            if (board.contains(pos.next(Direction.NW)) && board.containsOppositeColor(pos.next(Direction.NW), this.getColor())) {
                ListPos.add(pos.next(Direction.NW));
            }
            if (board.contains(pos.next(Direction.SE)) && board.containsOppositeColor(pos.next(Direction.NE), this.getColor())) {
                ListPos.add(pos.next(Direction.NE));
            }
        }
        return ListPos;
    }

    /**
     * Checks if the case in front of the pawn is free
     *
     * @param pos the position of the pawn
     * @param board the board
     * @return true if the first case in front is free, and false otherwise
     */
    private boolean firstCaseFree(Position pos, Board board, Direction dir) {
        if (board.contains(pos.next(dir))) {
            return board.isFree(pos.next(dir));
        }
        return false;
    }

    /**
     * Checks if the second case in front of the pawn is free
     *
     * @param pos the position of the pawn
     * @param board the board
     * @return true if the case is free, and false otherwise
     */
    private boolean secondCaseFree(Position pos, Board board, Direction dir) {
        if (board.contains(pos.next(dir).next(dir))) {
            return board.isFree(pos.next(dir).next(dir));
        }
        return false;
    }

    /**
     * Checks if the move is the first of the Piece
     *
     * @param pos the position of the pawn
     * @param board the board
     * @return true if the the row (position) of the piece equals the initial
     * row of a piece of a color, and false otherwise
     */
    private boolean isFirstMove(Position pos, Board board) {
        return pos.getRow() == board.getInitialPawnRow(this.getColor());
    }
}
