import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static char[][] A;
    static int[][] sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            A = new char[N + 1][N + 1];
            sum = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                String row = br.readLine();
                for (int j = 1; j <= N; j++) {
                    int num = row.charAt(j - 1) - '0';
                    sum[i][j] = num + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                }
            }
            ans = sum[N][N];

            solve(0, 0, N);

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }

    private static void solve(int x, int y, int size) {
        if (size == 1) {
            return;
        }
        int solveSum = getSum(x, y, size);
        int remain = solveSum % 4;

        if (remain == 0) {
            ans -= getSum(x, y, size / 2);
            solve(x, y + size / 2, size / 2);
            solve(x + size / 2, y, size / 2);
            solve(x + size / 2, y + size / 2, size / 2);
        } else if (remain == 1) {
            ans -= getSum(x, y + size / 2, size / 2);
            solve(x, y, size / 2);
            solve(x + size / 2, y, size / 2);
            solve(x + size / 2, y + size / 2, size / 2);
        } else if (remain == 2) {
            ans -= getSum(x + size / 2, y, size / 2);
            solve(x, y, size / 2);
            solve(x, y + size / 2, size / 2);
            solve(x + size / 2, y + size / 2, size / 2);
        } else {
            ans -= getSum(x + size / 2, y + size / 2, size / 2);
            solve(x, y, size / 2);
            solve(x, y + size / 2, size / 2);
            solve(x + size / 2, y, size / 2);
        }
    }

    private static int getSum(int x, int y, int size) {
        return sum[x + size][y + size] - sum[x][y + size] - sum[x + size][y] + sum[x][y];
    }
}
