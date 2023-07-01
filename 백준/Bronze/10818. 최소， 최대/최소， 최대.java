import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int min = Integer.parseInt(st.nextToken());
		int max = min;
		for (int i=1; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (min > temp) min = temp;
			if (max < temp) max = temp;
		}
		
		System.out.println(min + " " + max);
		
	}
}
