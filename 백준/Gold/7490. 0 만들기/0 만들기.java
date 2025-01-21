import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;
    static char[] operators = new char[8];
    static char[] op = { ' ', '+', '-' };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            int N = Integer.parseInt(br.readLine());
            solve(N);
            if (TC > 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void solve(int N) {
        bt(N, 0);
    }

    private static void bt(int N, int depth) {
        if (depth == N - 1) {
            if (check(N)) {
                for (int i = 0; i < N - 1; i++) {
                    sb.append(i + 1).append(operators[i]);
                }
                sb.append(N).append("\n");
            }
            return;
        }
        for (char o : op) {
            operators[depth] = o;
            bt(N, depth + 1);
        }
    }

    private static boolean check(int N) {
        int ans = 0;
        int cur = 1;
        for (int i = 2; i <= N; i++) {
            switch (operators[i - 2]) {
                case ' ':
                    if (cur > 0) {
                        cur = cur * 10 + i;
                    } else {
                        cur = cur * 10 - i;
                    }
                    break;
                case '+':
                    ans += cur;
                    cur = i;
                    break;
                case '-':
                    ans += cur;
                    cur = -i;
                    break;
                default:
                    break;
            }
        }
        ans += cur;
        if (ans == 0) {
            return true;
        }
        return false;
    }
}
