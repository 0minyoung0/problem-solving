import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][][] dis = new int[6][N][M];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dis[i][j], -1);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = row.charAt(j);
                map[i][j] = c;
                if (c == 'D') {
                    queue.offer(new int[] { 5, i, j });
                    dis[5][i][j] = 0;
                }
            }
        }

        // (동, 서, 남, 북)
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        // (위, 동, 서, 남, 북, 아래)가 구멍일때 (동, 서, 남, 북) 방향으로 이동 시 구멍 위치
        int[][] dd = { { 1, 2, 3, 4 }, { 5, 0, 1, 1 }, { 0, 5, 2, 2 }, { 3, 3, 5, 0 }, { 4, 4, 0, 5 }, { 2, 1, 4, 3 } };

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[1] + dx[dir];
                int ny = cur[2] + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#') {
                    continue;
                }

                int nextDis = dis[cur[0]][cur[1]][cur[2]] + 1;
                int holeDir = dd[cur[0]][dir];
                if (map[nx][ny] == 'R') {
                    if (holeDir == 5) {
                        System.out.println(nextDis);
                        return;
                    }
                    continue;
                }
                if (dis[holeDir][nx][ny] != -1) {
                    continue;
                }
                queue.offer(new int[] { holeDir, nx, ny });
                dis[holeDir][nx][ny] = nextDis;
            }
        }

        System.out.println(-1);
    }
}