package programmers.kit.hash.전화번호_목록;

import java.util.*;

class SolutionHash {

    public boolean solution(String[] phone_book) {

        Set<String> set = new HashSet<>();

        for (String phone : phone_book) {
            set.add(phone);
        }

        for (String phone : phone_book) {
            for(int i = 1; i<phone.length(); i++) {
                if(set.contains(phone.substring(0,i)))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        SolutionHash s = new SolutionHash();
        System.out.println(s.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(s.solution(new String[]{"123", "456", "789"}));
        System.out.println(s.solution(new String[]{"12", "123", "1235", "567", "88"}));
    }
}
