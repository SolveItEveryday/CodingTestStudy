import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Solution {
    private static class Ingredient {
        int score;
        int cal;
        Ingredient(int score, int cal) {
            this.score = score;
            this.cal = cal;
        }
    }
    private static Ingredient[] arr;
    private static int N, L;
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트 케이스의 수 입력
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            //N, L 입력
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            arr = new Ingredient[N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                //점수와 칼로리 입력
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());
                arr[i] = new Ingredient(score, cal);
            }
            answer = Integer.MIN_VALUE;
            backTrack(0,0, 0);
            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    private static void backTrack(int start, int calSum, int scoreSum) {
        //칼로리 합 이하중에서 점수가 높은 것 갱신
        if(calSum > L) {
            return;
        }
        else {
            answer = Math.max(answer, scoreSum);
        }
        for(int i = start; i < arr.length; i++) {
            backTrack(i + 1,calSum + arr[i].cal, scoreSum + arr[i].score);
        }
    }
}