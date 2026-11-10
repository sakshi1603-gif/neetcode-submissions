class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char num = board[i][j];

                if (num == '.') {
                    continue;
                }

                String row = num + " in row " + i;
                String col = num + " in col " + j;

                int boxIndex = (i / 3) * 3 + (j / 3);
                String box = num + " in box " + boxIndex;

                if (!seen.add(row) ||
                    !seen.add(col) ||
                    !seen.add(box)) {
                    return false;
                }
            }
        }

        return true;
    }
}