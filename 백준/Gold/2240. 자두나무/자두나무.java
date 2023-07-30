import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 특정 시간에 떨어지는 자두의 위치 저장
        int[] pos = new int[T + 1];
        for (int t = 1; t <= T; t++) {
            pos[t] = Integer.parseInt(br.readLine());
        }

        // [움직인횟수][시간]
        int[][] dp = new int[W + 1][T + 1];

        // 1번 나무에서 안움직인 경우 초기화
        for (int t = 1; t <= T; t++) {
            if (pos[t] == 1) {
                dp[0][t] = dp[0][t - 1] + 1;
            } else {
                dp[0][t] = dp[0][t - 1];
            }
        }

        // 움직인 횟수 별로 순차적으로 갱신
        for (int w = 1; w <= W; w++) {

            // 각 시간마다 순차적으로 갱신
            for (int t = 1; t <= T; t++) {

                // 자두가 떨어지는 위치에 있는 경우
                if (pos[t] % 2 != w % 2) {
                    dp[w][t] = Math.max(dp[w][t - 1], dp[w - 1][t - 1]) + 1;
                }
                // 자두가 떨어지는 위치에 있지 않은 경우
                else {
                    dp[w][t] = Math.max(dp[w][t - 1], dp[w - 1][t - 1]);
                }
            }
        }

        // 답 출력
        int ans = 1;
        for (int w = 0; w <= W; w++) {
            if (ans < dp[w][T]) ans = dp[w][T];
        }
        System.out.print(ans);
    }
}