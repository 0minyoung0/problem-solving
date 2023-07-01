import java.io.*;
import java.util.*;

public class Solution {
	static int n, core, ans, cnt1, cnt2;
	static int[][] map;
	static List<int[]> data;
	static int[] select;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int X=1; X<=T; X++) {
			n = Integer.parseInt(br.readLine());
			
			// 맵 저장
			map = new int[n][n];
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 가장자리에 있는 코어 2로 변경
			// 두번째에 있고 코어로 막혀있지 않은 코어 2로 변경, ans에 1 추가
			// 그 외의 코어는 길이 계산해서 리스트에 추가
			int temp = 0;
			data = new ArrayList<>();
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (map[i][j] == 1) {
						if (i==0||i==n-1||j==0||j==n-1) {
							map[i][j] = 2;
						}else if ((i==1 && map[0][j]==0)
								||(i==n-2 && map[n-1][j]==0)
								||(j==1 && map[i][0]==0)
								||(j==n-2 && map[i][n-1]==0)) {
							map[i][j] = 2;
							temp++;
						}else {
							int d1 = i;
							int cur = i;
							find: while (cur > 0) {
								if (map[--cur][j] == 1 || map[cur][j] == 2) {
									d1 = -1;
									break find;
								}
							}
							int d2 = n-1-i;
							cur = i;
							find: while (cur < n-1) {
								if (map[++cur][j] == 1 || map[cur][j] == 2) {
									d2 = -1;
									break find;
								}
							}
							int d3 = j;
							cur = j;
							find: while (cur > 0) {
								if (map[i][--cur] == 1 || map[i][cur] == 2) {
									d3 = -1;
									break find;
								}
							}
							int d4 = n-1-j;
							cur = j;
							find: while (cur < n-1) {
								if (map[i][++cur] == 1 || map[i][cur] == 2) {
									d4 = -1;
									break find;
								}
							}
							
							data.add(new int[] {i,j,d1,d2,d3,d4});
						}
					}
				}
			}
			core = data.size();
			
			select = new int[core];
			
			ans = 0;
			cnt1 = 0;
			cnt2 = 0;
			
			// 각 코어의 데이터가 -1이 아닌 경우들에 대해 백트래킹
			func(0);
			
			System.out.println("#" + X + " " + (ans+temp));
		}
	}
	
	private static void func(int k) {
		if (k == core) {
			// 각 코어가 고른 방향에 대해서 계산 후 리턴
			// 맵에 전선을 boolean으로 나타내기
			boolean[][] check = new boolean[n][n];
			
			int length = 0;
			int c = 0;
			// 각 코어의 위치와 전선 길이
			int[] x = new int[core];
			int[] y = new int[core];
			int[] dis = new int[core];
			for (int i=0; i<core; i++) {
				if (select[i] != -1) {
					c++;
					x[i] = data.get(i)[0];
					y[i] = data.get(i)[1];
					dis[i] = data.get(i)[select[i]+2];
					int nx = x[i] + dx[select[i]];
					int ny = y[i] + dy[select[i]];
					while (0<=nx && nx<n && 0<=ny && ny<n) {
						// 만약 이미 전선이있다면 리턴
						if (check[nx][ny]) return;
						
						// 전선 깔기
						check[nx][ny] = true;
						nx += dx[select[i]];
						ny += dy[select[i]];
					}
					length += dis[i];
				}
			}
			
			// 전선 길이 계산
			// 새 코어 개수가 더 많은 경우
			if (c > cnt1) {
				ans = length;
				cnt1 = c;
			}else if (c == cnt1) {
				if (ans > length) ans = length;
			}
			
			return;
		}
		
		// k번째 코어의 방향 결정
		for (int dir=0; dir<4; dir++) {
			// 막힌 경우는 빼고 계산
			if (data.get(k)[dir+2] == -1) continue;
			select[k] = dir;
			func(k+1);
		}
		// 안고른 경우도 계산
		select[k] = -1;
		func(k+1);
	}
}
