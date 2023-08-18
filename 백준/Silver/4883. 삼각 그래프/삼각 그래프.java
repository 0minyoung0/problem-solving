import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase = 1;

        while (true) {

            // 행의 개수
            int N = Integer.parseInt(br.readLine());

            if (N == 0) return;

            // dp
            int[][] dp = new int[N+1][3];
            st = new StringTokenizer(br.readLine());
            dp[1][0] = Integer.parseInt(st.nextToken()) + 10000000;
            dp[1][1] = Integer.parseInt(st.nextToken());
            dp[1][2] = dp[1][1] + Integer.parseInt(st.nextToken());

            for (int i=2; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                dp[i][0] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][0], dp[i-1][1]);
                dp[i][1] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][0], Math.min(dp[i-1][1], Math.min(dp[i-1][2], dp[i][0])));
                dp[i][2] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][1], Math.min(dp[i-1][2], dp[i][1]));
            }

            // 답 출력
            System.out.println((testcase++) + ". " + dp[N][1]);
        }
    }
}
