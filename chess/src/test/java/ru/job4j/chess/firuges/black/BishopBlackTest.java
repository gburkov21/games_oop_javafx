package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPositionIsValid() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertEquals(bishopBlack.position(), Cell.C8);
    }

    @Test
    public void whenPositionIsNotValid() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertNotEquals(bishopBlack.position(), Cell.D8);
    }

    @Test
    public void whenCopyIsValid() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Figure copy = bishopBlack.copy(Cell.C8);
        assertEquals(bishopBlack.position(), copy.position());
    }

    @Test
    public void whenCopyIsNotValid() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Figure copy = bishopBlack.copy(Cell.C7);
        assertNotEquals(bishopBlack.position(), copy.position());
    }

    @Test
    public void whenWayIsValid() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] resultArray = bishopBlack.way(Cell.G5);
        Cell[] expectedArray = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(resultArray, expectedArray);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayIsNotValid() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.E8);
    }

    @Test
    public void whenDiagonalIsNotValid() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertFalse(bishopBlack.isDiagonal(bishopBlack.position(), Cell.H1));
    }

    @Test
    public void whenDiagonalIsValid() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertTrue(bishopBlack.isDiagonal(bishopBlack.position(), Cell.D2));
    }
}