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

            String W = br.readLine();
            int[] aWinSum = new int[2 * N + 1];
            for (int i = 0; i < 2 * N; i++) {
                aWinSum[i + 1] = aWinSum[i] + (W.charAt(i % N) == 'A' ? 1 : 0);
            }

            long ans = 0;

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());

                int start = s + g / 2;
                int end = s + g - 1;

                while (start < end) {
                    int mid = (start + end) / 2;

                    int aWinCount = aWinSum[mid] - aWinSum[s - 1];
                    int bWinCount = (mid - s + 1) - aWinCount;

                    if (aWinCount >= (g + 1) / 2 || bWinCount >= (g + 1) / 2) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                }

                ans += (start - s + 1);
            }

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
