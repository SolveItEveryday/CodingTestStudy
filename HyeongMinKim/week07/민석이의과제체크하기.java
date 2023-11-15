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
            int k = Integer.parseInt(st.nextToken());
            boolean arr[] = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                arr[Integer.parseInt(st.nextToken())] = true;
            }

            sb.append("#" + (i + 1));
            for (int j = 1; j <= n; j++) {
                if(!arr[j]) {
                    sb.append(" " + j);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

