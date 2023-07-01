import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 단위면적에 자라는 참외의 개수
		int k = Integer.parseInt(br.readLine());
		
		// 길이 정보
		int[] length = new int[6];
		for (int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			length[i] = Integer.parseInt(st.nextToken());
		}
		int maxLength1 = 0;
		int maxLength2 = 0;
		int maxIdx1 = -1;
		int maxIdx2 = -1;
		for (int i=0; i<3; i++) {
			if (length[i*2] > maxLength1) {
				maxLength1 = length[i*2];
				maxIdx1 = i*2;
			}
			if (length[i*2+1] > maxLength2) {
				maxLength2 = length[i*2+1];
				maxIdx2 = i*2+1;
			}
		}
		int area = maxLength1 * maxLength2 - length[(maxIdx1+3) % 6] * length[(maxIdx2+3) % 6];
		
		System.out.println(k * area);
	}
}
