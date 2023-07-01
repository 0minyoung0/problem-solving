import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 학급의 수
		int N = Integer.parseInt(st.nextToken());
		
		// 각 학급의 학생의 수
		int M = Integer.parseInt(st.nextToken());
		
		// 학급 학생들의 능력치
		int[][] abil = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				abil[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(abil[i]);
		}
		
		// 포인터를 다루기 위한 트리셋
		// int[] : index0(능력치), index1(학급번호), index2(학생번호)
		TreeSet<int[]> ts = new TreeSet<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) return o1[0] - o2[0];
				if (o1[1] != o2[1]) return o1[1] - o2[1];
				return o1[2] - o2[2];
			}
		});
		
		// 각 학급의 첫번째 학생을 트리셋에 추가
		for (int i=0; i<N; i++) {
			ts.add(new int[] {abil[i][0], i, 0});
		}
		
		// 답을 저장할 변수
		int ans = ts.last()[0] - ts.first()[0];
		
		// 최초로 한 학급에서 마지막으로 트리셋에서 제거되는 학생의 능력치
		int minAbil = -1;
		
		// 트리셋이 빌때까지 시뮬레이션
		while (!ts.isEmpty()) {
			
			// 트리셋의 첫번째 학생 제거
			int[] cur = ts.pollFirst();
			
			// 트리셋의 첫번째 학생이 자신의 학급의 마지막 학생인 경우
			if (cur[2] == M - 1) {
				// minAbil이 비어있다면 저장
				if (minAbil == -1) minAbil = cur[0];
				// minAbil이 비어있지 않다면 continue
				else continue;
			}

			// 마지막 학생이 아닌 경우 트리셋에 학생 추가
			else ts.add(new int[] {abil[cur[1]][cur[2]+1], cur[1], cur[2]+1});
			
			// 현재 트리셋에서 답을 갱신할 수 있으면 갱신
			if (minAbil == -1) {
				if (ans > ts.last()[0] - ts.first()[0]) {
					ans = ts.last()[0] - ts.first()[0];
				}
			}
			else {
				if (ans > ts.last()[0] - minAbil) {
					ans = ts.last()[0] - minAbil;
				}
			}
		}
		
		// 답 출력
		System.out.println(ans);
	}
}
