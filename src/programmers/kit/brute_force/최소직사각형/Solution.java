package programmers.kit.brute_force.최소직사각형;

class Solution {
    public int solution(int[][] sizes) {

        int n = sizes.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int bigger = Math.max(sizes[i][0], sizes[i][1]);
            int smaller = Math.min(sizes[i][0], sizes[i][1]);

            max = Math.max(max, bigger);
            min = Math.max(min, smaller);
        }

        return max * min;
    }
}