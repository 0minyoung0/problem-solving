import java.io.*;
import java.util.*;

public class Main {
    static long[][] combi;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        combi = new long[M + 1][M + 1];
        combi[0][0] = 1;
        for (int i = 1; i <= M; i++) {
            combi[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                combi[i][j] = (combi[i - 1][j] + combi[i - 1][j - 1]) % M;
            }
        }

        sb.append(combination(N, K));

        System.out.print(sb);
    }

    private static long combination(long n, long k) {
        if (n < k) {
            return 0;
        }
        long ret = 1;
        while (n > 0 || k > 0) {
            ret *= combi[(int) (n % M)][(int) (k % M)];
            ret %= M;
            n /= M;
            k /= M;
        }
        return ret;
    }
}
