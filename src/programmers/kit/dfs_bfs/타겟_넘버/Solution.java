package programmers.kit.dfs_bfs.타겟_넘버;

class Solution {
    int count = 0;


    public int solution(int[] numbers, int target) {
        dfs(0, 0, target, numbers);
        return count;
    }

    void dfs(int level, int sum, int target, int[] numbers) {
        if (level == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        dfs(level + 1, sum + numbers[level], target, numbers);
        dfs(level + 1, sum - numbers[level], target, numbers);
    }
}
