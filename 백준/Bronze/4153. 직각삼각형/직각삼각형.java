import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 0) return;
			
			int x = a*a;
			int y = b*b;
			int z = c*c;
			
			if (x==y+z || y==z+x || z==x+y) System.out.println("right");
			else System.out.println("wrong");
		}
	}
}
