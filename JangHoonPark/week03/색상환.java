import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    private static int N, K;
    private static int[][] dp;
    private static int MOD = 1_000_000_003;
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        dp = new int[N + 1][N + 1];
        br.close();
    }
    private static void solve() {
        for(int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
        }
        for(int i = 3; i <= N; i++) {
            for(int j = 2; j <= (i + 1) / 2; j++) {
                dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        System.out.print((dp[N - 3][K - 1] + dp[N - 1][K]) % MOD);
    }
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}