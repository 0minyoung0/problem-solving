import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static final int ROOT = 1;
    static int unused = 2;
    static final int MX = 1000005;
    static boolean[] chk = new boolean[MX];
    static int[][] nxt = new int[MX][2];

    static boolean isgood;
    static String foundString;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < MX; i++) {
            Arrays.fill(nxt[i], -1);
        }

        int[][] data = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = i;
        }
        Arrays.sort(data, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        String[] ans = new String[N];
        for (int[] d : data) {
            isgood = false;
            func(d[0], "");
            if (!isgood) {
                System.out.print(-1);
                return;
            }
            ans[d[1]] = foundString;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for (int i = 0; i < N; i++) {
            sb.append("\n").append(ans[i]);
        }
        System.out.print(sb);
    }

    private static void func(int length, String cur) {
        if (isgood) {
            return;
        }
        if (cur.length() == length) {
            insert(cur);
            isgood = true;
            foundString = cur;
        }

        if (!find(cur + "0")) {
            func(length, cur + "0");
        }
        if (isgood) {
            return;
        }

        if (!find(cur + "1")) {
            func(length, cur + "1");
        }
    }

    private static void insert(String s) {
        int cur = ROOT;
        for (char c : s.toCharArray()) {
            if (nxt[cur][c - '0'] == -1) {
                nxt[cur][c - '0'] = unused++;
            }
            cur = nxt[cur][c - '0'];
        }
        chk[cur] = true;
    }

    private static boolean find(String s) {
        int cur = ROOT;
        for (int c : s.toCharArray()) {
            if (nxt[cur][c - '0'] == -1) {
                return false;
            }
            cur = nxt[cur][c - '0'];
        }
        return chk[cur];
    }
}