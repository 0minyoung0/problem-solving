import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		
		// 테스트케이스의 개수
		int TC = Integer.parseInt(br.readLine());
		
		// 테스트케이스 별로 실행
		for (int T=1; T<=TC; T++) {
			
			// 원자들의 수
			int N = Integer.parseInt(br.readLine());
			
			// 원자들의 x위치, y위치, 이동 방향, 보유 에너지
			int[] x = new int[N+1];
			int[] y = new int[N+1];
			int[] dir = new int[N+1];
			int[] K = new int[N+1];
			for (int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				
				// x,y 좌표는 *2+2000해서 저장
				x[i] = Integer.parseInt(st.nextToken())*2+2000;
				y[i] = Integer.parseInt(st.nextToken())*2+2000;
				
				dir[i] = Integer.parseInt(st.nextToken());
				K[i] = Integer.parseInt(st.nextToken());
			}
			
			// 남은 원자 수
			int remain = N;
			
			// 원자들이 소멸되면서 방출하는 에너지의 총합을 저장할 변수
			int ans = 0;
			
			// 원자를 0.5초씩 총 2000초간 이동시키면서 충돌하면 소멸시 발생하는 에너지 저장
			simulation: for (int t=1; t<=4000; t++) {
				
				// 원자를 맵에 표시하기 위한 해시 맵
				HashMap<Integer, Integer> hm = new HashMap<>();
				
				// 이동한 좌표에 원자 번호 저장
				for (int i=1; i<=N; i++) {
					if (x[i] == -1) continue;
					x[i] += dx[dir[i]];
					y[i] += dy[dir[i]];
					
					// out of range
					if (x[i] < 0 || x[i] > 4000 || y[i] < 0 || y[i] > 4000) {
						x[i] = -1;
						if (--remain == 0) break simulation;
						continue;
					}
					
					// 해당 좌표에 원자가 이미 있으면 둘 다 제거 (x좌표를 -1로 함)하고 에너지 합산
					if (hm.containsKey(x[i] * 5381 + y[i])) {
						int o = hm.get(x[i] * 5381 + y[i]);
						if (x[o] != -1) {
							x[o] = -1;
							ans += K[o];
							remain--;
						}
						x[i] = -1;
						ans += K[i];
						if (--remain == 0) break simulation;
					}
					
					// 없는 경우 맵에 현재 원자 번호 저장
					else {
						hm.put(x[i] * 5381 + y[i], i);
					}
				}
			}
			
			// 답 출력
			System.out.println("#" + T + " " + ans);
		}
	}
}
