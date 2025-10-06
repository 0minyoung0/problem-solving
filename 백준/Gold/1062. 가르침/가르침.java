import java.io.*;
import java.util.*;

public class Main {

    static boolean[] learned;
    static String[] words;
    static int N, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // a, n, t, i, c는 배워야 함
        if (M < 5) {
            System.out.println(0);
            return;
        }

        learned = new boolean[26];
        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;

        ans = 0;

        // M - 5개 더 배울 수 있음
        bt(0, M - 5);

        System.out.println(ans);
    }

    private static void bt(int startIdx, int remain) {
        if (startIdx == 26 && remain > 0) {
            return;
        }
        if (remain == 0) {
            int count = 0;
            word: for (int i = 0; i < N; i++) {
                for (int j = 4; j < words[i].length() - 4; j++) {
                    if (!learned[words[i].charAt(j) - 'a']) {
                        continue word;
                    }
                }
                count++;
            }
            if (ans < count) {
                ans = count;
            }
            return;
        }

        for (int i = startIdx; i < 26; i++) {
            if (learned[i]) {
                continue;
            }
            learned[i] = true;
            bt(i + 1, remain - 1);
            learned[i] = false;
        }
    }
}
