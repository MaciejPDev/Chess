/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58206.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author macie
 */
public class PositionTest {

    @Test
    public void testNextNE() {
        Position pos1 = new Position(1, 1);
        Position pos2 = pos1.next(Direction.NE);
        Position pos3 = new Position(2, 2);
        assertEquals(pos2, pos3);
    }

    @Test
    public void testNextNW() {
        Position pos1 = new Position(1, 1);
        Position pos2 = pos1.next(Direction.NW);
        Position pos3 = new Position(2, 0);
        assertEquals(pos2, pos3);
    }

    @Test
    public void testNextN() {
        Position pos1 = new Position(1, 1);
        Position pos2 = pos1.next(Direction.N);
        Position pos3 = new Position(2, 1);
        assertEquals(pos2, pos3);
    }

    @Test
    public void testNextW() {
        Position pos1 = new Position(1, 1);
        Position pos2 = pos1.next(Direction.W);
        Position pos3 = new Position(1, 0);
        assertEquals(pos2, pos3);
    }

    @Test
    public void testNextE() {
        Position pos1 = new Position(1, 1);
        Position pos2 = pos1.next(Direction.E);
        Position pos3 = new Position(1, 2);
        assertEquals(pos2, pos3);
    }

    @Test
    public void testNextS() {
        Position pos1 = new Position(1, 1);
        Position pos2 = pos1.next(Direction.S);
        Position pos3 = new Position(0, 1);
        assertEquals(pos2, pos3);
    }

    @Test
    public void testNextSE() {
        Position pos1 = new Position(1, 1);
        Position pos2 = pos1.next(Direction.SE);
        Position pos3 = new Position(0, 2);
        assertEquals(pos2, pos3);
    }

    @Test
    public void testNextSW() {
        Position pos1 = new Position(1, 1);
        Position pos2 = pos1.next(Direction.SW);
        Position pos3 = new Position(0, 0);
        assertEquals(pos2, pos3);
    }
}
