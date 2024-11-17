package g58206.chess.model;

/**
 * This enumeration contains two color WHITE and BLACK and the methods to handle
 * them
 *
 * @author macie
 */
public enum Color {
    WHITE, BLACK;

    /**
     * Return the opposite color
     *
     * @return Color
     */
    public Color opposite() {
        if (this == WHITE) {
            return BLACK;
        } else {
            return WHITE;
        }
    }
}
