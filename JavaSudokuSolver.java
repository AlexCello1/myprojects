import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        puzzle sud = new puzzle();
        puzzle.solve();
        for(int i = 0; i < puzzle.grid.length; i++) {
            System.out.println(Arrays.toString(puzzle.grid[i]));
        }
    }
    public static class puzzle {
        public static int[][] grid = {
                {0, 0, 3, 0, 0, 9, 0, 8, 0},
                {7, 4, 0, 5, 3, 0, 0, 0, 9},
                {0, 0, 9, 0, 6, 0, 0, 0, 4},
                {8, 1, 7, 3, 4, 0, 9, 2, 0},
                {0, 9, 4, 7, 2, 6, 0, 0, 1},
                {2, 6, 0, 8, 0, 0, 4, 0, 0},
                {0, 7, 0, 0, 1, 0, 0, 0, 0},
                {9, 5, 1, 0, 0, 0, 0, 0, 2},
                {6, 0, 0, 0, 0, 0, 1, 9, 7}
        };

        public static boolean possible(int row, int column, int number) {
            for (int i = 0; i < 9; i++) {
                if (puzzle.grid[row][i] == number) {
                    return false;
                }
            }
            for (int i = 0; i < 9; i++) {
                if (puzzle.grid[i][column] == number) {
                    return false;
                }
            }
            int x0 = (column / 3) * 3;
            int y0 = (row / 3) * 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (puzzle.grid[y0 + i][x0 + j] == number) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static boolean solve() {
            for (int row = 0; row < 9; row++) {
                for (int column = 0; column < 9; column++) {
                    if (puzzle.grid[row][column] == 0) {
                        for (int number = 1; number <= 9; number++) {
                            if (possible(row, column, number)) {
                                puzzle.grid[row][column] = number;
                                if (solve()) {
                                    return true;
                                }
                                puzzle.grid[row][column] = 0;
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
