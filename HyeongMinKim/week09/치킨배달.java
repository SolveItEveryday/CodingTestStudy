import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static ArrayList<Node> home = new ArrayList<>();
    static ArrayList<Node> chicken = new ArrayList<>();
    static boolean open[];
    static int result = Integer.MAX_VALUE;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String now = st.nextToken();
                if (now.equals("1")) home.add(new Node(i, j));
                else if (now.equals("2")) chicken.add(new Node(i, j));
            }
        }

        open = new boolean[chicken.size()];

        backtrack(0, 0);
        bw.write(result + "\n");
        bw.flush();
    }

    static void backtrack(int start, int select) {
        if (select == m) {
            int sum = 0; // 치킨 거리
            for (int i = 0; i < home.size(); i++) {
                int res = Integer.MAX_VALUE; // i번째 집에서 치킨 집까지 걸리는 최소 거리
                for (int j = 0; j < chicken.size(); j++) {
                    if (!open[j]) continue;
                    int distance = Math.abs(chicken.get(j).x - home.get(i).x) + Math.abs(chicken.get(j).y - home.get(i).y);
                    res = Math.min(res, distance);
                }
                sum += res;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            backtrack(i + 1, select + 1);
            open[i] = false;
        }
    }

}
