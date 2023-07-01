import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 탐색을 위한 델타배열
    	int[] dx = {-1,-1,-1,0,0,1,1,1};
    	int[] dy = {-1,0,1,-1,1,-1,0,1};
    	
    	// 테스트 케이스 개수
        int T = sc.nextInt();
        
        for (int t=1; t<=T; t++) {
        	// 저수지 구획의 크기
        	int n = sc.nextInt();
        	
        	// 저수지 저장
        	boolean[][] isWater = new boolean[n][n];
        	for (int i=0; i<n; i++) {
        		for (int j=0; j<n; j++) {
        			if (sc.next().equals("W")) {
        				isWater[i][j] = true;
        			}
        		}
        	}
        	
        	// 깊이 계산
        	int ans = 0;
        	for (int i=0; i<n; i++) {
        		for (int j=0; j<n; j++) {
        			if (isWater[i][j]) {
        				int temp = 0;
	        			for (int dir=0; dir<8; dir++) {
	        				int nx = i + dx[dir];
	        				int ny = j + dy[dir];
	        				// 배열을 벗어나는 경우 continue
	        				if (nx<0 || nx>=n || ny<0 || ny>=n) continue;
	        				// 물이면 +1
	        				if (isWater[nx][ny]) temp++;
	        			}
	        			// 0이면 1로 만들기
	        			temp = temp == 0? 1 : temp;
	        			ans = Math.max(ans, temp);
        			}
        		}
        	}
        	// 답 출력
        	System.out.println("#" + t + " " + ans);
        }
    }
}