public class NQueens {
    public static void main(String[] args) {
        int n = 4;//Try for 5 too
        boolean[][] board = new boolean[n][n];
        int solutions = queens(board, 0);
        System.out.println("Total solutions: " + solutions);
    }

    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            return 1;
        }

        int count = 0;

        // Placing the queen and checking for every column in the current row
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true; // Place the queen
                count += queens(board, row + 1); // Recurse to the next row
                board[row][col] = false; // Backtrack
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Check vertical column
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // Check diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // Check diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
