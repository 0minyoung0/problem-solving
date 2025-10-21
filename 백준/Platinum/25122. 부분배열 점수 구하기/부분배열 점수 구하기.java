import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static long ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] A = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            ans = 0;
            HashSet<Integer> set = new HashSet<>();
            int i = 1;
            for (int j = 1; j <= n; j++) {
                while (set.contains(A[j])) {
                    ans += powSum(i, j - i);
                    ans %= MOD;
                    set.remove(A[i++]);
                }
                ans += powSum(j, j - i + 1);
                ans %= MOD;
                set.add(A[j]);
            }
            while (i <= n) {
                ans += powSum(i, n - i + 1);
                ans %= MOD;
                set.remove(A[i++]);
            }
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }

    // r^2 + ... r^n 계산
    private static long powSum(int r, int n) {
        if (n == 1) {
            return 0;
        }
        if (r == 1) {
            return n - 1;
        }
        return ((pow(r, n + 1) - pow(r, 2)) * pow(r - 1, MOD - 2) % MOD + MOD) % MOD;
    }

    private static long pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        long sqrt = pow(a, b / 2);
        if (b % 2 == 0) {
            return sqrt * sqrt % MOD;
        }
        return sqrt * sqrt % MOD * a % MOD;
    }
}
