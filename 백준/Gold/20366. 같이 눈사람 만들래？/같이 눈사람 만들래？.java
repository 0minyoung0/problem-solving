import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 눈덩이의 수
		int N = Integer.parseInt(br.readLine());
		
		// 각 눈덩이의 지름
		int[] H = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			H[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(H);
		
		// 답을 저장할 변수
		int ans = Integer.MAX_VALUE;
		
		// 두 눈사람의 머리가 될 눈덩이의 인덱스 i1과 i2 고르기 (i1 < i2)
		find: for (int i1=0; i1<N-3; i1++) {
			for (int i2=i1+1; i2<N-2; i2++) {
				
				// 두 눈사람의 몸통이 될 눈덩이의 인덱스 j1과 j2를 투포인터로 찾기 (j1 > j2)
				int j1 = i2 + 2;
				int j2 = i2 + 1;
				
				// 투포인터 탐색
				while (j1 < N) {
					
					// 현재 포인터 기준으로 정답 갱신이 가능한지 확인
					if (ans > Math.abs(H[i1]+H[j1]-H[i2]-H[j2])) {
						
						// 가능하면 갱신
						ans = Math.abs(H[i1]+H[j1]-H[i2]-H[j2]);
						
						// ans가 0이면 탐색 조기 종료
						if (ans == 0) break find;
					}
					
					// j1 == j2 + 1이거나 1번 눈사람의 크기가 더 작은 경우
					if (j1 == j2 + 1 || H[i1]+H[j1] < H[i2]+H[j2]) j1++;
					// j1 > j2 + 1이면서 2번 눈사람의 크기가 더 작거나 같은 경우
					else j2++;
				}
			}
		}
		
		// 답 출력
		System.out.println(ans);
	}
}
