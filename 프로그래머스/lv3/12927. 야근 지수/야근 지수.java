import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        
        int sum = 0;
        for (int work : works) sum += work;
        
        if (n >= sum) return 0;
        sum -= n;
        
        long answer = 0;
        
        Arrays.parallelSort(works);
        for (int i=0; i<works.length; i++) {
            if (works[i] * (works.length - i) < sum) {
                answer += (long) works[i] * works[i];
                sum -= works[i];
            }
            else {
                int quo = sum / (works.length - i);
                int rem = sum % (works.length - i);
                for (int j=i; j<i+rem; j++) {
                    answer += (long) (quo + 1) * (quo + 1);
                }
                for (int j=i+rem; j<works.length; j++) {
                    answer += (long) quo * quo;
                }
                break;
            }
        }
        
        return answer;
    }
}