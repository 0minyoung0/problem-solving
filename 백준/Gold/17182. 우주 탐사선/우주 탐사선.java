import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] T;
    static boolean[] vis;
    static int ans = 10000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 행성의 개수
        N = Integer.parseInt(st.nextToken());
        // ana호가 발사되는 행성의 위치
        int K = Integer.parseInt(st.nextToken());

        // 각 행성간 이동시간
        T = new int[N][N];
        for (int[] t : T) {
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                t[i] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드-워셜 알고리즘
        for (int k=0; k<N; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (T[i][j] > T[i][k] + T[k][j]) {
                        T[i][j] = T[i][k] + T[k][j];
                    }
                }
            }
        }

        vis = new boolean[N];
        vis[K] = true;

        dfs(1, K, 0);

        System.out.print(ans);
    }
    private static void dfs(int level, int pre, int cost) {
        if (level == N) {
            if (ans > cost) {
                ans = cost;
            }
            return;
        }
        for (int i=0; i<N; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            dfs(level + 1, i, cost + T[pre][i]);
            vis[i] = false;
        }
    }
}