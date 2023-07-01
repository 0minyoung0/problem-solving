import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static List<int[]> list;
	static int ans;
	static boolean[] isUsed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열의 크기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 회전 연산의 개수
		K = Integer.parseInt(st.nextToken());

		// 배열 A
		int[][] A = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 회전 연산 저장
		list = new ArrayList<>();
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			list.add(new int[] { r, c, s });
		}
		
		// 회전 배열의 사용 여부를 저장할 배열
		isUsed = new boolean[K];

		// 답을 저장할 변수 초기화
		ans = 100 * M;

		// 모든 경우의 수 탐색
		BT(0, A);

		// 배열 A의 각 행의 합 중 최솟값 출력
		System.out.println(ans);
	}

	private static void BT(int k, int[][] A) {
		if (k == K) {
			for (int i = 1; i <= N; i++) {
				int temp = 0;
				for (int j = 1; j <= M; j++) {
					temp += A[i][j];
				}
				if (ans > temp)
					ans = temp;
			}
		}
		
		for (int i=0; i<K; i++) {
			if (isUsed[i]) continue;
			isUsed[i] = true;
			BT(k+1, rotate(A, list.get(i)[0], list.get(i)[1], list.get(i)[2]));
			isUsed[i] = false;
		}
		
	}

	private static int[][] rotate(int[][] A, int r, int c, int s) {
		int[][] result = new int[N + 1][];
		for (int i = 1; i <= N; i++) {
			result[i] = Arrays.copyOf(A[i], M + 1);
		}
		for (int i = 1; i <= s; i++) {
			result = rotateLine(result, r, c, i);
		}
		return result;
	}

	private static int[][] rotateLine(int[][] A, int r, int c, int s) {
		int[][] result = new int[N + 1][];
		for (int i = 1; i <= N; i++) {
			result[i] = Arrays.copyOf(A[i], M + 1);
		}

		int cx = r - s;
		int cy = c - s;
		int temp = result[cx][cy];

		while (cx < r + s) {
			result[cx][cy] = result[cx + 1][cy];
			cx++;
		}
		while (cy < c + s) {
			result[cx][cy] = result[cx][cy + 1];
			cy++;
		}
		while (cx > r - s) {
			result[cx][cy] = result[cx - 1][cy];
			cx--;
		}
		while (cy > c - s + 1) {
			result[cx][cy] = result[cx][cy - 1];
			cy--;
		}
		result[cx][cy] = temp;

		return result;
	}
}
