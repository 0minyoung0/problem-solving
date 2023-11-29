import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<int[]>[] graph;
    static long ans;

    public static void main(String[] args) throws IOException {
        init();
        simulation();
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
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(new int[] {i, B});
            graph[B].add(new int[] {i, A});
        }
    }

    private static void simulation() {
        boolean[] vis = new boolean[N+1];
        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[0] < o2[0]) return -1;
                if (o1[0] > o2[0]) return 1;
                if (o1[1] < o2[1]) return -1;
                if (o1[1] > o2[1]) return 1;
                return 0;
            }
        });
        pq.offer(new long[] {0, 1});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            if (vis[(int)cur[1]]) continue;
            ans = cur[0];
            if (cur[1] == N) break;
            vis[(int)cur[1]] = true;
            for (int[] nx : graph[(int)cur[1]]) {
                if (vis[nx[1]]) continue;
                long nxTime = ans / M * M + nx[0] + 1;
                if (nxTime <= ans) nxTime += M;
                pq.offer(new long[] {nxTime, nx[1]});
            }
        }
    }

    private static void printAns() {
        System.out.print(ans);
    }
}