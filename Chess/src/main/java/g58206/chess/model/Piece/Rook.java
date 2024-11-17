package g58206.chess.model.Piece;

import g58206.chess.model.Board;
import g58206.chess.model.Color;
import g58206.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the methods to handle the Rook piece
 */
public class Rook extends Piece {
    
    /**
     * Creates a rook 
     * 
     * @param color the color of the piece
     */
    public Rook(Color color){
        super(color);
    }

    /**
     * Returns the possible moves for the rook
     * 
     * @param pos the position of the piece
     * @param board the board
     * @return a list of possible moves
     */
    @Override
    public List<Position> getPossibleMoves(Position pos, Board board) {
        List<Position> listPos = new ArrayList<>();
        listPos.addAll(this.linearMoves(pos, board));
        return listPos;
    }

}
