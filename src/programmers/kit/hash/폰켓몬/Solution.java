package programmers.kit.hash.폰켓몬;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }

        return Math.min(nums.length / 2, set.size());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{3,3,3,2,2,4}));
    }
}
