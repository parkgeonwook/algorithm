package programmers.etc.lv1.음양_더하기;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        for(int i = 0; i<absolutes.length; i++) {
            if(!signs[i]) {
                absolutes[i] = -absolutes[i];
            }
        }

        int sum = 0;
        for(int a : absolutes) {
            sum += a;
        }

        return sum;
    }
}
