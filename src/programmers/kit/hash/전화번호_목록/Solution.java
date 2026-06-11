package programmers.kit.hash.전화번호_목록;

import java.util.*;

class Solution {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            String current = phone_book[i];
            String next = phone_book[i + 1];

            if (next.startsWith(current)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(s.solution(new String[]{"123", "456", "789"}));
        System.out.println(s.solution(new String[]{"12", "123", "1235", "567", "88"}));
    }
}
