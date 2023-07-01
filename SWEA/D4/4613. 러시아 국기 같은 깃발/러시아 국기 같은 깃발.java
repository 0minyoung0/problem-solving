import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스 개수
        int T = sc.nextInt();
        
        // 테스트 케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	// 러시아 국기 크기
        	int n = sc.nextInt();
        	int m = sc.nextInt();
        	
        	// 행마다의 색 개수를 세서 배열에 저장
        	int[][] cnt = new int[n][3];
        	for (int i=0; i<n; i++) {
        		String s = sc.next();
        		for (int j=0; j<s.length(); j++) {
        			// W는 0번 인덱스, B는 1번 인덱스, R은 2번 인덱스
        			if (s.charAt(j) == 'W') {
        				cnt[i][0]++;
        			}else if (s.charAt(j) == 'B') {
        				cnt[i][1]++;
        			}else {//s.charAt(j) == 'R'
        				cnt[i][2]++;
        			}
        		}
        	}
        	
        	// 정답을 저장할 변수에 가능한 최댓값인 n*m 할당
        	int ans = n*m;
        	
        	// 색을 구분지을 구분선의 위치 i, j
        	// i는 파란색 시작하는 인덱스, j는 빨간색 시작하는 인덱스
        	for (int i=1; i<n-1; i++) {
        		for (int j=i+1; j<n; j++) {
        			int temp = 0;
        			// 하얀색 색칠
        			for (int x=0; x<i; x++) {
        				temp += cnt[x][1] + cnt[x][2];
        			}
        			// 파란색 색칠
        			for (int x=i; x<j; x++) {
        				temp += cnt[x][0] + cnt[x][2];
        			}
        			// 빨간색 색칠
        			for (int x=j; x<n; x++) {
        				temp += cnt[x][0] + cnt[x][1];
        			}
        			
        			// ans 최신화
        			ans = Math.min(ans, temp);
        		}
        	}
        	
        	// 정답 출력
        	System.out.println("#" + t + " " + ans);
        }
    }
}