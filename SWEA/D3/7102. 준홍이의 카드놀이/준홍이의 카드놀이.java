import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스의 수
        int T = sc.nextInt();
        
        // 테스트 케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	int n = sc.nextInt();
        	int m = sc.nextInt();
        	
        	// 정답 출력
        	System.out.print("#" + t + " ");
        	for (int i=Math.min(n, m)+1; i<=Math.max(n, m)+1; i++) {
        		System.out.print(i + " ");
        	}
        	System.out.println();
        }
    }
}