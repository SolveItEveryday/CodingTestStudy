import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            String input = br.readLine();
            int mulNumber = input.length() - 1;
            double value = Double.parseDouble(input.substring(0, 3)) / 100;
            double answer = Math.round((value * 10)) / 10.0;
            if(answer >= 10.0) {
                mulNumber += 1;
                answer /= 10;
            }
            sb.append("#").append(test).append(" ").append(answer).append("*10^").append(mulNumber).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}