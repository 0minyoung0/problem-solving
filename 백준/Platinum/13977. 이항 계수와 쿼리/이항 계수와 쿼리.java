import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long[] factorial = new long[4_000_001];
        factorial[0] = 1;
        for (int i = 1; i <= 4_000_000; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            long ans = factorial[N];

            long temp = pow(factorial[K] * factorial[N - K] % MOD, MOD - 2);

            ans *= temp;
            ans %= MOD;

            System.out.println(ans);
        }
    }

    private static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long x = pow(a, b / 2);
        long temp = x * x % MOD;
        if (b % 2 == 0) {
            return temp;
        }
        return a * temp % MOD;
    }
}
