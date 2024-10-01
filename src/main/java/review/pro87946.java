package review;

public class pro87946 {

    static int answer;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        recur(0, dungeons, k, 0);
        return answer;
    }

    private void recur(int depth, int[][] dungeons, int curPiro, int use) {
        answer = Math.max(answer, use);

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (curPiro >= dungeons[i][0]) {
                visited[i] = true;
                recur(depth + 1, dungeons, curPiro - dungeons[i][1], use + 1);
                visited[i] = false;
            }
        }
    }
}
