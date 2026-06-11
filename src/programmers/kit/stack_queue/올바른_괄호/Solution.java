package programmers.kit.stack_queue.올바른_괄호;

class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        int count = 0;

        for(char c : arr) {
            if(c == '(') {
                count++;
            } else {
                if(count == 0) {
                    return false;
                }
                count--;
            }
        }

        if(count > 0)
            return false;

        return true;
    }
}
