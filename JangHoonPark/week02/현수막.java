import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int M, N;
    private static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    private static int[] dy = {1, -1, 0, 1, -1, 1, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //가로 세로 입력
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        //배열 초기화
        map = new int[M][N];
        visited = new boolean[M][N];
        //입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                //새로운 글자를 발견했다면,
                if(!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    answer += 1;
                }
            }
        }
        System.out.print(answer);
        br.close();
    }
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 8; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if(isNotRange(mx, my)) continue;
            if(!visited[mx][my] && map[mx][my] == 1) {
                dfs(mx, my);
            }
        }
    }
    private static boolean isNotRange(int x, int y) {
        return x < 0 || x >= M || y < 0 || y >= N;
    }
}