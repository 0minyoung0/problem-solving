import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String word;
    static int N, M;
    static char[][] board;
    static int[] dx = { 1, -1, 0, 0, 1, -1, 1, -1 };
    static int[] dy = { 0, 0, 1, -1, 1, -1, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        word = br.readLine();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        System.out.println(solution());
    }

    public static int solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == word.charAt(0)) {
                    for (int dir = 0; dir < 8; dir++) {
                        if (i + dx[dir] * (word.length() - 1) < 0 || i + dx[dir] * (word.length() - 1) >= N
                                || j + dy[dir] * (word.length() - 1) < 0 || j + dy[dir] * (word.length() - 1) >= M) {
                            continue;
                        }
                        if (dfs(i, j, 0, dir)) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static boolean dfs(int x, int y, int depth, int dir) {
        if (depth == word.length()) {
            return true;
        }
        if (board[x][y] != word.charAt(depth)) {
            return false;
        }
        return dfs(x + dx[dir], y + dy[dir], depth + 1, dir);
    }
}
