import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] p = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }

            int[] f = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                f[i] = Integer.parseInt(st.nextToken());
            }

            int[] d = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            long[][] cost = new long[n + 1][c + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(cost[i], Long.MAX_VALUE);
            }
            cost[0][b] = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= c; j++) {
                    if (cost[i - 1][j] == Long.MAX_VALUE) {
                        continue;
                    }
                    // 충전하기
                    cost[i][Math.min(j + p[i], c)] = Math.min(cost[i][Math.min(j + p[i], c)],
                            cost[i - 1][j] + (long) d[i] * f[i]);
                    // 전기 사용하기
                    if (j < d[i]) {
                        continue;
                    }
                    cost[i][j - d[i]] = Math.min(cost[i][j - d[i]], cost[i - 1][j]);
                }
            }

            long ans = Long.MAX_VALUE;
            for (int i = b; i <= c; i++) {
                if (ans > cost[n][i]) {
                    ans = cost[n][i];
                }
            }
            System.out.println(ans);
        }
    }
}