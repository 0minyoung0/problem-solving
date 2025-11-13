import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int totalLength = 0;
            List<Integer> sticks = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int Si = Integer.parseInt(st.nextToken());

                if (Si == 1) {
                    K--;
                } else {
                    totalLength += Si;
                    sticks.add(Si);
                }
            }

            if (K <= 0) {
                sb.append("0\n");
                continue;
            }

            long[] dp = new long[totalLength + 1];
            Arrays.fill(dp, Long.MAX_VALUE);
            dp[0] = 0;
            for (int L : sticks) {
                long cost = (long) a * (L - 1) * (L - 1) + b;

                for (int idx = totalLength - L; idx >= 0; idx--) {
                    if (dp[idx] == Long.MAX_VALUE) {
                        continue;
                    }
                    long temp = dp[idx] + cost;
                    if (dp[idx + L] > temp) {
                        dp[idx + L] = temp;
                    }
                }
            }

            long ans = Long.MAX_VALUE;
            for (int idx = K; idx <= totalLength; idx++) {
                if (ans > dp[idx]) {
                    ans = dp[idx];
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
