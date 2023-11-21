import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    private static StringBuilder sb;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        backTrack("", 0);
        System.out.print(sb);
        br.close();
    }

    private static void backTrack(String str, int count) {
        if(count == N) {
            sb.append(str).append("\n");
            return;
        }
        for(int i = 1; i < 10; i++) {
            String s = str + i;
            if(isPrime(Integer.parseInt(s))) {
                backTrack(s, count + 1);
            }
        }
    }

    private static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}