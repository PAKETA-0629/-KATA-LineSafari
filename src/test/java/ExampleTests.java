import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleTests {


    @Test
    public void allGood() {
        exGood1();
        exGood2();
        exGood3();
        exGood4();
        exGood5();

    }


    @Test
    public void allBad() {
        exBad1();
        exBad2();
        exBad3();
        exBad4();
        exBad5();

    }


    @Test
    public void exGood1() {
        final char[][] grid = Preloaded.makeGrid(new String[] {
                "           ",
                "X---------X",
                "           ",
                "           "
        });
        Preloaded.showGrid(grid);
        assertTrue(Dinglemouse.line(grid));
    }


    @Test
    public void exGood2() {
        final char[][] grid = Preloaded.makeGrid(new String[] {
                "     ",
                "  X  ",
                "  |  ",
                "  |  ",
                "  X  "
        });
        Preloaded.showGrid(grid);
        assertTrue(Dinglemouse.line(grid));
    }


    @Test
    public void exGood3() {
        final char[][] grid = Preloaded.makeGrid(new String[] {
                "                    ",
                "     +--------+     ",
                "  X--+        +--+  ",
                "                 |  ",
                "                 X  ",
                "                    "
        });
        Preloaded.showGrid(grid);
        assertTrue(Dinglemouse.line(grid));
    }


    @Test
    public void exGood4() {
        final char[][] grid = Preloaded.makeGrid(new String[] {
                "                     ",
                "    +-------------+  ",
                "    |             |  ",
                " X--+      X------+  ",
                "                     "
        });
        Preloaded.showGrid(grid);
        assertTrue(Dinglemouse.line(grid));
    }


    @Test
    public void exGood5() {
        final char[][] grid = Preloaded.makeGrid(new String[] {
                "                      ",
                "   +-------+          ",
                "   |      +++---+     ",
                "X--+      +-+   X      "
        });
        Preloaded.showGrid(grid);
        assertTrue(Dinglemouse.line(grid));
    }


    @Test
    public void exBad1() {
        final char[][] grid = Preloaded.makeGrid(new String[] {
                "X-----|----X"
        });
        Preloaded.showGrid(grid);
        assertFalse(Dinglemouse.line(grid));
    }


    @Test
    public void exBad2() {
        final char[][] grid = Preloaded.makeGrid(new String[] {
                " X  ",
                " |  ",
                " +  ",
                " X  "
        });
        Preloaded.showGrid(grid);
        assertFalse(Dinglemouse.line(grid));
    }


    @Test
    public void exBad3() {
        final char[][] grid = Preloaded.makeGrid(new String[] {
                "   |--------+    ",
                "X---        ---+ ",
                "               | ",
                "               X "
        });
        Preloaded.showGrid(grid);
        assertFalse(Dinglemouse.line(grid));
    }


    @Test
    public void exBad4() {
        final char[][] grid = Preloaded.makeGrid(new String[] {
                "              ",
                "   +------    ",
                "   |          ",
                "X--+      X   ",
                "              "
        });
        Preloaded.showGrid(grid);
        assertFalse(Dinglemouse.line(grid));
    }


    @Test
    public void exBad5() {
        final char[][] grid = Preloaded.makeGrid(new String[] {
                "      +------+",
                "      |      |",
                "X-----+------+",
                "      |       ",
                "      X       ",
        });
        Preloaded.showGrid(grid);
        assertFalse(Dinglemouse.line(grid));
    }
}
