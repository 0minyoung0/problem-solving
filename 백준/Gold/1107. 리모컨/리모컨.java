import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 수빈이가 이동하려고 하는 채널
		int N = Integer.parseInt(br.readLine());
		
		// 고장난 버튼의 개수
		int M = Integer.parseInt(br.readLine());
		
		// 고장난 버튼 Set
		HashSet<Integer> set = new HashSet<>();
		if (M != 0) {
			st = new StringTokenizer(br.readLine());
			while (M-- > 0) {
				set.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 버튼을 눌러야 하는 횟수 (초기값으로 100에서 +-로 이동하는 경우)
		int ans = Math.abs(N - 100);
		
		// 0으로 이동할 수 있으면 0에서 +-로 이동하는 경우 체크
		if (!set.contains(0)) {
			if (ans > N + 1) ans = N + 1;
		}
		
		// N보다 작거나 같은 채널 중 바로 갈 수 있는 채널 찾기
		int channel = N;
		ch: while (channel > 0) {
			int temp = channel;
			int digit = 0;
			while (temp != 0) {
				if (set.contains(temp%10)) {
					channel--;
					continue ch;
				}
				digit++;
				temp /= 10;
			}
			if (ans > digit + N - channel) ans = digit + N - channel;
			break;
		}
		
		// N보다 큰 채널 중 바로 갈 수 있는 채널 찾기
		channel = N+1;
		ch: while (channel <= 1000000) {
			int temp = channel;
			int digit = 0;
			while (temp != 0) {
				if (set.contains(temp%10)) {
					channel++;
					continue ch;
				}
				digit++;
				temp /= 10;
			}
			if (ans > digit + channel - N) ans = digit + channel - N;
			break;
		}
		
		// 답 출력
		System.out.println(ans);
	}
}
