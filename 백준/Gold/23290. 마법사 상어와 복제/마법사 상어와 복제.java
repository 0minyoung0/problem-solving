import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int M, S;
    static int[][][] map = new int[4][4][8];
    static int curX, curY;

    static int[][][] duplArr = new int[4][4][8];
    static int[][] smell = new int[4][4];

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int ans;

    public static void main(String[] args) throws IOException {
        init();
        practice();
        printAns();
    }
//    private static void print(String title, int turn) {
//        System.out.println(title);
//        System.out.println("현재 턴: " + turn);
//        System.out.println("물고기 수: " + ans);
//        System.out.println("상어 좌표: " + curX + "," + curY);
//        for (int i=0; i<4; i++) {
//            for (int j=0; j<4; j++) {
//                for (int k=0; k<8; k++) {
//                    System.out.print(map[i][j][k] + " ");
//                }
//                System.out.print("(" + smell[i][j] +")    ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        ans = M;
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken()) - 1;
            int fy = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            map[fx][fy][d]++;
        }
        st = new StringTokenizer(br.readLine());
        curX = Integer.parseInt(st.nextToken()) - 1;
        curY = Integer.parseInt(st.nextToken()) - 1;
    }
    private static void practice() {
        for (int i=1; i<=S; i++) {
            startDupl();
//            print("물고기 이동 전", i);
            moveFishes();
//            print("물고기 이동 후", i);
            moveShark(i);
//            print("상어 이동 후", i);
            removeSmell(i);
            executeDupl();
//            print("복사 후", i);
        }
    }
    private static void startDupl() {
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                 duplArr[i][j] = Arrays.copyOf(map[i][j], 8);
            }
        }
    }
    private static void moveFishes() {
        int[][][] temp = new int[4][4][8];
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                next: for (int k=0; k<8; k++) {
                    if (map[i][j][k] == 0) continue;
                    for (int l=0; l<8; l++) {
                        int nx = i + dx[(k-l+8)%8];
                        int ny = j + dy[(k-l+8)%8];
                        if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && (nx != curX || ny != curY) && smell[nx][ny] == 0) {
                            temp[nx][ny][(k-l+8)%8] += map[i][j][k];
                            continue next;
                        }
                    }
                    temp[i][j][k] += map[i][j][k];
                }
            }
        }
        map = temp;
    }
    private static void moveShark(int turn) {
        boolean[][] vis = new boolean[4][4];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int max = -1;
        int temp = 0;
        int[] dir = new int[] {-1, -1, -1};
        for (int i=0; i<4; i++) {
            if (curX + dx[i] < 0 || curX + dx[i] >= 4 || curY + dy[i] < 0 || curY + dy[i] >= 4) continue;
            int nx = curX + dx[i];
            int ny = curY + dy[i];
            vis[nx][ny] = true;
            for (int d=0; d<8; d++) {
                temp += map[nx][ny][d];
            }
            for (int j=0; j<4; j++) {
                if (nx + dx[j] < 0 || nx + dx[j] >= 4 || ny + dy[j] < 0 || ny + dy[j] >= 4) continue;
                nx += dx[j];
                ny += dy[j];
                vis[nx][ny] = true;
                for (int d=0; d<8; d++) {
                    temp += map[nx][ny][d];
                }
                for (int k=0; k<4; k++) {
                    if (nx + dx[k] < 0 || nx + dx[k] >= 4 || ny + dy[k] < 0 || ny + dy[k] >= 4) continue;
                    nx += dx[k];
                    ny += dy[k];
                    if (!vis[nx][ny]) {
                        for (int d = 0; d < 8; d++) {
                            temp += map[nx][ny][d];
                        }
                    }
                    if (max < temp) {
                        dir = new int[] {i, j, k};
                        max = temp;
                    }
                    if (!vis[nx][ny]) {
                        for (int d = 0; d < 8; d++) {
                            temp -= map[nx][ny][d];
                        }
                    }
                    nx -= dx[k];
                    ny -= dy[k];
                }
                for (int d=0; d<8; d++) {
                    temp -= map[nx][ny][d];
                }
                vis[nx][ny] = false;
                nx -= dx[j];
                ny -= dy[j];
            }
            for (int d=0; d<8; d++) {
                temp -= map[nx][ny][d];
            }
            vis[nx][ny] = false;
        }
        for (int i=0; i<3; i++) {
            curX += dx[dir[i]];
            curY += dy[dir[i]];
            for (int j=0; j<8; j++) {
                if (map[curX][curY][j] != 0) {
                    map[curX][curY][j] = 0;
                    if (smell[curX][curY] != turn) smell[curX][curY] = turn;
                }
            }
        }
        ans -= max;
    }
    private static void removeSmell(int turn) {
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if (smell[i][j] > 0 && smell[i][j] == turn - 2) smell[i][j] = 0;
            }
        }
    }
    private static void executeDupl() {
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                for (int k=0; k<8; k++) {
                    if (duplArr[i][j][k] == 0) continue;
                    map[i][j][k] += duplArr[i][j][k];
                    ans += duplArr[i][j][k];
                }
            }
        }
    }
    private static void printAns() {
        System.out.print(ans);
    }
}