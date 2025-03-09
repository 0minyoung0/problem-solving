import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] x = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.parallelSort(x);

            int[][] dp = new int[n + 1][201];
            dp[0][1] = 1;

            for (int i = 1; i <= n; i++) {
                int maxNum = x[i];
                for (int j = 1; j <= maxNum; j++) {
                    dp[i][j] = sum(dp[i - 1][j], dp[i][j - 1]);
                }
            }

            int ans = 0;
            for (int i = 1; i <= x[n]; i++) {
                ans = sum(ans, dp[n][i]);
            }
            ans = mul(ans, n);
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }

    private static int sum(int o1, int o2) {
        return (o1 + o2) % 1_000_000_007;
    }

    private static int mul(int o1, int o2) {
        return (int) (((long) o1 * o2) % 1_000_000_007);
    }
}