import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		boolean[] exist = new boolean[21];
		
		int M = Integer.parseInt(br.readLine());
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = 0;
			switch(st.nextToken()) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				exist[x] = true;
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				exist[x] = false;
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				if (exist[x]) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				exist[x] = !exist[x];
				break;
			case "all":
				for (int i=1; i<=20; i++) {
					exist[i] = true;
				}
				break;
			case "empty":
				for (int i=1; i<=20; i++) {
					exist[i] = false;
				}
				break;
			}
		}
		
		System.out.println(sb);
	}
}