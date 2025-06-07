import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] isForest = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                isForest[i][j] = st.nextToken().equals("1");
            }
        }

        int ans = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isForest[i][j]) {
                    queue.add(new int[] { i, j });
                    isForest[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = (cur[0] + dx[dir] + N) % N;
                            int ny = (cur[1] + dy[dir] + M) % M;
                            if (isForest[nx][ny]) {
                                continue;
                            }

                            queue.add(new int[] { nx, ny });
                            isForest[nx][ny] = true;
                        }
                    }
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}