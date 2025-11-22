import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] X;
    static List<Integer> Y;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                set.add(i);
                set.add(-i);
            }

            st = new StringTokenizer(br.readLine());
            X = new int[N];
            for (int i = 0; i < N; i++) {
                X[i] = Integer.parseInt(st.nextToken());
                set.remove(X[i]);
            }
            Y = new ArrayList<>(set);

            dp = new long[1 << N][N + 1];
            for (int i = 0; i < (1 << N); i++) {
                Arrays.fill(dp[i], -1);
            }

            sb.append(solve(0, 0, 0)).append('\n');
        }
        System.out.print(sb);
    }

    private static long solve(int maskState, int sumState, int depth) {
        if (depth == N) {
            return sumState == M ? 1 : 0;
        }
        if (sumState > M) {
            return 0;
        }
        if (dp[maskState][sumState] != -1) {
            return dp[maskState][sumState];
        }

        long res = 0;
        for (int i = 0; i < N; i++) {
            if ((maskState & (1 << i)) > 0) {
                continue;
            }

            int x = X[depth];
            int y = Y.get(i);
            int sumDiff = 0;

            if (x * y < 0 || Math.abs(x) > Math.abs(y)) {
                sumDiff++;
            }

            int newMaskState = maskState | (1 << i);
            int newSumState = sumState + sumDiff;
            res += solve(newMaskState, newSumState, depth + 1);
        }
        dp[maskState][sumState] = res;
        return res;
    }
}
