// 으으 문제 너무 열받아

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스 개수
        int T = sc.nextInt();
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	// 커맨드의 수
        	int n = sc.nextInt();
        	
        	// 총 이동거리
        	int ans = 0;
        	
        	// 현재 속도
        	int curV = 0;
        	
        	for (int i=0; i<n; i++) {
        		int command = sc.nextInt();
        		switch (command) {
        			case 1:
        				curV += sc.nextInt();
        				break;
        			case 2:
        				curV -= sc.nextInt();
        				if (curV < 0) {
        					curV = 0;
        				}
        				break;
        			default:
        				break;
        		}
        		ans += curV;
        	}
        	
        	System.out.println("#" + t + " " + ans);
        }
    }
}