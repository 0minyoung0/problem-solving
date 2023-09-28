import java.io.*;
import java.util.*;

public class Main {
    static long[][] campus = {
                    {0, 1, 1, 0, 0, 0, 0, 0},
                    {1, 0, 1, 1, 0, 0, 0, 0},
                    {1, 1, 0, 1, 1, 0, 0, 0},
                    {0, 1, 1, 0, 1, 1, 0, 0},
                    {0, 0, 1, 1, 0, 1, 1, 0},
                    {0, 0, 0, 1, 1, 0, 0, 1},
                    {0, 0, 0, 0, 1, 0, 0, 1},
                    {0, 0, 0, 0, 0, 1, 1, 0}};
    final static int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int D = Integer.parseInt(br.readLine());

        // 답 출력
        long[][] ans = matrixPower(D);
        System.out.print(ans[0][0]);
    }
    private static long[][] matrixPower(int n) {
        if (n == 1) {
            return campus;
        }

        long[][] r = matrixPower(n/2);
        if (n % 2 == 0) {
            return matrixMultiple(r, r);
        }else {
            return matrixMultiple(matrixMultiple(r, r), campus);
        }
    }
    private static long[][] matrixMultiple(long[][] a, long[][] b) {
        long[][] result = new long[8][8];
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                for (int k=0; k<8; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return result;
    }
}
