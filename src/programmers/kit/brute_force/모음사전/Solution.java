package programmers.kit.brute_force.모음사전;

class Solution {
    String[] s = {"A", "E", "I", "O", "U"};
    int count = 0;
    int answer = 0;

    public int solution(String word) {

        dfs(word, "");
        return answer;
    }

    //StringBuilder를 쓰면 가변 -> 객체 같은 거라 돌아왔을때 기대한 문자열과 다른 상태 (호출해서 변경된 문자열을 사용하게 됨)
    void dfs(String word, String cur) {
        if(cur.equals(word)) {
            answer = count;
            return;
        }

        if(cur.length() == 5) {
            return;
        }

        for(int i = 0; i<5; i++) {
            count++;
            dfs(word, cur + s[i]);

            if(answer != 0) {
                return;
            }
        }
    }
}