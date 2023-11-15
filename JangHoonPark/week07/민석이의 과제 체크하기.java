import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 1; test <= T; test++) {
            sb.append("#").append(test).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            //N, k입력
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            boolean[] submit = new boolean[N + 1];
            st = new StringTokenizer(br.readLine(), " ");
            //제출 처리
            for(int i = 0; i < K; i++) {
                submit[Integer.parseInt(st.nextToken())] = true;
            }
            //제출 안한 사람 출력
            for(int i = 1; i <= N; i++) {
                if(!submit[i]) sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        //출력
        System.out.print(sb);
        br.close();
    }
}