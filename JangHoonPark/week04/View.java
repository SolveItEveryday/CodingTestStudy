import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= 10; t++) {
            //N 입력
            int N = Integer.parseInt(br.readLine());
            //배열 선언
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            //배열 입력
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            //조망권
            int sum = 0;
            for(int i = 2; i < N - 2; i++) {
                int height = arr[i];
                //인접한 빌딩의 최댓값
                int max = Integer.MIN_VALUE;
                //인접한 2개 이내의 빌딩이 나보다 작을 경우,
                if(arr[i - 2] < height && arr[i - 1] < height && arr[i + 1] < height && arr[i + 2] < height) {
                    max = Math.max(max, arr[i - 2]);
                    max = Math.max(max, arr[i - 1]);
                    max = Math.max(max, arr[i + 2]);
                    max = Math.max(max, arr[i + 1]);
                    sum += (height - max);
                }
            }
            sb.append("#").append(t)
                    .append(" ")
                    .append(sum + "\n");
        }
        //출력
        System.out.print(sb);
        br.close();
    }
}