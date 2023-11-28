import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<int[]>[] graph;
    static int[] parent;
    static int[] cnt;
    static Queue<Integer> nodes = new ArrayDeque<>();
    static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
        simulation();
        printAns();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new List[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        parent = new int[N+1];
        cnt = new int[N+1];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            graph[X].add(new int[] {Y, K});
            parent[Y]++;
        }
        nodes.offer(N);
        cnt[N] = 1;
    }
    private static void simulation() {
        while (!nodes.isEmpty()) {
            int cur = nodes.poll();
            if (graph[cur].isEmpty()) {
                hm.put(cur, cnt[cur]);
                continue;
            }
            for (int[] nx : graph[cur]) {
                cnt[nx[0]] += cnt[cur] * nx[1];
                if (--parent[nx[0]] == 0) {
                    nodes.offer(nx[0]);
                }
            }
        }
    }
    private static void printAns() {
        List<Integer> keys = new ArrayList<>(hm.keySet());
        Collections.sort(keys);
        for (int key : keys) {
            System.out.println(key + " " + hm.get(key));
        }
    }
}