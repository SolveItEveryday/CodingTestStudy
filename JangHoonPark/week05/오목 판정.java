import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());
            char[][] board = new char[N][N];
            for(int i = 0; i < N; i++) {
                board[i] = br.readLine().toCharArray();
            }
            String answer = "NO";
            //왼쪽에서 오른쪽으로 내려가는 대각선
            for(int i = 0; i <= N - 5; i++) {
                for(int j = 0; j <= N - 5; j++) {
                    if(board[i][j] == 'o' && board[i + 1][j + 1] == 'o' && board[i + 2][j + 2] == 'o' && board[i + 3][j + 3] == 'o' && board[i + 4][j + 4] == 'o') {
                        answer = "YES";
                    }
                }
            }
            //오른쪽에서 왼쪽으로 내려가는 대각선
            for(int i = 0; i <= N - 5; i++) {
                for(int j = 4; j <= N - 1; j++) {
                    if(board[i][j] == 'o' && board[i + 1][j - 1] == 'o' && board[i + 2][j - 2] == 'o' && board[i + 3][j - 3] == 'o' && board[i + 4][j - 4] == 'o') {
                        answer = "YES";
                    }
                }
            }
            //위 아래
            for(int i = 0; i <= N - 5; i++) {
                for(int j = 0; j <= N - 1; j++) {
                    if(board[i][j] == 'o' && board[i + 1][j] == 'o' && board[i + 2][j] == 'o' && board[i + 3][j] == 'o' && board[i + 4][j] == 'o') {
                        answer = "YES";
                    }
                }
            }
            //오른쪽 왼쪽
            for(int i = 0; i <= N - 1; i++) {
                for(int j = 0; j <= N - 5; j++) {
                    if(board[i][j] == 'o' && board[i][j + 1] == 'o' && board[i][j + 2] == 'o' && board[i][j + 3] == 'o' && board[i][j + 4] == 'o') {
                        answer = "YES";
                    }
                }
            }
            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}