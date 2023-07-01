import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        // 테스트케이스
        for (int t=1; t<=T; t++) {
        	// 게임 맵의 높이
            int h = sc.nextInt();
            // 게임 맵의 너비
            int w = sc.nextInt();
            
            // 전차의 위치를 저장할 변수
            int X = -1;
            int Y = -1;
            
            // 게임 맵 초기 상태
            char[][] map = new char[h][w];
            for (int i=0; i<h; i++) {
            	map[i] = sc.next().toCharArray();
            	for (int j=0; j<w; j++) {
            		// i,j가 전차의 위치
            		if (map[i][j] == '^' || map[i][j] == 'v'
            			|| map[i][j] == '<' || map[i][j] == '>') {
            			X = i;
            			Y = j;
            		}
            	}
            }
            
            // 사용자가 넣을 입력의 개수
            int n = sc.nextInt();
            
            // 입력 문자열
            String input = sc.next();
            
            // 입력 문자열 처리
            for (int i=0; i<n; i++) {
            	// 처리할 명령 문자
            	char oper = input.charAt(i);
            	
            	switch (oper) {
            		// U, D, L, R일때 이동할 수 있으면 이동
            		// 이동할 수 없으면 방향만 바꾸기
            		case 'U':
            			if (X-1 >= 0 && map[X-1][Y] == '.') {
            				map[X-1][Y] = '^';
            				map[X][Y] = '.';
            				X--;
            			}else {
            				map[X][Y] = '^';
            			}
            			break;
            		case 'D':
            			if (X+1 < h && map[X+1][Y] == '.') {
            				map[X+1][Y] = 'v';
            				map[X][Y] = '.';
            				X++;
            			}else {
            				map[X][Y] = 'v';
            			}
            			break;
            		case 'L':
            			if (Y-1 >= 0 && map[X][Y-1] == '.') {
            				map[X][Y-1] = '<';
            				map[X][Y] = '.';
            				Y--;
            			}else {
            				map[X][Y] = '<';
            			}
            			break;
            		case 'R':
            			if (Y+1 < w && map[X][Y+1] == '.') {
            				map[X][Y+1] = '>';
            				map[X][Y] = '.';
            				Y++;
            			}else {
            				map[X][Y] = '>';
            			}
            			break;
            		case 'S':
            			char dir = map[X][Y];
            			// 포탄의 좌표
            			int sX = X;
            			int sY = Y;
            			switch (dir) {
            				case '^':
            					// 인덱스를 벗어나지 않고 맵이 평지나 물이라면 포탄 이동
            					while (sX-1 >= 0 && (map[sX-1][sY] == '.' || map[sX-1][sY] == '-')) {
            						sX--;
            					}
            					// 인덱스를 벗어나지 않고 벽돌벽이면 부수기
            					if (sX-1 >= 0 && map[sX-1][sY] == '*') {
            						map[sX-1][sY] = '.';
            					}
            					break;
            				case 'v':
            					// 인덱스를 벗어나지 않고 맵이 평지나 물이라면 포탄 이동
            					while (sX+1 < h && (map[sX+1][sY] == '.' || map[sX+1][sY] == '-')) {
            						sX++;
            					}
            					// 인덱스를 벗어나지 않고 벽돌벽이면 부수기
            					if (sX+1 < h && map[sX+1][sY] == '*') {
            						map[sX+1][sY] = '.';
            					}
            					break;
            				case '<':
            					// 인덱스를 벗어나지 않고 맵이 평지나 물이라면 포탄 이동
            					while (sY-1 >= 0 && (map[sX][sY-1] == '.' || map[sX][sY-1] == '-')) {
            						sY--;
            					}
            					// 인덱스를 벗어나지 않고 벽돌벽이면 부수기
            					if (sY-1 >= 0 && map[sX][sY-1] == '*') {
            						map[sX][sY-1] = '.';
            					}
            					break;
            				case '>':
            					// 인덱스를 벗어나지 않고 맵이 평지나 물이라면 포탄 이동
            					while (sY+1 < w && (map[sX][sY+1] == '.' || map[sX][sY+1] == '-')) {
            						sY++;
            					}
            					// 인덱스를 벗어나지 않고 벽돌벽이면 부수기
            					if (sY+1 < w && map[sX][sY+1] == '*') {
            						map[sX][sY+1] = '.';
            					}
            					break;
        					default:
        						break;
            			}
            			break;
        			default:
            			break;	
            	}
            }
            // 답 출력
            System.out.print("#" + t + " ");
            for (int i=0; i<h; i++) {
            	for (int j=0; j<w; j++) {
            		System.out.print(map[i][j]);
            	}System.out.println();
            }
        }
    }
}