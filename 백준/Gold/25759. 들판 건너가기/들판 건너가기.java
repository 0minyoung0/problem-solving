import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] beautifulValue = new long[101];
        Arrays.fill(beautifulValue, Long.MIN_VALUE);

        st = new StringTokenizer(br.readLine());
        beautifulValue[Integer.parseInt(st.nextToken())] = 0;
        for (int i = 1; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            for (int pre = 1; pre <= 100; pre++) {
                if (beautifulValue[pre] == Long.MIN_VALUE) {
                    continue;
                }
                long newBeautifulValue = beautifulValue[pre] + (cur - pre) * (cur - pre);
                if (beautifulValue[cur] < newBeautifulValue) {
                    beautifulValue[cur] = newBeautifulValue;
                }
            }
        }
        long ans = beautifulValue[1];
        for (int i = 2; i <= 100; i++) {
            if (ans < beautifulValue[i]) {
                ans = beautifulValue[i];
            }
        }
        System.out.println(ans);
    }
}