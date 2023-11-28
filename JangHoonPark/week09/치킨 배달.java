import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int N, M;
    private static int answer;
    private static ArrayList<Point> chickenPointList;
    private static ArrayList<Point> housePointList;
    private static boolean[] selected;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chickenPointList = new ArrayList<>();
        housePointList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                int board = Integer.parseInt(st.nextToken());
                if(board == 1) housePointList.add(new Point(i, j));
                else if(board == 2) chickenPointList.add(new Point(i, j));
            }
        }

        selected = new boolean[chickenPointList.size()];

        br.close();
    }

    private static void solve() {
        answer = Integer.MAX_VALUE;
        backtracking(0, 0);
        System.out.print(answer);
    }

    private static void backtracking(int count, int idx) {
        if(count == M) {
            int totalDistance = 0;
            for(int i = 0; i < housePointList.size(); i++) {
                int minDistance = Integer.MAX_VALUE;
                for(int j = 0; j < chickenPointList.size(); j++) {
                    if(selected[j]) {
                        int distance = Math.abs(housePointList.get(i).x - chickenPointList.get(j).x)
                                + Math.abs(housePointList.get(i).y - chickenPointList.get(j).y);
                        minDistance = Math.min(minDistance, distance);
                    }
                }
                totalDistance += minDistance;
            }
            answer = Math.min(totalDistance, answer);
            return;
        }

        for(int i = idx; i < chickenPointList.size(); i++) {
            if(!selected[i]) {
                selected[i] = true;
                backtracking(count + 1, i + 1);
                selected[i] = false;
            }
        }
    }
}