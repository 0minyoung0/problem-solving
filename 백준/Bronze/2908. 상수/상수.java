import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int x = A % 10;
		A /= 10;
		x *= 10;
		x += A % 10;
		A /= 10;
		x *= 10;
		x += A;
		
		int B = sc.nextInt();
		int y = B % 10;
		B /= 10;
		y *= 10;
		y += B % 10;
		B /= 10;
		y *= 10;
		y += B;
		
		if (x > y) System.out.println(x);
		else System.out.println(y);
	}
}
