import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int arr[] = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            String result = "Possible";
            int bread = 0;
            for (int j = 0; j < n; j++) {
                bread = (arr[j] / m) * k;
                if (bread < (j + 1)) {
                    result = "Impossible";
                }
            }

            sb.append("#" + (i + 1) + " " + result + "\n");
        }

        System.out.println(sb);
    }
}
