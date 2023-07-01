import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean asc = true;
		boolean desc = true;
		
		int[] arr = new int[8];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<7; i++) {
			int temp = arr[i] - arr[i+1];
			if (temp > 0) asc = false;
			else desc = false;
		}
		
		if (asc) System.out.println("ascending");
		else if (desc) System.out.println("descending");
		else System.out.println("mixed");
	}
}
