package g58206.chess.model;

/**
 * This class contains the methods to handle the Positions
 * 
 * @author macie
 */
public class Position {

    private final int row;
    private final int column;

    /**
     * Creates an object Position
     *
     * @param ro position x
     * @param col position y
     */
    public Position(int ro, int col) {
        this.row = ro;
        this.column = col;
    }

    /**
     * Gets the attribute row
     *
     * @return the value of row
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the attribute column
     *
     * @return the value of column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Changes the Position
     *
     * @param dir choosed direction
     * @return Modified Position
     */
    public Position next(Direction dir) {
        int row = this.getRow() + dir.getDeltaRow();
        int column = this.getColumn() + dir.getDeltaColumn();
        Position next = new Position(row, column);
        return next;
    }

    
    
    //////////////////////////////////EQUALS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.row;
        hash = 61 * hash + this.column;
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
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }
}
