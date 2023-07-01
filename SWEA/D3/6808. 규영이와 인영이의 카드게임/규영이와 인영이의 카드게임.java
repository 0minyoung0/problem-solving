import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int[] ky, iy;
	static List<Integer> list;
	static boolean[] isUsed;
	static int win, lose;
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        
    	// 테스트 케이스 개수
    	int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
        	// 규영이가 내는 카드
        	ky = new int[9];
        	for (int i=0; i<9; i++) {
        		ky[i] = sc.nextInt();
        	}
        	
        	// 인영이가 낼 수 있는 카드 리스트
        	list = new ArrayList<>();
        	cards: for (int i=1; i<=18; i++) {
        		for (int j=0; j<9; j++) {
        			// 이미 규영이가 가져간 카드면 다음 카드 보기
        			if (i == ky[j]) continue cards;
        		}
        		// 규영이가 가져간 적 없는 카드면 인영이 카드 리스트에 저장
        		list.add(i);
        	}
        	
        	// 인영이가 낼 카드 순서
        	iy = new int[9];
        	// 사용한 카드의 인덱스를 표시할 boolean 배열
        	isUsed = new boolean[9];
        	// win, lose 초기화
        	win = 0;
					lose = 0;
        	
        	// 백트래킹으로 경우의 수 세기
        	bt(0);
        	
        	// 답 출력
        	System.out.println("#" + t + " " + win + " " + lose);
        }
    }
	private static void bt(int k) {
		// 인영이가 카드 순서를 모두 정한 경우
		if (k == 9) {
			// 규영이 점수 - 인영이 점수
			int score = 0;
			for (int i=0; i<9; i++) {
				if (ky[i] > iy[i]) {
					score += ky[i] + iy[i];
				}
				else {
					score -= ky[i] + iy[i];
				}
			}
			// 규영이가 이겼으면 win에 +1
			if (score > 0) win++;
			// 규영이가 졌으면 
			else if (score < 0) lose++;
			// 리턴
			return;
		}
		
		// 인영이의 k번째 카드 결정하기
		for (int i=0; i<9; i++) {
			// 쓴 카드는 continue
			if (isUsed[i]) continue;
			
			// 인영이의 k번째 카드를 리스트의 i번째 카드로 하기
			isUsed[i] = true;
			iy[k] = list.get(i);
			bt(k+1);
			
			// 이제 안쓸래요
			isUsed[i] = false;
		}
	}
}