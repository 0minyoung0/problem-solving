import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 격자의 개수, 색상의 개수, 점수
    static int N, M, score;
    // 격자의 칸에 들어있는 블록의 정보
    static int[][] blocks;
    // 일반블록 방문체크 배열
    static boolean[][] vis;
    // BFS에 사용할 큐
    static Queue<int[]> q = new ArrayDeque<>();
    // 무지개 블록 임시 저장할 큐
    static Queue<int[]> rq = new ArrayDeque<>();
    // 선택된 블록그룹
    static int[] blockGroup;

    public static void main(String[] args) throws IOException {
        init();
        findGroup();
        while (blockGroup[0] >= 2) {
//            print("그룹삭제이전");
            removeGroup();
//            print("그룹삭제이후");
            gravity();
//            print("중력적용1");
            turn();
//            print("돌리기");
            gravity();
//            print("중력적용2");
            findGroup();
        }
        System.out.print(score);
    }
//    private static void print(String title) {
//        System.out.println(title + " score:" + score);
//        for (int i=0; i<N; i++) {
//            for (int j=0; j<N; j++) {
//                if (blocks[i][j] >= 0) System.out.printf(" %2s ", blocks[i][j]);
//                else if (blocks[i][j] == -2) System.out.print("    ");
//                else System.out.print("  X ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
    private static void turn() {
        int[][] temp = new int[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                temp[i][j] = blocks[j][N - i - 1];
            }
        }
        blocks = temp;
    }
    private static void gravity() {
        for (int col=0; col<N; col++) {
            int bottom = N - 1;
            for (int cur = N - 1; cur >= 0; cur--) {
                if (blocks[cur][col] == -2) {
                    continue;
                }
                else if (blocks[cur][col] == -1) {
                    bottom = cur - 1;
                }
                else if (cur != bottom) {
                    blocks[bottom][col] = blocks[cur][col];
                    blocks[cur][col] = -2;
                    bottom--;
                }
                else {
                    bottom--;
                }
            }
        }
    }
    private static void removeGroup() {
        score += blockGroup[0] * blockGroup[0];
        boolean[][] chk = new boolean[N][N];
        int curColor = blocks[blockGroup[2]][blockGroup[3]];
        q.offer(new int[] {blockGroup[2], blockGroup[3]});
        chk[blockGroup[2]][blockGroup[3]] = true;
        blocks[blockGroup[2]][blockGroup[3]] = -2;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir=0; dir<4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || chk[nx][ny]) continue;
                if (blocks[nx][ny] == 0 || blocks[nx][ny] == curColor) {
                    q.offer(new int[] {nx, ny});
                    chk[nx][ny] = true;
                    blocks[nx][ny] = -2;
                }
            }
        }
    }
    private static void findGroup() {
        blockGroup = new int[] {1, 0, 0, 0};
        vis = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                // 이미 방문한 블록 continue
                if (vis[i][j]) continue;
                // 일반 블록이 아닌 경우 continue
                if (blocks[i][j] <= 0) continue;
                // 블록 그룹 크기
                int groupSize = 1;
                // 블록 그룹에 포함된 무지개 블록
                int rainbowCnt = 0;
                // 현재 블록 색상
                int curColor = blocks[i][j];
                // 기준 블록 좌표
                int[] standardBlock = new int[] {i, j};
                q.offer(new int[] {i, j});
                vis[i][j] = true;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int dir=0; dir<4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N || vis[nx][ny]) continue;
                        if (blocks[nx][ny] == 0 || blocks[nx][ny] == curColor) {
                            q.offer(new int[] {nx, ny});
                            vis[nx][ny] = true;
                            groupSize++;
                            if (blocks[nx][ny] == 0) {
                                rq.offer(new int[]{nx, ny});
                                rainbowCnt++;
                            }
                            else if (nx < standardBlock[0] || (nx == standardBlock[0] && ny < standardBlock[1])) {
                                standardBlock[0] = nx;
                                standardBlock[1] = ny;
                            }
                        }
                    }
                }
                while (!rq.isEmpty()) {
                    int[] cur = rq.poll();
                    vis[cur[0]][cur[1]] = false;
                }
                if ((groupSize >= 2 && groupSize > blockGroup[0])
                || (groupSize == blockGroup[0] && rainbowCnt > blockGroup[1])
                || (groupSize == blockGroup[0] && rainbowCnt == blockGroup[1] && standardBlock[0] > blockGroup[2])
                || (groupSize == blockGroup[0] && rainbowCnt == blockGroup[1] && standardBlock[0] == blockGroup[2] && standardBlock[1] > blockGroup[3])) {
                    blockGroup[0] = groupSize;
                    blockGroup[1] = rainbowCnt;
                    blockGroup[2] = standardBlock[0];
                    blockGroup[3] = standardBlock[1];
                }
            }
        }
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        blocks = new int[N][N];
        for (int[] line : blocks) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                line[i] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
