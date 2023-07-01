import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		// 인풋을 받으면서 현재까지의 최대값, 최소값, 합계를 계속 갱신
		for (int caseNum=1; caseNum<=T; caseNum++) {
			// 합계를 저장할 변수 선언
			int sum = 0; 
			// 최대값을 저장할 변수 선언 (인풋의 최소범위로 초기화)
			int max = 0;
			// 최소값을 저장할 변수 선언 (인풋의 최대범위로 초기화)
			int min = 10000;
			
			// 10개의 인풋 받기
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<10; i++) {
				int temp = Integer.parseInt(st.nextToken());
				sum += temp;
				max = Math.max(max, temp);
				min = Math.min(min, temp);
			}
			
			// 최대값과 최소값 빼기
			sum -= max + min;
			
			// 평균 구해서 반올림
			long ans = Math.round((double) sum / 8);
			
			System.out.println("#"+caseNum+" "+ans);
		}
	}
}