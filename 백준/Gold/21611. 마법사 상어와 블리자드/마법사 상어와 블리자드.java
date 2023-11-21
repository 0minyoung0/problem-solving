import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ans;
    static int[] map;
    static int[][] magicData;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
        printAns();
    }
//    private static void print(String title) {
//        System.out.println(title);
//        for (int i=0; i<N*N-1; i++) {
//            System.out.print(map[i] + " ");
//        }
//        System.out.println();
//    }
    private static void printAns() {
        System.out.print(ans);
    }
    private static void transpose() {
        int[] newMap = new int[N*N-1];
        int target = 0;
        for (int idx=0; idx<N*N-1; idx++) {
            if (map[idx] == 0) {
                break;
            }
            if (idx > 0 && map[idx] != map[idx-1]) target+=2;
            if (target >= N*N-1) break;
            newMap[target]++;
            if (newMap[target+1] == 0) newMap[target+1] = map[idx];
        }
        map = newMap;
        gravity();
    }
    private static void gravity() {
        int idx = 0;
        for (int i=0; i<N*N-1; i++) {
            if (map[i] != 0) {
                if (idx != i) {
                    map[idx] = map[i];
                    map[i] = 0;
                }
                idx++;
            }
        }
    }
    private static void explosion() {
        boolean isExplosed = true;
        while (isExplosed) {
            isExplosed = false;
            int x = 0;
            int y = 0;
            while (map[y] != 0 && y < N*N-1) {
                if (map[x] == map[y]) {
                    if (x + 3 <= y && (y == N*N-2 || map[y] != map[y+1])) {
                        ans += (y - x + 1) * map[x];
                        for (int i=x; i<=y; i++) {
                            map[i] = 0;
                        }
                        x = y;
                        isExplosed = true;
                    }
                }
                else {
                    x = y;
                }
                y++;
            }
            gravity();
        }
    }
    private static void magic(int turn) {
        int init = 0;
        if (magicData[turn][0] == 2) init = 2;
        else if (magicData[turn][0] == 4) init = 4;
        else if (magicData[turn][0] == 1) init = 6;
        map[init] = 0;
        int diff = init + 9;
        for (int i=1; i<magicData[turn][1]; i++) {
            init += diff;
            map[init] = 0;
            diff += 8;
        }
        gravity();
    }
    private static void simulate() {
        for (int i=0; i<M; i++) {
//            print("마법 전");
            magic(i);
//            print("마법 후");
            explosion();
//            print("폭발 후");
            transpose();
//            print("변형 후");
        }
    }
    private static int[] nextPoint(int[] point) {
        if (point[0] > point[1]) {
            if (point[0] + point[1] < N - 1) return new int[] {point[0] + 1, point[1]};
            else return new int[] {point[0], point[1] + 1};
        }
        else {
            if (point[0] + point[1] > N - 1) return new int[] {point[0] - 1, point[1]};
            else return new int[] {point[0], point[1] - 1};
        }
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] temp = new int[N][N];
        for (int[] line : temp) {
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                line[i] = Integer.parseInt(st.nextToken());
            }
        }
        map = new int[N*N-1];
        int[] cur = new int[] {N/2, N/2};
        for (int i=0; i<N*N-1; i++) {
            cur = nextPoint(cur);
            map[i] = temp[cur[0]][cur[1]];
        }
        magicData = new int[M][2];
        for (int[] line : magicData) {
            st = new StringTokenizer(br.readLine());
            line[0] = Integer.parseInt(st.nextToken());
            line[1] = Integer.parseInt(st.nextToken());
        }
    }
}