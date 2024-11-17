package g58206.chess.model.Piece;

import g58206.chess.model.Board;
import g58206.chess.model.Color;
import g58206.chess.model.Direction;
import g58206.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the methods to handle the Queen piece
 */
public class Queen extends Piece {

    /**
     * Creates a queen 
     * 
     * @param color the color of the piece
     */
    public Queen(Color color) {
        super(color);
    }

    /**
     * Returns the possible moves for the queen
     * 
     * @param pos the position of the piece
     * @param board the board
     * @return a list of possible moves
     */
    @Override
    public List<Position> getPossibleMoves(Position pos, Board board) {
        List<Position> listPos = new ArrayList<>();
        listPos.addAll(this.linearMoves(pos, board));
        //listPos.addAll(this.diagonalMoves(pos, board));
        return listPos;
    }

}
