import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스 개수
        int T = sc.nextInt();
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	// 정수의 개수
        	int n = sc.nextInt();
        	
        	// 배열에 수열을 저장
        	int[] arr = new int[n];
        	for (int i=0; i<n; i++) {
        		arr[i] = sc.nextInt();
        	}
        	
        	// 최댓값을 저장할 변수
        	int ans = -1;
        	
        	// 이중포문 완전탐색
        	for (int i=0; i<n-1; i++) {
        		for (int j=i+1; j<n; j++) {
        			int mul = arr[i] * arr[j];
        			String m = String.valueOf(mul);
        			boolean danjo = true;
        			for (int k=0; k<m.length()-1; k++) {
        				if (m.charAt(k) > m.charAt(k+1)) {
        					danjo = false;
        					break;
        				}
        			}
        			if (danjo) {
        				ans = Math.max(ans, mul);
        			}
        		}
        	}
        	
        	// 답 출력
        	System.out.println("#" + t + " " + ans);
        }
    }
}