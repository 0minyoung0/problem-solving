import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] V;
    static long[] sum;
    static long ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            V = new int[n];
            sum = new long[n];
            for (int i = 0; i < n; i++) {
                V[i] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    sum[i] = V[i];
                } else {
                    sum[i] = sum[i - 1] + V[i];
                }
            }

            ans = Long.MIN_VALUE;
            solve(a, b, c);
            solve(a, c, b);
            solve(b, a, c);
            solve(b, c, a);
            solve(c, a, b);
            solve(c, b, a);

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }

    private static void solve(int lSize, int mSize, int rSize) {
        long[] lMin = new long[n];
        long[] lMax = new long[n];
        lMin[0] = lMax[0] = sum[lSize - 1];
        for (int i = 1; i <= n - lSize - mSize - rSize; i++) {
            long lSum = sum[lSize + i - 1] - sum[i - 1];
            lMin[i] = Math.min(lMin[i - 1], lSum);
            lMax[i] = Math.max(lMax[i - 1], lSum);
        }

        long[] rMin = new long[n];
        long[] rMax = new long[n];
        rMin[n - rSize] = rMax[n - rSize] = sum[n - 1] - sum[n - rSize - 1];
        for (int i = n - rSize - 1; i >= lSize + mSize; i--) {
            long rSum = sum[rSize + i - 1] - sum[i - 1];
            rMin[i] = Math.min(rMin[i + 1], rSum);
            rMax[i] = Math.max(rMax[i + 1], rSum);
        }

        // mid 시작 인덱스
        // 최소 : lSize
        // 최대 : n - mSize - rSize
        for (int mIdx = lSize; mIdx <= n - mSize - rSize; mIdx++) {
            long mid = sum[mSize + mIdx - 1] - sum[mIdx - 1];
            int lIdx = mIdx - lSize;
            int rIdx = mIdx + mSize;

            ans = Math.max(ans, mid * lMin[lIdx] * rMin[rIdx]);
            ans = Math.max(ans, mid * lMin[lIdx] * rMax[rIdx]);
            ans = Math.max(ans, mid * lMax[lIdx] * rMin[rIdx]);
            ans = Math.max(ans, mid * lMax[lIdx] * rMax[rIdx]);
        }
    }
}
