import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] cost = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(cost[i], 100_000_000);
            cost[i][i] = 0;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (cost[u][v] > h) {
                cost[u][v] = h;
            }
        }

        // 플로이드 워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (cost[i][j] > Math.max(cost[i][k], cost[k][j])) {
                        cost[i][j] = Math.max(cost[i][k], cost[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (cost[s][e] != 100_000_000) {
                sb.append(cost[s][e]).append("\n");
            } else {
                sb.append("-1\n");
            }
        }
        System.out.print(sb);
    }
}