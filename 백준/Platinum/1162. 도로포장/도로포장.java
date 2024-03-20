import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final long INF = 10_000_000_000L;

        // 도시의 수
        int N = Integer.parseInt(st.nextToken());
        // 도로의 수
        int M = Integer.parseInt(st.nextToken());
        // 포장할 도로의 수
        int K = Integer.parseInt(st.nextToken());

        // 도로 정보
        List<int[]>[] road = new List[N];
        for (int i=0; i<N; i++) {
            road[i] = new ArrayList<>();
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            road[c1].add(new int[] {c2, cost});
            road[c2].add(new int[] {c1, cost});
        }

        // 포장 i번 했을때 j번 도시에 도착하는 최소 거리 정보
        long[][] cost = new long[K+1][N];
        for (int i=0; i<=K; i++) {
            Arrays.fill(cost[i], INF);
            cost[i][0] = 0;
        }

        // 다익스트라를 위한 pq 선언
        // 0: cost, 1: 포장 도로 개수, 2: 도시 번호
        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            public int compare(long[] o1, long[] o2) {
                if (o1[0] < o2[0]) return -1;
                if (o1[0] > o2[0]) return 1;
                return (int)(o1[1] - o2[1]);
            }
        });

        // 다익스트라
        pq.offer(new long[] {0, 0, 0});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            if (cur[0] != cost[(int)cur[1]][(int)cur[2]]) continue;
            if (cur[2] == N - 1) {
                System.out.println(cur[0]);
                return;
            }
            for (int[] nx : road[(int)cur[2]]) {
                if (cur[0] + nx[1] < cost[(int)cur[1]][nx[0]]) {
                    cost[(int)cur[1]][nx[0]] = cur[0] + nx[1];
                    pq.offer(new long[] {cost[(int)cur[1]][nx[0]], cur[1], nx[0]});
                }
                if (cur[1] < K && cur[0] < cost[(int)cur[1] + 1][nx[0]]) {
                    cost[(int)cur[1] + 1][nx[0]] = cur[0];
                    pq.offer(new long[] {cur[0], cur[1] + 1, nx[0]});
                }
            }
        }
    }
}