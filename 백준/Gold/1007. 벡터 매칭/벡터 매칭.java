import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] used;
    static int[][] points;
    static double ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            used = new boolean[N];
            points = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            ans = 10_000_000;
            bt(0, -1);
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }

    private static void bt(int depth, int prev) {
        if (depth == N / 2) {
            solve();
            return;
        }

        for (int i = prev + 1; i < N; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            bt(depth + 1, i);
            used[i] = false;
        }
    }

    private static void solve() {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        for (int i = 0; i < N; i++) {
            if (used[i]) {
                x1 += points[i][0];
                y1 += points[i][1];
            } else {
                x2 += points[i][0];
                y2 += points[i][1];
            }
        }

        double temp = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        if (ans > temp) {
            ans = temp;
        }
    }
}
