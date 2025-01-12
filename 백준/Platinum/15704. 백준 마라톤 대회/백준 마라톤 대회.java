import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] roads;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        roads = new int[M][4];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            roads[i][0] = Integer.parseInt(st.nextToken()) - 1;
            roads[i][1] = Integer.parseInt(st.nextToken()) - 1;
            roads[i][2] = Integer.parseInt(st.nextToken());
            roads[i][3] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색으로 참가할 수 있는 사람 수의 최댓값 구하기
        int left = 1;
        int right = 100000;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (isPossible(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

    private static boolean isPossible(int P) {
        // 간선 정보 저장
        List<List<int[]>> edge = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            edge.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            long cost = P <= road[3] ? 0 : (long) road[2] * (long) (P - road[3]) * (long) (P - road[3]);
            if (cost <= (long) K) {
                edge.get(road[0]).add(new int[] { road[1], (int) cost });
                edge.get(road[1]).add(new int[] { road[0], (int) cost });
            }
        }

        // 다익스트라로 최단 cost 구하기
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int[] dist = new int[N];
        Arrays.fill(dist, 1_000_000_001);
        boolean[] visited = new boolean[N];

        pq.offer(new int[] { 0, 0 });
        dist[0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            if (curNode == N - 1) {
                return true;
            }

            if (visited[curNode]) {
                continue;
            }
            visited[curNode] = true;

            for (int[] next : edge.get(curNode)) {
                int nextNode = next[0];
                int nextDist = next[1];
                int newDist = curDist + nextDist;
                if (dist[nextNode] > newDist && newDist <= K) {
                    dist[nextNode] = newDist;
                    pq.offer(new int[] { nextNode, newDist });
                }
            }
        }

        return false;
    }
}
