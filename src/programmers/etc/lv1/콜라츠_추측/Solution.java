package programmers.etc.lv1.콜라츠_추측;

class Solution {
    public int solution(int num) {
        int count = 0;

        long n = num; // 오버플로우 방지
        while(n != 1 && count < 500) {
            count++;
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n = (3*n)+1;
            }
        }

        if(count >= 500) {
            return -1;
        }
        return count;
    }
}
