import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 지도의 세로 크기와 가로 크기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 섬을 -1로 저장
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (st.nextToken().equals("1")) {
                    map[i][j] = -1;
                }
            }
        }

        // BFS 돌면서 섬의 번호 매기기
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int islandNum = 0;
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != -1) {
                    continue;
                }
                map[i][j] = ++islandNum;
                q.offer(new int[]{i, j});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                            continue;
                        }
                        if (map[nx][ny] != -1) {
                            continue;
                        }
                        map[nx][ny] = islandNum;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        // 건설 가능한 다리 정보 전부 저장하기
        int[][] bridges = new int[islandNum + 1][islandNum + 1];
        for (int i = 1; i <= islandNum; i++) {
            Arrays.fill(bridges[i], 10000);
        }
        // 가로로 스캔
        for (int row = 0; row < N; row++) {
            int recentCol = -1;
            for (int col = 0; col < M; col++) {
                // 섬이 아닌 경우
                if (map[row][col] == 0) {
                    continue;
                }
                // 처음으로 발견한 섬이거나 기존과 같은 섬인 경우거나 다리 길이가 1인 경우
                if (recentCol == -1 || map[row][recentCol] == map[row][col]
                        || col - recentCol == 2) {
                    recentCol = col;
                    continue;
                }
                // 기존의 다리 거리보다 짧다면 갱신
                if (bridges[map[row][recentCol]][map[row][col]] > col - recentCol - 1) {
                    bridges[map[row][recentCol]][map[row][col]] = col - recentCol - 1;
                    bridges[map[row][col]][map[row][recentCol]] = col - recentCol - 1;
                }
                recentCol = col;
            }
        }
        // 세로로 스캔
        for (int col = 0; col < M; col++) {
            int recentRow = -1;
            for (int row = 0; row < N; row++) {
                // 섬이 아닌 경우
                if (map[row][col] == 0) {
                    continue;
                }
                // 처음으로 발견한 섬이거나 기존과 같은 섬인 경우거나 다리 길이가 1인 경우
                if (recentRow == -1 || map[recentRow][col] == map[row][col]
                        || row - recentRow == 2) {
                    recentRow = row;
                    continue;
                }
                // 기존의 다리 거리보다 짧다면 갱신
                if (bridges[map[recentRow][col]][map[row][col]] > row - recentRow - 1) {
                    bridges[map[recentRow][col]][map[row][col]] = row - recentRow - 1;
                    bridges[map[row][col]][map[recentRow][col]] = row - recentRow - 1;
                }
                recentRow = row;
            }
        }

        // 다리 정보를 인접리스트 꼴로 변환
        List<int[]> edges = new ArrayList<>();
        for (int i = 1; i <= islandNum; i++) {
            for (int j = i + 1; j <= islandNum; j++) {
                if (bridges[i][j] == 10000) {
                    continue;
                }
                edges.add(new int[]{bridges[i][j], i, j});
            }
        }
        edges.sort((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            return o1[2] - o2[2];
        });

        // 크루스칼 알고리즘
        parent = new int[islandNum + 1];
        for (int i = 1; i <= islandNum; i++) {
            parent[i] = i;
        }
        int cnt = 0;
        int ans = 0;
        for (int[] edge : edges) {
            // 부모 배열이 같으면 continue
            if (!union(edge[1], edge[2])) {
                continue;
            }

            // 부모 배열이 달랐는데 같아졌으면 ans에 값 계산
            cnt++;
            ans += edge[0];
        }

        if (cnt != islandNum - 1) {
            ans = -1;
        }

        // 답 출력
        System.out.print(ans);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        }

        parent[Math.max(x, y)] = Math.min(x, y);
        return true;
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}