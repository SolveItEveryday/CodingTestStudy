import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[m];

        int left = 1, right = 0, result = 0;

        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(br.readLine());
            arr[i] = now;
            if(right < now) right = now;
        }

        while (left <= right) {
            int mid = (left + right) / 2; // 질투심
            int sum = 0; // 질투심이 mid일 때, 보석을 나눠준 학생 수

            for (int i = 0; i < m; i++) {
                sum += arr[i] / mid;
                if (arr[i] % mid != 0) sum += 1;
            }

            // 보석을 나눠줄 수 없는 경우
            if(sum > n) left = mid + 1;
            // 보석을 나눠줄 수 있는 경우
            else {
                right = mid - 1;
                result = mid;
            }
        }

        System.out.println(result);
    }
}
