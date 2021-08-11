public class Preloaded {

    public static char[][] makeGrid(String[] grid) {
        char[][] result = new char[grid.length][grid[0].length()];
        for(int i = 0; i < result.length; i++) {
            result[i] = grid[i].toCharArray();
        }
        return result;
    }


    public static void showGrid(char[][] grid) {
        for (char[] array: grid) {
            for (char ch : array) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
