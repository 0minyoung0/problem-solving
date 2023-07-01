import java.io.*;
import java.util.*;

public class Main {
	static HashMap<Integer, Long> map = new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int maxInput = 4;
		
		int[] input = new int[T];
		for (int i=0; i<T; i++) {
			input[i] = Integer.parseInt(br.readLine());
			if (maxInput < input[i]) maxInput = input[i];
		}
		
		int[] ans = new int[maxInput+1];
		ans[1] = 1;
		ans[2] = 2;
		ans[3] = 4;
		for (int j=4; j<=maxInput; j++) {
			ans[j] = (int)(((long)ans[j-1] + ans[j-2] + ans[j-3]) % 1000000009);
		}
		
		for (int i=0; i<T; i++) {
			System.out.println(ans[input[i]]);
		}
	}
}
