import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스의 수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 별 실행
		for (int tc=1; tc<=T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			// 꿈에서 본 그림의 크기 H x W
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			// 선생님의 그림의 크기 N x M
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 롤링해시를 위한 상수 미리 계산
			long pow2W_1 = 1;
			for (int i=0; i<W-1; i++) {
				pow2W_1 *= 2;
			}
			long pow3W_1 = 1;
			for (int i=0; i<W-1; i++) {
				pow3W_1 *= 3;
			}
			long pow3H_1 = 1;
			for (int i=0; i<H-1; i++) {
				pow3H_1 *= 3;
			}
			long pow5H_1 = 1;
			for (int i=0; i<H-1; i++) {
				pow5H_1 *= 5;
			}
			
			// 꿈에서 본 그림 정보
			boolean[][] dPic = new boolean[H][W];
			for (int i=0; i<H; i++) {
				String row = br.readLine();
				for (int j=0; j<W; j++) {
					if (row.charAt(j) == 'o') {
						dPic[i][j] = true;
					}
				}
			}
			
			// 꿈에서 본 그림의 해시 값
			long dHash1 = 0;
			long dHash2 = 0;
			for (int i=0; i<H; i++) {
				
				long temp1 = 0;
				long temp2 = 0;
				for (int j=0; j<W; j++) {
					if (dPic[i][j]) {
						temp1 = temp1 * 2 + 1;
						temp2 = temp2 * 3 + 1;
					}
					else {
						temp1 = temp1 * 2;
						temp2 = temp2 * 3;
					}
				}
				
				dHash1 = dHash1 * 3 + temp1;
				dHash2 = dHash2 * 5 + temp2;
			}
			
			// 선생님의 그림 정보
			boolean[][] tPic = new boolean[N][M];
			for (int i=0; i<N; i++) {
				String row = br.readLine();
				for (int j=0; j<M; j++) {
					if (row.charAt(j) == 'o') {
						tPic[i][j] = true;
					}
				}
			}
			
			// 선생님의 그림에서 1 x W 영역에 해당하는 해시 값 저장
			long[][] tHash1 = new long[N][M-W+1];
			long[][] tHash2 = new long[N][M-W+1];
			for (int i=0; i<N; i++) {
				
				long temp1 = 0;
				long temp2 = 0;
				for (int j=0; j<W; j++) {
					if (tPic[i][j]) {
						temp1 = temp1 * 2 + 1;
						temp2 = temp2 * 3 + 1;
					}
					else {
						temp1 = temp1 * 2;
						temp2 = temp2 * 3;
					}
				}
				
				tHash1[i][0] = temp1;
				tHash2[i][0] = temp2;
				
				// 롤링해시
				for (int j=W; j<M; j++) {
					if (tPic[i][j-W]) {
						temp1 = (temp1 - pow2W_1) * 2;
						temp2 = (temp2 - pow3W_1) * 3;
					}
					else {
						temp1 = temp1 * 2;
						temp2 = temp2 * 3;
					}
					if (tPic[i][j]) {
						temp1 += 1;
						temp2 += 1;
					}
					
					tHash1[i][j-W+1] = temp1;
					tHash2[i][j-W+1] = temp2;
				}
			}
			
			// 답을 저장할 변수
			int ans = 0;
			
			// tHash1, tHash2에 저장된 1xW에 해당하는 해시 값을 HxW에 해당하는 해시 값으로 변환
			for (int j=0; j<M-W+1; j++) {
				long hash1 = 0;
				long hash2 = 0;
				
				for (int i=0; i<H; i++) {
					hash1 = hash1 * 3 + tHash1[i][j];
					hash2 = hash2 * 5 + tHash2[i][j];
				}
				if (dHash1 == hash1 && dHash2 == hash2) {
					ans++;
				}
				
				for (int i=H; i<N; i++) {
					hash1 = (hash1 - pow3H_1 * tHash1[i-H][j]) * 3 + tHash1[i][j];
					hash2 = (hash2 - pow5H_1 * tHash2[i-H][j]) * 5 + tHash2[i][j];
					if (dHash1 == hash1 && dHash2 == hash2) {
						ans++;
					}
				}
				
			}
			
			// 답 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
}
