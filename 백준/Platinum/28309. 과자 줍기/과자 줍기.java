import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_003;
    static long[] factorial = new long[2_000_001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        factorial[0] = 1;
        for (int i = 1; i <= 2_000_000; i++) {
            factorial[i] = muliple(factorial[i - 1], i);
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            List<int[]> coordinate = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()) - 1;
                int Y = Integer.parseInt(st.nextToken()) - 1;

                coordinate.add(new int[] { X, Y });
            }
            coordinate.add(new int[] { R - 1, C - 1 });
            Collections.sort(coordinate, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
                }
            });

            int[] snackNum = new int[N + 1];
            int[] ans = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                int cx = coordinate.get(i)[0];
                int cy = coordinate.get(i)[1];

                int prevSnackNumMax = 0;
                for (int j = 0; j < i; j++) {
                    int px = coordinate.get(j)[0];
                    int py = coordinate.get(j)[1];
                    if (py > cy) {
                        continue;
                    }

                    int prevSnackNum = snackNum[j];
                    if (prevSnackNumMax < prevSnackNum) {
                        prevSnackNumMax = prevSnackNum;
                    }
                }

                snackNum[i] = prevSnackNumMax + 1;

                if (prevSnackNumMax == 0) {
                    ans[i] += combination(cx + cy, cx);
                    ans[i] %= MOD;
                    continue;
                }

                for (int j = 0; j < i; j++) {
                    int px = coordinate.get(j)[0];
                    int py = coordinate.get(j)[1];
                    if (py > cy || snackNum[j] < prevSnackNumMax) {
                        continue;
                    }

                    ans[i] += muliple(ans[j], combination(cx - px + cy - py, cx - px));
                    ans[i] %= MOD;
                }
            }
            sb.append(ans[N]).append('\n');
        }
        System.out.print(sb);
    }

    private static long combination(int n, int r) {
        long ans = factorial[n];
        ans = muliple(ans, pow((int) factorial[r], MOD - 2));
        ans = muliple(ans, pow((int) factorial[n - r], MOD - 2));
        return ans;
    }

    private static long pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        long sqrt = pow(a, b / 2);
        long ans = muliple(sqrt, sqrt);
        if (b % 2 == 0) {
            return ans;
        } else {
            return muliple(ans, a);
        }
    }

    private static long muliple(long x, long y) {
        return (x * y % MOD + MOD) % MOD;
    }
}
