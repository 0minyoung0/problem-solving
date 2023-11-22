import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        dp = new int[N][K+1];
        for (int i=0; i<N; i++) {
            for (int j=0; j<=K; j++) {
                dp[i][j] = -1;
            }
        }
    }
    private static void solution() {
        solveDp(N-1, K);
        solveDp(N-3, K-1);
        System.out.print((dp[N-1][K] + dp[N-3][K-1]) % 1_000_000_003);
    }
    private static void solveDp(int n, int k) {
        if (dp[n][k] != -1) return;
        if (n < k) dp[n][k] = 0;
        else if (n == 0 || n == 1 || k == 0) dp[n][k] = 1;
        else {
            solveDp(n-1, k);
            solveDp(n-2, k-1);
            dp[n][k] = (dp[n-1][k] + dp[n-2][k-1]) % 1_000_000_003;
        }
    }
}