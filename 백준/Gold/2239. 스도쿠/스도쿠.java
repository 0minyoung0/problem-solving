import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] board = new char[9][9];
    static boolean find;
    static boolean[][] rowUsed = new boolean[9][9];
    static boolean[][] colUsed = new boolean[9][9];
    static boolean[][] subUsed = new boolean[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '0') {
                    rowUsed[i][board[i][j] - '1'] = true;
                    colUsed[j][board[i][j] - '1'] = true;
                    subUsed[(i / 3) * 3 + (j / 3)][board[i][j] - '1'] = true;
                }
            }
        }

        dfs(0);
    }

    private static void dfs(int k) {
        if (find) {
            return;
        }
        if (k == 81) {
            for (int i = 0; i < 9; i++) {
                System.out.println(board[i]);
            }
            find = true;
            return;
        }
        int row = k / 9;
        int col = k % 9;
        if (board[row][col] == '0') {
            int sub = (row / 3) * 3 + (col / 3);
            for (char val = '1'; val <= '9'; val++) {
                if (rowUsed[row][val - '1'] || colUsed[col][val - '1'] || subUsed[sub][val - '1']) {
                    continue;
                }
                board[row][col] = val;
                rowUsed[row][val - '1'] = true;
                colUsed[col][val - '1'] = true;
                subUsed[sub][val - '1'] = true;
                dfs(k + 1);
                board[row][col] = '0';
                rowUsed[row][val - '1'] = false;
                colUsed[col][val - '1'] = false;
                subUsed[sub][val - '1'] = false;
            }
        } else {
            dfs(k + 1);
        }
    }
}
