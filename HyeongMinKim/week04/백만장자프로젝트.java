import java.io.*;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            long result = 0;
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int max = arr[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                // 최대 매매가 교체
                if(max < arr[j]) max = arr[j];
                // 판매
                else result += (max - arr[j]);
            }

            sb.append("#" + (i + 1) + " " + result + "\n");
        }

        System.out.println(sb);
    }
}
