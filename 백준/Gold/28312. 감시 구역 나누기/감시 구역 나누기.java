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
            int M = Integer.parseInt(st.nextToken());

            int[] d = new int[N - 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N - 1; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            long start = 0;
            long end = Long.MAX_VALUE / 2;

            while (start < end) {
                long mid = (start + end) / 2;

                int count = 0;
                int length = 0;
                long partialSum = 0;
                long sum = 0;
                for (int i = 0; i < N - 1; i++) {
                    length++;
                    partialSum += (long) length * d[i];
                    sum += partialSum;

                    if (sum > mid) {
                        count++;
                        length = 0;
                        partialSum = 0;
                        sum = 0;

                        if (i == N - 2) {
                            count++;
                        }
                    }
                }
                if (sum > 0) {
                    count++;
                }

                if (count <= M) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            sb.append(start).append('\n');
        }
        System.out.print(sb);
    }
}
