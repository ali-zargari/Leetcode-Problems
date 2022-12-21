import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create a HashSet for each row, column, and box
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        // Initialize the HashSets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Iterate over the elements in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];

                // Check if the element is a valid character (1-9 or '.')
                if (c != '.') {
                    // Check if the element is already in the same row, column, or box
                    if (rows[i].contains(c) || cols[j].contains(c) || boxes[(i / 3) * 3 + j / 3].contains(c)) {
                        return false;
                    }

                    // Add the element to the appropriate HashSets
                    rows[i].add(c);
                    cols[j].add(c);
                    boxes[(i / 3) * 3 + j / 3].add(c);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        Solution s = new Solution();
        System.out.println(s.isValidSudoku(board));
    }
}
