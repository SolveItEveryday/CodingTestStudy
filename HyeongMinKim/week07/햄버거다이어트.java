import java.io.*;
import java.util.*;

class Solution {
    static int n, l, max;
    static ArrayList<int[]> al;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            al = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                al.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            max = 0;
            backtrack(-1, 0, 0);
            sb.append("#" + (i + 1) + " " + max + "\n");
        }
        System.out.println(sb);
    }

    static void backtrack(int x, int score, int kaloe) {
        if (kaloe > l) return;
        if (score > max) max = score;

        for (int i = x + 1; i < n; i++) {
            int[] now = al.get(i);
            backtrack(i, score + now[0], kaloe + now[1]);
        }
    }
}

