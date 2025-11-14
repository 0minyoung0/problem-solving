import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] abDiff = new int[N];
            for (int i = 0; i < N; i++) {
                abDiff[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                abDiff[i] -= Integer.parseInt(st.nextToken());
            }

            Arrays.sort(abDiff);

            int start = 0;
            int end = (int) ((long) N * (N - 1) / 2);
            while (start < end) {
                int mid = (int) (((long) start + end) / 2);

                int count = 0;
                int j = 0;
                for (int i = 0; i < N; i++) {
                    while (j < N - 1) {
                        if (abDiff[j + 1] - abDiff[i] > mid) {
                            break;
                        }
                        j++;
                    }
                    count += (j - i);
                }

                // K개보다 많거나 같으면
                if (count >= K) {
                    end = mid;
                }

                // K개보다 적으면
                if (count < K) {
                    start = mid + 1;
                }
            }

            int count = 0;
            int j = 0;
            for (int i = 0; i < N; i++) {
                while (j < N - 1) {
                    if (abDiff[j + 1] - abDiff[i] > start) {
                        break;
                    }
                    j++;
                }
                count += (j - i);
            }
            if (count == K) {
                sb.append(start).append('\n');
            } else {
                sb.append("-1\n");
            }
        }
        System.out.print(sb);
    }
}
