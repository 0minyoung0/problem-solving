import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static final int[][] A = {
            { 21, 0, -20, 21, 0, -21, 21, 0, -21, 0 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 5, 0, -125, 5, 0, 0, 5, 0, -125, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 3, 9, 0, 3, 9, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
            { 26, 0, -145, 26, 0, -21, 26, 0, -146, 1 }
    };
    static final int[][] A3 = {
            { 15813 }, { 546 }, { 21 }, { 3645 }, { 130 }, { 5 }, { 2262 }, { 78 }, { 0 }, { 20160 }
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(numsMinus(solve(b), solve(a - 1)));
    }

    private static int solve(long size) {
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return 26;
        }
        if (size == 2) {
            return 702;
        }
        if (size == 3) {
            return 20160;
        }

        return arraysMul(arrayPow(A, size - 3), A3)[9][0];
    }

    private static int[][] arrayPow(int[][] x, long y) {
        if (y == 0) {
            int length = x.length;
            int[][] ans = new int[length][length];
            for (int i = 0; i < length; i++) {
                ans[i][i] = 1;
            }
            return ans;
        }

        int[][] sqrt = arrayPow(x, y / 2);
        if (y % 2 == 0) {
            return arraysMul(sqrt, sqrt);
        } else {
            return arraysMul(arraysMul(sqrt, sqrt), x);
        }
    }

    private static int[][] arraysMul(int[][] x, int[][] y) {
        int l = x.length;
        int m = y.length;
        int n = y[0].length;

        int[][] ans = new int[l][n];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    ans[i][j] = numsPlus(ans[i][j], numsMul(x[i][k], y[k][j]));
                }
            }
        }

        return ans;
    }

    private static int numsPlus(int x, int y) {
        return (x + y) % MOD;
    }

    private static int numsMinus(int x, int y) {
        return (x - y + MOD) % MOD;
    }

    private static int numsMul(int x, int y) {
        return (int) ((((long) x * y) % MOD + MOD) % MOD);
    }
}
