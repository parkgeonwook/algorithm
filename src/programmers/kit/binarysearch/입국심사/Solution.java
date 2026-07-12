package programmers.kit.binarysearch.입국심사;

class Solution {
    public long solution(int n, int[] times) {

        long maxTime = Integer.MIN_VALUE;
        for(long time : times) {
            maxTime = Math.max(maxTime, time);
        }

        long max = maxTime * n;
        long min = 0;

        long answer = -1;
        while(min <= max) {
            long mid = min + (max - min) / 2;
            long sum = 0;

            for(long time : times) {
                sum += mid / time;
            }

            if(sum >= n) {
                answer = mid;

                max = mid -1;
            }

            if(sum < n)
                min = mid + 1;
        }

        return answer;
    }
}