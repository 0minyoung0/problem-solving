import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] B = new int[N];
            for (int i = 0; i < N; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 0;

            Deque<long[]> dq = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                int cur = B[i];
                while (!dq.isEmpty() && (int) dq.peekFirst()[0] < cur) {
                    long[] top = dq.pollFirst();
                    int count = (int) top[1];
                    int lastIdx = (int) top[2];
                    long idxSum = top[3];
                    if (lastIdx == i - 1) {
                        ans += Math.abs(((long) (i + 1) * (count - 1) - (idxSum - lastIdx)));
                    } else {
                        ans += Math.abs(((long) (i + 1) * count - idxSum));
                    }
                }
                if (!dq.isEmpty() && (int) dq.peekFirst()[0] == cur) {
                    long[] top = dq.pollFirst();
                    int value = (int) top[0];
                    int count = (int) top[1];
                    int lastIdx = (int) top[2];
                    long idxSum = top[3];
                    if (lastIdx == i - 1) {
                        ans += Math.abs(((long) (i + 1) * (count - 1) - (idxSum - lastIdx)));
                    } else {
                        ans += Math.abs(((long) (i + 1) * count - idxSum));
                    }
                    dq.offerFirst(new long[] { value, count + 1, i, idxSum + i });
                } else {
                    dq.offerFirst(new long[] { cur, 1, i, i });
                }
            }

            dq.clear();
            for (int i = N - 1; i >= 0; i--) {
                int cur = B[i];
                while (!dq.isEmpty() && (int) dq.peekFirst()[0] < cur) {
                    long[] top = dq.pollFirst();
                    int value = (int) top[0];
                    int count = (int) top[1];
                    int lastIdx = (int) top[2];
                    long idxSum = top[3];
                    if (lastIdx == i + 1) {
                        ans += Math.abs(((long) (i - 1) * (count - 1) - (idxSum - lastIdx)));
                    } else {
                        ans += Math.abs(((long) (i - 1) * count - idxSum));
                    }
                }
                if (!dq.isEmpty() && (int) dq.peekFirst()[0] == cur) {
                    long[] top = dq.pollFirst();
                    int value = (int) top[0];
                    int count = (int) top[1];
                    int lastIdx = (int) top[2];
                    long idxSum = top[3];
                    dq.offerFirst(new long[] { value, count + 1, i, idxSum + i });
                } else {
                    dq.offerFirst(new long[] { cur, 1, i, i });
                }
            }

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
