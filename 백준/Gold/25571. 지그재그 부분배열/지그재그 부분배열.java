import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] A = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            if (n == 1) {
                sb.append("0\n");
                continue;
            }

            long ans = 0;
            int curLength = 1;

            for (int i = 1; i < n; i++) {
                if ((curLength == 1 && A[i - 1] - A[i] != 0)
                        || (curLength > 1 && (long) (A[i - 2] - A[i - 1]) * (A[i - 1] - A[i]) < 0)) {
                    ans += curLength++;
                } else if (A[i - 1] - A[i] == 0) {
                    curLength = 1;
                } else {
                    ans += 1;
                    curLength = 2;
                }
            }

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
