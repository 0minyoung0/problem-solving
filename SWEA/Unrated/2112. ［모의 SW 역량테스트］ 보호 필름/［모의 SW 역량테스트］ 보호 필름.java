import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int D, W, K, ans;
	static boolean[][] isB;
	static boolean[] isUsed;
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 테스트 케이스 개수
    	int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
        	
        	// 보호 필름의 두께
        	D = sc.nextInt();
        	// 가로 크기
        	W = sc.nextInt();
        	// 합격 기준
        	K = sc.nextInt();
        	
        	// 셀이 B인지 boolean배열에 저장
        	isB = new boolean[D][W];
        	for (int i=0; i<D; i++) {
        		for (int j=0; j<W; j++) {
        			if (sc.nextInt() == 1) isB[i][j] = true;
        		}
        	}
        	
        	// 약품을 투입한 행 체크를 위한 boolean 배열
        	isUsed = new boolean[D];
        	
        	// 답을 저장할 변수 (답의 최대값은 K임)
        	ans = K;
        	
        	// 백트래킹 돌리기
        	backTracking(0, -1);
        	
        	// 답 출력
        	System.out.println("#" + t + " " + ans);
        }
    }
	
	private static void backTracking(int depth, int pre) {
		// 백트래킹 종료 조건
		if (depth >= ans) return;
		
		// 성능검사하기
		boolean pass = true;
		col: for (int i=0; i<W; i++) {
			int temp = 1;
			for (int j=1; j<D; j++) {
				if (isB[j-1][i] == isB[j][i]) temp++;
				else temp = 1;
				if (temp >= K) continue col;
			}
			
			// 특정 열에서 continue하지 못한 경우 성능 검사 실패
			pass = false;
			break col;
		}
		
		// 성능검사 통과했으면 ans 갱신 후 리턴
		if (pass) {
			ans = depth;
			return;
		}
		
		// 약품 투입하는 경우
		for (int i=pre+1; i<D; i++) {
			
			// 이미 약품 투입한 행이면 continue
			if (isUsed[i]) continue;
			
			// 약품 투입했다고 체크
			isUsed[i] = true;
			
			// i번째 막 임시로 저장
			boolean[] temp = Arrays.copyOf(isB[i], W);
			
			// i번째 막을 A로 만들기
			Arrays.fill(isB[i], false);
			
			// 다음 재귀 호출
			backTracking(depth+1, i);
			
			// i번째 막을 B로 만들기
			Arrays.fill(isB[i], true);
			
			// 다음 재귀 호출
			backTracking(depth+1, i);
			
			// 원상복구
			isUsed[i] = false;
			isB[i] = Arrays.copyOf(temp, W);
		}
	}
}