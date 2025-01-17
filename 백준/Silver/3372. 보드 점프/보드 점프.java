import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        BigInteger[][] dp = new BigInteger[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = BigInteger.ZERO;
            }
        }
        dp[0][0] = BigInteger.ONE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0)
                    continue;
                if (i + num < N)
                    dp[i + num][j] = dp[i + num][j].add(dp[i][j]);
                if (j + num < N)
                    dp[i][j + num] = dp[i][j + num].add(dp[i][j]);
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}
