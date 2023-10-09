import java.io.*;
import java.util.*;

class Main {
    static int m, n;
    static int arr[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        visited = new boolean[m][n];

        // 그래프 형성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bfs(i, j)) result += 1;
            }
        }
        System.out.println(result);
    }

    static int rx[] = new int[]{0, 0, -1, 1, -1, 1, -1, 1};
    static int ry[] = new int[]{-1, 1, 0, 0, -1, 1, 1, -1};
    static boolean bfs(int x, int y) {
        // 이미 방문 했거나 글자가 아닌 경우
        if(visited[x][y] || arr[x][y] == 0) return false;
        ArrayDeque<int[]> q = new ArrayDeque();
        q.addLast(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] now = q.pollFirst();

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + rx[i];
                int ny = now[1] + ry[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if(arr[nx][ny] != 1 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.addLast(new int[]{nx, ny});
            }
        }
        return true;
    }
}

