import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 델타배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 행렬의 크기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 벽 정보
        boolean[][] isWall = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == '1') {
                    isWall[i][j] = true;
                }
            }
        }

        // 각 위치에서 이어진 빈 칸의 개수 저장
        HashMap<Integer, Integer> parent = new HashMap<>();
        HashMap<Integer, Integer> blankCnt = new HashMap<>();
        // BFS를 위한 큐 선언
        Queue<int[]> q = new ArrayDeque<>();
        // BFS 방문 체크 배열
        boolean[][] vis = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (vis[i][j] || isWall[i][j]) {
                    continue;
                }
                parent.put(i * M + j, i * M + j);
                q.offer(new int[]{i, j});
                vis[i][j] = true;
                int cnt = 1;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M || vis[nx][ny]
                                || isWall[nx][ny]) {
                            continue;
                        }
                        parent.put(nx * M + ny, i * M + j);
                        q.offer(new int[]{nx, ny});
                        vis[nx][ny] = true;
                        cnt++;
                    }
                }
                blankCnt.put(i * M + j, cnt);
            }
        }

        // 답 출력
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isWall[i][j]) {
                    int temp = 1;
                    set.clear();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M || isWall[nx][ny]) {
                            continue;
                        }
                        set.add(parent.get(nx * M + ny));
                    }
                    for (int c : set) {
                        temp += blankCnt.get(c);
                    }
                    sb.append(temp % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
