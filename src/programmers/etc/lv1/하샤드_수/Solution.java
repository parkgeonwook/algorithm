package programmers.etc.lv1.하샤드_수;

class Solution {
    public boolean solution(int x) {
        int origin = x;

        int sum = 0;
        while(x / 10 != 0) {
            sum += x % 10;
            x /= 10;
        }
        sum += x;

        return origin % sum == 0;
    }
}
