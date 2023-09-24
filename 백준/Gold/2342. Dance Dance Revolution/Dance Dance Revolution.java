import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> command;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        command = new ArrayList<>();
        while (true) {
            int c = Integer.parseInt(st.nextToken());
            if (c == 0) {
                break;
            }
            command.add(c);
        }

        // dp를 위한 배열 선언
        dp = new int[5][5][command.size() + 1];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // dfs로 탐색한 결과 출력
        System.out.print(dfs(0, 0, 0));
    }

    private static int dfs(int left, int right, int idx) {
        if (idx == command.size()) {
            return 0;
        }

        if (dp[left][right][idx] != -1) {
            return dp[left][right][idx];
        }

        dp[left][right][idx] = Math.min(
                dfs(command.get(idx), right, idx + 1) + calculate(left, command.get(idx)),
                dfs(left, command.get(idx), idx + 1) + calculate(right, command.get(idx))
        );

        return dp[left][right][idx];
    }

    private static int calculate(int pre, int nxt) {
        if (pre == nxt) {
            return 1;
        }
        if (pre == 0) {
            return 2;
        }
        if (Math.abs(pre - nxt) == 2) {
            return 4;
        }
        return 3;
    }
}