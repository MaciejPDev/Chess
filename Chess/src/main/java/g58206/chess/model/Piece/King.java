package g58206.chess.model.Piece;

import g58206.chess.model.Board;
import g58206.chess.model.Color;
import g58206.chess.model.Direction;
import g58206.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the methods to handle the King piece
 */
public class King extends Piece {

    /**
     * Creates a king
     * 
     * @param color the color of the piece
     */
    public King(Color color) {
        super(color);
    }

    /**
     * Returns the possible moves for the king
     * 
     * @param pos the position of the piece
     * @param board the board
     * @return a list of possible moves
     */
    @Override
    public List<Position> getPossibleMoves(Position pos, Board board) {
        List<Position> listPos = new ArrayList<>();
        List<Position> posPossible = List.of(
                pos.next(Direction.N),
                pos.next(Direction.NW),
                pos.next(Direction.NE),
                pos.next(Direction.W),
                pos.next(Direction.E),
                pos.next(Direction.S),
                pos.next(Direction.SW),
                pos.next(Direction.SE)
        );
        for (int i = 0; i < posPossible.size(); i++) {
            if (board.contains(posPossible.get(i))) {
                if (board.isFree(posPossible.get(i)) || board.containsOppositeColor(posPossible.get(i), this.getColor())) {
                    listPos.add(posPossible.get(i));
                }
            }
        }
        return listPos;
    }
}
