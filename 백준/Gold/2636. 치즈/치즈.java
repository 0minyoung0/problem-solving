import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로와 가로의 길이
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        // 최근에 치즈조각이 놓여있던 칸의 개수
        int c = 0;

        // 판 위의 상태
        int[][] plate = new int[X][Y];
        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < Y; j++) {
                plate[i][j] = Integer.parseInt(st.nextToken());
                if (plate[i][j] == 1) c++;
            }
        }

        // 다음 녹을 좌표를 담을 quque
        Deque<int[]> deque = new ArrayDeque<>();

        // 방문 배열
        boolean[][] vis = new boolean[X][Y];

        // 시작 좌표
        for (int i = 0; i < X; i++) {
            deque.offer(new int[]{i, 0, -1});
            deque.offer(new int[]{i, Y - 1, -1});
            vis[i][0] = vis[i][Y - 1] = true;
        }
        for (int i = 1; i < Y - 1; i++) {
            deque.offer(new int[]{0, i, -1});
            deque.offer(new int[]{X - 1, i, -1});
            vis[0][i] = vis[X - 1][i] = true;
        }

        // 시뮬레이션 돌리기
        for (int time = -1; ; time++) {

            // 치즈 녹이기
            int dequeSize = deque.size();
            for (int i = 0; i < dequeSize; i++) {
                int[] cur = deque.poll();
                if (plate[cur[0]][cur[1]] == 1) {
                    c--;
                    plate[cur[0]][cur[1]] = 0;
                }
                deque.offer(cur);
            }

            // 다음 시간에 녹을 치즈 구하기
            while (deque.peek()[2] < time) {
                int[] cur = deque.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];
                    if (nx < 0 || nx >= X || ny < 0 || ny >= Y || vis[nx][ny]) continue;
                    vis[nx][ny] = true;
                    if (plate[nx][ny] == 0) deque.offerFirst(new int[]{nx, ny, cur[2]});
                    else deque.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }

            // 다음 시간에 녹을 치즈의 개수가 남은 치즈 개수와 같으면 종료
            if (deque.size() == c) {
                System.out.println(time + 1);
                System.out.println(c);
                return;
            }
        }
    }
}