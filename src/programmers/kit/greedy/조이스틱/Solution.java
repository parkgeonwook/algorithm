package programmers.kit.greedy.조이스틱;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int move = length-1;

        for(int i = 0; i<length; i++) {
            char current = name.charAt(i);

            int up = current - 'A';
            int down = 'Z' - current + 1;
            answer += Math.min(up, down);

            int next = i + 1;
            while(next < length && name.charAt(next) == 'A') {
                next++;
            }

            int moveRightAndLeft = i * 2 + (length - next);
            int moveLeftAndRight = i + (length-next) * 2;

            move = Math.min(move, moveRightAndLeft);
            move = Math.min(move, moveLeftAndRight);
        }

        return answer + move;
    }
}
