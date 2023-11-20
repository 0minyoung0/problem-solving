import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] map;
    static int[][] dir;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        init();
        grouping();
        grouping();
        printAns();
    }
    private static void printAns() {
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                set.add(map[serialize(new int[] {i, j})]);
            }
        }
        System.out.print(set.size());
    }
    private static int[] deserialize(int x) {
        return new int[] {x / M, x % M};
    }
    private static int serialize(int[] p) {
        return p[0] * M + p[1];
    }
    private static int find(int[] p) {
        if (map[serialize(p)] == serialize(p)) return map[serialize(p)];
        return map[serialize(p)] = find(deserialize(map[serialize(p)]));
    }
    private static void union(int[] p1, int[] p2) {
        p1 = deserialize(find(p1));
        p2 = deserialize(find(p2));
        if (p1[0] < p2[0] || (p1[0] == p2[0] && p1[1] < p2[1])) {
            map[serialize(p2)] = serialize(p1);
        }
        else {
            map[serialize(p1)] = serialize(p2);
        }
    }
    private static void grouping() {
        for (int x1=0; x1<N; x1++) {
            for (int y1=0; y1<M; y1++) {
                int x2 = x1 + dx[dir[x1][y1]];
                int y2 = y1 + dy[dir[x1][y1]];
                if (x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) continue;
                union(new int[] {x1, y1}, new int[] {x2, y2});
            }
        }
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N*M];
        dir = new int[N][M];
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<M; j++) {
                map[serialize(new int[] {i, j})] = serialize(new int[] {i, j});
                switch (str.charAt(j)) {
                    case 'U':
                        dir[i][j] = 0;
                        break;
                    case 'D':
                        dir[i][j] = 1;
                        break;
                    case 'L':
                        dir[i][j] = 2;
                        break;
                    case 'R':
                        dir[i][j] = 3;
                        break;
                }
            }
        }
    }
}
