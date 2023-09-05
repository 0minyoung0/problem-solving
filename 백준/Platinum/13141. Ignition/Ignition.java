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

        if (N == 2) {
            int ans = 0;
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                if (ans < L) ans = L;
            }
            System.out.printf("%.1f", (float)ans);
            return;
        }

        // 최소, 최대 그래프
        int[][] min = new int[N + 1][N + 1];
        int[][] max = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(min[i], 20000);
            min[i][i] = 0;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            if (min[S][E] > L) {
                min[S][E] = L;
                min[E][S] = L;
            }
            if (max[S][E] < L) {
                max[S][E] = L;
                max[E][S] = L;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (min[i][j] > min[i][k] + min[k][j]) {
                        min[i][j] = min[i][k] + min[k][j];
                    }
                }
            }
        }

        int ans = 50000;
        for (int x = 1; x <= N; x++) {
            int temp = 0;
            for (int y = 1; y <= N; y++) {
                if (x == y) continue;
                for (int z = y; z <= N; z++) {
                    if (x == z) continue;
                    if (temp < min[x][y] + min[x][z] + max[y][z]) {
                        temp = min[x][y] + min[x][z] + max[y][z];
                    }
                }
            }
            if (temp != 0 && ans > temp) {
                ans = temp;
            }
        }
        System.out.printf("%.1f", (float) ans / 2);
    }
}