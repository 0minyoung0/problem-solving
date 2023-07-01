import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 레벨의 수
		int N = Integer.parseInt(br.readLine());
		
		// 각 레벨을 클리어하면 얻는 점수
		int[] score = new int[N];
		for (int i=0; i<N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		// 마지막 레벨부터 앞으로 순회하며 기존 레벨보다 낮은 점수로 만들기
		int ans = 0;
		for (int i=N-2; i>=0; i--) {
			if (score[i] >= score[i+1]) {
				ans += score[i] - score[i+1] + 1;
				score[i] = score[i+1] - 1;
			}
		}
		
		// 답 출력
		System.out.println(ans);
	}
}