import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] isInvalid = new boolean[2][N];
        for (int i = 0; i < 2; i++) {
            String map = br.readLine();
            for (int j = 0; j < N; j++) {
                if (map.charAt(j) == '0') {
                    isInvalid[i][j] = true;
                }
            }
        }

        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { 1, -1, k, k };

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0, 0 });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx < 0 || nx > 1 || ny < 0) {
                    continue;
                }
                if (ny >= N) {
                    System.out.println(1);
                    return;
                }
                if (isInvalid[nx][ny] || cur[2] >= ny) {
                    continue;
                }

                isInvalid[nx][ny] = true;
                q.offer(new int[] { nx, ny, cur[2] + 1 });
            }
        }

        System.out.println(0);
    }
}