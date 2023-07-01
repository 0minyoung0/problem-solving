import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 테스트 케이스 개수
    	int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
        	
        	// 점원 수
        	int N = sc.nextInt();
        	// 선반 높이
        	int B = sc.nextInt();
        	
        	// 점원 키 정보
        	int[] h = new int[N];
        	for (int i=0; i<N; i++) {
        		h[i] = sc.nextInt();
        	}
        	
        	// 답을 저장할 변수
        	int ans = Integer.MAX_VALUE;
        	
        	// 비트마스킹으로 순회
        	find: for (int i=0; i<(1<<N); i++) {
        		if (ans == B) break;
        		int temp = 0;
        		for (int j=0; j<N; j++) {
        			if ((i & 1<<j) > 0) {
        				temp += h[j];
        				if (temp >= B) {
        					if (ans > temp) {
        						ans = temp;
        					}
        					continue find;
        				}
        			}
        		}
        	}
        	
        	// 답 출력
        	System.out.println("#" + t + " " + (ans-B));
        }
    }
}