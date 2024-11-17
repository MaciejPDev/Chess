package g58206.chess.view;

import g58206.chess.model.Color;
import g58206.chess.model.Model;
import g58206.chess.model.Piece.Bishop;
import g58206.chess.model.Piece.King;
import g58206.chess.model.Piece.Knight;
import g58206.chess.model.Piece.Pawn;
import g58206.chess.model.Piece.Queen;
import g58206.chess.model.Piece.Rook;
import g58206.chess.model.Position;
import java.util.List;
import java.util.Scanner;

/**
 * This class implements the interface View
 *
 * @author macie
 */
public class TextView implements View {

    private final Model model;

    public TextView(Model model) {
        this.model = model;
    }

    /**
     * Displays the Title and a "welcome" message
     */
    @Override
    public void displayTitle() {
        System.out.println("___________________________________________");
        System.out.println("|                 CHESS                   |");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        System.out.println("          Bienvenue dans le jeu");
    }

    /**
     * Displays the board
     */
    @Override
    public void displayBoard() {
        String a = "  -----------------------------------------";
        String b = "     a    b    c    d    e    f    g    h  ";
        System.out.println(a);
        for (int i = 7; i > -1; i--) {
            System.out.print(i + 1 + " |");
            for (int j = 0; j < 8; j++) {
                Position pos = new Position(i, j);
                if (model.getPiece(pos) == null) {
                    System.out.print("    |");
                }
                if (model.getPiece(pos) != null && model.getPiece(pos).getColor() == Color.WHITE) {
                    if (model.getPiece(pos) instanceof Pawn) {
                        System.out.print(" PB |");
                    } else if (model.getPiece(pos) instanceof Rook) {
                        System.out.print(" TB |");
                    } else if (model.getPiece(pos) instanceof Knight) {
                        System.out.print(" CB |");
                    } else if (model.getPiece(pos) instanceof Bishop) {
                        System.out.print(" FB |");
                    } else if (model.getPiece(pos) instanceof Queen) {
                        System.out.print(" #B |");
                    } else if (model.getPiece(pos) instanceof King) {
                        System.out.print(" *B |");
                    }
                }
                if (model.getPiece(pos) != null && model.getPiece(pos).getColor() == Color.BLACK) {
                    if (model.getPiece(pos) instanceof Pawn) {
                        System.out.print(" PN |");
                    } else if (model.getPiece(pos) instanceof Rook) {
                        System.out.print(" TN |");
                    } else if (model.getPiece(pos) instanceof Knight) {
                        System.out.print(" CN |");
                    } else if (model.getPiece(pos) instanceof Bishop) {
                        System.out.print(" FN |");
                    } else if (model.getPiece(pos) instanceof Queen) {
                        System.out.print(" #N |");
                    } else if (model.getPiece(pos) instanceof King) {
                        System.out.print(" *N |");
                    }
                }
            }
            System.out.println("");
            System.out.println(a);
        }
        System.out.println(b);
    }

    /**
     * Displays the winning Player
     */
    @Override
    public void displayWinner() {
        System.out.println("Le joueur gagnant est : " + model.getOppositePlayer().getColorPlayer());
    }

    /**
     * Displays a message to inform which Player has to play
     */
    @Override
    public void displayPlayer() {
        System.out.println("C'est le tour du joueur " + model.getCurrentPlayer().getColorPlayer());
        System.out.println("Choissisez une pièce en donnant sa position et\n"
                + "ensuite introduisez la position à laquelle vous voulez la déplacer");
    }

    /**
     * Asks the Player to enter a valid position on the board
     *
     * @return the entered position
     */
    @Override
    public Position askPosition() {
        String pos = lireEntree("Entrez une position sous forme d'un chiffre (entre 1 et 8)\net d'une lettre (entre a et h). Par exemple : 5a ou 4g");
        List<String> possibleNumbers = List.of("1", "2", "3", "4", "5", "6", "7", "8");
        List<String> possibleLetters = List.of("a", "b", "c", "d", "e", "f", "g", "h");
        boolean correct = false;
        while (!correct) {
            if (pos == null) {
                displayError("Vous devez entre une position");
                pos = lireEntree("Introduisez une nouvelle position");
            } else if (pos.length() != 2) {
                displayError("La position entrée doit être composé d'un seul et unique chiffre,\nainsi qu'une seule et unique lettre.");
                pos = lireEntree("Réintroduisez une nouvelle position");
            } else if (!possibleNumbers.contains(pos.substring(0, 1))) {
                displayError("Vérifiez que vous avez bien entrez un chiffre compris entre 1 et 8");
                pos = lireEntree("Réintroduisez une nouvelle position");
            } else if (!possibleLetters.contains(pos.substring(1, 2))) {
                displayError("Vérifiez que vous avez bien entrez une lettre comprise entre a et h");
                pos = lireEntree("Réintroduisez une nouvelle position");
            } else {
                correct = true;
            }
        }

        int row = possibleNumbers.indexOf(pos.substring(0, 1));
        int col = possibleLetters.indexOf(pos.substring(1, 2));
        return new Position(row, col);
    }

    /**
     * This methods reads the user's input
     *
     * @param message a string
     * @return the input in lower case
     */
    private String lireEntree(String message) {
        Scanner clavier = new Scanner(System.in);
        System.out.println(message);
        String entree = clavier.nextLine();
        return entree.toLowerCase();
    }

    /**
     * Displays the given error message
     *
     * @param message a string
     */
    @Override
    public void displayError(String message) {
        System.out.println("Erreur : " + message);
    }

    /**
     * Displays a message to say that the current player is in a Check position
     */
    @Override
    public void displayCheck() {
        System.out.println(model.getCurrentPlayer().getColorPlayer() + " est en position d'échec");
    }

    /**
     * Displays a message to say that there is a player is in a check mate
     * position
     */
    @Override
    public void displayMat() {
        System.out.println(model.getCurrentPlayer().getColorPlayer() + " est en position d'échec et mat");
    }

    /**
     * Displays a message to say that the state of the is game is stale mate and
     * informs the players that the game is a draw
     */
    @Override
    public void displayStaleMate() {
        System.out.println("L'état de la partie est mat pat");
        System.out.println("C'est-à-dire que c'est égailité.");
    }
}
