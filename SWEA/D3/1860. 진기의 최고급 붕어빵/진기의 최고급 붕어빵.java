import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 테스트 케이스 개수
        int T = sc.nextInt();
        
        for (int t=1; t<=T; t++) {
        	// 손님의 수
        	int n = sc.nextInt();
        	// m초에 k개의 붕어빵 만듦
        	int m = sc.nextInt();
        	int k = sc.nextInt();
        	
        	// i번째 손님이 도착하는 시간
        	int[] time = new int[n+1];
        	for (int i=1; i<=n; i++) {
        		time[i] = sc.nextInt();
        	}
        	Arrays.sort(time);
        	
        	// 가능여부를 저장할 boolean 변수
        	boolean possible = true;
        	
        	// i번째 손님이 왔을때 붕어빵이 i개 이상 있는지 확인
        	for (int i=1; i<=n; i++) {
        		// 불가능한 경우 출력
        		if (time[i] / m * k < i) {
        			possible = false;
        			System.out.println("#" + t + " Impossible");
        			break;
        		}
        	}
            
            // 가능한 경우 출력
        	if (possible) {
        		System.out.println("#" + t + " Possible");
        	}
        }
    }
}