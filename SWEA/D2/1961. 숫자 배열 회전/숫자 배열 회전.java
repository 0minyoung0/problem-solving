import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스 개수
        int T = sc.nextInt();
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	// 배열의 크기
        	int n = sc.nextInt();
        	
        	// 입력 배열
        	int[][] arr = new int[n][n];
        	for (int i=0; i<n; i++) {
        		for (int j=0; j<n; j++) {
        			arr[i][j] = sc.nextInt();
        		}
        	}
        	// 출력 양식 맞춰서 바로 출력
        	System.out.println("#" + t);
        	for (int i=0; i<n; i++) {
        		// 90도 돌린 배열
        		for (int j=0; j<n; j++) {
        			System.out.print(arr[n-j-1][i]);
        		}
        		System.out.print(" ");
        		// 180도 돌린 배열
        		for (int j=0; j<n; j++) {
        			System.out.print(arr[n-i-1][n-j-1]);
        		}
        		System.out.print(" ");
        		// 270도 돌린 배열
        		for (int j=0; j<n; j++) {
        			System.out.print(arr[j][n-i-1]);
        		}
        		System.out.println();
        	}
        	
        }
    }
}