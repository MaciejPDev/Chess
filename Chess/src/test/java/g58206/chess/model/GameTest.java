/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58206.chess.model;

import g58206.chess.model.Piece.King;
import g58206.chess.model.Piece.Pawn;
import g58206.chess.model.Piece.Piece;
import g58206.chess.model.Piece.Rook;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author macie
 */
public class GameTest {

    private Game game;

    public GameTest() {
    }

    /////////////////////////////////Test Start\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Test
    public void testStartPlayer() {
        game = new Game();
        game.start();
        Player expP1 = new Player(Color.WHITE);
        Player P1 = game.getCurrentPlayer();

        assertEquals(expP1, P1);
    }

    @Test
    public void testStartWhitePiece() {
        game = new Game();
        game.start();
        List<Position> listPos = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Position pos = new Position(1, i);
            if (game.getPiece(pos) != null && game.getPiece(pos).getColor() == Color.WHITE) {
                listPos.add(pos);
            }
        }

        List<Position> expected = List.of(
                new Position(1, 0),
                new Position(1, 1),
                new Position(1, 2),
                new Position(1, 3),
                new Position(1, 4),
                new Position(1, 5),
                new Position(1, 6),
                new Position(1, 7)
        );

        assertEqualsIgnoringOrder(expected, listPos);
    }

    @Test
    public void testStartBlackPiece() {
        game = new Game();
        game.start();
        List<Position> listPos = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Position pos = new Position(6, i);
            if (game.getPiece(pos) != null && game.getPiece(pos).getColor() == Color.BLACK) {
                listPos.add(pos);
            }
        }

        List<Position> expected = List.of(
                new Position(6, 0),
                new Position(6, 1),
                new Position(6, 2),
                new Position(6, 3),
                new Position(6, 4),
                new Position(6, 5),
                new Position(6, 6),
                new Position(6, 7)
        );

        assertEqualsIgnoringOrder(expected, listPos);
    }

    ///////////////////////Test isCurrentPlayerPosition\\\\\\\\\\\\\\\\\\\\\\\\\
    @Test
    public void testIsCurrentPlayerPositionWhite() {
        game = new Game();
        game.start();
        boolean exp = true;
        boolean color = game.isCurrentPlayerPosition(new Position(1, 4));
        assertEquals(exp, color);
    }

    @Test
    public void testIsCurrentPlayerPositionBlack() {
        game = new Game();
        game.start();
        boolean exp = false;
        boolean color = game.isCurrentPlayerPosition(new Position(6, 4));
        assertEquals(exp, color);
    }

    @Test
    public void testIsCurrentPlayerPositionWHiteInitial() {
        game = new Game();
        game.start();
        List<Boolean> list = new ArrayList();
        for (int i = 0; i < 8; i++) {
            list.add(game.isCurrentPlayerPosition(new Position(1, i)));
        }
        List<Boolean> excpected = List.of(
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true);
        assertEquals(excpected, list);
    }

    @Test
    public void testIsCurrentPlayerPositionBlackInitial() {
        game = new Game();
        game.start();
        game.movePiecePosition(new Position(1, 0), new Position(2, 0));
        List<Boolean> list = new ArrayList();
        for (int i = 0; i < 8; i++) {
            list.add(game.isCurrentPlayerPosition(new Position(6, i)));
        }
        List<Boolean> excpected = List.of(
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true);
        assertEquals(excpected, list);
    }

    /////////////////////////Test movePiecePosition\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @Test
    public void testMovePiecePosition1() {
        game = new Game();
        game.start();
        game.movePiecePosition(new Position(1, 0), new Position(2, 0));
        List<Position> list = new ArrayList();
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                Position pos = new Position(i, j);
                if (game.getPiece(pos) != null) {
                    list.add(pos);
                }
            }
        }
        List<Position> excpected = List.of(
                new Position(2, 0),
                new Position(1, 1),
                new Position(1, 2),
                new Position(1, 3),
                new Position(1, 4),
                new Position(1, 5),
                new Position(1, 6),
                new Position(1, 7),
                new Position(6, 0),
                new Position(6, 1),
                new Position(6, 2),
                new Position(6, 3),
                new Position(6, 4),
                new Position(6, 5),
                new Position(6, 6),
                new Position(6, 7)
        );
        assertEqualsIgnoringOrder(excpected, list);
    }

    @Test
    public void testMovePiecePosition2() {
        game = new Game();
        game.start();
        game.movePiecePosition(new Position(1, 0), new Position(3, 0));
        game.movePiecePosition(new Position(6, 0), new Position(4, 0));
        game.movePiecePosition(new Position(1, 1), new Position(2, 1));
        game.movePiecePosition(new Position(6, 1), new Position(4, 1));
        List<Position> list = new ArrayList();
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                Position pos = new Position(i, j);
                if (game.getPiece(pos) != null) {
                    list.add(pos);
                }
            }
        }
        List<Position> excpected = List.of(
                new Position(3, 0),
                new Position(2, 1),
                new Position(1, 2),
                new Position(1, 3),
                new Position(1, 4),
                new Position(1, 5),
                new Position(1, 6),
                new Position(1, 7),
                new Position(4, 0),
                new Position(4, 1),
                new Position(6, 2),
                new Position(6, 3),
                new Position(6, 4),
                new Position(6, 5),
                new Position(6, 6),
                new Position(6, 7)
        );
        assertEqualsIgnoringOrder(excpected, list);
    }

    /////////////////////////////Test isGameOver\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    //@Test
    //public void testIsGameOver() {
    //    game = new Game();
    //    game.start();
    //    game.movePiecePosition(new Position(1, 0), new Position(3, 0));
    //    game.movePiecePosition(new Position(6, 0), new Position(4, 0));
    //    game.movePiecePosition(new Position(1, 1), new Position(2, 1));
    //    game.movePiecePosition(new Position(6, 1), new Position(4, 1));
    //    game.movePiecePosition(new Position(1, 2), new Position(3, 2));
    //    game.movePiecePosition(new Position(4, 1), new Position(3, 2));
    //    game.movePiecePosition(new Position(2, 1), new Position(3, 2));
    //    game.movePiecePosition(new Position(6, 2), new Position(4, 2));
    //    game.movePiecePosition(new Position(1, 3), new Position(2, 3));
    //    game.movePiecePosition(new Position(6, 3), new Position(4, 3));
    //    game.movePiecePosition(new Position(1, 4), new Position(3, 4));
    //    game.movePiecePosition(new Position(4, 3), new Position(3, 4));
    //    game.movePiecePosition(new Position(2, 3), new Position(3, 4));
    //    game.movePiecePosition(new Position(6, 4), new Position(4, 4));
    //    game.movePiecePosition(new Position(1, 5), new Position(2, 5));
    //    game.movePiecePosition(new Position(6, 5), new Position(4, 5));
    //    game.movePiecePosition(new Position(1, 6), new Position(3, 6));
    //    game.movePiecePosition(new Position(4, 5), new Position(3, 6));
    //    game.movePiecePosition(new Position(2, 5), new Position(3, 6));
    //    game.movePiecePosition(new Position(6, 6), new Position(4, 6));
    //    game.movePiecePosition(new Position(1, 7), new Position(3, 7));
    //    game.movePiecePosition(new Position(4, 6), new Position(3, 7));
    //    game.movePiecePosition(new Position(3, 6), new Position(4, 6));
    //    game.movePiecePosition(new Position(6, 7), new Position(5, 7));
    //    game.movePiecePosition(new Position(4, 6), new Position(5, 7));
    //    game.movePiecePosition(new Position(3, 7), new Position(2, 7));
    //    game.movePiecePosition(new Position(5, 7), new Position(6, 7));
    //    game.movePiecePosition(new Position(2, 7), new Position(1, 7));
    //    game.movePiecePosition(new Position(6, 7), new Position(7, 7));
    //    boolean flag = true;
    //    boolean ex = game.isGameOver();
    //    assertEquals(flag, ex);
    //}
    
    @Test
    public void testisValid() {
        game = new Game();
        game.start();
        game.movePiecePosition(new Position(1, 6), new Position(3, 6));
        game.movePiecePosition(new Position(6, 4), new Position(4, 4));
        game.movePiecePosition(new Position(1, 5), new Position(2, 5));
        game.movePiecePosition(new Position(7, 3), new Position(3, 7));

        assertFalse(game.isValidMove(new Position(0, 1), new Position(2, 0)));
    }

    @Test
    public void testisValid2() {
        game = new Game();
        game.start();
        
        assertTrue(game.isValidMove(new Position(1, 6), new Position(3, 6)));
    }

    @Test
    public void testGameStateChangesCheckMate() {
        game = new Game();
        game.start();
        game.movePiecePosition(new Position(1, 6), new Position(3, 6));
        game.movePiecePosition(new Position(6, 4), new Position(4, 4));
        game.movePiecePosition(new Position(1, 5), new Position(2, 5));
        game.movePiecePosition(new Position(7, 3), new Position(3, 7));

        GameState state = game.getGameState();
        GameState exp = GameState.CHECK_MATE;

        assertEquals(exp, state);
    }

    @Test
    public void testGameStateChangesStaleMate() {
        game = new Game();
        game.start();
        game.movePiecePosition(new Position(1, 4), new Position(2, 4));
        game.movePiecePosition(new Position(6, 0), new Position(4, 0));
        game.movePiecePosition(new Position(0, 3), new Position(4, 7));
        game.movePiecePosition(new Position(7, 0), new Position(5, 0));
        game.movePiecePosition(new Position(4, 7), new Position(4, 0));
        game.movePiecePosition(new Position(6, 7), new Position(4, 7));
        game.movePiecePosition(new Position(1, 7), new Position(3, 7));
        game.movePiecePosition(new Position(5, 0), new Position(5, 7));
        game.movePiecePosition(new Position(4, 0), new Position(6, 2));
        game.movePiecePosition(new Position(6, 5), new Position(5, 5));
        game.movePiecePosition(new Position(6, 2), new Position(6, 3));
        game.movePiecePosition(new Position(7, 4), new Position(6, 5));
        game.movePiecePosition(new Position(6, 3), new Position(6, 1));
        game.movePiecePosition(new Position(7, 3), new Position(2, 3));
        game.movePiecePosition(new Position(6, 1), new Position(7, 1));
        game.movePiecePosition(new Position(2, 3), new Position(6, 7));
        game.movePiecePosition(new Position(7, 1), new Position(7, 2));
        game.movePiecePosition(new Position(6, 5), new Position(5, 6));
        game.movePiecePosition(new Position(7, 2), new Position(5, 4));

        GameState state = game.getGameState();
        GameState exp = GameState.STALE_MATE;

        assertEquals(exp, state);
    }

    @Test
    public void testGameStateChangesCheck() {
        game = new Game();
        game.start();
        game.movePiecePosition(new Position(1, 4), new Position(2, 4));
        game.movePiecePosition(new Position(6, 4), new Position(5, 4));
        game.movePiecePosition(new Position(1, 5), new Position(2, 5));
        game.movePiecePosition(new Position(7, 3), new Position(3, 7));

        GameState state = game.getGameState();
        GameState exp = GameState.CHECK;

        assertEquals(exp, state);
    }

    /*
     *      Permet de tester si deux listes de positions sont identiques Ã  l'ordre
     *      des Ã©lÃ©ments prÃªts. Cette mÃ©thode est appelÃ©e
     *      par les mÃ©thodes de test.
     */
    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }
}
