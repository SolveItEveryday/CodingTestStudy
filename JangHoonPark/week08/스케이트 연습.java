import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N 입력
        N = Integer.parseInt(br.readLine());
        //배열 선언
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //배열 거꾸로 넣기
        for(int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }
    private static void solve() {
        //거꾸로 출발, 이전 속력
        int temp = 1;
        //속력의 합
        long sum = 1;
        for(int i = 1; i < N; i++) {
            //이전 속력보다 다음 속력의 제한이 더 크면 속도를 높힌다.
            if(temp < arr[i]) {
                temp += 1;
            }
            //이전 속력보다 다음 속력 제한이 같거나 작다면 속도를 맞춘다.
            else {
                temp = arr[i];
            }
            //속력을 더한다.
            sum += temp;
        }
        //출력
        System.out.print(sum);
    }
}