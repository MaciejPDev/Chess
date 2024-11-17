package g58206.chess.model;

import g58206.chess.model.Piece.Piece;
import java.util.Objects;

/**
 * This methods contains the methods to handle the Square(a case on the board)
 *
 * @author macie
 */
public class Square {

    private Piece piece;

    /**
     * Creates an object Piece
     *
     * @param pion the piece
     */
    public Square(Piece pion) {
        this.piece = pion;
    }

    /**
     * Gets the attribute piece
     *
     * @return the value of piece
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Sets the attribute piece with the Piece given in parameter
     *
     * @param pion the given Piece
     */
    public void setPiece(Piece pion) {
        this.piece = pion;
    }

    /**
     * Checks if the square is empty
     *
     * @return true if the case is free and false if not
     */
    public boolean isFree() {
        return this.getPiece() == null;
    }

    //////////////////////////////////EQUALS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.piece);
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
        final Square other = (Square) obj;
        if (!Objects.equals(this.piece, other.piece)) {
            return false;
        }
        return true;
    }

}
