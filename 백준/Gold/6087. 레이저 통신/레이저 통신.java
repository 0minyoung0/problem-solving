import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 지도의 크기
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        // 시작점, 끝점 좌표
        int[] start = {-1};
        int[] end = {};

        // 지도
        char[][] map = new char[H][];
        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'C') {
                    if (start[0] == -1) {
                        start = new int[]{i, j};
                    } else {
                        end = new int[]{i, j};
                    }
                }
            }
        }

        // 그래프를 인접리스트로 표현
        List<int[]>[][] graph = new List[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }

        // 각 행, 각 열에 대해서 바로 갈 수 있는 칸 연결
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            list.clear();
            for (int j = 0; j < W; j++) {
                // 벽이 아닌 경우
                if (map[i][j] != '*') {
                    for (int[] node : list) {
                        graph[node[0]][node[1]].add(new int[]{i, j});
                        graph[i][j].add(node);
                    }
                    list.add(new int[]{i, j});
                }
                // 벽인 경우
                else { // map[i][j] == '*'
                    list.clear();
                }
            }
        }
        for (int j = 0; j < W; j++) {
            list.clear();
            for (int i = 0; i < H; i++) {
                // 벽이 아닌 경우
                if (map[i][j] != '*') {
                    for (int[] node : list) {
                        graph[node[0]][node[1]].add(new int[]{i, j});
                        graph[i][j].add(node);
                    }
                    list.add(new int[]{i, j});
                }
                // 벽인 경우
                else { // map[i][j] == '*'
                    list.clear();
                }
            }
        }

        // 시작점에서부터 BFS 돌면서 끝점에 도달하기 위한 비용 측정
        int cost = -1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        boolean[][] vis = new boolean[H][W];
        vis[start[0]][start[1]] = true;

        BFS: while (!q.isEmpty()) {
            cost++;
            int qsize = q.size();
            while (qsize-- > 0) {
                int[] cur = q.poll();
                for (int[] next : graph[cur[0]][cur[1]]) {
                    if (vis[next[0]][next[1]]) continue;
                    if (next[0] == end[0] && next[1] == end[1]) break BFS;
                    q.offer(next);
                    vis[next[0]][next[1]] = true;
                }
            }
        }

        // 답 출력
        System.out.print(cost);
    }
}