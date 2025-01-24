import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 세그먼트 트리 만들기
        int tSize = 1;
        while (tSize < 2 * N) {
            tSize *= 2;
        }
        long[] segmentTree = new long[tSize + 1];

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                int p = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int idx = tSize / 2 + p;
                while (idx > 0) {
                    segmentTree[idx] += x;
                    idx /= 2;
                }
            } else {
                long ans = 0;
                int p = Integer.parseInt(st.nextToken()) + tSize / 2;
                int q = Integer.parseInt(st.nextToken()) + tSize / 2;
                while (p <= q) {
                    if (p % 2 == 1) {
                        ans += segmentTree[p];
                    }
                    if (q % 2 == 0) {
                        ans += segmentTree[q];
                    }
                    p = (p + 1) / 2;
                    q = (q - 1) / 2;
                }
                sb.append(ans).append('\n');
            }
        }
        System.out.println(sb);
    }
}
