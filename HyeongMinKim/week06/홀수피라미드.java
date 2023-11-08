import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long left = 1, right = 1;
            long leftPlus = -2, rightPlus = 2;

            for (int j = 1; j < n; j++) {
                leftPlus += 4;
                rightPlus += 4;
                left += leftPlus;
                right += rightPlus;
            }

            sb.append("#" + (i + 1) + " " + left + " " + right + "\n");
        }

        System.out.println(sb);
    }
}
