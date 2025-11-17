import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        int[][][] dp = new int[K][4][4];
        int[][] attacked = new int[4][4];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(attacked[i], -1);
        }
        for (int turn = 0; turn < K; turn++) {
            st = new StringTokenizer(br.readLine());
            char d = st.nextToken().charAt(0);
            int s = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if (d == 'U') {
                int k = s;
                for (int j = 0; j < r; j++) {
                    attacked[j][k] = Math.max(attacked[j][k], turn + p - 1);
                }
            } else if (d == 'D') {
                int k = s;
                for (int j = 3; j >= 4 - r; j--) {
                    attacked[j][k] = Math.max(attacked[j][k], turn + p - 1);
                }
            } else if (d == 'L') {
                int j = s;
                for (int k = 0; k < r; k++) {
                    attacked[j][k] = Math.max(attacked[j][k], turn + p - 1);
                }
            } else { // d == 'R'
                int j = s;
                for (int k = 3; k >= 4 - r; k--) {
                    attacked[j][k] = Math.max(attacked[j][k], turn + p - 1);
                }
            }

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (attacked[j][k] >= turn) {
                        dp[turn][j][k] = 1;
                    }
                    if (turn > 0) {
                        int prev = dp[turn - 1][j][k];
                        if (j > 0) {
                            prev = Math.min(prev, dp[turn - 1][j - 1][k]);
                        }
                        if (j < 3) {
                            prev = Math.min(prev, dp[turn - 1][j + 1][k]);
                        }
                        if (k > 0) {
                            prev = Math.min(prev, dp[turn - 1][j][k - 1]);
                        }
                        if (k < 3) {
                            prev = Math.min(prev, dp[turn - 1][j][k + 1]);
                        }
                        dp[turn][j][k] += prev;
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int temp = dp[K - 1][i][j];
                if (ans > temp) {
                    ans = temp;
                }
            }
        }
        System.out.println(ans);
    }
}
