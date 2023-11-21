import java.io.*;

class Main {
    static int n;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        backtrack("2");
        backtrack("3");
        backtrack("5");
        backtrack("7");

        bw.flush();
    }

    static void backtrack(String value) throws IOException {
        int v = Integer.parseInt(value);
        for (int i = 2; i <= v / 2; i++) {
            if (v % i == 0) return;
        }

        if (value.length() == n) {
            bw.write(value + "\n");
            return;
        }

        for (int i = 1; i < 10; i++) {
            backtrack(value + i);
        }
    }
}
