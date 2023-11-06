import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[][] board;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int half = N / 2;
            board = new int[N][N];
            board[half - 1][half - 1] = 2;
            board[half][half] = 2;
            board[half - 1][half] = 1;
            board[half][half - 1] = 1;
            for(int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int rock = Integer.parseInt(st.nextToken());
                board[x][y] = rock;
                othello(x, y, rock);
            }
            int black = 0;
            int white = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(board[i][j] == 1) {
                        black += 1;
                    }
                    else if(board[i][j] == 2) {
                        white += 1;
                    }
                }
            }
            sb.append("#").append(test).append(" ")
                    .append(black).append(" ")
                    .append(white).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    private static void othello(int x, int y, int rock) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }
                int mx = x + dx;
                int my = y + dy;
                //dx, dy에 해당하는 방향에 같은 색깔의 돌이 있는 경우를 체크.
                boolean check = false;
                while (mx >= 0 && mx < N && my >= 0 && my < N && board[mx][my] != 0) {
                    if (board[mx][my] == rock) {
                        check = true;
                        break;
                    }
                    mx += dx;
                    my += dy;
                }
                //같은 색깔의 돌이 있다면, 사이에 있는 돌들을 자신의 색깔로 변경
                while (check) {
                    if (mx == x && my == y) break;
                    board[mx][my] = rock;
                    mx -= dx;
                    my -= dy;
                }
            }
        }
    }
}