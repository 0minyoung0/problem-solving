import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 난이도 의견의 개수 n
		int n = Integer.parseInt(br.readLine());
		
		// 사용자들이 제출한 난이도 의견
		int[] opinion = new int[n];
		for (int i=0; i<n; i++) {
			opinion[i] = Integer.parseInt(br.readLine());
		}
		Arrays.parallelSort(opinion);
		
		// 앞뒤로 절사할 의견의 개수
		int x = (int) Math.round(0.15 * n);
		
		// 난이도 합
		int sum = 0;
		for (int i=x; i<n-x; i++) {
			sum += opinion[i];
		}
		
		// 답 출력
		System.out.println((int) Math.round((double) sum / (n - 2 * x)));
	}
}
