package programmers.kit.hash.의상;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        int size = clothes.length;

        for (int i = 0; i < size; i++) {
            String category = clothes[i][1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }

        for (int count : map.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[][]{
                {"red_hat", "headgear"},
                {"blue_hat", "headgear"},
                {"white_shirt", "top"},
                {"black_pants", "bottom"},
                {"blue_jeans", "bottom"}
        }));
    }
}
