import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int T = Integer.parseInt(sc.nextLine());
        
        for (int t=1; t<=T; t++) {
        	// 데이터를 저장할 char 이중배열
        	char[][] arr = new char[5][15];
        	for (int i=0; i<5; i++) {
        		String s = sc.nextLine();
        		for (int j=0; j<s.length(); j++) {
        			arr[i][j] = s.charAt(j);
        		}
        	}
        	
        	// 테스트 케이스 넘버 출력
        	System.out.print("#" + t + " ");
        	
        	// 세로로 출력
        	for (int i=0; i<15; i++) {
        		for (int j=0; j<5; j++) {
        			if (arr[j][i] != '\u0000') {
        				System.out.print(arr[j][i]);
        			}
        		}
        	}
        	System.out.println();
        }
    }
}