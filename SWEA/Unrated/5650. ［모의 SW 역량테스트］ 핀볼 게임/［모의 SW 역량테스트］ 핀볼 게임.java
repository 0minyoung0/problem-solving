import java.util.*;

public class Solution {
	
	static int[][] board;
	
	// 탐색을 위한 델타배열 (위, 오른쪽, 아래, 왼쪽)
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		
		// 테스트 케이스 별로 실행
		for (int tc=1; tc<=T; tc++) {
			
			// 핀볼 게임판의 크기
			int N = sc.nextInt();
			
			// 웜홀 정보 저장할 배열
			int[][] wormhole = new int[5][4];
			
			// 핀볼 게임판 정보
			board = new int[N+2][N+2];
			Arrays.fill(board[0], 5);
			Arrays.fill(board[N+1], 5);
			for (int i=1; i<=N; i++) {
				board[i][0] = 5;
				board[i][N+1] = 5;
			}
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					board[i][j] = sc.nextInt();
					if (board[i][j] >= 6) {
						if (wormhole[board[i][j]-6][0] == 0) {
							wormhole[board[i][j]-6][0] = i;
							wormhole[board[i][j]-6][1] = j;
						}else {
							wormhole[board[i][j]-6][2] = i;
							wormhole[board[i][j]-6][3] = j;
						}
					}
				}
			}
			
			// 게임에서 얻을 수 있는 점수의 최댓값을 저장할 변수
			int ans = 0;
			
			// 시작점과 방향에 대해서 시뮬레이션
			for (int sX=1; sX<=N; sX++) {
				for (int sY=1; sY<=N; sY++) {
					for (int sDir=0; sDir<4; sDir++) {
						
						// 빈칸이 아닌 곳에서는 시뮬레이션 실시 X
						if (board[sX][sY] != 0) continue;
						
						// 진행 방향 바로 앞에 블럭이 없으면 시뮬레이션 실시 X
						if (board[sX+dx[sDir]][sY+dy[sDir]] == 0) continue;
						
						// 이번 시뮬레이션에서의 점수를 저장할 변수
						int score = 0;
						
						// 현재 좌표를 나타낼 변수
						int curX = sX;
						int curY = sY;
						int curDir = sDir;
						
						// 시작점을 -1로 변경 (블랙홀과 마찬가지로 종료조건)
						board[sX][sY] = -1;
						
						// 시뮬레이션
						simulation: while (true) {
							
							// 벽에 반사시 조기 종료
							if (reflectCheck(curX, curY, curDir)) {
								score *= 2;
								score++;
								break simulation;
							}
							
							// 다음 좌표 계산
							curX += dx[curDir];
							curY += dy[curDir];
							int curBoard = board[curX][curY];
							
							// 블랙홀 or 시작점 종료 조건
							if (curBoard == -1) {
								break simulation;
							}
							
							// 방향이 꺾이는 경우
							else if (1 <= curBoard && curBoard <= 4) {
								curDir = findNextDir(curBoard, curDir);
								score++;
							}
							
							// 웜홀인 경우
							else if (6 <= board[curX][curY]) {
								
								// 반대 웜홀로 이동
								if (wormhole[curBoard-6][0] == curX
								&& wormhole[curBoard-6][1] == curY) {
									curX = wormhole[curBoard-6][2];
									curY = wormhole[curBoard-6][3];
								}
								else {
									curX = wormhole[curBoard-6][0];
									curY = wormhole[curBoard-6][1];
								}
							}
						}
						
						// 시작점을 다시 0으로 변경
						board[sX][sY] = 0;
						
						// 이전까지 구했던 점수의 최댓값보다 크다면 갱신
						if (ans < score) ans = score;
					}
				}
			}
			
			// 답 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	// (x, y) 좌표에서 dir 방향으로 진행할때 꺾인 방향을 구하는 메서드
	private static int findNextDir(int curBoard, int dir) {
		if (dir == 0) {
			if (curBoard == 2) return 1;
			if (curBoard == 3) return 3;
		}
		else if (dir == 1) {
			if (curBoard == 3) return 2;
			if (curBoard == 4) return 0;
		}
		else if (dir == 2) {
			if (curBoard == 1) return 1;
			if (curBoard == 4) return 3;
		}
		else if (dir == 3) {
			if (curBoard == 1) return 0;
			if (curBoard == 2) return 2;
		}
		return -1;
	}
	
	// (x, y) 좌표에서 dir 방향으로 진행할때 벽에 반사되어 돌아오는지 확인하는 메서드
	private static boolean reflectCheck(int x, int y, int dir) {
		int nx = x+dx[dir];
		int ny = y+dy[dir];
		int nxtBoard = board[nx][ny];
		
		// 해당 방향일때 수평면 or 수직면인 경우
		if ((dir == 0 && (nxtBoard == 1 || nxtBoard == 4 || nxtBoard == 5))
		|| (dir == 1 && (nxtBoard == 1 || nxtBoard == 2 || nxtBoard == 5))
		|| (dir == 2 && (nxtBoard == 2 || nxtBoard == 3 || nxtBoard == 5))
		|| (dir == 3 && (nxtBoard == 3 || nxtBoard == 4 || nxtBoard == 5))) {
			return true;
		}
		// 그 외의 경우
		return false;
	}
}