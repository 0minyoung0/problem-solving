import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스 개수
        int T = sc.nextInt();
        
        // 테스트 케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	// 카드 개수
        	int n = sc.nextInt();
        	
        	// 카드 이름을 배열에 저장
        	String[] cards = new String[n+1];
        	for (int i=0; i<n; i++) {
        		cards[i] = sc.next();
        	}
        	if (n % 2 == 1) {
        		cards[n] = "";
        	}
        	
        	// 카드 출력
        	System.out.print("#" + t + " ");
        	for (int i=0; i<(n+1)/2; i++) {
        		System.out.print(cards[i] + " " + cards[(n+1)/2 + i] + " ");
        	}
        	System.out.println();
        }
    }
}