import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String input = br.readLine();
			System.out.print((char)input.charAt(0));
			System.out.println((char)input.charAt(input.length()-1));
		}
	}
}
