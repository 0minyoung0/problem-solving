import java.io.*;
import java.util.*;

public class Main {
	static int[][] board;
	static List<int[]> blankList;
	static HashSet<Integer>[] rowSet = new HashSet[9];
	static HashSet<Integer>[] colSet = new HashSet[9];
	static HashSet<Integer>[] recSet = new HashSet[9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		board = new int[9][9];
		blankList = new ArrayList<>();
		for (int i=0; i<9; i++) {
			rowSet[i] = new HashSet<>();
			colSet[i] = new HashSet<>();
			recSet[i] = new HashSet<>();
		}
		
		// 스도쿠 판 정보
		for (int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					blankList.add(new int[] {i, j});
				}
				else {
					rowSet[i].add(board[i][j]);
					colSet[j].add(board[i][j]);
					recSet[recNum(i, j)].add(board[i][j]);
				}
			}
		}
		
		// 백트래킹으로 스도쿠 판 채우기
		backTracking(0);
		
		// 답 출력
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				System.out.print(board[i][j] + " ");
			}System.out.println();
		}
	}
	
	private static int recNum(int x, int y) {
		return x/3*3 + y/3;
	}
	
	static boolean find;
	
	private static void backTracking(int cnt) {
		
		// 빈칸을 모두 채운 경우
		if (cnt == blankList.size()) {
			find = true;
			return;
		}
		
		// cnt번째 빈칸의 좌표
		int[] cur = blankList.get(cnt);
		int curX = cur[0];
		int curY = cur[1];
		
		// 각 숫자가 들어갈 수 있는지 확인
		for (int num=1; num<=9; num++) {
			if (!possible(curX, curY, num)) continue;
			
			// 들어갈 수 있는 숫자를 넣고 재귀호출
			rowSet[curX].add(num);
			colSet[curY].add(num);
			recSet[recNum(curX, curY)].add(num);
			board[curX][curY] = num;
			backTracking(cnt+1);
			
			// 끝났으면 리턴
			if (find) return;
			
			// 안끝났으면 원상복구
			rowSet[curX].remove(num);
			colSet[curY].remove(num);
			recSet[recNum(curX, curY)].remove(num);
		}
	}
	
	private static boolean possible(int x, int y, int num) {
		if (rowSet[x].contains(num)) return false;
		if (colSet[y].contains(num)) return false;
		if (recSet[recNum(x, y)].contains(num)) return false;
		return true;
	}
}
