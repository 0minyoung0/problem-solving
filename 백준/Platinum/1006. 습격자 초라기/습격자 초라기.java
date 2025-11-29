import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int[][] circletagon = new int[N][2];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    circletagon[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (N == 1) {
                sb.append(circletagon[0][0] + circletagon[0][1] <= W ? 1 : 2).append('\n');
                continue;
            }

            int[][] dp = new int[N + 1][3];
            dp[0][1] = 1;
            dp[0][2] = 1;
            for (int i = 1; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1] + 1, dp[i - 1][2] + 1);
                if (circletagon[i - 1][0] + circletagon[i - 1][1] <= W) {
                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] + 1);
                }
                if (i >= 2 && circletagon[i - 2][0] + circletagon[i - 1][0] <= W
                        && circletagon[i - 2][1] + circletagon[i - 1][1] <= W) {
                    dp[i][0] = Math.min(dp[i][0], dp[i - 2][0] + 2);
                }

                if (i == N) {
                    break;
                }

                dp[i][1] = dp[i][0] + 1;
                if (circletagon[i - 1][0] + circletagon[i][0] <= W) {
                    dp[i][1] = Math.min(dp[i][1], dp[i - 1][2] + 1);
                }

                dp[i][2] = dp[i][0] + 1;
                if (circletagon[i - 1][1] + circletagon[i][1] <= W) {
                    dp[i][2] = Math.min(dp[i][2], dp[i - 1][1] + 1);
                }
            }
            int ans = dp[N][0];

            if (circletagon[0][0] + circletagon[N - 1][0] <= W) {
                dp[0][0] = MAX;
                dp[0][1] = 1;
                dp[0][2] = MAX;

                for (int i = 1; i <= N; i++) {
                    dp[i][0] = Math.min(dp[i - 1][1] + 1, dp[i - 1][2] + 1);
                    if (circletagon[i - 1][0] + circletagon[i - 1][1] <= W) {
                        dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] + 1);
                    }
                    if (i >= 2 && circletagon[i - 2][0] + circletagon[i - 1][0] <= W
                            && circletagon[i - 2][1] + circletagon[i - 1][1] <= W) {
                        dp[i][0] = Math.min(dp[i][0], dp[i - 2][0] + 2);
                    }

                    if (i == N) {
                        break;
                    }

                    dp[i][1] = dp[i][0] + 1;
                    if (circletagon[i - 1][0] + circletagon[i][0] <= W) {
                        dp[i][1] = Math.min(dp[i][1], dp[i - 1][2] + 1);
                    }

                    dp[i][2] = dp[i][0] + 1;
                    if (circletagon[i - 1][1] + circletagon[i][1] <= W) {
                        dp[i][2] = Math.min(dp[i][2], dp[i - 1][1] + 1);
                    }
                }
                ans = Math.min(ans, dp[N - 1][2]);
            }

            if (circletagon[0][1] + circletagon[N - 1][1] <= W) {
                dp[0][0] = MAX;
                dp[0][1] = MAX;
                dp[0][2] = 1;

                for (int i = 1; i <= N; i++) {
                    dp[i][0] = Math.min(dp[i - 1][1] + 1, dp[i - 1][2] + 1);
                    if (circletagon[i - 1][0] + circletagon[i - 1][1] <= W) {
                        dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] + 1);
                    }
                    if (i >= 2 && circletagon[i - 2][0] + circletagon[i - 1][0] <= W
                            && circletagon[i - 2][1] + circletagon[i - 1][1] <= W) {
                        dp[i][0] = Math.min(dp[i][0], dp[i - 2][0] + 2);
                    }

                    if (i == N) {
                        break;
                    }

                    dp[i][1] = dp[i][0] + 1;
                    if (circletagon[i - 1][0] + circletagon[i][0] <= W) {
                        dp[i][1] = Math.min(dp[i][1], dp[i - 1][2] + 1);
                    }

                    dp[i][2] = dp[i][0] + 1;
                    if (circletagon[i - 1][1] + circletagon[i][1] <= W) {
                        dp[i][2] = Math.min(dp[i][2], dp[i - 1][1] + 1);
                    }
                }
                ans = Math.min(ans, dp[N - 1][1]);
            }

            if (circletagon[0][0] + circletagon[N - 1][0] <= W && circletagon[0][1] + circletagon[N - 1][1] <= W) {
                dp[1][0] = 2;
                dp[1][1] = 3;
                dp[1][2] = 3;

                for (int i = 2; i <= N; i++) {
                    dp[i][0] = Math.min(dp[i - 1][1] + 1, dp[i - 1][2] + 1);
                    if (circletagon[i - 1][0] + circletagon[i - 1][1] <= W) {
                        dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] + 1);
                    }
                    if (i >= 2 && circletagon[i - 2][0] + circletagon[i - 1][0] <= W
                            && circletagon[i - 2][1] + circletagon[i - 1][1] <= W) {
                        dp[i][0] = Math.min(dp[i][0], dp[i - 2][0] + 2);
                    }

                    if (i == N) {
                        break;
                    }

                    dp[i][1] = dp[i][0] + 1;
                    if (circletagon[i - 1][0] + circletagon[i][0] <= W) {
                        dp[i][1] = Math.min(dp[i][1], dp[i - 1][2] + 1);
                    }

                    dp[i][2] = dp[i][0] + 1;
                    if (circletagon[i - 1][1] + circletagon[i][1] <= W) {
                        dp[i][2] = Math.min(dp[i][2], dp[i - 1][1] + 1);
                    }
                }
                ans = Math.min(ans, dp[N - 1][0]);
            }
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
