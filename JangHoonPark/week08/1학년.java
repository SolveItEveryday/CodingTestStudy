import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N 입력
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //배열 선언
        int[] arr = new int[N];
        long[][] dp = new long[N][21];
        //배열 입력
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][arr[0]] = 1;
        for(int i = 1; i < N - 1; i++) {
            for(int j = 0; j <= 20; j++) {
                if(dp[i - 1][j] != 0) {
                    int plus = j + arr[i];
                    int minus = j - arr[i];
                    if(0 <= plus && plus <= 20) {
                        dp[i][plus] += dp[i - 1][j];
                    }
                    if(0 <= minus && minus <= 20) {
                        dp[i][minus] += dp[i - 1][j];
                    }
                }
            }
        }
        System.out.print(dp[N - 2][arr[N - 1]]);
    }
}