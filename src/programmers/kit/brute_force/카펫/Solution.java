package programmers.kit.brute_force.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int mn = brown + yellow;

        int n = 1;
        int m = mn;

        while(true) {
            if(((2*n) + 2 * (m - 2)) == brown && ((m-2) * (n-2)) == yellow)
                return new int[]{m, n};
            else {
                do {
                    n++;
                } while(mn % n != 0);
                m = mn / n;
            }
        }
    }
}
