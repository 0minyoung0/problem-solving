import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[3] != o2[3] ? o1[3] - o2[3] : o1[2] - o2[2];
            }
        });
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    pq.offer(new int[] { i, j, map[i][j], 0 });
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;
        int Y = Integer.parseInt(st.nextToken()) - 1;

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        while (!pq.isEmpty() && pq.peek()[3] < S) {
            int[] cur = pq.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0) {
                    continue;
                }

                map[nx][ny] = cur[2];
                pq.offer(new int[] { nx, ny, cur[2], cur[3] + 1 });
            }
        }

        System.out.println(map[X][Y]);
    }
}