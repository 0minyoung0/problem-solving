import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] combination;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int INF = 1_000_000_001;

        combination = new int[N+M+1][N+M+1];
        combination[0][0] = 1;
        for (int i=1; i<=N+M; i++) {
            combination[i][0] = 1;
            for (int j=1; j<=i; j++) {
                combination[i][j] = Math.min(combination[i-1][j-1] + combination[i-1][j], INF);
            }
        }

        // 불가능한 경우
        if (combination[N+M][N] < K) {
            System.out.println("-1");
            return;
        }

        System.out.println(findStr(N, M, K));
    }

    private static String findStr(int N, int M, int K) {
        // 남은 경우의 수가 하나인 경우
        if (N == 0) {
            return "z".repeat(M);
        }
        if (M == 0) {
            return "a".repeat(N);
        }

        // 앞에 a를 사용하는 경우의 수
        int caseA = combination[N+M-1][M];

        // 앞에 a를 붙여서 탐색
        if (K <= caseA) return "a" + findStr(N-1, M, K);
        // 앞에 z를 붙여서 탐색
        return "z" + findStr(N, M-1, K - caseA);
    }
}
