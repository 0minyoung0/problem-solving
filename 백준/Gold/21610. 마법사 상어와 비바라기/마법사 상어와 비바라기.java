import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] A;
    static int[][] move;

    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    static Queue<int[]> cloud = new ArrayDeque<>();
    static boolean[][] used;

    public static void main(String[] args) throws IOException {
        init();
        simulation();
        printAns();
    }
//    private static void print(String title) {
//        System.out.println(title);
//        for (int i=0; i<N; i++) {
//            for (int j=0; j<N; j++) {
//                System.out.printf("%4d", A[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
    private static void printAns() {
        int ans = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (A[i][j] > 0) {
                    ans += A[i][j];
                }
            }
        }
        System.out.print(ans);
    }
    private static void makeCloud() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (used[i][j]) continue;
                if (A[i][j] >= 2) {
                    cloud.offer(new int[] {i, j});
                    A[i][j] -= 2;
                }
            }
        }
    }
    private static void magic() {
        while (!cloud.isEmpty()) {
            int[] cur = cloud.poll();
            int water = 0;
            for (int dir=2; dir<9; dir+=2) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (A[nx][ny] > 0) water++;
            }
            if (water > 0) A[cur[0]][cur[1]] += water;
        }
    }
    private static void moveAndRain(int turn) {
        used = new boolean[N][N];
        int size = cloud.size();
        while (size-- > 0) {
            int[] cur = cloud.poll();
            int nx = (cur[0] + dx[move[turn][0]] * move[turn][1] + 50 * N) % N;
            int ny = (cur[1] + dy[move[turn][0]] * move[turn][1] + 50 * N) % N;
            A[nx][ny] += 1;
            used[nx][ny] = true;
            cloud.offer(new int[] {nx, ny});
        }
    }
    private static void simulation() {
        for (int i=0; i<M; i++) {
//            print("비 오기 전");
            moveAndRain(i);
//            print("비 온 뒤");
            magic();
//            print("물복사 마법");
            makeCloud();
        }
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for (int[] line : A) {
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                line[i] = Integer.parseInt(st.nextToken());
            }
        }
        move = new int[M][2];
        for (int[] line : move) {
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<2; i++) {
                line[i] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=N-2; i<N; i++) {
            for (int j=0; j<2; j++) {
                cloud.offer(new int[] {i, j});
            }
        }
    }
}
