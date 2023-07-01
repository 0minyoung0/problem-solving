import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스 개수
        int T = sc.nextInt();
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	// 파스칼 삼각형의 크기
        	int n = sc.nextInt();
        	
        	// 파스칼 삼각형
        	int[][] pas = new int[n][n];
        	for (int i=0; i<n; i++) {
        		pas[i][0] = 1;
        		for (int j=1; j<=i; j++) {
        			pas[i][j] = pas[i-1][j-1] + pas[i-1][j];
        		}
        	}
        	
        	// 파스칼 삼각형 출력
        	System.out.println("#" + t);
        	for (int i=0; i<n; i++) {
        		for (int j=0; j<=i; j++) {
        			System.out.print(pas[i][j] + " ");
        		}
        		System.out.println();
        	}
        }
    }
}