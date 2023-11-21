import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] map;
    static int[][] score;
    static int top=1, back=2, right=3, left=4, front=5, bottom=6;
    static int curX, curY, curD;
    static int ans;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        init();
        simulate();
        printAns();
    }
    private static void init() throws IOException {
        getInput();
        calculateScore();
    }
    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int[] line : map) {
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<M; i++) {
                line[i] = Integer.parseInt(st.nextToken());
            }
        }
    }
    private static void calculateScore() {
        score = new int[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<int[]> temp = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (vis[i][j]) continue;
                queue.offer(new int[] {i, j});
                temp.offer(new int[] {i, j});
                vis[i][j] = true;
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for (int dir=0; dir<4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if (vis[nx][ny] || map[cur[0]][cur[1]] != map[nx][ny]) continue;
                        queue.offer(new int[] {nx, ny});
                        temp.offer(new int[] {nx, ny});
                        vis[nx][ny] = true;
                    }
                }
                int cnt = map[i][j] * temp.size();
                while (!temp.isEmpty()) {
                    int[] cur = temp.poll();
                    score[cur[0]][cur[1]] = cnt;
                }
            }
        }
    }
    private static void simulate() {
        for (int i=0; i<K; i++) {
            roll();
            getScore();
            nextDir();
        }
    }
    private static void roll() {
        curX += dx[curD];
        curY += dy[curD];
        int temp = top;
        switch (curD) {
            case 0:
                top = left;
                left = bottom;
                bottom = right;
                right = temp;
                break;
            case 1:
                top = back;
                back = bottom;
                bottom = front;
                front = temp;
                break;
            case 2:
                top = right;
                right = bottom;
                bottom = left;
                left = temp;
                break;
            case 3:
                top = front;
                front = bottom;
                bottom = back;
                back = temp;
                break;
        }
    }
    private static void getScore() {
        ans += score[curX][curY];
    }
    private static void nextDir() {
        if (bottom > map[curX][curY]) curD = (curD + 1) % 4;
        else if (bottom < map[curX][curY]) curD = (curD + 3) % 4;
        int nx = curX + dx[curD];
        int ny = curY + dy[curD];
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) curD = (curD + 2) % 4;
    }
    private static void printAns() {
        System.out.print(ans);
    }
}