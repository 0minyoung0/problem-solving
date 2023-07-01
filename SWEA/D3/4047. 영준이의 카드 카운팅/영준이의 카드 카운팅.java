import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스 개수
        int T = sc.nextInt();
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	// 카드가 겹치는 경우를 나타낼 변수 선언
        	boolean isError = false;
        	
        	// 카드 정보 문자열
        	String s = sc.next();
        	
        	// 카드 정보를 boolean 배열에 저장하면서 카운팅
        	boolean[][] isChecked = new boolean[4][13];
        	
        	for (int i=0; i<s.length()/3; i++) {
        		// 카드의 모양
        		int shape = -1;
        		if (s.charAt(3*i) == 'S') {
        			shape = 0;
        		}else if (s.charAt(3*i) == 'D') {
        			shape = 1;
        		}else if (s.charAt(3*i) == 'H') {
        			shape = 2;
        		}else { // s.charAt(3*i) == 'C'
        			shape = 3;
        		}
        		
        		// 카드의 숫자
        		int num = (s.charAt(3*i+1)-'0') * 10 + s.charAt(3*i+2)-'0';
        		
        		// 중복인 경우
        		if (isChecked[shape][num-1]) {
        			isError = true;
        			break;
        		}
        		// 중복이 아닌 경우
        		isChecked[shape][num-1] = true;
        	}
        	
        	// 결과 출력
        	if (isError) {
        		System.out.println("#" + t + " ERROR");
        	}else {
        		System.out.print("#" + t);
        		for (int i=0; i<4; i++) {
        			int cnt = 0;
        			for (int j=0; j<13; j++) {
        				if (!isChecked[i][j]) {
        					cnt++;
        				}
        			}
        			System.out.print(" " + cnt);
        		}
        		System.out.println();
        	}
        }
    }
}