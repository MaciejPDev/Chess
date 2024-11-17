package g58206.chess.model.Piece;

import g58206.chess.model.Board;
import g58206.chess.model.Color;
import g58206.chess.model.Direction;
import g58206.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the methods to handle the Knight piece
 */
public class Knight extends Piece {

    /**
     * Creates a knight 
     * 
     * @param color the color of the piece
     */
    public Knight(Color color) {
        super(color);
    }

    /**
     * Returns the possible moves for the knight
     * 
     * @param pos the position of the piece
     * @param board the board
     * @return a list of possible moves
     */
    @Override
    public List<Position> getPossibleMoves(Position pos, Board board) {
        List<Position> listPos = new ArrayList<>();
        List<Position> posPossible = List.of(
                pos.next(Direction.W).next(Direction.N).next(Direction.N),
                pos.next(Direction.W).next(Direction.W).next(Direction.N),
                pos.next(Direction.W).next(Direction.W).next(Direction.S),
                pos.next(Direction.W).next(Direction.S).next(Direction.S),
                pos.next(Direction.E).next(Direction.N).next(Direction.N),
                pos.next(Direction.E).next(Direction.E).next(Direction.N),
                pos.next(Direction.E).next(Direction.E).next(Direction.S),
                pos.next(Direction.E).next(Direction.S).next(Direction.S)
        );
        for (int i = 0; i < posPossible.size(); i++){
            if (board.contains(posPossible.get(i))){
                if (board.isFree(posPossible.get(i)) || board.containsOppositeColor(posPossible.get(i), this.getColor())){
                    listPos.add(posPossible.get(i));
                }
            }
        }
        return listPos;
    }
}
