import java.io.*;

class Main {
    static int arr[][];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            dfs(0, 0, 1, 0);

            sb.append("#" + (i + 1) + "\n");
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sb.append(arr[j][k] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    // 우, 하, 좌, 상
    static int rx[] = {0, 1, 0, -1};
    static int ry[] = {1, 0, -1, 0};
    static void dfs(int x, int y, int num, int di) {
        arr[x][y] = num;

        int nx = x + rx[di];
        int ny = y + ry[di];
        // 계속 가던 방향으로 갈 수 있을 떄
        if (!(nx < 0 || ny < 0 || nx >= n || ny >= n) && arr[nx][ny] == 0) {
            dfs(nx, ny, num + 1, di);
        } else {
            // 방향전환
            di = (di + 1) % 4;

            nx = x + rx[di];
            ny = y + ry[di];

            // 범위 밖일 때 or 마지막 지점에 도착했을 때
            if ((nx < 0 || ny < 0 || nx >= n || ny >= n) || arr[nx][ny] != 0) return;
            dfs(nx, ny, num + 1, di);
        }
    }
}
