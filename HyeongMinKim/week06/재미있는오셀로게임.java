import java.io.*;
import java.util.StringTokenizer;

class Solution {
    static int arr[][];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr = new int[n][n];

            arr[n / 2 - 1][n / 2 - 1] = 2;
            arr[n / 2][n / 2 - 1] = 1;
            arr[n / 2 - 1][n / 2] = 1;
            arr[n / 2][n / 2] = 2;

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken());
                arr[y][x] = v;

                // 돌 먹기 (상,하,좌,우,대각)
                put(x, y, v);
            }

            int black = 0, white = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] == 1) black += 1;
                    else if (arr[j][k] == 2) white += 1;
                }
            }

            sb.append("#" + (i + 1) + " " + black + " " + white + "\n");
        }

        System.out.println(sb);
    }

    // 상, 좌, 하, 우, 왼쪽 위 대각, 오른쪽 아래 대각, 왼쪽 아래 대각, 오른쪽 위 대각
    static int nx[] = {0, -1, 0, 1, -1, 1, -1, 1};
    static int ny[] = {-1, 0, 1, 0, -1, 1, 1, -1};

    static void put(int x, int y, int v) {
        arr[y][x] = v;
        for (int dir = 0; dir < 8; dir++) {
            check(x, y, dir);
        }
    }

    private static void check(int x, int y, int dir) {
        int rx = x + nx[dir];
        int ry = y + ny[dir];

        while (true) {
            if (!isRange(rx, ry) || arr[ry][rx] == 0)
                break;

            if (arr[y][x] != arr[ry][rx]) {
                rx += nx[dir];
                ry += ny[dir];
            } else
                break;
        }

        if (isRange(rx, ry) && arr[ry][rx] == arr[y][x]) {
            while (x != rx || y != ry) {
                arr[ry][rx] = arr[y][x];
                rx -= nx[dir];
                ry -= ny[dir];
            }
        }

    }

    private static boolean isRange(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < n)
            return true;
        return false;
    }
}
