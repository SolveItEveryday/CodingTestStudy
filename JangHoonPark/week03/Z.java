import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    private static int N;
    private static int r, c;
    private static int size;
    private static int count;
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, N);
        count = 0;
        br.close();
    }
    private static void solve() {
        find(size, r, c);
        System.out.print(count);
    }
    private static void find(int size, int r, int c) {
        //size가 1이라면, 행 열에 해당하는 숫자를 다 구한 것이므로,
        if(size == 1) {
            return;
        }
        //1사분면일때,
        if(r < size/2 && c < size/2) {
            find(size/2, r, c);
        }
        //2사분면일때,
        else if(r < size/2 && c >= size/2) {
            count += size * size / 4;
            find(size/2, r, c - size/2);
        }
        //3사분면일때,
        else if(r >= size/2 && c < size/2) {
            count += (size * size / 4) * 2;
            find(size/2, r - size/2, c);
        }
        //4사분면일때,
        else {
            count += (size * size /4) * 3;
            find(size/2, r - size/2, c - size/2);
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}