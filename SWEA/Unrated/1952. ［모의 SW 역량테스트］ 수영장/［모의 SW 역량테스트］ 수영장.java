import java.util.*;

public class Solution {
	static int ans;
	static int[] cost, day;
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 테스트 케이스의 수
    	int T = sc.nextInt();
    	
    	// 각 테스트 케이스 별로 실행
    	for (int t=1; t<=T; t++) {
    		
    		// 1일, 1달, 3달 이용권 요금
    		cost = new int[3];
    		for (int i=0; i<3; i++) {
    			cost[i] = sc.nextInt();
    		}
    		
    		// 최소 비용을 1년 이용권 요금으로 초기화
    		ans = sc.nextInt();
    		
    		// 12개월 이용 계획
    		day = new int[12];
    		for (int i=0; i<12; i++) {
    			day[i] = sc.nextInt();
    		}
    		
    		// 백트래킹으로 최소 비용 구하기
    		bt(0, 0);
    		
    		// 답 출력
    		System.out.println("#" + t + " " + ans);
    	}
    }
	
	private static void bt(int k, int sum) {
		// 12개월 이용 계획이 모두 세워졌다면
		if (k >= 12) {
			
			// ans보다 sum이 더 작다면 갱신
			if (ans > sum) ans = sum;
			
			return;
		}
		
		// k번째 달(0-indexed)의 이용 요금 어떻게 낼지 결정하기
		
		// 1일 이용권과 1달 이용권 중 더 싼 가격 구하기
		int tempCost = Math.min(cost[0] * day[k], cost[1]);
		
		// 그 가격이 3달 이용권보다 싸다면 재귀 호출
		if (tempCost < cost[2]) bt(k+1, sum+tempCost);
		
		// 3달 이용권 재귀 호출
		bt(k+3, sum+cost[2]);
	}
}	
