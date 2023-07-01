import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		if (x > 0 && y > 0) System.out.println(1);
		if (x < 0 && y > 0) System.out.println(2);
		if (x < 0 && y < 0) System.out.println(3);
		if (x > 0 && y < 0) System.out.println(4);
	}
}
