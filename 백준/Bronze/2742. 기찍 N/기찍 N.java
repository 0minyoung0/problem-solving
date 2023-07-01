import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=N; i>0; i--) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}
