import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    private static boolean[] visited;
    private static int N, P;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        visited = new boolean[1001];
        br.close();
    }

    private static void solve() {
        visited[N] = true;
        int movePoint = N;
        int cycleStart = -1;
        //시작점을 구함
        while(true) {
            int target = (movePoint * N) % P;
            if(visited[target]) {
                cycleStart = target;
                break;
            }
            visited[target] = true;
            movePoint = target;
        }
        //시작점의 개수부터 구해야함
        int answer = 1;
        //시작점에 초기값을 넣음
        movePoint = cycleStart;
        //반복되는 서로 다른 수의 개수를 구한다.
        while(true) {
            int target = (movePoint * N) % P;
            if(target == cycleStart) {
                break;
            }
            answer += 1;
            movePoint = target;
        }
        System.out.print(answer);
    }
}