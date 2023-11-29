import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
public class Main {
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static int N, M;
    private static int[] arr;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            arr[X] += 1;
            arr[Y] -= 1;
        }
        br.close();
    }

    private static void solve() {
        if(!check()) {
            System.out.print(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
    }

    private static boolean check() {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= N; i++) {
            //범위 벗어날 경우
            if(arr[i] < 0 || arr[i] > N) return false;
            //중복된 숫자가 나타날 경우
            if(!set.add(arr[i])) return false;
        }
        return true;
    }
}