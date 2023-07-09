import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 지도의 크기 n과 m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 목표 지점 좌표
        int[] target = new int[2];

        // 땅 정보 입력
        boolean[][] reachable = new boolean[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {

                String ground = st.nextToken();
                if (!ground.equals("0")) {
                    reachable[i][j] = true;

                    if (ground.equals("2")) {
                        target[0] = i;
                        target[1] = j;
                    }
                }
            }
        }
        
        // BFS를 위한 세팅
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(target);
        int[][] dis = new int[n][m];
        dis[target[0]][target[1]] = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 목표 지점에서부터 BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir=0; dir<4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || dis[nx][ny] > 0 || !reachable[nx][ny]) continue;
                q.offer(new int[] {nx, ny});
                dis[nx][ny] = dis[cur[0]][cur[1]] + 1;
            }
        }

        // 답 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!reachable[i][j]) sb.append("0 ");
                else if (dis[i][j] > 0) sb.append(dis[i][j] - 1).append(" ");
                else sb.append("-1 ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
