import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayDeque;
public class Main {
    private static int LENGTH = 5;
    private static int TOTAL = 7;
    private static char[][] map;
    private static boolean[] visited;
    private static int[] selected;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //배열 초기화
        map = new char[LENGTH][LENGTH];
        visited = new boolean[LENGTH * LENGTH];
        selected = new int[TOTAL];
        //입력
        for(int i = 0; i < LENGTH; i++) {
            String input = br.readLine();
            for(int j = 0; j < LENGTH; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        answer = 0;
        //백트래킹 수행
        backTrack(0, 0);
        System.out.print(answer);
        br.close();
    }
    private static void backTrack(int depth, int start) {
        if(depth == 7) {
            if(check()) answer += 1;
            return;
        }
        else {
            for(int i = start; i < LENGTH * LENGTH; i++) {
                //선택되지 않은 학생 선택
                if(!visited[i]) {
                    visited[i] = true;
                    //선택된 학생을 기록
                    selected[depth] = i;
                    backTrack(depth + 1, i + 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean check() {
        int yCnt = 0;
        //임도연 파의 개수 구하기
        for(int student : selected) {
            if(map[student / 5][student % 5] == 'Y')
                yCnt += 1;
        }
        //임도연파가 4명 이상이라면 => 소문난 칠공주 x
        if(yCnt > 3) {
            return false;
        }
        //이제 인접해 있는지 확인
        //선택된 학생들을 기록
        ArrayList<Integer> selectList = new ArrayList<>();
        for(int student : selected) {
            selectList.add(student);
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(selected[0]);
        while(!queue.isEmpty()) {
            int student = queue.removeFirst();
            for(int i = 0; i < 4; i++) {
                int mx = student / LENGTH + dx[i];
                int my = student % LENGTH + dy[i];
                if(isNotRange(mx, my)) {
                    continue;
                }
                //인접한 학생들에 선택된 학생들이 있다면,
                if(selectList.contains(mx * LENGTH + my)) {
                    //제거하고
                    selectList.remove(Integer.valueOf(mx * LENGTH + my));
                    //큐에 넣는다.
                    queue.addLast(mx * LENGTH + my);
                }
            }
        }
        return selectList.isEmpty();
    }
    private static boolean isNotRange(int mx, int my) {
        return mx < 0 || mx >= LENGTH || my < 0 || my >= LENGTH ;
    }
}