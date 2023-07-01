import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 라운드 수
        int n = Integer.parseInt(br.readLine());
        
        // A와 B의 딱지 비교를 위한 배열
        int[] A = new int[4];
        int[] B = new int[4];
        
        for (int i=0; i<n; i++) {
        	// 배열 초기화
        	for (int j=0; j<4; j++) {
        		A[j] = 0;
        		B[j] = 0;
        	}
        	
        	// A입력 받기
        	st = new StringTokenizer(br.readLine());
        	int temp = Integer.parseInt(st.nextToken());
        	for (int j=0; j<temp; j++) {
        		A[Integer.parseInt(st.nextToken())-1]++;
        	}
        	
        	// B입력 받기
        	st = new StringTokenizer(br.readLine());
        	temp = Integer.parseInt(st.nextToken());
        	for (int j=0; j<temp; j++) {
        		B[Integer.parseInt(st.nextToken())-1]++;
        	}
        	
        	if(A[3] > B[3]) {
        		System.out.println("A");
        	}else if(A[3] < B[3]) {
        		System.out.println("B");
        	}else if(A[2] > B[2]) {
        		System.out.println("A");
        	}else if(A[2] < B[2]) {
        		System.out.println("B");
        	}else if(A[1] > B[1]) {
        		System.out.println("A");
        	}else if(A[1] < B[1]) {
        		System.out.println("B");
        	}else if(A[0] > B[0]) {
        		System.out.println("A");
        	}else if(A[0] < B[0]) {
        		System.out.println("B");
        	}else {
        		System.out.println("D");
        	}
        	
        }
    }
}