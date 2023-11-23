import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Integer>[] graph;
    static Queue<Integer> q = new ArrayDeque<>();
    static boolean[][] vis;
    static List<Integer> ansList = new ArrayList<>();
    static int max;

    public static void main(String[] args) throws IOException {
        init();
        findAns();
        printAns();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }
        vis = new boolean[N+1][N+1];
    }
    private static void findAns() {
        for (int cur=1; cur<=N; cur++) {
            q.offer(cur);
            vis[cur][cur] = true;
            int temp = 1;
            while (!q.isEmpty()) {
                int c = q.poll();
                for (int nx : graph[c]) {
                    if (vis[cur][nx]) continue;
                    q.offer(nx);
                    vis[cur][nx] = true;
                    temp++;
                }
            }
            if (max <= temp) {
                if (max < temp) {
                    ansList.clear();
                    max = temp;
                }
                ansList.add(cur);
            }
        }
    }
    private static void printAns() {
        StringBuilder sb = new StringBuilder();
        for (int ans : ansList) sb.append(ans).append(" ");
        System.out.print(sb);
    }
}
