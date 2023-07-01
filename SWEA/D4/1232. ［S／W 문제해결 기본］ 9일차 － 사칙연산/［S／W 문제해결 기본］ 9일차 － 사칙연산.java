import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트케이스
        for (int t=1; t<=10; t++) {
        	// 정점의 개수
            int n = sc.nextInt();
            
            // 정보를 저장할 배열 선언
            // index 0: 연산자, index 1: left 주소, index 2: right 주소, index 3: value
            int[][] info = new int[n+1][4];

            // 정점의 정보 받아서 저장하기
            for (int i=1; i<=n; i++) {
            	int cur = sc.nextInt();
            	String temp = sc.next();
            	// 숫자인 경우
            	if (temp.charAt(0) != '+' && temp.charAt(0) != '-' 
            		&& temp.charAt(0) != '*' && temp.charAt(0) != '/') {
            		info[cur][3] = Integer.parseInt(temp);
            		continue;
            	}
            	// 연산자인 경우
            	// 연산자 저장
            	info[cur][0] = temp.charAt(0);
            	// 왼쪽 자식노드 주소
            	info[cur][1] = sc.nextInt();
            	// 오른쪽 자식노드 주소
            	info[cur][2] = sc.nextInt();
            }

            // 뒤에서부터 순회하며 연산하기
            for (int i=n; i>0; i--) {
            	// 연산자가 들어있다면 value 계산하기
            	if (info[i][0] != 0) {
            		if (info[i][0] == '+') {
            			info[i][3] = info[info[i][1]][3] + info[info[i][2]][3];
            		}
            		else if (info[i][0] == '-') {
            			info[i][3] = info[info[i][1]][3] - info[info[i][2]][3];
            		}
            		else if (info[i][0] == '*') {
            			info[i][3] = info[info[i][1]][3] * info[info[i][2]][3];
            		}
            		else { // info[i][0] == '/'
            			info[i][3] = info[info[i][1]][3] / info[info[i][2]][3];
            		}
            	}
            }
            
            // 답 출력
            System.out.println("#" + t + " " + info[1][3]);
        }
    }
}