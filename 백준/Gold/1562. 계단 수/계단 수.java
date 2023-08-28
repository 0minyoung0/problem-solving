import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 길이 N
        int N = Integer.parseInt(br.readLine());

        long[][][] dp = new long[N + 1][10][1024];
        for (int j = 1; j <= 9; j++) {
            dp[1][j][1 << j] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1024; k++) {
                    int newK = k | (1 << j);
                    if (j == 0) {
                        dp[i][j][newK] = (dp[i][j][newK] + dp[i - 1][1][k]) % 1_000_000_000;
                    }
                    else if (j != 9) {
                        dp[i][j][newK] = (dp[i][j][newK] + dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k])% 1_000_000_000;
                    }
                    else { // j == 9
                        dp[i][j][newK] = (dp[i][j][newK] + dp[i - 1][8][k]) % 1_000_000_000;
                    }
                }
            }
        }

        long ans = 0;
        for (int j=0; j<10; j++) {
            ans += dp[N][j][1023];
        }
        ans %= 1_000_000_000;
        System.out.println(ans);
    }
}