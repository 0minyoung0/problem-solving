import java.io.*;
import java.util.*;

public class Main {

    static int[] p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                }
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.offer(new int[] { A, B, C });
        }

        int ans = (N - 2) * (N - 1) / 2 * t;

        int cnt = 0;
        while (cnt != N - 1) {
            int[] cur = pq.poll();
            if (!union(cur[0], cur[1])) {
                continue;
            }
            ans += cur[2];
            cnt++;
        }

        System.out.println(ans);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        }

        p[Math.max(x, y)] = Math.min(x, y);
        return true;
    }

    private static int find(int x) {
        if (x == p[x]) {
            return x;
        }
        return p[x] = find(p[x]);
    }
}