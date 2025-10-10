import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_003;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()) - 1;
        int E = Integer.parseInt(st.nextToken()) - 1;
        int T = Integer.parseInt(st.nextToken());

        int[][] A = new int[5 * N][5 * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                A[5 * i + j + 1][5 * i + j] = 1;
            }
        }
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                if (c == '0') {
                    continue;
                }
                int num = c - '0';
                A[5 * i][5 * j + num - 1] = 1;
            }
        }

        int[][] ans = matrixPow(A, T);
        System.out.println(ans[5 * S][5 * E]);
    }

    private static int[][] matrixMultiple(int[][] x, int[][] y) {
        if (x[0].length != y.length) {
            throw new Error("행렬 곱셈 불가능");
        }

        int[][] res = new int[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < x[0].length; k++) {
                    res[i][j] += (long) x[i][k] * y[k][j] % MOD;
                    res[i][j] %= MOD;
                }
                res[i][j] += MOD;
                res[i][j] %= MOD;
            }
        }
        return res;
    }

    private static int[][] matrixPow(int[][] x, int y) {
        if (x.length != x[0].length) {
            throw new Error("행렬 제곱 불가능");
        }

        if (y == 0) {
            int[][] e = new int[x.length][x.length];
            for (int i = 0; i < x.length; i++) {
                e[i][i] = 1;
            }
            return e;
        }

        int[][] r = matrixPow(x, y / 2);
        int[][] rSquare = matrixMultiple(r, r);
        if (y % 2 == 0) {
            return rSquare;
        }
        return matrixMultiple(x, rSquare);
    }
}
