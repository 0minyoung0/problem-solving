import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] cost = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][M][3];
        for (int j = 0; j < M; j++) {
            Arrays.fill(dp[0][j], cost[0][j]);
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 왼쪽
                if (j != M - 1) {
                    dp[i][j][0] = cost[i][j] + Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]);
                }
                dp[i][M - 1][0] = Integer.MAX_VALUE;
                // 가운데
                dp[i][j][1] = cost[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
                // 오른쪽
                if (j != 0) {
                    dp[i][j][2] = cost[i][j] + Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]);
                }
                dp[i][0][2] = Integer.MAX_VALUE;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                if (ans > dp[N - 1][j][k]) {
                    ans = dp[N - 1][j][k];
                }
            }
        }
        System.out.println(ans);
    }
}