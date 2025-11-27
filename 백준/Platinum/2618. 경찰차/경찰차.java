import java.io.*;
import java.util.*;

public class Main {
    static int W;
    static int[][] dp;
    static int[][] trace;
    static int[][] pos;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        dp = new int[W + 2][W + 2];
        trace = new int[W + 2][W + 2];
        for (int i = 0; i < W + 2; i++) {
            Arrays.fill(dp[i], -1);
        }
        pos = new int[W + 2][2];
        pos[0][0] = pos[0][1] = 1;
        pos[1][0] = pos[1][1] = N;

        for (int i = 2; i < W + 2; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }

        sb.append(func(0, 1)).append('\n');

        int p1 = 0;
        int p2 = 1;
        for (int next = 2; next < W + 2; next++) {
            sb.append(trace[p1][p2]).append('\n');
            if (trace[p1][p2] == 1) {
                p1 = next;
            } else {
                p2 = next;
            }
        }

        System.out.print(sb);
    }

    private static int func(int p1, int p2) {
        if (dp[p1][p2] != -1) {
            return dp[p1][p2];
        }

        int nextPosIndex = Math.max(p1, p2) + 1;

        if (nextPosIndex == W + 2) {
            dp[p1][p2] = 0;
            return 0;
        }

        int p1x = pos[p1][0];
        int p1y = pos[p1][1];
        int p2x = pos[p2][0];
        int p2y = pos[p2][1];
        int pnx = pos[nextPosIndex][0];
        int pny = pos[nextPosIndex][1];

        int n1 = func(nextPosIndex, p2) + Math.abs(p1x - pnx) + Math.abs(p1y - pny);
        int n2 = func(p1, nextPosIndex) + Math.abs(p2x - pnx) + Math.abs(p2y - pny);

        if (n1 < n2) {
            dp[p1][p2] = n1;
            trace[p1][p2] = 1;
        } else {
            dp[p1][p2] = n2;
            trace[p1][p2] = 2;
        }

        return dp[p1][p2];
    }
}