import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] isChanged;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        isChanged = new boolean[N];
        for (int i = 1; i < N; i++) {
            isChanged[i] = (s.charAt(i - 1) != s.charAt(i));
        }

        int ans = 0;
        for (int i = 2; i < N; i++) {
            if (isChanged[i - 1] && isChanged[i]) {
                ans++;
            }
        }

        int Q = Integer.parseInt(br.readLine());

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());

            if (q == 1) {
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;

                if (l > 0) {
                    ans -= getScore(l);
                    isChanged[l] = !isChanged[l];
                    ans += getScore(l);
                }

                if (r < N - 1) {
                    ans -= getScore(r + 1);
                    isChanged[r + 1] = !isChanged[r + 1];
                    ans += getScore(r + 1);
                }
            } else { // q == 2
                sb.append(ans).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static int getScore(int idx) {
        int score = 0;
        if (idx > 0 && idx < N && isChanged[idx - 1] && isChanged[idx]) {
            score++;
        }
        if (idx >= 0 && idx < N - 1 && isChanged[idx] && isChanged[idx + 1]) {
            score++;
        }
        return score;
    }
}
