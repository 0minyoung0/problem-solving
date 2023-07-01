import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
         
        // 테스트 케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	st = new StringTokenizer(br.readLine());
            // 보드의 한 변의 길이
            int n = Integer.parseInt(st.nextToken());
            // 플레이어가 돌을 놓는 횟수
            int m = Integer.parseInt(st.nextToken());
            
            // 보드
            int[][] board = new int[n+1][n+1];
            board[n/2][n/2] = 2;
            board[n/2][n/2+1] = 1;
            board[n/2+1][n/2] = 1;
            board[n/2+1][n/2+1] = 2;
            
            // 플레이어의 돌 놓기
            int[] dx = {-1,-1,-1,0,0,1,1,1};
            int[] dy = {-1,0,1,-1,1,-1,0,1};
            for (int i=0; i<m; i++) {
            	st = new StringTokenizer(br.readLine());
            	int curX = Integer.parseInt(st.nextToken());
            	int curY = Integer.parseInt(st.nextToken());
            	int curC = Integer.parseInt(st.nextToken());
            	board[curX][curY] = curC;
            	
            	// 인접한 8방향 탐색
            	for (int dir=0; dir<8; dir++) {
            		int nx = curX + dx[dir];
            		int ny = curY + dy[dir];
            		// out of index
            		if (nx <= 0 || nx > n || ny <= 0 || ny > n) continue;
            		// 다른 색의 돌이 아닌 경우
            		if (board[nx][ny] != 3 - curC) continue;
            		// 해당방향에 같은 색의 돌이 있는지 확인
            		while (!(nx <= 0 || nx > n || ny <= 0 || ny > n)
            				&& board[nx][ny] == 3 - curC) {
            			nx += dx[dir];
            			ny += dy[dir];
            		} if (nx <= 0 || nx > n || ny <= 0 || ny > n) continue;
            		if (board[nx][ny] != curC) continue;
            		
            		nx = curX + dx[dir];
            		ny = curY + dy[dir];
            		// 다른 색의 돌이 있는 경우 다른색이 나오는동안 탐색하며 색 바꾸기
            		while (!(nx <= 0 || nx > n || ny <= 0 || ny > n)
            				&& board[nx][ny] == 3 - curC) {
            			board[nx][ny] = curC;
            			nx += dx[dir];
            			ny += dy[dir];
            		}
            	}
            }
            
            // 답 출력
            int[] ans = new int[2];
            for (int i=1; i<=n; i++) {
            	for (int j=1; j<=n; j++) {
            		if (board[i][j] != 0) {
            			ans[board[i][j] - 1]++;
            		}
            	}
            }
            System.out.println("#" + t + " " + ans[0] + " " + ans[1]);
        }
    }
}