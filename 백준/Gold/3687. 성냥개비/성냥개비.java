import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;
        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                if (j == 6) {
                    dp[i] = Math.min(dp[i], dp[i - j] * 10);
                } else {
                    dp[i] = Math.min(dp[i], dp[i - j] * 10 + dp[j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (TC-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n]).append(' ');
            if (n % 2 == 1) {
                sb.append(7);
            } else {
                sb.append(1);
            }
            for (int i = 0; i < n / 2 - 1; i++) {
                sb.append(1);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}