import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int c = 0;
		for (int i=1; i<(1<<10); i<<=1) {
			if ((a & i) > 0 ^ (b & i) > 0) {
				c += i;
			}
		}
		
		System.out.println(c);
	}
}
