import java.util.*;

class Solution {
    List<Integer> binary = new ArrayList<>();
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            binary.clear();
            while (numbers[i] != 0) {
                binary.add((int)(numbers[i] % 2));
                numbers[i] /= 2;
            }
            int temp = 1;
            while (binary.size() >= temp) temp *= 2;
            while (binary.size() != temp - 1) binary.add(0);
            
            if (func(0, binary.size() - 1) == -1) answer[i] = 0;
            else answer[i] = 1;
        }
        return answer;
    }
    private int func(int start, int end) {
        // 리프노드인 경우
        if (start == end) return binary.get(start);
        
        int mid = (start + end) / 2;
        
        // 자식노드 계산
        int left = func(start, mid - 1);
        int right = func(mid + 1, end);
        
        // 자식노드 중에 불가능한 경우가 이미 있는 경우
        if (left == -1 || right == -1) return -1;
        // 자신이 0인데 자식이 0이 아닌경우
        if (binary.get(mid) == 0 && (left == 1 || right == 1)) return -1;
        
        return binary.get(mid);
    }
}