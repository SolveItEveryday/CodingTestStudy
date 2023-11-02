import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            //배열 입력
            for(int i = 0; i < N; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            //오름차순 정렬
            Collections.sort(arr);
            int lastTime = arr.get(arr.size() - 1);
            int sum = 0;
            String answer = "Possible";
            //손님이 0초 이후에 올 수 있다. => 0초에는 붕어빵이 없음
            if(arr.get(0) == 0) {
                answer = "Impossible";
            }
            else {
                for (int time = 1; time <= lastTime; time++) {
                    //손님이 없을 경우
                    if (arr.isEmpty()) {
                        break;
                    }
                    //붕어빵이 만들어질 경우
                    if (time % M == 0) {
                        sum += K;
                    }
                    //손님이 오셨다면,
                    if (arr.get(0) == time) {
                        //붕어빵 준다.
                        sum -= 1;
                        //불가능할 경우
                        if (sum < 0) {
                            answer = "Impossible";
                            break;
                        }
                        //손님이 왔으므로, 제거
                        arr.remove(0);
                    }
                }
            }
            //출력 형식 저장
            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }
        //출력
        System.out.print(sb);
        br.close();
    }
}