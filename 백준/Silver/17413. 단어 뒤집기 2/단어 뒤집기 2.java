import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Deque<Character> stack = new ArrayDeque<>();
        
        String s = br.readLine();
        boolean isTag = false;
        for (int i=0; i<s.length(); i++) {
        	if (s.charAt(i) == '<') {
        		while (!stack.isEmpty()) {
        			System.out.print(stack.poll());
        		}
        		isTag = true;
        		System.out.print("<");
        	}else if (s.charAt(i) == '>') {
        		isTag = false;
        		System.out.print(">");
        	}else if (isTag) {
        		System.out.print(s.charAt(i));
        	}else if (s.charAt(i) == ' ') {
        		while (!stack.isEmpty()) {
        			System.out.print(stack.poll());
        		}
        		System.out.print(" ");
        	}else { // 단어
        		stack.offerFirst(s.charAt(i));
        	}
        }
        while (!stack.isEmpty()) {
			System.out.print(stack.poll());
		}
    }
}