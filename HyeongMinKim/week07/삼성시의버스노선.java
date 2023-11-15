import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int arr[] = new int[5001];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                for (int k = start; k <= end; k++) {
                    arr[k]++;
                }
            }

            sb.append("#" + (i + 1));
            int p = Integer.parseInt(br.readLine());
            for (int j = 0; j < p; j++) {
                sb.append(" " + arr[Integer.parseInt(br.readLine())]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

