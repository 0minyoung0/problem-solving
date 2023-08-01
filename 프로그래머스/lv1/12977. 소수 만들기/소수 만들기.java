class Solution {
    public int solution(int[] nums) {
        boolean[] isNotPrime = new boolean[2998];
        isNotPrime[1] = true;
        for (int i=2; i*i<=2997; i++) {
            if (isNotPrime[i]) continue;
            for (int j=2*i; j<=2997; j+=i) {
                isNotPrime[j] = true;
            }
        }
        
        int answer = 0;
        
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    if (!isNotPrime[nums[i] + nums[j] + nums[k]]) answer++;
                }
            }
        }

        return answer;
    }
}