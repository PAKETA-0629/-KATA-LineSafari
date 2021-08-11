public class Dinglemouse {


    public static char[][] grid;
    private static int nextX;
    private static int nextY;
    private static int prevX;
    private static int prevY;


    public static boolean line(final char[][] Grid) {
        grid = new char[Grid.length][Grid[0].length];
        for (int i = 0; i < Grid.length; i++) {
            System.arraycopy(Grid[i], 0, grid[i], 0, Grid[0].length);
        }
        boolean x1 = start(false);

        if (x1 && checkGrid()) return true;
        else {
            grid = Grid;
            return start(true) && checkGrid();
        }
    }


    public static boolean checkGrid() {

        for (char[] chars : grid) {
            for (char ch : chars) {
                if (ch != ' ' && ch != '.') return false;
            }
        }
        return true;
    }


    public static int[] findX(char[][] grid, boolean findSecond, char ch) {
        int[] result = new int[2];

        main:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ch) {
                    if (findSecond) {
                        findSecond = false;
                        continue;
                    }
                    result[0] = i;
                    result[1] = j;
                    break main;
                }
            }
        }
        return result;
    }


    public static boolean checkHorizontal(int x, int y, boolean ignoreCorners) {
        boolean yO = false;
        for (int i = -1; i < 2; i+=2) {
            if ((y + i) < 0 || (y + i) >= grid[0].length) continue;
            if (grid[x][y + i] == '|') yO ^= false;
            else if (grid[x][y + i] == '-' || grid[x][y + i] == 'X' || (grid[x][y + i] == '+' && !ignoreCorners)){
                nextX = x;
                nextY = y + i;
                yO ^= true;
            } else if (grid[x][y + i] == '.') {
                prevX = x;
                prevY = y + i;
            }
        }
        return yO;
    }


    public static boolean checkHorizontal(int x, int y) {
        return  checkHorizontal(x, y, false);
    }


    public static boolean checkVertical(int x, int y, boolean ignoreCorners) {
        boolean xO = false;
        for (int i = -1; i < 2; i+=2) {
            if ((x + i) < 0 || (x + i) >= grid.length) continue;
            if (grid[x + i][y] == '-') xO ^= false;
            else if (grid[x + i][y] == '|' || grid[x + i][y] == 'X' || (grid[x + i][y] == '+' && !ignoreCorners)){
                nextX = x + i;
                nextY = y;
                xO ^= true;
            } else if (grid[x + i][y] == '.') {
                prevX = x + i;
                prevY = y;
            }
        }
        return xO;

    }


    public static boolean checkVertical(int x, int y) {
        return checkVertical(x, y, false);
    }


    public static boolean checkAllSides(int x, int y, boolean ignoreCorners) {
        return checkHorizontal(x, y, ignoreCorners) != checkVertical(x, y, ignoreCorners);
    }


    public static boolean start(boolean secondAttempt) {
        int[] startCor = findX(grid, secondAttempt, 'X');
        return checkNextPosition(startCor[0], startCor[1]);
    }


    public static boolean checkNextPosition(int x, int y) {
        if (grid[x][y] == 'X') {
            if (!checkAllSides(x, y, false)) return false;
        } else if (grid[x][y] == '+') {
            checkAllSides(x, y, false);
            if (x == prevX) {
                if (!checkVertical(x, y)) return false;
            } else {
                if (!checkHorizontal(x, y)) return false;
            }
        } else if (grid[x][y] == '-') {
            if (!checkHorizontal(x, y, false)) return false;
        } else if (grid[x][y] == '|') {
            if (!checkVertical(x, y, false)) return false;
        }

        grid[x][y] = '.';

        if (grid[nextX][nextY] == 'X') {
            grid[nextX][nextY] = '.';
            return true;
        } else if (grid[nextX][nextY] == '+') {
            grid[nextX][nextY] = '.';
            if (x == nextX) {
                if (!checkVertical(nextX, nextY, false)) return false;
            } else {
                if (!checkHorizontal(nextX, nextY, false)) return false;
            }
            if (grid[nextX][nextY] == 'X') {
                grid[nextX][nextY] = ' ';
                return true;
            }
        } else if (grid[nextX][nextY] == '-') {
            if (!checkHorizontal(x, y)) return false;
        } else if (grid[nextX][nextY] == '|') {
            if (!checkVertical(x, y)) return false;
        }

        return checkNextPosition(nextX, nextY);

    }
}