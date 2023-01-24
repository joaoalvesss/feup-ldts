package org.minesweeper.model.game.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.minesweeper.Game;
import org.minesweeper.model.Position;
import org.minesweeper.model.game.elements.Bomb;
import org.minesweeper.model.game.elements.ClickCell;
import org.minesweeper.model.game.elements.Wall;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class LoaderBoardBuilderTest {
    private Board board;
    private Game game;
    private List<Bomb> bombs;

    @BeforeEach
    public void helper() throws IOException, URISyntaxException, FontFormatException {
        board = Mockito.mock(Board.class);
    }

    @Test
    void testConstructor() {
        assertEquals(-1, (new LoaderBoardBuilder("Something")).getHeight());
        assertEquals(Short.SIZE, (new LoaderBoardBuilder((String) "hard")).getHeight());
        assertEquals(10, (new LoaderBoardBuilder((String) "easy")).getHeight());
        assertEquals(Short.SIZE, (new LoaderBoardBuilder((String) "medium")).getHeight());
    }

    @Test
    void testCreateBombs() {
        assertEquals(99, (new LoaderBoardBuilder("hard")).createBombs().size());
        assertEquals(10, (new LoaderBoardBuilder("easy")).createBombs().size());
        assertEquals(40, (new LoaderBoardBuilder("medium")).createBombs().size());
    }

    @Test
    void testGetWidth() {
        assertEquals(-1, (new LoaderBoardBuilder("LOL")).getWidth());
        assertEquals(10, (new LoaderBoardBuilder("easy")).getWidth());
        assertEquals(30, (new LoaderBoardBuilder("hard")).getWidth());
        assertEquals(Short.SIZE, (new LoaderBoardBuilder("medium")).getWidth());
    }

    @Test
    void testGetHeight() {
        assertEquals(10, (new LoaderBoardBuilder("easy")).getHeight());
        assertEquals(Short.SIZE, (new LoaderBoardBuilder("hard")).getHeight());
        assertEquals(Short.SIZE, (new LoaderBoardBuilder("medium")).getHeight());
    }

    @Test
    void testCreateClickableCells() {
        assertTrue((new LoaderBoardBuilder("Difficulty")).createClickableCells().isEmpty());
    }

    @Test
    void testCreateClickableCells2() {
        List<ClickCell> actualCreateClickableCellsResult = (new LoaderBoardBuilder("easy")).createClickableCells();
        assertEquals(100, actualCreateClickableCellsResult.size());
        ClickCell getResult = actualCreateClickableCellsResult.get(5);
        assertFalse(getResult.isFlagged());
        ClickCell getResult1 = actualCreateClickableCellsResult.get(94);
        assertFalse(getResult1.isFlagged());
        ClickCell getResult2 = actualCreateClickableCellsResult.get(4);
        assertFalse(getResult2.isFlagged());
        ClickCell getResult3 = actualCreateClickableCellsResult.get(1);
        assertFalse(getResult3.isFlagged());
        ClickCell getResult4 = actualCreateClickableCellsResult.get(0);
        assertFalse(getResult4.isFlagged());
        ClickCell getResult5 = actualCreateClickableCellsResult.get(99);
        assertFalse(getResult5.isFlagged());
        ClickCell getResult6 = actualCreateClickableCellsResult.get(96);
        assertFalse(getResult6.isFlagged());
        ClickCell getResult7 = actualCreateClickableCellsResult.get(3);
        assertFalse(getResult7.isFlagged());
        ClickCell getResult8 = actualCreateClickableCellsResult.get(95);
        assertFalse(getResult8.isFlagged());
        ClickCell getResult9 = actualCreateClickableCellsResult.get(2);
        assertFalse(getResult9.isFlagged());
        ClickCell getResult10 = actualCreateClickableCellsResult.get(97);
        assertFalse(getResult10.isFlagged());
        ClickCell getResult11 = actualCreateClickableCellsResult.get(98);
        assertFalse(getResult11.isFlagged());
        Position cellPosition = getResult3.getCellPosition();
        assertEquals(12, cellPosition.getY());
        Position cellPosition1 = getResult7.getCellPosition();
        assertEquals(14, cellPosition1.getY());
        assertEquals(14, cellPosition1.getX());
        assertEquals(14, cellPosition.getX());
        Position cellPosition2 = getResult4.getCellPosition();
        assertEquals(14, cellPosition2.getX());
        Position cellPosition3 = getResult6.getCellPosition();
        assertEquals(23, cellPosition3.getX());
        Position cellPosition4 = getResult8.getCellPosition();
        assertEquals(Short.SIZE, cellPosition4.getY());
        Position cellPosition5 = getResult1.getCellPosition();
        assertEquals(23, cellPosition5.getX());
        Position cellPosition6 = getResult.getCellPosition();
        assertEquals(Short.SIZE, cellPosition6.getY());
        assertEquals(15, cellPosition5.getY());
        assertEquals(11, cellPosition2.getY());
        assertEquals(23, cellPosition4.getX());
        Position cellPosition7 = getResult11.getCellPosition();
        assertEquals(23, cellPosition7.getX());
        assertEquals(19, cellPosition7.getY());
        Position cellPosition8 = getResult10.getCellPosition();
        assertEquals(18, cellPosition8.getY());
        Position cellPosition9 = getResult2.getCellPosition();
        assertEquals(15, cellPosition9.getY());
        Position cellPosition10 = getResult9.getCellPosition();
        assertEquals(13, cellPosition10.getY());
        assertEquals(14, cellPosition6.getX());
        Position cellPosition11 = getResult5.getCellPosition();
        assertEquals(20, cellPosition11.getY());
        assertEquals(14, cellPosition10.getX());
        assertEquals(23, cellPosition8.getX());
        assertEquals(17, cellPosition3.getY());
        assertEquals(23, cellPosition11.getX());
        assertEquals(14, cellPosition9.getX());
    }

    @Test
    void testCreateClickableCells3() {
        List<ClickCell> actualCreateClickableCellsResult = (new LoaderBoardBuilder("hard")).createClickableCells();
        assertEquals(480, actualCreateClickableCellsResult.size());
        ClickCell getResult = actualCreateClickableCellsResult.get(5);
        assertFalse(getResult.isFlagged());
        ClickCell getResult1 = actualCreateClickableCellsResult.get(474);
        assertFalse(getResult1.isFlagged());
        ClickCell getResult2 = actualCreateClickableCellsResult.get(4);
        assertFalse(getResult2.isFlagged());
        ClickCell getResult3 = actualCreateClickableCellsResult.get(1);
        assertFalse(getResult3.isFlagged());
        ClickCell getResult4 = actualCreateClickableCellsResult.get(0);
        assertFalse(getResult4.isFlagged());
        ClickCell getResult5 = actualCreateClickableCellsResult.get(479);
        assertFalse(getResult5.isFlagged());
        ClickCell getResult6 = actualCreateClickableCellsResult.get(476);
        assertFalse(getResult6.isFlagged());
        ClickCell getResult7 = actualCreateClickableCellsResult.get(3);
        assertFalse(getResult7.isFlagged());
        ClickCell getResult8 = actualCreateClickableCellsResult.get(475);
        assertFalse(getResult8.isFlagged());
        ClickCell getResult9 = actualCreateClickableCellsResult.get(2);
        assertFalse(getResult9.isFlagged());
        ClickCell getResult10 = actualCreateClickableCellsResult.get(477);
        assertFalse(getResult10.isFlagged());
        ClickCell getResult11 = actualCreateClickableCellsResult.get(478);
        assertFalse(getResult11.isFlagged());
        Position cellPosition = getResult3.getCellPosition();
        assertEquals(8, cellPosition.getY());
        Position cellPosition1 = getResult7.getCellPosition();
        assertEquals(10, cellPosition1.getY());
        assertEquals(4, cellPosition1.getX());
        assertEquals(4, cellPosition.getX());
        Position cellPosition2 = getResult4.getCellPosition();
        assertEquals(4, cellPosition2.getX());
        Position cellPosition3 = getResult6.getCellPosition();
        assertEquals(33, cellPosition3.getX());
        Position cellPosition4 = getResult8.getCellPosition();
        assertEquals(18, cellPosition4.getY());
        Position cellPosition5 = getResult1.getCellPosition();
        assertEquals(33, cellPosition5.getX());
        Position cellPosition6 = getResult.getCellPosition();
        assertEquals(12, cellPosition6.getY());
        assertEquals(17, cellPosition5.getY());
        assertEquals(7, cellPosition2.getY());
        assertEquals(33, cellPosition4.getX());
        Position cellPosition7 = getResult11.getCellPosition();
        assertEquals(33, cellPosition7.getX());
        assertEquals(21, cellPosition7.getY());
        Position cellPosition8 = getResult10.getCellPosition();
        assertEquals(20, cellPosition8.getY());
        Position cellPosition9 = getResult2.getCellPosition();
        assertEquals(11, cellPosition9.getY());
        Position cellPosition10 = getResult9.getCellPosition();
        assertEquals(9, cellPosition10.getY());
        assertEquals(4, cellPosition6.getX());
        Position cellPosition11 = getResult5.getCellPosition();
        assertEquals(22, cellPosition11.getY());
        assertEquals(4, cellPosition10.getX());
        assertEquals(33, cellPosition8.getX());
        assertEquals(19, cellPosition3.getY());
        assertEquals(33, cellPosition11.getX());
        assertEquals(4, cellPosition9.getX());
    }

    @Test
    void testCreateClickableCells4() {
        List<ClickCell> actualCreateClickableCellsResult = (new LoaderBoardBuilder("medium")).createClickableCells();
        assertEquals(256, actualCreateClickableCellsResult.size());
        ClickCell getResult = actualCreateClickableCellsResult.get(5);
        assertFalse(getResult.isFlagged());
        ClickCell getResult1 = actualCreateClickableCellsResult.get(250);
        assertFalse(getResult1.isFlagged());
        ClickCell getResult2 = actualCreateClickableCellsResult.get(4);
        assertFalse(getResult2.isFlagged());
        ClickCell getResult3 = actualCreateClickableCellsResult.get(1);
        assertFalse(getResult3.isFlagged());
        ClickCell getResult4 = actualCreateClickableCellsResult.get(0);
        assertFalse(getResult4.isFlagged());
        ClickCell getResult5 = actualCreateClickableCellsResult.get(255);
        assertFalse(getResult5.isFlagged());
        ClickCell getResult6 = actualCreateClickableCellsResult.get(252);
        assertFalse(getResult6.isFlagged());
        ClickCell getResult7 = actualCreateClickableCellsResult.get(3);
        assertFalse(getResult7.isFlagged());
        ClickCell getResult8 = actualCreateClickableCellsResult.get(251);
        assertFalse(getResult8.isFlagged());
        ClickCell getResult9 = actualCreateClickableCellsResult.get(2);
        assertFalse(getResult9.isFlagged());
        ClickCell getResult10 = actualCreateClickableCellsResult.get(253);
        assertFalse(getResult10.isFlagged());
        ClickCell getResult11 = actualCreateClickableCellsResult.get(254);
        assertFalse(getResult11.isFlagged());
        Position cellPosition = getResult3.getCellPosition();
        assertEquals(8, cellPosition.getY());
        Position cellPosition1 = getResult7.getCellPosition();
        assertEquals(10, cellPosition1.getY());
        assertEquals(11, cellPosition1.getX());
        assertEquals(11, cellPosition.getX());
        Position cellPosition2 = getResult4.getCellPosition();
        assertEquals(11, cellPosition2.getX());
        Position cellPosition3 = getResult6.getCellPosition();
        assertEquals(26, cellPosition3.getX());
        Position cellPosition4 = getResult8.getCellPosition();
        assertEquals(18, cellPosition4.getY());
        Position cellPosition5 = getResult1.getCellPosition();
        assertEquals(26, cellPosition5.getX());
        Position cellPosition6 = getResult.getCellPosition();
        assertEquals(12, cellPosition6.getY());
        assertEquals(17, cellPosition5.getY());
        assertEquals(7, cellPosition2.getY());
        assertEquals(26, cellPosition4.getX());
        Position cellPosition7 = getResult11.getCellPosition();
        assertEquals(26, cellPosition7.getX());
        assertEquals(21, cellPosition7.getY());
        Position cellPosition8 = getResult10.getCellPosition();
        assertEquals(20, cellPosition8.getY());
        Position cellPosition9 = getResult2.getCellPosition();
        assertEquals(11, cellPosition9.getY());
        Position cellPosition10 = getResult9.getCellPosition();
        assertEquals(9, cellPosition10.getY());
        assertEquals(11, cellPosition6.getX());
        Position cellPosition11 = getResult5.getCellPosition();
        assertEquals(22, cellPosition11.getY());
        assertEquals(11, cellPosition10.getX());
        assertEquals(26, cellPosition8.getX());
        assertEquals(19, cellPosition3.getY());
        assertEquals(26, cellPosition11.getX());
        assertEquals(11, cellPosition9.getX());
    }

    @Test
    void testCreatePointer() {
        Position cellPosition = (new LoaderBoardBuilder("Fail")).createPointer().getCellPosition();
        assertEquals(0, cellPosition.getX());
        assertEquals(0, cellPosition.getY());
    }

    @Test
    void testCreatePointer2() {
        Position cellPosition = (new LoaderBoardBuilder("easy")).createPointer().getCellPosition();
        assertEquals(19, cellPosition.getX());
        assertEquals(Short.SIZE, cellPosition.getY());
    }

    @Test
    void testCreatePointer3() {
        Position cellPosition = (new LoaderBoardBuilder("hard")).createPointer().getCellPosition();
        assertEquals(19, cellPosition.getX());
        assertEquals(15, cellPosition.getY());
    }

    @Test
    void testCreatePointer4() {
        Position cellPosition = (new LoaderBoardBuilder("medium")).createPointer().getCellPosition();
        assertEquals(19, cellPosition.getX());
        assertEquals(15, cellPosition.getY());
    }

    @Test
    void testCreateWalls1() {
        List<Wall> actualCreateWallsResult = (new LoaderBoardBuilder("easy")).createWalls();
        assertEquals(48, actualCreateWallsResult.size());
        Wall getResult = actualCreateWallsResult.get(5);
        assertEquals("side", getResult.getLocation());
        Wall getResult1 = actualCreateWallsResult.get(42);
        assertEquals("topBottom", getResult1.getLocation());
        Wall getResult2 = actualCreateWallsResult.get(4);
        assertEquals("side", getResult2.getLocation());
        Wall getResult3 = actualCreateWallsResult.get(1);
        assertEquals("Edge", getResult3.getLocation());
        Wall getResult4 = actualCreateWallsResult.get(0);
        assertEquals("Edge", getResult4.getLocation());
        Wall getResult5 = actualCreateWallsResult.get(47);
        assertEquals("topBottom", getResult5.getLocation());
        Wall getResult6 = actualCreateWallsResult.get(44);
        assertEquals("topBottom", getResult6.getLocation());
        Wall getResult7 = actualCreateWallsResult.get(3);
        assertEquals("Edge", getResult7.getLocation());
        Wall getResult8 = actualCreateWallsResult.get(43);
        assertEquals("topBottom", getResult8.getLocation());
        Wall getResult9 = actualCreateWallsResult.get(2);
        assertEquals("Edge", getResult9.getLocation());
        Wall getResult10 = actualCreateWallsResult.get(45);
        assertEquals("topBottom", getResult10.getLocation());
        Wall getResult11 = actualCreateWallsResult.get(46);
        assertEquals("topBottom", getResult11.getLocation());
        Position cellPosition = getResult3.getCellPosition();
        assertEquals(21, cellPosition.getY());
        Position cellPosition1 = getResult7.getCellPosition();
        assertEquals(21, cellPosition1.getY());
        assertEquals(25, cellPosition1.getX());
        assertEquals(12, cellPosition.getX());
        Position cellPosition2 = getResult4.getCellPosition();
        assertEquals(12, cellPosition2.getX());
        Position cellPosition3 = getResult6.getCellPosition();
        assertEquals(23, cellPosition3.getX());
        Position cellPosition4 = getResult8.getCellPosition();
        assertEquals(21, cellPosition4.getY());
        Position cellPosition5 = getResult1.getCellPosition();
        assertEquals(22, cellPosition5.getX());
        Position cellPosition6 = getResult.getCellPosition();
        assertEquals(11, cellPosition6.getY());
        assertEquals(10, cellPosition5.getY());
        assertEquals(10, cellPosition2.getY());
        assertEquals(22, cellPosition4.getX());
        Position cellPosition7 = getResult11.getCellPosition();
        assertEquals(24, cellPosition7.getX());
        assertEquals(10, cellPosition7.getY());
        Position cellPosition8 = getResult10.getCellPosition();
        assertEquals(21, cellPosition8.getY());
        Position cellPosition9 = getResult2.getCellPosition();
        assertEquals(11, cellPosition9.getY());
        Position cellPosition10 = getResult9.getCellPosition();
        assertEquals(10, cellPosition10.getY());
        assertEquals(25, cellPosition6.getX());
        Position cellPosition11 = getResult5.getCellPosition();
        assertEquals(21, cellPosition11.getY());
        assertEquals(25, cellPosition10.getX());
        assertEquals(23, cellPosition8.getX());
        assertEquals(10, cellPosition3.getY());
        assertEquals(24, cellPosition11.getX());
        assertEquals(12, cellPosition9.getX());
    }

    @Test
    void testCreateWalls2() {
        List<Wall> actualCreateWallsResult = (new LoaderBoardBuilder("hard")).createWalls();
        assertEquals(100, actualCreateWallsResult.size());
        Wall getResult = actualCreateWallsResult.get(5);
        assertEquals("side", getResult.getLocation());
        Wall getResult1 = actualCreateWallsResult.get(94);
        assertEquals("topBottom", getResult1.getLocation());
        Wall getResult2 = actualCreateWallsResult.get(4);
        assertEquals("side", getResult2.getLocation());
        Wall getResult3 = actualCreateWallsResult.get(1);
        assertEquals("Edge", getResult3.getLocation());
        Wall getResult4 = actualCreateWallsResult.get(0);
        assertEquals("Edge", getResult4.getLocation());
        Wall getResult5 = actualCreateWallsResult.get(99);
        assertEquals("topBottom", getResult5.getLocation());
        Wall getResult6 = actualCreateWallsResult.get(96);
        assertEquals("topBottom", getResult6.getLocation());
        Wall getResult7 = actualCreateWallsResult.get(3);
        assertEquals("Edge", getResult7.getLocation());
        Wall getResult8 = actualCreateWallsResult.get(95);
        assertEquals("topBottom", getResult8.getLocation());
        Wall getResult9 = actualCreateWallsResult.get(2);
        assertEquals("Edge", getResult9.getLocation());
        Wall getResult10 = actualCreateWallsResult.get(97);
        assertEquals("topBottom", getResult10.getLocation());
        Wall getResult11 = actualCreateWallsResult.get(98);
        assertEquals("topBottom", getResult11.getLocation());
        Position cellPosition = getResult3.getCellPosition();
        assertEquals(23, cellPosition.getY());
        Position cellPosition1 = getResult7.getCellPosition();
        assertEquals(23, cellPosition1.getY());
        assertEquals(35, cellPosition1.getX());
        assertEquals(2, cellPosition.getX());
        Position cellPosition2 = getResult4.getCellPosition();
        assertEquals(2, cellPosition2.getX());
        Position cellPosition3 = getResult6.getCellPosition();
        assertEquals(33, cellPosition3.getX());
        Position cellPosition4 = getResult8.getCellPosition();
        assertEquals(23, cellPosition4.getY());
        Position cellPosition5 = getResult1.getCellPosition();
        assertEquals(Integer.SIZE, cellPosition5.getX());
        Position cellPosition6 = getResult.getCellPosition();
        assertEquals(7, cellPosition6.getY());
        assertEquals(6, cellPosition5.getY());
        assertEquals(6, cellPosition2.getY());
        assertEquals(Integer.SIZE, cellPosition4.getX());
        Position cellPosition7 = getResult11.getCellPosition();
        assertEquals(34, cellPosition7.getX());
        assertEquals(6, cellPosition7.getY());
        Position cellPosition8 = getResult10.getCellPosition();
        assertEquals(23, cellPosition8.getY());
        Position cellPosition9 = getResult2.getCellPosition();
        assertEquals(7, cellPosition9.getY());
        Position cellPosition10 = getResult9.getCellPosition();
        assertEquals(6, cellPosition10.getY());
        assertEquals(35, cellPosition6.getX());
        Position cellPosition11 = getResult5.getCellPosition();
        assertEquals(23, cellPosition11.getY());
        assertEquals(35, cellPosition10.getX());
        assertEquals(33, cellPosition8.getX());
        assertEquals(6, cellPosition3.getY());
        assertEquals(34, cellPosition11.getX());
        assertEquals(2, cellPosition9.getX());
    }

    @Test
    void testCreateWalls3() {
        List<Wall> actualCreateWallsResult = (new LoaderBoardBuilder("medium")).createWalls();
        assertEquals(72, actualCreateWallsResult.size());
        Wall getResult = actualCreateWallsResult.get(5);
        assertEquals("side", getResult.getLocation());
        Wall getResult1 = actualCreateWallsResult.get(66);
        assertEquals("topBottom", getResult1.getLocation());
        Wall getResult2 = actualCreateWallsResult.get(4);
        assertEquals("side", getResult2.getLocation());
        Wall getResult3 = actualCreateWallsResult.get(1);
        assertEquals("Edge", getResult3.getLocation());
        Wall getResult4 = actualCreateWallsResult.get(0);
        assertEquals("Edge", getResult4.getLocation());
        Wall getResult5 = actualCreateWallsResult.get(71);
        assertEquals("topBottom", getResult5.getLocation());
        Wall getResult6 = actualCreateWallsResult.get(68);
        assertEquals("topBottom", getResult6.getLocation());
        Wall getResult7 = actualCreateWallsResult.get(3);
        assertEquals("Edge", getResult7.getLocation());
        Wall getResult8 = actualCreateWallsResult.get(67);
        assertEquals("topBottom", getResult8.getLocation());
        Wall getResult9 = actualCreateWallsResult.get(2);
        assertEquals("Edge", getResult9.getLocation());
        Wall getResult10 = actualCreateWallsResult.get(69);
        assertEquals("topBottom", getResult10.getLocation());
        Wall getResult11 = actualCreateWallsResult.get(70);
        assertEquals("topBottom", getResult11.getLocation());
        Position cellPosition = getResult3.getCellPosition();
        assertEquals(23, cellPosition.getY());
        Position cellPosition1 = getResult7.getCellPosition();
        assertEquals(23, cellPosition1.getY());
        assertEquals(28, cellPosition1.getX());
        assertEquals(9, cellPosition.getX());
        Position cellPosition2 = getResult4.getCellPosition();
        assertEquals(9, cellPosition2.getX());
        Position cellPosition3 = getResult6.getCellPosition();
        assertEquals(26, cellPosition3.getX());
        Position cellPosition4 = getResult8.getCellPosition();
        assertEquals(23, cellPosition4.getY());
        Position cellPosition5 = getResult1.getCellPosition();
        assertEquals(25, cellPosition5.getX());
        Position cellPosition6 = getResult.getCellPosition();
        assertEquals(7, cellPosition6.getY());
        assertEquals(6, cellPosition5.getY());
        assertEquals(6, cellPosition2.getY());
        assertEquals(25, cellPosition4.getX());
        Position cellPosition7 = getResult11.getCellPosition();
        assertEquals(27, cellPosition7.getX());
        assertEquals(6, cellPosition7.getY());
        Position cellPosition8 = getResult10.getCellPosition();
        assertEquals(23, cellPosition8.getY());
        Position cellPosition9 = getResult2.getCellPosition();
        assertEquals(7, cellPosition9.getY());
        Position cellPosition10 = getResult9.getCellPosition();
        assertEquals(6, cellPosition10.getY());
        assertEquals(28, cellPosition6.getX());
        Position cellPosition11 = getResult5.getCellPosition();
        assertEquals(23, cellPosition11.getY());
        assertEquals(28, cellPosition10.getX());
        assertEquals(26, cellPosition8.getX());
        assertEquals(6, cellPosition3.getY());
        assertEquals(27, cellPosition11.getX());
        assertEquals(9, cellPosition9.getX());
    }

    @Test
    void testCreateEmptyCells() {
        assertTrue((new LoaderBoardBuilder("Empty")).createEmptyCells().isEmpty());
    }
}
