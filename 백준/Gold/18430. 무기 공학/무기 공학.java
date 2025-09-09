import java.io.*;
import java.util.*;

public class Main {
    static int N, M, sum, ans;
    static int[][] strength;
    static boolean[][] used;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        strength = new int[N][M];
        used = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                strength[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bt(0, 0);

        System.out.println(ans);
    }

    private static void bt(int x, int y) {
        if (x == N - 1) {
            if (ans < sum) {
                ans = sum;
            }
            return;
        }

        if (y == M - 1) {
            bt(x + 1, 0);
            return;
        }

        // r
        if (!used[x][y] && !used[x][y + 1] && !used[x + 1][y + 1]) {
            used[x][y] = used[x][y + 1] = used[x + 1][y + 1] = true;
            sum += strength[x][y] + strength[x][y + 1] * 2 + strength[x + 1][y + 1];
            bt(x, y + 1);
            used[x][y] = used[x][y + 1] = used[x + 1][y + 1] = false;
            sum -= strength[x][y] + strength[x][y + 1] * 2 + strength[x + 1][y + 1];
        }

        // J
        if (!used[x][y + 1] && !used[x + 1][y] && !used[x + 1][y + 1]) {
            used[x][y + 1] = used[x + 1][y] = used[x + 1][y + 1] = true;
            sum += strength[x][y + 1] + strength[x + 1][y] + strength[x + 1][y + 1] * 2;
            bt(x, y + 1);
            used[x][y + 1] = used[x + 1][y] = used[x + 1][y + 1] = false;
            sum -= strength[x][y + 1] + strength[x + 1][y] + strength[x + 1][y + 1] * 2;
        }

        // ㄴ
        if (!used[x][y] && !used[x + 1][y] && !used[x + 1][y + 1]) {
            used[x][y] = used[x + 1][y] = used[x + 1][y + 1] = true;
            sum += strength[x][y] + strength[x + 1][y] * 2 + strength[x + 1][y + 1];
            bt(x, y + 1);
            used[x][y] = used[x + 1][y] = used[x + 1][y + 1] = false;
            sum -= strength[x][y] + strength[x + 1][y] * 2 + strength[x + 1][y + 1];
        }

        // r
        if (!used[x][y] && !used[x][y + 1] && !used[x + 1][y]) {
            used[x][y] = used[x][y + 1] = used[x + 1][y] = true;
            sum += strength[x][y] * 2 + strength[x][y + 1] + strength[x + 1][y];
            bt(x, y + 1);
            used[x][y] = used[x][y + 1] = used[x + 1][y] = false;
            sum -= strength[x][y] * 2 + strength[x][y + 1] + strength[x + 1][y];
        }

        // 부메랑 안만들기
        bt(x, y + 1);
    }
}