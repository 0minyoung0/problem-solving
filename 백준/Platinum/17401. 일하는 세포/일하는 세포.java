import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        long[][][] input = new long[T][N][N];

        for (int i = 0; i < T; i++) {
            int M = Integer.parseInt(br.readLine());
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                input[i][a][b] = c;
            }
        }

        long[][] ans = new long[N][N];
        for (int i = 0; i < N; i++) {
            ans[i][i] = 1;
        }

        if (D / T > 0) {
            for (int i = 0; i < T; i++) {
                ans = matrixMultiple(ans, input[i]);
            }
            ans = matrixPower(ans, D / T);
        }
        for (int i = 0; i < D % T; i++) {
            ans = matrixMultiple(ans, input[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                sb.append('\n');
            }
            for (int j = 0; j < N; j++) {
                if (j > 0) {
                    sb.append(' ');
                }
                sb.append(ans[i][j]);
            }
        }
        System.out.print(sb);
    }

    private static long[][] matrixPower(long[][] a, int b) {
        if (a.length != a[0].length) {
            throw new Error("행렬 제곱 불가");
        }

        if (b == 0) {
            long[][] e = new long[a.length][a.length];
            for (int i = 0; i < a.length; i++) {
                e[i][i] = 1;
            }
            return e;
        }

        long[][] r = matrixPower(a, b / 2);
        long[][] rSquare = matrixMultiple(r, r);
        if (b % 2 == 0) {
            return rSquare;
        }
        return matrixMultiple(rSquare, a);
    }

    private static long[][] matrixMultiple(long[][] a, long[][] b) {
        if (a[0].length != b.length) {
            throw new Error("행렬 곱셈 불가");
        }

        long[][] res = new long[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                    res[i][j] %= MOD;
                }
                res[i][j] += MOD;
                res[i][j] %= MOD;
            }
        }

        return res;
    }
}
