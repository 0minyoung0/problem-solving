import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] fenwickTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[N + 1];
        fenwickTree = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            update(i, arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (M > 0 || K > 0) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                update(b, c - arr[b]);
                arr[b] = c;
                M--;
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(sum(c) - sum(b - 1)).append('\n');
                K--;
            }
        }
        System.out.print(sb);
    }

    private static long sum(int pos) {
        long ret = 0;
        while (pos > 0) {
            ret += fenwickTree[pos];
            pos &= (pos - 1);
        }
        return ret;
    }

    private static void update(int pos, long val) {
        while (pos <= N) {
            fenwickTree[pos] += val;
            pos += (pos & -pos);
        }
    }
}
