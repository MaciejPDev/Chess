/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58206.chess.model.Piece;

import g58206.chess.model.Board;
import g58206.chess.model.Color;
import g58206.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the methods to handle the Bishop piece
 */
public class Bishop extends Piece {
    
    /**
     * Creates a bishop 
     * 
     * @param color the color of the piece
     */
    public Bishop(Color color){
        super(color);
    }

    /**
     * Returns the possible moves for the bishop
     * 
     * @param pos the position of the piece
     * @param board the board
     * @return a list of possible moves
     */
    @Override
    public List<Position> getPossibleMoves(Position pos, Board board) {
        List<Position> listPos = new ArrayList<>();
        listPos.addAll(this.diagonalMoves(pos, board));
        return listPos;
    }

}
