import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 행렬의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 행렬의 크기 data
        int[][] data = new int[N][2];
        for (int[] rc : data) {
            st = new StringTokenizer(br.readLine());
            rc[0] = Integer.parseInt(st.nextToken());
            rc[1] = Integer.parseInt(st.nextToken());
        }

        // dp 행렬
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }

        // dp 갱신
        for (int size = 1; size < N; size++) {
            for (int start = 0; start + size < N; start++) {
                for (int i = start; i < start + size; i++) {
                    dp[start][start + size] = Math.min(dp[start][i] + dp[i + 1][start + size]
                                    + data[start][0] * data[i][1] * data[start + size][1],
                            dp[start][start + size]);
                }
            }
        }

        // 답 출력
        System.out.print(dp[0][N - 1]);
    }
}
