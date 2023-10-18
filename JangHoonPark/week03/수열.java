import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    private static int[] arr;
    private static int N, K;
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //N, K 입력
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        //배열 선언
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        //배열 값 입력
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }
    private static void solve() {
        //최댓값
        int max = Integer.MIN_VALUE;
        int sum = 0;
        //처음구간 합 계산
        for(int i = 0; i < K; i++) {
            sum += arr[i];
        }
        //최댓값 갱신
        max = Math.max(max, sum);
        //그 다음구간 합 계산
        for(int right = K; right < N; right++) {
            int left = right - K;
            sum += arr[right];
            sum -= arr[left];
            max = Math.max(max, sum);
        }
        //출력
        System.out.print(max);
    }
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}