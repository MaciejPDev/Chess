package g58206.chess.model;

import g58206.chess.model.Piece.Bishop;
import g58206.chess.model.Piece.King;
import g58206.chess.model.Piece.Knight;
import g58206.chess.model.Piece.Pawn;
import g58206.chess.model.Piece.Piece;
import g58206.chess.model.Piece.Queen;
import g58206.chess.model.Piece.Rook;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author srexhep
 */
public class PieceTest {

    Board board;

    public PieceTest() {
    }

    @Test
    public void testGetPossibleMovesPawnFirstWhite() {
        board = new Board();
        Position position = new Position(1, 1);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(3, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPawnFirstWhiteInACorner() {
        board = new Board();
        Position position = new Position(1, 7);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 7),
                new Position(3, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPawnWhiteInACorner() {
        board = new Board();
        Position position = new Position(2, 7);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(3, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPawnFirstBlack() {
        board = new Board();
        Position position = new Position(6, 1);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 1),
                new Position(4, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPawnFirstBlackInACorner() {
        board = new Board();
        Position position = new Position(6, 0);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 0),
                new Position(4, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPawnBlackInACorner() {
        board = new Board();
        Position position = new Position(4, 0);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(3, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPawnWhiteCapturingNW() {
        board = new Board();
        Position position = new Position(1, 1);
        Position position2 = new Position(2, 0);
        Piece piece = new Pawn(Color.WHITE);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(3, 1),
                new Position(2, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPawnWhiteCapturingNE() {
        board = new Board();
        Position position = new Position(1, 1);
        Position position2 = new Position(2, 2);
        Piece piece = new Pawn(Color.WHITE);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(3, 1),
                new Position(2, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPawnBlackCapturingSW() {
        board = new Board();
        Position position = new Position(6, 1);
        Position position2 = new Position(5, 0);
        Piece piece = new Pawn(Color.BLACK);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(5, 1),
                new Position(4, 1),
                new Position(5, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPawnBlackCapturingSE() {
        board = new Board();
        Position position = new Position(6, 1);
        Position position2 = new Position(5, 2);
        Piece piece = new Pawn(Color.BLACK);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(5, 1),
                new Position(4, 1),
                new Position(5, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPawnWithObstacles1() {
        board = new Board();
        Position position = new Position(1, 1);
        Position position2 = new Position(3, 1);
        Piece piece = new Pawn(Color.WHITE);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPawnWithObstacles2() {
        board = new Board();
        Position position = new Position(1, 1);
        Position position2 = new Position(3, 1);
        Piece piece = new Pawn(Color.WHITE);
        Piece piece2 = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(2, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesPawnWithObstacles3() {
        board = new Board();
        Position position = new Position(1, 1);
        Position position2 = new Position(2, 1);
        Piece piece = new Pawn(Color.WHITE);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossiblesMovesKnight() {
        board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 2),
                new Position(4, 1),
                new Position(2, 1),
                new Position(1, 2),
                new Position(5, 4),
                new Position(4, 5),
                new Position(2, 5),
                new Position(1, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossiblesMovesKnightCorner() {
        board = new Board();
        Position position = new Position(0, 0);
        Piece piece = new Knight(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(1, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossiblesMovesKnightWithObstacles() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(5, 2);
        Position position3 = new Position(1, 2);
        Position position4 = new Position(2, 5);
        Piece piece = new Knight(Color.WHITE);
        Piece piece2 = new Pawn(Color.WHITE);
        Piece piece3 = new Pawn(Color.WHITE);
        Piece piece4 = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(4, 1),
                new Position(2, 1),
                new Position(5, 4),
                new Position(4, 5),
                new Position(1, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossiblesMovesKnightCapturing() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(5, 2);
        Piece piece = new Knight(Color.WHITE);
        Piece piece2 = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);

        List<Position> expected = List.of(
                new Position(4, 1),
                new Position(2, 1),
                new Position(1, 2),
                new Position(5, 4),
                new Position(4, 5),
                new Position(1, 4),
                new Position(2, 5),
                new Position(5, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossiblesMovesKnightAtInitialPosition() {
        board = new Board();
        Position position = new Position(0, 1);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);
        for (int i = 0; i < 8; i++) {
            Position pos = new Position(1, i);
            Piece pawn = new Pawn(Color.WHITE);
            board.setPiece(pawn, pos);
        }

        List<Position> expected = List.of(
                new Position(2, 0),
                new Position(2, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossiblesMovesKnightMIX() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(4, 1);
        Position position3 = new Position(4, 5);
        Position position4 = new Position(1, 2);
        Piece piece = new Knight(Color.WHITE);
        Piece piece2 = new Knight(Color.BLACK);
        Piece piece3 = new Pawn(Color.WHITE);
        Piece piece4 = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(5, 2),
                new Position(4, 1),
                new Position(2, 1),
                new Position(5, 4),
                new Position(2, 5),
                new Position(1, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossiblesMovesKnightNextToAWall() {
        board = new Board();
        Position position = new Position(3, 0);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(1, 1),
                new Position(2, 2),
                new Position(5, 1),
                new Position(4, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesKing() {
        board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(4, 3),
                new Position(2, 3),
                new Position(3, 4),
                new Position(3, 2),
                new Position(4, 2),
                new Position(4, 4),
                new Position(2, 2),
                new Position(2, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesKingInACorner() {
        board = new Board();
        Position position = new Position(0, 0);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(1, 0),
                new Position(1, 1),
                new Position(0, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesKingWithObstacles() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(4, 2);
        Position position3 = new Position(2, 2);
        Position position4 = new Position(3, 4);
        Piece piece = new King(Color.WHITE);
        Piece piece2 = new Knight(Color.WHITE);
        Piece piece3 = new Pawn(Color.WHITE);
        Piece piece4 = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(4, 3),
                new Position(2, 3),
                new Position(3, 2),
                new Position(4, 4),
                new Position(2, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesKingCapturing() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(4, 2);
        Position position3 = new Position(2, 2);
        Position position4 = new Position(3, 4);
        Piece piece = new King(Color.WHITE);
        Piece piece2 = new Knight(Color.BLACK);
        Piece piece3 = new Pawn(Color.BLACK);
        Piece piece4 = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(4, 3),
                new Position(2, 3),
                new Position(3, 4),
                new Position(3, 2),
                new Position(4, 2),
                new Position(4, 4),
                new Position(2, 2),
                new Position(2, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesKingMIX() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(4, 2);
        Position position3 = new Position(2, 2);
        Position position4 = new Position(3, 4);
        Piece piece = new King(Color.WHITE);
        Piece piece2 = new Knight(Color.BLACK);
        Piece piece3 = new Pawn(Color.WHITE);
        Piece piece4 = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(4, 3),
                new Position(2, 3),
                new Position(3, 4),
                new Position(3, 2),
                new Position(4, 2),
                new Position(4, 4),
                new Position(2, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesQueen() {
        board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Queen(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(0, 3),
                new Position(1, 3),
                new Position(2, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 4),
                new Position(3, 5),
                new Position(3, 6),
                new Position(3, 7)//,
                //new Position(4, 2),
                //new Position(5, 1),
                //new Position(6, 0),
                //new Position(2, 4),
                //new Position(1, 5),
                //new Position(0, 6),
                //new Position(0, 0),
                //new Position(1, 1),
                //new Position(2, 2),
                //new Position(4, 4),
                //new Position(5, 5),
                //new Position(6, 6),
                //new Position(7, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesQueenInACorner() {
        board = new Board();
        Position position = new Position(0, 0);
        Piece piece = new Queen(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(1, 0),
                new Position(2, 0),
                new Position(3, 0),
                new Position(4, 0),
                new Position(5, 0),
                new Position(6, 0),
                new Position(7, 0),
                new Position(0, 1),
                new Position(0, 2),
                new Position(0, 3),
                new Position(0, 4),
                new Position(0, 5),
                new Position(0, 6),
                new Position(0, 7)//,
                //new Position(1, 1),
                //new Position(2, 2),
                //new Position(3, 3),
                //new Position(4, 4),
                //new Position(5, 5),
                //new Position(6, 6),
                //new Position(7, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesQueenWithObstacles() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(4, 2);
        Position position3 = new Position(2, 4);
        Position position4 = new Position(6, 3);
        Piece piece = new Queen(Color.WHITE);
        Piece piece2 = new Pawn(Color.WHITE);
        Piece piece3 = new King(Color.WHITE);
        Piece piece4 = new Knight(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(0, 3),
                new Position(1, 3),
                new Position(2, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 4),
                new Position(3, 5),
                new Position(3, 6),
                new Position(3, 7),
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesQueenCapturing() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(4, 2);
        Position position3 = new Position(2, 4);
        Position position4 = new Position(6, 3);
        Piece piece = new Queen(Color.WHITE);
        Piece piece2 = new Pawn(Color.BLACK);
        Piece piece3 = new King(Color.BLACK);
        Piece piece4 = new Knight(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(0, 3),
                new Position(1, 3),
                new Position(2, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 4),
                new Position(3, 5),
                new Position(3, 6),
                new Position(3, 7),
                new Position(4, 2),
                new Position(2, 4),
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesQueenMIX() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(4, 2);
        Position position3 = new Position(2, 4);
        Position position4 = new Position(6, 3);
        Position position5 = new Position(4, 3);
        Piece piece = new Queen(Color.WHITE);
        Piece piece2 = new Pawn(Color.BLACK);
        Piece piece3 = new King(Color.WHITE);
        Piece piece4 = new Knight(Color.BLACK);
        Piece piece5 = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);
        board.setPiece(piece4, position4);
        board.setPiece(piece5, position5);

        List<Position> expected = List.of(
                new Position(0, 3),
                new Position(1, 3),
                new Position(2, 3),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 4),
                new Position(3, 5),
                new Position(3, 6),
                new Position(3, 7),
                new Position(4, 2),
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossiblesMovesRook() {
        board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Rook(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(0, 3),
                new Position(1, 3),
                new Position(2, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 4),
                new Position(3, 5),
                new Position(3, 6),
                new Position(3, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossiblesMovesRookInACorner() {
        board = new Board();
        Position position = new Position(0, 0);
        Piece piece = new Rook(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(0, 1),
                new Position(0, 2),
                new Position(0, 3),
                new Position(0, 4),
                new Position(0, 5),
                new Position(0, 6),
                new Position(0, 7),
                new Position(1, 0),
                new Position(2, 0),
                new Position(3, 0),
                new Position(4, 0),
                new Position(5, 0),
                new Position(6, 0),
                new Position(7, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossiblesMovesRookWithObstacles() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(3, 5);
        Position position3 = new Position(2, 3);
        Piece piece = new Rook(Color.WHITE);
        Piece piece2 = new Pawn(Color.WHITE);
        Piece piece3 = new Queen(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossiblesMovesRookCapturing() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(3, 5);
        Position position3 = new Position(2, 3);
        Piece piece = new Rook(Color.WHITE);
        Piece piece2 = new Pawn(Color.BLACK);
        Piece piece3 = new Queen(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(2, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 4),
                new Position(3, 5)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossiblesMovesRookMIX() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(1, 3);
        Position position3 = new Position(3, 5);
        Position position4 = new Position(3, 7);
        Piece piece = new Rook(Color.WHITE);
        Piece piece2 = new Pawn(Color.BLACK);
        Piece piece3 = new Pawn(Color.WHITE);
        Piece piece4 = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);
        board.setPiece(piece4, position4);

        List<Position> expected = List.of(
                new Position(1, 3),
                new Position(2, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3),
                new Position(7, 3),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(3, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesBishop() {
        board = new Board();
        Position position = new Position(3, 3);
        Piece piece = new Bishop(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7),
                new Position(0, 6),
                new Position(1, 5),
                new Position(2, 4),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesBishopInACorner() {
        board = new Board();
        Position position = new Position(0, 0);
        Piece piece = new Bishop(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(1, 1),
                new Position(2, 2),
                new Position(3, 3),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesBishopWithObstacles() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(4, 4);
        Position position3 = new Position(5, 1);
        Piece piece = new Bishop(Color.WHITE);
        Piece piece2 = new Pawn(Color.WHITE);
        Piece piece3 = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(0, 6),
                new Position(1, 5),
                new Position(2, 4),
                new Position(4, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesBishopCapturing() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(4, 4);
        Position position3 = new Position(5, 1);
        Piece piece = new Bishop(Color.WHITE);
        Piece piece2 = new Pawn(Color.BLACK);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(4, 4),
                new Position(0, 6),
                new Position(1, 5),
                new Position(2, 4),
                new Position(4, 2),
                new Position(5, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesBishopMIX() {
        board = new Board();
        Position position = new Position(3, 3);
        Position position2 = new Position(5, 5);
        Position position3 = new Position(6, 0);
        Piece piece = new Bishop(Color.WHITE);
        Piece piece2 = new Pawn(Color.WHITE);
        Piece piece3 = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(piece2, position2);
        board.setPiece(piece3, position3);

        List<Position> expected = List.of(
                new Position(0, 0),
                new Position(1, 1),
                new Position(2, 2),
                new Position(4, 4),
                new Position(0, 6),
                new Position(1, 5),
                new Position(2, 4),
                new Position(4, 2),
                new Position(5, 1),
                new Position(6, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
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
