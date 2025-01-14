import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Queue<Integer>[] graph;
    static int[][] board;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new Queue[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayDeque<>();
        }
        board = new int[n][n];
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                sum += board[i][j];
                for (int k = 0; k < board[i][j]; k++) {
                    graph[i].offer(j);
                }
            }
            if (sum % 2 == 1) {
                System.out.println(-1);
                return;
            }
        }
        solution(0);
        System.out.println(sb);
    }

    private static void solution(int cur) {
        while (!graph[cur].isEmpty()) {
            int next = graph[cur].poll();
            if (board[cur][next] == 0) {
                continue;
            }
            board[cur][next]--;
            board[next][cur]--;
            solution(next);
        }

        sb.append(cur + 1).append(' ');
    }
}
