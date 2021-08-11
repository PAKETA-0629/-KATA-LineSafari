import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleTests {

    // "Good" examples from the Kata description.

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

    // "Bad" examples from the Kata description.

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
