import java.io.*;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int min;
            int result = 0;
            // 건물마다 조망권 확인
            for (int j = 2; j < n - 2; j++) {
                int left1 = arr[j] - arr[j - 1];
                int left2 = arr[j] - arr[j - 2];
                int right1 = arr[j] - arr[j + 1];
                int right2 = arr[j] - arr[j + 2];

                // 조망권 확보 X
                if (left1 <= 0 || left2 <= 0 || right1 <= 0 || right2 <= 0) continue;

                // 확보된 칸 구하기
                min = Math.min(left1, left2);
                min = Math.min(min, right1);
                min = Math.min(min, right2);

                result += min;
            }
            sb.append("#" + (i + 1) + " " + result + "\n");
        }

        System.out.println(sb);
    }
}

