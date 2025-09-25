import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        int sx = -1, sy = -1, sdir = -1;
        int ex = -1, ey = -1;

        char[][] map = new char[N + 2][M + 2];
        Arrays.fill(map[0], '*');
        Arrays.fill(map[N + 1], '*');
        for (int i = 1; i <= N; i++) {
            map[i][0] = map[i][M + 1] = '*';

            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1);
                if (map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                    if (sx == N) {
                        sdir = 0;
                    } else if (sy == 1) {
                        sdir = 1;
                    } else if (sx == 1) {
                        sdir = 2;
                    } else if (sy == M) {
                        sdir = 3;
                    }
                } else if (map[i][j] == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();

        int lCount = 0;
        q.add(new int[] { sx, sy, sdir });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            if (cx == ex && cy == ey) {
                break;
            }
            int cdir = (cur[2] + 3) % 4; // 좌회전
            while (true) {
                int nx = cx + dx[cdir];
                int ny = cy + dy[cdir];

                if (map[nx][ny] != '*') {
                    break;
                }
                cdir = (cdir + 1) % 4; // 우회전
            }
            q.offer(new int[] { cx + dx[cdir], cy + dy[cdir], cdir });// 전진
            lCount++;
        }

        int rCount = 0;
        q.add(new int[] { sx, sy, sdir });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            if (cx == ex && cy == ey) {
                break;
            }
            int cdir = (cur[2] + 1) % 4; // 우회전
            while (true) {
                int nx = cx + dx[cdir];
                int ny = cy + dy[cdir];

                if (map[nx][ny] != '*') {
                    break;
                }
                cdir = (cdir + 3) % 4; // 좌회전
            }
            q.offer(new int[] { cx + dx[cdir], cy + dy[cdir], cdir });// 전진
            rCount++;
        }

        if (lCount < rCount) {
            System.out.println("LEFT IS BEST");
        } else if (lCount > rCount) {
            System.out.println("RIGHT IS BEST");
        } else {
            System.out.println("SAME");
        }
    }
}