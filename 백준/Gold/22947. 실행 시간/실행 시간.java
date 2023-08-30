import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] time;
    static int[] indegree;
    static int[] outdegree;
    static List<Integer>[] graph;
    static PriorityQueue<int[]> pq;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        indegree = new int[N + 1];
        outdegree = new int[N + 1];

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList();
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            indegree[e]++;
            outdegree[s]++;
        }

        pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        ans = 100_000_000;

        select(0, 1);

        System.out.print(ans);
    }

    private static void select(int k, int pre) {
        if (k == K) {
            simulation();
            return;
        }
        for (int i = pre + 1; i <= N; i++) {
            // 마지막 작업 예외처리
            if (outdegree[i] == 0) {
                continue;
            }
            int temp = time[i];
            time[i] = 0;
            select(k + 1, i);
            time[i] = temp;
        }
    }

    private static void simulation() {
        int[] indegreeCopy = Arrays.copyOf(indegree, N + 1);
        int temp = 0;
        pq.offer(new int[]{time[1], 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curTime = cur[0];
            int curJob = cur[1];
            for (int nx : graph[curJob]) {
                if (--indegreeCopy[nx] == 0) {
                    pq.offer(new int[]{curTime + time[nx], nx});
                }
            }
            temp = curTime;
        }
        if (ans > temp) {
            ans = temp;
        }
    }
}