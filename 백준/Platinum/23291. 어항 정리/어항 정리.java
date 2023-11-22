import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int roll1, roll2;
    static int[][] map;
    static int ans;

    public static void main(String[] args) throws IOException {
        init();
        simulation();
        printAns();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[10][N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            map[9][i] = Integer.parseInt(st.nextToken());
        }
        find: for (int i=1; i<=10; i++) {
            for (int j=0; j<2; j++) {
                if (N < i * (i + j)) {
                    break find;
                }
                roll1 = i;
                roll2 = i + j;
            }
        }
    }
    private static void simulation() {
        while (!checkFinish()) {
            ans++;
            putFishes();
//            print("물고기 투입");
            magic1();
            magic2();
        }
    }
    private static boolean checkFinish() {
        int min = 10000;
        int max = 1;
        for (int i=0; i<N; i++) {
            if (min > map[9][i]) min = map[9][i];
            if (max < map[9][i]) max = map[9][i];
        }
        return max - min <= K;
    }
    private static void putFishes() {
        int min = 10000;
        for (int i=0; i<N; i++) {
            if (min > map[9][i]) min = map[9][i];
        }
        for (int i=0; i<N; i++) {
            if (min == map[9][i]) map[9][i]++;
        }
    }
    private static void magic1() {
        stack1();
//        print("어항 쌓기 1");
        moveFishes();
//        print("물고기 옮기기 1");
        clean();
//        print("clean 1");
    }
    private static void stack1() {
        int i=1;
        int j=1;
        int x=0;
        while (i != roll1 || j != roll2) {
            roll(x, i, j);
            x += i;
            if (i != j) i++;
            else j++;
        }
    }
    private static void roll(int x, int A, int B) {
        // (9, x) 부터 (9 - B + 1, x + A - 1)까지를 오른쪽으로 회전시켜서
        // (9 - A, x + A) 부터 (8, x + A + B - 1)로 옮기기
        for (int i=0; i<A; i++) {
            for (int j=0; j<B; j++) {
                map[8 - i][x + A + B - 1 - j] = map[9 - B + 1 + j][x + A - 1 - i];
                map[9 - B + 1 + j][x + A - 1 - i] = 0;
            }
        }
    }
    private static void magic2() {
        stack2();
//        print("어항 쌓기 2");
        moveFishes();
//        print("물고기 옮기기 2");
        clean();
//        print("clean 2");
    }
    private static void stack2() {
        for (int i=0; i<N/2; i++) {
            map[8][N-1-i] = map[9][i];
            map[9][i] = 0;
        }
        for (int i=N/2; i<N*3/4; i++) {
            for (int j=8; j<10; j++) {
                map[15-j][N*3/2-1-i] = map[j][i];
                map[j][i] = 0;
            }
        }
    }
    private static void moveFishes() {
        int[][] temp = new int[10][N];
        for (int i=0; i<10; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 0) continue;
                if (i != 9 && map[i+1][j] != 0) {
                    temp[i][j] -= (map[i][j] - map[i+1][j]) / 5;
                    temp[i+1][j] -= (map[i+1][j] - map[i][j]) / 5;
                }
                if (j != N - 1 && map[i][j+1] != 0) {
                    temp[i][j] -= (map[i][j] - map[i][j+1]) / 5;
                    temp[i][j+1] -= (map[i][j+1] - map[i][j]) / 5;
                }
            }
        }
        for (int i=0; i<10; i++) {
            for (int j=0; j<N; j++) {
                if (temp[i][j] != 0) map[i][j] += temp[i][j];
            }
        }
    }
    private static void clean() {
        int idx = 0;
        int[] temp = new int[N];
        find: for (int col=0; col<N; col++) {
            if (map[9][col] == 0) continue;
            for (int row=9; row>=0; row--) {
                if (map[row][col] == 0) break;
                temp[idx] = map[row][col];
                map[row][col] = 0;
                if (++idx == N) break find;
            }
        }
        map[9] = temp;
    }
    private static void printAns() {
        System.out.print(ans);
    }
//    private static void print(String title) {
//        System.out.println(title);
//        for (int i=0; i<10; i++) {
//            for (int j=0; j<N; j++) {
//                System.out.printf("%5d ", map[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}