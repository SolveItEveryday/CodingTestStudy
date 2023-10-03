import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] color = new int[M];
        for(int i = 0; i < M; i++) {
            color[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(color);
        //1부터 이분 탐색을 해야하므로,
        int left = 1;
        int right = color[color.length - 1];
        int answer = Integer.MAX_VALUE;
        while(left <= right) {
            //mid 계산
            int mid = (left + right) / 2;

            //mid로 분배 했을때 받을 수 있는 학생 수
            int total = 0;

            for(int i = 0; i < M; i++) {
                total += color[i] / mid;
                //분배했을때 나머지가 있을 경우
                if(color[i] % mid != 0) {
                    //학생이 한명 더 받아야함.
                    total += 1;
                }
            }
            //받을 수 있는 학생 수보다 현재 학생 수보다 더 많다면(인원이 초과라면)
            if(total > N) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        System.out.print(answer);
        br.close();
    }
}