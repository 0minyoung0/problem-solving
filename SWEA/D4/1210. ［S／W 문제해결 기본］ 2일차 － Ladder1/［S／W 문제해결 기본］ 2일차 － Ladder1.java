import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int caseNum=1; caseNum<=10; caseNum++) {
			// 케이스 번호
			sc.nextInt();
			
			// 사다리 따라갈 포인터
			int[] cur = {99, -1};
			
			// boolean 이중배열에 사다리 정보 저장
			boolean[][] isLadder = new boolean[100][100];
			for (int i=0; i<100; i++) {
				for (int j=0; j<100; j++) {
					int temp = sc.nextInt();
					if (temp == 0) {
						isLadder[i][j] = false;
					}
					else if (temp == 1) {
						isLadder[i][j] = true;
					}
					// 인풋이 2면 int[] cur = {99, x꼴}
					else {
						isLadder[i][j] = true;
						cur[1] = j;
					}
				}
			}
			
			// while문으로 탐색, 한층 올라갈때마다 한루프
			while (cur[0] > 0) {
				// 왼쪽 사다리 있으면 타고 쭉 가기
				if (cur[1] > 0 && isLadder[cur[0]][cur[1]-1]) {
					while (cur[1] > 0 && isLadder[cur[0]][cur[1]-1]) {
						cur[1]--;
					}
				}
				
				// 오른쪽 사다리 있으면 타고 쭉 가기
				else if (cur[1] < 99 && isLadder[cur[0]][cur[1]+1]) {
					while (cur[1] < 99 && isLadder[cur[0]][cur[1]+1]) {
						cur[1]++;
					}
				}
				
				// 위로 한칸 올라가기
				cur[0]--;
			}
			
			System.out.println("#" + caseNum + " " + cur[1]);
		}
	}
}
