import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {
    private static class FireBall {
        int r;
        int c;
        int m;
        int d;
        int s;
        FireBall(int r, int c, int m, int d, int s) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.d = d;
            this.s = s;
        }

    }
    private static int N, K;
    private static ArrayList<FireBall> list;
    private static ArrayDeque<FireBall>[][] space;
    //움직이는 방향
    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        //파이어볼 입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new FireBall(r, c, m, d, s));
        }
        //각 칸에 담을 파이어볼의 큐를 생성
        space = new ArrayDeque[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                space[i][j] = new ArrayDeque<>();
            }
        }
        br.close();
    }
    private static void solve() {
        //K번 명령
        for(int i = 0; i < K; i++) {
            move();
            combineAndDivide();
        }
        //남아 있는 파이어볼의 질량의 개수 계산
        int answer = 0;
        for(FireBall fb: list) {
            answer += fb.m;
        }
        System.out.print(answer);
    }
    //움직이는 함수
    private static void move() {
        for(FireBall fb : list) {
            //행과 열을 자신의 방향 d로 속력 s 만큼 이동
            fb.r = (N + fb.r + dx[fb.d] * (fb.s % N)) % N;
            fb.c = (N + fb.c + dy[fb.d] * (fb.s % N)) % N;
            //각 칸에 파이어볼 정보를 큐에 넣는다.
            space[fb.r][fb.c].addLast(fb);
        }
    }
    //파이어볼을 나누는 함수
    private static void combineAndDivide() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //파이어볼이 2개 이상 저장되 었을 경우,
                if (space[i][j].size() >= 2) {
                    int m_sum = 0;
                    int s_sum = 0;
                    int cnt_sum = space[i][j].size();// 합쳐진 파이어볼의 개수
                    int odd = 0;
                    int even = 0;

                    // 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다
                    while (!space[i][j].isEmpty()) {
                        FireBall f = space[i][j].removeFirst();
                        //질량 합
                        m_sum += f.m;
                        //속력합
                        s_sum += f.s;

                        // 모두 홀수 짝수 개수 계산
                        if (f.d % 2 == 0) {
                            odd += 1;
                        } else {
                            even += 1;
                        }
                        list.remove(f);
                    }

                    //나누어진 파이어볼의 질량, 속력, 방향을 계산
                    int nm = m_sum / 5;

                    //파이어볼 소멸
                    if (nm == 0)
                        continue;

                    // 속력은 합쳐진 파이어볼 속력합/ 합쳐진 파이어볼 개수
                    int ns = s_sum / cnt_sum;

                    //모두 홀수, 짝수 일경우 방향 짝수
                    if (odd == cnt_sum || even == cnt_sum) {
                        for (int k = 0; k < 8; k += 2) {
                            list.add(new FireBall(i, j, nm, k, ns));
                        }
                    }
                    //그게 아닐 경우 방향 홀수
                    else {
                        for (int k = 1; k < 8; k += 2) {
                            list.add(new FireBall(i, j, nm, k, ns));
                        }
                    }
                } else {
                    /*
                        큐에 클리어 하는 이유? => 큐의 사용용도는 파이어볼을 나누는 용도이고,
                        claer()되는 fireBall이 list에는 저장되어있음
                     */
                    space[i][j].clear();
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}