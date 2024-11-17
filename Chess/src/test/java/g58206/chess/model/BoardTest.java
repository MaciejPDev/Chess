package g58206.chess.model;

import g58206.chess.model.Piece.Pawn;
import g58206.chess.model.Piece.Piece;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author srexhep
 */
public class BoardTest {
    
    private Board board;
    
    @BeforeEach     // ExÃ©cutÃ©e avant chaque test
    public void setUp() {
        board = new Board();
    }

    // **************** testContains *****************
    @Test
    public void testContainsOnCorner() {
        // A corner of the board
        board = new Board();
        Position pos = new Position(0,0);
        assertTrue(board.contains(pos));
    }
    
    @Test
    public void testContainsMiddleBoard() {
        // A point on the midle of the board
        board = new Board();
        Position pos = new Position(4,4);
        assertTrue(board.contains(pos));
    }
    
    @Test
    public void testContainsRowOutOfRange() {
        // Row out of range
        board = new Board();
        Position pos = new Position(-1,3);
        assertFalse(board.contains(pos));
    }
    
    @Test
    public void testContainsColOutOfRange() {
        // Col. out of range
        board = new Board();
        Position pos = new Position(1,8);
        assertFalse(board.contains(pos));
    }
    
    @Test
    public void testContainsColAndRowOutOfRange() {
        // Row and col. out of range
        board = new Board();
        Position pos = new Position(10,10);
        assertFalse(board.contains(pos));
    }
    
    // ************** testIsFree ****************
    
    @Test
    public void testIsFreePositionNotFree() {
        // When a piece is on the given positon
        board = new Board();
        Position pos = new Position(1,1);
        board.setPiece(new Pawn(Color.BLACK), pos);
        
        assertFalse(board.isFree(pos));
    }
    
    @Test
    public void testIsFreePositionIsFree() {
        // When a piece is NOT on the given positon
        board = new Board();
        Position pos = new Position(3,2);
        
        assertTrue(board.isFree(pos));
    }
    
    // ************** testContainsOppositeColor ****************
    @Test
    public void testContainsOppositeColorNoPiece() {
        // When the position contains no piece at all
        board = new Board();
        Position pos = new Position(4,4);
        assertFalse(board.containsOppositeColor(pos, Color.BLACK));
    }
    
    @Test
    public void testContainsOppositeColorSameColorBlack() {
        // When the position contains a piece of the same color (black)
        board = new Board();
        Position pos = new Position(2,5);
        board.setPiece(new Pawn(Color.BLACK), pos);
        assertFalse(board.containsOppositeColor(pos, Color.BLACK));
    }
    
    @Test
    public void testContainsOppositeColorSameColorWhite() {
        // When the position contains a piece of the same color (white)
        board = new Board();
        Position pos = new Position(7,7);
        board.setPiece(new Pawn(Color.WHITE), pos);
        assertFalse(board.containsOppositeColor(pos, Color.WHITE));
    }
    
    @Test
    public void testContainsOppositeColorOppositeColorWB() {
        // When the position contains a piece of the opposite color 
        // White and black
        board = new Board();
        Position pos = new Position(7,7);
        board.setPiece(new Pawn(Color.WHITE), pos);
        assertTrue(board.containsOppositeColor(pos, Color.BLACK));
    }
    
    @Test
    public void testContainsOppositeColorOppositionColorBW() {
        // When the position contains a piece of the opposite color 
        // black and white
        board = new Board();
        Position pos = new Position(7,7);
        board.setPiece(new Pawn(Color.BLACK), pos);
        assertTrue(board.containsOppositeColor(pos, Color.WHITE));
    }
    
    // ************** testGetPositionOccupiedBy ****************
    
    @Test
    public void testGetPositionOccupiedByWhiteInitialPosition() {
        board = new Board();
    
        Color color = Color.WHITE;
        Player player = new Player(color);
        List<Position> positions; 
        List<Position> expected = new ArrayList<>();
        
        for (int i = 0; i < 8; i++){
            board.setPiece(new Pawn(color), new Position(1,i));
            expected.add(new Position(1,i));
        }
        
        positions = board.getPositionOccupiedBy(player);
        
        assertEqualsIgnoringOrder(positions,expected);   
    } 
    
    @Test
    public void testGetPositionOccupiedByWhiteRandomPositions() {
        board = new Board();
    
        Color color = Color.WHITE;
        Player player = new Player(color);
        List<Position> positions; 
        List<Position> expected = new ArrayList<>();
        
      
        board.setPiece(new Pawn(color), new Position(2,0));
        expected.add(new Position(2,0));
        
        board.setPiece(new Pawn(color), new Position(3,2));
        expected.add(new Position(3,2));
        
        board.setPiece(new Pawn(color), new Position(5,5));
        expected.add(new Position(5,5));
        
        positions = board.getPositionOccupiedBy(player);
        
        /* Test if the two lists contain exactly the same elements,
        independently of the order of the elements. */
        assertEqualsIgnoringOrder(positions,expected);   
    } 
    
    @Test
    public void testGetPositionOccupiedByBlackInitialPositions() {
        board = new Board();
    
        Color color = Color.BLACK;
        Player player = new Player(color);
        List<Position> positions; 
        List<Position> expected = new ArrayList<>();
        
        for (int i = 0; i < 8; i++){
            board.setPiece(new Pawn(color), new Position(6,i));
            expected.add(new Position(6,i));
        }
        
        positions = board.getPositionOccupiedBy(player);
        
        /* Test if the two lists contain exactly the same elements,
        independently of the order of the elements. */
        assertEqualsIgnoringOrder(positions,expected);
    } 
    
    @Test
    public void testGetPositionOccupiedByBlackRandomPositions() {
        board = new Board();
    
        Color color = Color.BLACK;
        Player player = new Player(color);
        List<Position> positions; 
        List<Position> expected = new ArrayList<>();
        
        board.setPiece(new Pawn(color), new Position(0,0));
        expected.add(new Position(0,0));
        
        board.setPiece(new Pawn(color), new Position(1,1));
        expected.add(new Position(1,1));
        
        board.setPiece(new Pawn(color), new Position(6,7));
        expected.add(new Position(6,7));
        
        board.setPiece(new Pawn(color), new Position(1,7));
        expected.add(new Position(1,7));
        
        positions = board.getPositionOccupiedBy(player);
        
        assertEqualsIgnoringOrder(positions,expected);
    }
    
    @Test
    public void testGetPositionOccupiedByBlackNoPositions() {
        board = new Board();
    
        Color color = Color.BLACK;
        Player player = new Player(color);
        List<Position> positions; 
        
        positions = board.getPositionOccupiedBy(player);
           
        assertTrue(positions.isEmpty());
    }
    
    /*
     *      Permet de tester si deux listes de positions sont identiques Ã  l'ordre
     *      des Ã©lÃ©ments prÃªts. Cette mÃ©thode est appelÃ©e
     *      par les mÃ©thodes de test.
     */
    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        board = new Board();
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }
}

