import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 1; test <= T; test++) {
            long N = Long.parseLong(br.readLine());
            long left = 1, right = 1;
            if (N >= 2) {
                long order = N - 1;
                long leftStart = 2;
                long rightStart = 6;
                long d = 4;
                long leftSum =  order * ((2 * leftStart) + ((order - 1) * d)) / 2;
                long rightSum =  order * ((2 * rightStart) + ((order - 1) * d)) / 2;
                left += leftSum;
                right += rightSum;
            }
            sb.append("#").append(test).append(" ")
                    .append(left).append(" ")
                    .append(right).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}