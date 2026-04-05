import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                list.add(new int[] { p, w });
            }
            Collections.sort(list, (x, y) -> x[0] - y[0]);

            // 누적합
            int[][] prefixSum = new int[N][N];
            for (int i = 0; i < N; i++) {
                prefixSum[i][i] = list.get(i)[1];
                for (int j = i + 1; j < N; j++) {
                    prefixSum[i][j] = prefixSum[i][j - 1] + list.get(j)[1];
                }
            }
            int totalSum = prefixSum[0][N - 1];

            long[][][] dp = new long[N][N][2];
            for (int i = 0; i < N; i++) {
                long min = (long) list.get(i)[0] * list.get(i)[0];
                long optimalX = totalSum / 2;
                long teleportCost = Math.abs(optimalX - Math.abs(list.get(i)[0])) * totalSum + optimalX * optimalX;
                if (min > teleportCost) {
                    min = teleportCost;
                }
                dp[i][i][0] = dp[i][i][1] = min;
            }

            for (int length = 1; length <= N - 1; length++) {
                for (int i = 0; i + length < N; i++) {
                    int j = i + length;

                    long p = totalSum - prefixSum[i + 1][j];
                    dp[i][j][0] = Math.min(
                            dp[i + 1][j][0] + (list.get(i + 1)[0] - list.get(i)[0]) * p,
                            dp[i + 1][j][1] + (list.get(j)[0] - list.get(i)[0]) * p);
                    p = totalSum - prefixSum[i][j - 1];
                    dp[i][j][1] = Math.min(
                            dp[i][j - 1][1] + (list.get(j)[0] - list.get(j - 1)[0]) * p,
                            dp[i][j - 1][0] + (list.get(j)[0] - list.get(i)[0]) * p);
                }
            }

            System.out.println(Math.min(dp[0][N - 1][0], dp[0][N - 1][1]));
        }
    }
}
