import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {
    //방향에 대한 정보를 담는 배열
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //T 입력
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            //N 입력
            int N = Integer.parseInt(br.readLine());
            //값을 담을 2차원 배열
            int[][] arr = new int[N][N];
            //방문 여부
            boolean[][] visited = new boolean[N][N];
            //x, y, 현재 방향에 대한 값 초기화
            int x = 0;
            int y = 0;
            int dir = 0;
            for(int i = 1; i <= N * N; i++) {
                //값을 담고 방문 처리,
                arr[x][y] = i;
                visited[x][y] = true;
                //다음 인접 정점 값 구하기
                int nextX = x + dx[dir];
                int nextY = y + dy[dir];
                //값의 범위를 벗어나거나, 방문했을 경우 방향 전환
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextX][nextY]) {
                    dir = (dir + 1) % 4;
                }
                x += dx[dir];
                y += dy[dir];
            }
            sb.append("#").append(test).append("\n");
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}