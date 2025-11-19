import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long P = 1;
        for (int i = 2; i <= 20; i++) {
            P = LCM(P, i);
        }

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long[] ans = new long[N];

            int[] V = new int[M];
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                V[j] = Integer.parseInt(st.nextToken());
                for (int i = 0; i < N; i++) {
                    int A = Integer.parseInt(st.nextToken());
                    ans[i] += P / V[j] * A;
                }
            }

            long max = 0;
            long min = Long.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (max < ans[i]) {
                    max = ans[i];
                }
                if (min > ans[i]) {
                    min = ans[i];
                }
            }
            long gcd = GCD(max - min, P);
            long X = (max - min) / gcd;
            long Y = P / gcd;

            if (Y == 1) {
                sb.append(X).append('\n');
            } else {
                sb.append(X).append('/').append(Y).append('\n');
            }
        }
        System.out.print(sb);
    }

    private static long LCM(long x, long y) {
        return x * y / GCD(x, y);
    }

    private static long GCD(long x, long y) {
        if (x < y) {
            return GCD(y, x);
        }
        if (y == 0) {
            return x;
        }
        return GCD(y, x % y);
    }
}
