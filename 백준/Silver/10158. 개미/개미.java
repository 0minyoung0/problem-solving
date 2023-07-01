import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 격자 공간의 크기
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        // 초기 위치
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        // 개미가 움직일 시간
        int t = Integer.parseInt(br.readLine());
        
        int x = (p + t) % (2 * w);
        int y = (q + t) % (2 * h);
        
        if (x > w) {
        	x = 2*w - x;
        }
        if (y > h) {
        	y = 2*h - y;
        }
        
        System.out.println(x + " " + y);
    }
}