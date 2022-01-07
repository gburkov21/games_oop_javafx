package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int cell = 0; cell < board[row].length; cell++) {
                if (board[row][cell] == 1) {
                    if (checkRowOrColumn(board[row])) {
                        return true;
                    } else {
                        int[] columnForCheck = new int[board.length];
                        for (int i = 0; i < columnForCheck.length; i++) {
                            columnForCheck[i] = board[i][cell];
                        }
                        if (checkRowOrColumn(columnForCheck)) {
                            return true;
                        }
                    }
                    break;
                }
            }
        }
        return false;
    }

    public static boolean checkRowOrColumn(int[] row) {
        for (int value : row) {
            if (value == 0) {
                return false;
            }
        }
        return true;
    }
}
