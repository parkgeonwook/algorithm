package programmers.kit.sort.H_Index;

import java.util.*;

//단기 이해 o, 다시
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}
