import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 캠퍼스의 크기 N과 M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // BFS 초기 세팅
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][M];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        // 캠퍼스 정보
        char[][] campus = new char[N][M];
        for (int i=0; i<N; i++) {
            campus[i] = br.readLine().toCharArray();
            for (int j=0; j<M; j++) {
                if (campus[i][j] == 'I') {
                    q.offer(new int[] {i, j});
                    vis[i][j] = true;
                }
            }
        }

        // 답을 저장할 변수
        int ans = 0;

        // BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir=0; dir<4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx<0 || nx>=N || ny<0 || ny>=M || vis[nx][ny] || campus[nx][ny]=='X') continue;
                if (campus[nx][ny] == 'P') ans++;
                q.offer(new int[] {nx, ny});
                vis[nx][ny] = true;
            }
        }

        // 답 출력
        if(ans > 0) System.out.println(ans);
        else System.out.println("TT");
    }
}
