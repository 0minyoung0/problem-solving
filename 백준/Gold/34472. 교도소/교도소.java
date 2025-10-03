import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            sum += A[i];
        }
        int avg = (int) (sum / N);

        long ans = 0;

        Deque<int[]> dq = new ArrayDeque<int[]>();
        // 두번 순회하면서 나라시
        for (int z = 0; z < 2; z++) {
            for (int i = 0; i < N; i++) {
                if (A[i] > avg) {
                    dq.offer(new int[] { i, A[i] - avg });
                    A[i] = avg;
                }
                while (!dq.isEmpty() && A[i] < avg) {
                    int rest = avg - A[i];
                    int[] cur = dq.poll();
                    if (cur[1] > rest) {
                        ans += (long) ((N + i - cur[0]) % N) * rest;
                        A[i] += rest;
                        dq.offerFirst(new int[] { cur[0], cur[1] - rest });
                    } else {
                        ans += (long) ((N + i - cur[0]) % N) * cur[1];
                        A[i] += cur[1];
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
