import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer>[] graph;
    static int[][] dp;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        init();
        simulation();
        printAns();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new List[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        dp = new int[N+1][2];
        vis = new boolean[N+1];
    }
    private static void simulation() {
        dfs(1);
    }
    private static void dfs(int node) {
        if (vis[node]) return;
        vis[node] = true;
        if (!graph[node].isEmpty()) {
            for (int child : graph[node]) {
                dfs(child);
            }
            for (int child : graph[node]) {
                dp[node][0] += dp[child][1];
                dp[node][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
        dp[node][1]++;
    }
    private static void printAns() {
        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }
}