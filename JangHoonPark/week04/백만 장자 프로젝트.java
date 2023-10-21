import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트 케이스의 수 입력
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            //N 입력
            int N = Integer.parseInt(br.readLine());
            //배열 선언
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            //배열 입력
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long  sum = 0;
            int max = arr[N - 1];
            //이익 계산
            for (int i = N - 2; i >= 0; i--) {
                if (arr[i] < max) {
                    sum += (max - arr[i]);
                } else {
                    max = arr[i];
                }
            }
            System.out.println("#" + test + " " + sum);
        }
        br.close();
    }
}