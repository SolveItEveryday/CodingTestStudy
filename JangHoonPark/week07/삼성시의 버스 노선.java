import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution {
    private static int STATION_NUMBER = 5001;
    private static int[] station;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //테스트의 케이스의 수 입력
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            //배열 선언
            station = new int[STATION_NUMBER];
            int N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++) {
                //정수 A, B 입력후 정류장 개수 증가
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                for(int k = A; k <= B; k++) {
                    station[k] += 1;
                }
            }
            //P 입력
            int P = Integer.parseInt(br.readLine());
            sb.append("#").append(test).append(" ");
            for(int i = 0; i < P; i++) {
                //버스 노선의 개수 출력
                int C = Integer.parseInt(br.readLine());
                sb.append(station[C]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}