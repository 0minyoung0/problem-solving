import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] start;
    static List<int[]> list;
    static boolean[] visited;
    static int[][] dist;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> c2i = new HashMap<>();
        list = new ArrayList<>();

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') {
                    start = new int[] { i, j };
                    c2i.put(i * M + j, list.size());
                    list.add(new int[] { i, j });
                } else if (map[i][j] == 'K') {
                    c2i.put(i * M + j, list.size());
                    list.add(new int[] { i, j });
                }
            }
        }

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        // list 내의 각 좌표간 거리 계산
        dist = new int[list.size()][list.size()];
        for (int i = 0; i < list.size(); i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            int[][] d = new int[N][M];
            for (int j = 0; j < N; j++) {
                Arrays.fill(d[j], Integer.MAX_VALUE);
            }

            q.offer(list.get(i));
            d[list.get(i)[0]][list.get(i)[1]] = 0;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }
                    if (map[nx][ny] == 'X' || d[nx][ny] != Integer.MAX_VALUE) {
                        continue;
                    }
                    q.offer(new int[] { nx, ny });
                    d[nx][ny] = d[cur[0]][cur[1]] + 1;
                    if (c2i.containsKey(nx * M + ny)) {
                        int j = c2i.get(nx * M + ny);
                        dist[i][j] = d[nx][ny];
                    }
                }
            }
        }

        // 조합 탐색
        visited = new boolean[list.size()];
        visited[c2i.get(start[0] * M + start[1])] = true;
        ans = Integer.MAX_VALUE;
        bt(0, 0, c2i.get(start[0] * M + start[1]));

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);
    }

    private static void bt(int depth, int cost, int pre) {
        if (depth == 5) {
            if (ans > cost) {
                ans = cost;
            }
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (visited[i] || dist[pre][i] == Integer.MAX_VALUE) {
                continue;
            }
            visited[i] = true;
            bt(depth + 1, cost + dist[pre][i], i);
            visited[i] = false;
        }
    }
}
