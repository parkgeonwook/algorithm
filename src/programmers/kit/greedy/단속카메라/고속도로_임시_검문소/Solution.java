package programmers.kit.greedy.단속카메라.고속도로_임시_검문소;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(
                solution,
                1,
                new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}},
                new int[]{-15, -13, -5},
                2
        );

        runTest(
                solution,
                2,
                new int[][]{{0, 4}, {2, 6}, {5, 9}},
                new int[]{1, 3, 7},
                2
        );

        runTest(
                solution,
                3,
                new int[][]{{1, 3}, {5, 7}},
                new int[]{2, 4, 8},
                -1
        );
    }

    private static void runTest(Solution solution, int testNumber, int[][] routes, int[] candidates, int expected) {
        int result = solution.solution(routes, candidates);
        System.out.println("[test" + testNumber + "] result: " + result + " / expected: " + expected);
    }

    public int solution(int[][] routes, int[] candidates) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(candidates);

        int count = 0;
        int last = -30001;
        int check = 0;
        for (int[] route : routes) {
            if(route[0] <= last && last <= route[1]) {
                continue;
            }

            while(check < candidates.length && candidates[check] <= route[1]) {
                check++;
            }

            int selectedIdx = check - 1;


            if(selectedIdx < 0 || candidates[selectedIdx] < route[0])
                return -1;

            last = candidates[selectedIdx];
            count++;
        }

        return count;
    }
}
