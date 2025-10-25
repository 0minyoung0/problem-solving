import java.io.*;
import java.util.*;

public class Main {
    static int[] v;
    static List<Integer>[] children;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            v = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                v[i] = Integer.parseInt(st.nextToken());
            }

            int root = -1;
            int[] p = new int[n];
            children = new List[n];
            for (int i = 0; i < n; i++) {
                children[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(st.nextToken()) - 1;
                if (p[i] != -1) {
                    children[p[i]].add(i);
                } else {
                    root = i;
                }
            }

            dp = new long[n][2];
            func(root);

            sb.append(Math.max(dp[root][0], dp[root][1])).append('\n');
        }
        System.out.print(sb);
    }

    private static void func(int node) {
        for (int child : children[node]) {
            func(child);
        }

        boolean isContainsChild = false;
        long minDiff = Long.MAX_VALUE;

        dp[node][0] = v[node];
        for (int child : children[node]) {
            dp[node][0] += dp[child][1];
            if (dp[child][0] >= dp[child][1]) {
                dp[node][1] += dp[child][0];
                isContainsChild = true;
            } else {
                dp[node][1] += dp[child][1];
                minDiff = Math.min(minDiff, dp[child][1] - dp[child][0]);
            }
        }

        if (children[node].size() > 0 && !isContainsChild) {
            dp[node][1] -= minDiff;
        }
    }
}
