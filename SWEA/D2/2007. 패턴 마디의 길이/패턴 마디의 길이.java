import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int T = Integer.parseInt(sc.nextLine());
        
        for (int t=1; t<=T; t++) {
        	// 길이가 30인 문자열
        	String s = sc.nextLine();
        	
        	// 마디가 i인 경우를 1인 경우부터 순차적으로 확인
        	madi: for (int i=1; i<=10; i++) {
        		// 조건에 맞지 않으면 continue로 다음 마디 확인
        		for (int j=i; j<30; j++) {
        			if (s.charAt(j%i) != s.charAt(j)) {
        				continue madi;
        			}
        		}
        		
        		// 조건에 맞는 경우 i를 출력하고 for문 탈출
        		System.out.println("#" + t + " " + i);
        		break;
        	}
        }
    }
}