import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
 
    static int N;
    static int[][] cost;
    static int[][] dp;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        // 도시의 수 N
        N = Integer.parseInt(br.readLine());
 
        // 비용 행렬
        cost = new int[N][N];
        for (int[] row : cost) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                row[i] = Integer.parseInt(st.nextToken());
            }
        }
 
        // dp 행렬
        dp = new int[N][1 << N];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
 
        // dfs
        System.out.println(dfs(0, 1));
    }
 
    private static int dfs(int city, int visit) {
        if (visit == (1 << N) - 1) {
            // 시작점으로 못돌아가는 경우
            if (cost[city][0] == 0) {
                return 100_000_000;
            }
 
            return cost[city][0];
        }
 
        // 계산 한 값이면
        if (dp[city][visit] != -1) {
            return dp[city][visit];
        }
 
        // 다음 dfs 돌아서 리턴값으로 dp 갱신하고 리턴
        for (int i = 0; i < N; i++) {
            // 현재 도시에서 i번 도시로 갈 수 있고, 방문하지 않았다면
            if (cost[city][i] != 0 && (visit & (1 << i)) == 0) {
                if (dp[city][visit] == -1) dp[city][visit] = cost[city][i] + dfs(i, visit | (1 << i));
                else dp[city][visit] = Math.min(dp[city][visit], cost[city][i] + dfs(i, visit | (1 << i)));
            }
        }
        
        if (dp[city][visit] == -1) return 100_000_000;
        return dp[city][visit];
    }
}