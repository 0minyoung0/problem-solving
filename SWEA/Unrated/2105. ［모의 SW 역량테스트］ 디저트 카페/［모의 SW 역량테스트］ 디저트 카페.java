import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N, ans, startX, startY;
	static int[][] data;
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,-1,1};
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 테스트 케이스 개수
    	int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
        	
        	// 지역의 한 변의 길이
        	N = sc.nextInt();
        	
        	// 디저트 종류 정보
        	data = new int[N][N];
        	for (int i=0; i<N; i++) {
        		for (int j=0; j<N; j++) {
        			data[i][j] = sc.nextInt();
        		}
        	}
        	
        	// 답을 저장할 변수 초기화
        	ans = -1;
        	
        	// 백트래킹으로 탐색하기
        	for (int i=0; i<N-2; i++) {
        		for (int j=1; j<N-1; j++) {
        			// 먹은 디저트 표시할 배열
        			boolean[] eat = new boolean[101];
        			
        			// 시작점 저장
        			startX = i;
        			startY = j;
        			// 시작점으로 되돌아올때까지 백트래킹
        			backTracking(i+1, j+1, eat, 0, 0);
        		}
        	}
        	
        	// 답 출력
        	System.out.println("#" + t + " " + ans);
        }
    }
	private static void backTracking(int curX, int curY, boolean[] eat, int eatCnt, int dir) {
		// out of index
		if (curX<0 || curX>=N || curY<0 || curY>=N) return;
		
		// 도착한 지점에 있는 디저트가 이미 먹은거면 리턴
		if (eat[data[curX][curY]]) return;
		
		// 먹은 디저트 정보 저장
		boolean[] newEat = Arrays.copyOf(eat, 101);
		
		// 도착한 지점에 있는 디저트 먹기
		newEat[data[curX][curY]] = true;
		eatCnt++;
		
		// 시작점으로 돌아왔다면 결과 갱신 후 리턴
		if (curX == startX && curY == startY) {
			if (ans < eatCnt) ans = eatCnt;
			return;
		}
		
		// dir 방향으로 이동하기
		backTracking(curX+dx[dir], curY+dy[dir], newEat, eatCnt, dir);
		
		// dir이 3인 경우 리턴
		if (dir == 3) return;
		
		// dir+1 방향으로 이동하기
		dir++;
		backTracking(curX+dx[dir], curY+dy[dir], newEat, eatCnt, dir);
	}
}