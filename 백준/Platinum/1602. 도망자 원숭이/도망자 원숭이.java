import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 10_000_000;

    static int N;
    static int[] annoyingTime;
    static int[][] annoyingMax;
    static List<int[]> list = new ArrayList<>();
    static List<Integer>[] graph;
    static int[][] query;
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        init();
        simulation();
        printAns();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        annoyingTime = new int[N + 1];
        annoyingMax = new int[N + 1][N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            annoyingTime[i] = Integer.parseInt(st.nextToken());
            list.add(new int[]{i, annoyingTime[i]});
            annoyingMax[i][i] = annoyingTime[i];
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        ans = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(ans[i], INF);
            ans[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
            ans[a][b] = ans[b][a] = c;
            annoyingMax[a][b] = annoyingMax[b][a] = Math.max(annoyingTime[a], annoyingTime[b]);
        }
        query = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            query[i][0] = Integer.parseInt(st.nextToken());
            query[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    private static void simulation() {
        for (int[] k : list) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (ans[i][j] + annoyingMax[i][j] > ans[i][k[0]] + ans[k[0]][j]
                        + Math.max(annoyingMax[i][k[0]], annoyingMax[k[0]][j])) {
                        ans[i][j] = ans[i][k[0]] + ans[k[0]][j];
                        annoyingMax[i][j] = Math.max(annoyingMax[i][k[0]], annoyingMax[k[0]][j]);
                    }
                }
            }
        }
    }

    private static void printAns() {
        StringBuilder sb = new StringBuilder();
        for (int[] q : query) {
            sb.append(ans[q[0]][q[1]] != INF ? ans[q[0]][q[1]] + annoyingMax[q[0]][q[1]] : -1).append("\n");
        }
        System.out.print(sb);
    }
}