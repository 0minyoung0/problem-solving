import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] tree = new List[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            tree[Integer.parseInt(st.nextToken()) - 1].add(i);
        }

        int[] level = new int[N];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 0, 0 });
        level[0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int next : tree[cur[0]]) {
                level[cur[1] + 1]++;
                q.offer(new int[] { next, cur[1] + 1 });
            }
        }

        int max = 0;
        for (int d = 2; d <= N; d++) {
            int count = 0;
            for (int i = 0; i < N; i += d) {
                count += level[i];
            }
            if (max < count) {
                max = count;
            }
        }
        System.out.println(max);
    }
}