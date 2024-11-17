package g58206.chess.model;

/**
 * This enumeration contains the cardinal directions and the methods to handle
 * the Direction
 *
 * @author macie
 */
public enum Direction {
    NW(1, -1), N(1, 0), NE(1, 1), W(0, -1), E(0, 1), SW(-1, -1), S(-1, 0), SE(-1, 1);

    private final int deltaRow;
    private final int deltaColumn;

    /**
     * Creates an object Direction
     *
     * @param deltaR movement in row
     * @param deltaC movement in column
     */
    private Direction(int deltaR, int deltaC) {
        this.deltaRow = deltaR;
        this.deltaColumn = deltaC;
    }

    /**
     * Gets the attribut deltaRow
     *
     * @return deltaRow
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Gets the attribut deltaColumn
     *
     * @return deltaColumn
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }
}
