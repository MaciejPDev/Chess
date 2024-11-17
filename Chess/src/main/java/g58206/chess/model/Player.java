package g58206.chess.model;

import java.util.Objects;

/**
 * This class contains the methods to handle the Player
 * 
 * @author macie
 */
public class Player {

    private final Color colorPlayer;

    /**
     * Creates an object Player
     *
     * @param couleur color of the Player
     */
    public Player(Color couleur) {
        this.colorPlayer = couleur;
    }

    /**
     * Gets the attribut of colorPlayer
     *
     * @return the color of the Player
     */
    public Color getColorPlayer() {
        return colorPlayer;
    }

    
    
    //////////////////////////////////EQUALS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.colorPlayer);
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
        final Player other = (Player) obj;
        if (this.colorPlayer != other.colorPlayer) {
            return false;
        }
        return true;
    }

}
