import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st  = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int startIdx = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int result = sum;

        for (int i = k; i < n; i++) {
            sum -= arr[startIdx++];
            sum += arr[i];
            if(result < sum) result = sum;
        }
        System.out.println(result);
    }
}

