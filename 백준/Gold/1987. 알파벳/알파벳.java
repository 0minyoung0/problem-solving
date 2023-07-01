import java.io.*;
import java.util.*;

public class Main {
	static int R, C, ans;
	static char[][] board;
	static boolean[] vis;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 보드의 세로, 가로 칸 수
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// 보드 정보
		board = new char[R][];
		for (int i=0; i<R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		// 방문한 알파벳을 체크할 boolean 배열
		vis = new boolean[26];
		vis[board[0][0]-'A'] = true;
		
		// 말이 지날 수 있는 최대의 칸수를 저장할 변수
		ans = 1;
		
		// 백트래킹으로 탐색
		backTracking(0, 0, 1);
		
		// 답 출력
		System.out.println(ans);
	}
	
	private static void backTracking(int x, int y, int length) {
		// 이미 가장 긴 경우를 찾았다면 리턴
		if (ans == 26) return;

		// 인접한 네칸 확인
		for (int dir=0; dir<4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			// out of index
			if (nx<0 || nx>=R || ny<0 || ny>=C) continue;
			
			// 방문한 알파벳인 경우
			if (vis[board[nx][ny]-'A']) continue;
			
			// 새롭게 방문
			vis[board[nx][ny]-'A'] = true;
			
			// length+1이 ans보다 크다면 갱신
			if (ans < length+1) ans = length+1;
			
			// 재귀 호출
			backTracking(nx, ny, length+1);
			
			// 방문 흔적 지우기
			vis[board[nx][ny]-'A'] = false;
		}
		
	}
}
