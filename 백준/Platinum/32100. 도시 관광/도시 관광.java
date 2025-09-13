import java.io.*;
import java.util.*;

public class Main {
    static int N, minAns, maxAns;
    static int[][][] D, min, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            D = new int[N][N][N];
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < N; j++) {
                        D[k][i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }
            min = new int[N][(1 << N)][(1 << N)];
            max = new int[N][(1 << N)][(1 << N)];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < (1 << N); j++) {
                    Arrays.fill(min[i][j], 100_000_000);
                    Arrays.fill(max[i][j], -1);
                }
            }

            bt(0, 1, 0);

            if (min[0][1][0] == 100_000_000) {
                System.out.println("0 0");
            } else {
                System.out.println(min[0][1][0] + " " + max[0][1][0]);
            }
        }
    }

    private static void bt(int curCity, int visit, int used) {
        if (min[curCity][visit][used] != 100_000_000) {
            return;
        }

        if (visit == (1 << N) - 1) {
            for (int i = 0; i < N; i++) {
                if ((used & (1 << i)) > 0) {
                    continue;
                }
                if (D[i][curCity][0] != 0) {
                    min[curCity][visit][used] = Math.min(min[curCity][visit][used], D[i][curCity][0]);
                    max[curCity][visit][used] = Math.max(max[curCity][visit][used], D[i][curCity][0]);
                }
            }
            return;
        }

        for (int nextCity = 1; nextCity < N; nextCity++) {
            if ((visit & (1 << nextCity)) > 0) {
                continue;
            }
            for (int nextTran = 0; nextTran < N; nextTran++) {
                if ((used & (1 << nextTran)) > 0) {
                    continue;
                }
                if (D[nextTran][curCity][nextCity] != 0) {
                    bt(nextCity, visit | (1 << nextCity), used | (1 << nextTran));
                    if (min[nextCity][visit | (1 << nextCity)][used | (1 << nextTran)] != 100_000_000) {
                        min[curCity][visit][used] = Math.min(min[curCity][visit][used],
                                min[nextCity][visit | (1 << nextCity)][used | (1 << nextTran)]
                                        + D[nextTran][curCity][nextCity]);
                    }
                    if (max[nextCity][visit | (1 << nextCity)][used | (1 << nextTran)] != -1) {
                        max[curCity][visit][used] = Math.max(max[curCity][visit][used],
                                max[nextCity][visit | (1 << nextCity)][used | (1 << nextTran)]
                                        + D[nextTran][curCity][nextCity]);
                    }
                }
            }
        }
    }
}