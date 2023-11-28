import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer>[] graph;
    static int[] time;
    static int[] parent;
    static Queue<Integer> startNodes = new ArrayDeque<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        }
    });

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new List[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        time = new int[N+1];
        parent = new int[N+1];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            parent[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < parent[i]; j++) {
                graph[Integer.parseInt(st.nextToken())].add(i);
            }
            if (parent[i] == 0) {
                startNodes.add(i);
            }
        }
        for (int startNode : startNodes) {
            pq.offer(new int[] {time[startNode], startNode});
        }
    }
    private static void simulation() {
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (ans < cur[0]) ans = cur[0];
            if (graph[cur[1]].isEmpty()) continue;
            for (int nx : graph[cur[1]]) {
                if (--parent[nx] == 0) {
                    pq.offer(new int[] {cur[0] + time[nx], nx});
                }
            }
        }
        System.out.print(ans);
    }
}