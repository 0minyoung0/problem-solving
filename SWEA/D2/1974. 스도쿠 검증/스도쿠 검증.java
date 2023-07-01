import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스 개수
        int T = sc.nextInt();
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=T; t++) {
        	// 결과를 저장할 변수
        	int ans = 1;
        	
        	// 배열에 스도쿠를 저장
        	int[][] puz = new int[9][9];
        	for (int i=0; i<9; i++) {
        		for (int j=0; j<9; j++) {
        			puz[i][j] = sc.nextInt();
        		}
        	}
        	
        	// 중복 숫자 체크를 위한 boolean 배열 선언
        	boolean[] check;
        	
        	for (int i=0; i<9; i++) {
        		// 가로 순회
        		check = new boolean[10];
        		for (int j=0; j<9; j++) {
        			// 중복일 때
        			if (check[puz[i][j]] == true) {
        				ans = 0;
        				break;
        			}
        			check[puz[i][j]] = true;
        		}
        		if (ans == 0) break;
        		
        		// 세로 순회
        		check = new boolean[10];
        		for (int j=0; j<9; j++) {
        			// 중복일 때
        			if (check[puz[j][i]] == true) {
        				ans = 0;
        				break;
        			}
        			check[puz[j][i]] = true;
        		}
        		if (ans == 0) break;
        	}
        	
        	// 아직 중복 없으면 3x3도 검사
        	if (ans == 1) {
        		for (int i=0; i<3; i++) {
        			for (int j=0; j<3; j++) {
        				check = new boolean[10];
        				for (int k=3*i; k<3*i+3; k++) {
        					for (int l=3*j; l<3*j+3; l++) {
        	        			// 중복일 때
        	        			if (check[puz[k][l]] == true) {
        	        				ans = 0;
        	        				break;
        	        			}
        	        			check[puz[k][l]] = true;
        					}
        					if (ans == 0) break;
        				}
        				if (ans == 0) break;
        			}
        			if (ans == 0) break;
        		}
        	}
        	
        	System.out.println("#" + t + " " + ans);
        }
    }
}