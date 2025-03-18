import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static final int INPUT_MAX = 100_000;
    static int[] factorial;
    static int[] inverseFac;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        factorial = new int[2 * INPUT_MAX + 1];
        inverseFac = new int[2 * INPUT_MAX + 1];
        factorial[0] = inverseFac[0] = 1;
        for (int i = 1; i <= 2 * INPUT_MAX; i++) {
            factorial[i] = numsMul(factorial[i - 1], i);
            inverseFac[i] = numsMul(inverseFac[i - 1], inverse(i));
        }

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = numsAdd(ans, numsMul(combi(n + i - 1, i), combi(2 * m - n - i - 1, m - i)));
            }

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }

    private static int combi(int n, int r) {
        return numsMul(factorial[n], numsMul(inverseFac[r], inverseFac[n - r]));
    }

    private static int inverse(int x) {
        return pow(x, MOD - 2);
    }

    private static int pow(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int sqrt = pow(x, y / 2);
        if (y % 2 == 0) {
            return numsMul(sqrt, sqrt);
        } else {
            return numsMul(numsMul(sqrt, sqrt), x);
        }
    }

    private static int numsAdd(int x, int y) {
        return (x + y) % MOD;
    }

    private static int numsMul(int x, int y) {
        return (int) ((long) x * y % MOD);
    }
}