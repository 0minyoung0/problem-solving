import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 리스트를 링크드리스트로 구현
        List<Integer> list = new LinkedList<>();
        
        // 테스트케이스 별로 실행
        for (int t=1; t<=10; t++) {
        	// 원본 암호문의 길이
        	int n = sc.nextInt();
        	
        	// 원본 암호문을 리스트에 추가
        	for (int i=0; i<n; i++) {
        		list.add(sc.nextInt());
        	}
        	
        	// 명령어의 개수
        	int o = sc.nextInt();
        	
        	// 명령어
        	for (int i=0; i<o; i++) {
        		sc.next();
        		int x = sc.nextInt();
        		int y = sc.nextInt();
        		// x위치 바로 다음에 y개의 숫자 삽입
        		for (int j=0; j<y; j++) {
        			list.add(x+j, sc.nextInt());
        		}
        	}

        	System.out.print("#" + t);
        	for (int i=0; i<10; i++) {
        		System.out.print(" " + list.get(i));
        	}System.out.println();
        	
        	// 리스트 클리어
        	list.clear();
        }
    }
}