import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<int[]> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int balloon = 1; balloon <= N; balloon++) {
            int paper = Integer.parseInt(st.nextToken());
            dq.offerLast(new int[] { balloon, paper });
        }

        int[] cur = dq.pollFirst();
        sb.append(cur[0]).append(' ');
        while (!dq.isEmpty()) {
            if (cur[1] > 0) {
                for (int i = 0; i < cur[1] - 1; i++) {
                    dq.offerLast(dq.pollFirst());
                }
            } else {
                for (int i = 0; i < -cur[1]; i++) {
                    dq.offerFirst(dq.pollLast());
                }
            }

            cur = dq.pollFirst();
            sb.append(cur[0]).append(' ');
        }

        System.out.println(sb);
    }
}
