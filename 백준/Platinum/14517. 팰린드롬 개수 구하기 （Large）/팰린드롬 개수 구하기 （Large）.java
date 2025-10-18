import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String S = br.readLine();

        int[][] dp = new int[S.length()][S.length()];

        for (int i = 0; i < S.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) != S.charAt(i + 1)) {
                dp[i][i + 1] = 2;
            } else {
                dp[i][i + 1] = 3;
            }
        }

        for (int length = 2; length < S.length(); length++) {
            for (int i = 0; i + length < S.length(); i++) {
                int j = i + length;
                dp[i][j] = dp[i + 1][j] + dp[i][j - 1];

                if (S.charAt(i) != S.charAt(j)) {
                    dp[i][j] -= dp[i + 1][j - 1];
                } else {
                    dp[i][j] += 1;
                }
                dp[i][j] %= 10_007;
                dp[i][j] += 10_007;
                dp[i][j] %= 10_007;
            }
        }

        System.out.println(dp[0][S.length() - 1]);
    }
}
