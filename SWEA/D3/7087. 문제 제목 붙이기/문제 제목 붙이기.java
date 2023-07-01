import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 테스트 케이스 개수
        int T = sc.nextInt();
        
        for (int t=1; t<=T; t++) {
        	// 제목의 개수
        	int n = sc.nextInt();
        	
        	// 제목의 첫글자만 확인해서 각 알파벳에 해당하는 인덱스에 저장
        	boolean[] exist = new boolean[26];
        	for (int i=0; i<n; i++) {
        		exist[sc.next().charAt(0) - 'A'] = true;
        	}
        	
        	// 알파벳 존재 배열 순회하면서 정답 세기
        	int ans = 0;
        	for (int i=0; i<26; i++) {
        		if (!exist[i]) {
        			break;
        		}
        		ans++;
        	}
            
            // 답 출력
            System.out.println("#" + t + " " + ans);
        }
    }
}