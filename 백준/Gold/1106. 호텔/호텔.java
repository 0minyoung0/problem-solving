import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[C + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customerCount = Integer.parseInt(st.nextToken());
            for (int i = 0; i <= C; i++) {
                if (dp[i] == Integer.MAX_VALUE) {
                    continue;
                }
                if (dp[i + customerCount] > dp[i] + cost) {
                    dp[i + customerCount] = dp[i] + cost;
                }
            }
        }

        int ans = dp[C];
        for (int i = C + 1; i <= C + 100; i++) {
            if (ans > dp[i]) {
                ans = dp[i];
            }
        }
        System.out.print(ans);
    }
}