import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // (x,y), (x+1,y), (x,y+1), (x+1,y+1) 네 점으로 둘러쌓인
        // 넓이가 1인 정사각형을 (x,y) 사각형이라 하자
        // 전체 영역이 가로 세로 100이므로 x와 y의 범위는 0부터 99까지이다.
        
        // (x,y) 사각형이 색종이로 덮였는지 확인하기 위한 boolean 이중 배열
        boolean[][] isCovered = new boolean[100][100];
        
        // 색종이의 수
        int paper = sc.nextInt();
        
        // 색종이 붙이기
        for (int p=0; p<paper; p++) {
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	for (int i=x; i<x+10; i++) {
        		for (int j=y; j<y+10; j++) {
        			isCovered[i][j] = true;
        		}
        	}
        }
        
        // (x,y) 사각형이 색종이로 덮였는지 확인하여 덮여있으면 ans에 +1
        int ans = 0;
        for (int i=0; i<100; i++) {
        	for (int j=0; j<100; j++) {
        		if (isCovered[i][j]) {
        			ans++;
        		}
        	}
        }
        
        // ans 출력
        System.out.println(ans);
    }
}