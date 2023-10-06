import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 나라
            arr[i][1] = Integer.parseInt(st.nextToken()); // 금
            arr[i][2] = Integer.parseInt(st.nextToken()); // 은
            arr[i][3] = Integer.parseInt(st.nextToken()); // 동
        }

        // 메달 순위 규칙에 따라 순위가 높은 순으로 나라들을 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]) return 1;
                else if(o1[1] > o2[1]) return -1;
                else if (o1[2] < o2[2]) return 1;
                else if (o1[2] > o2[2]) return -1;
                else if (o1[3] < o2[3]) return 1;
                else if (o1[3] > o2[3]) return -1;
                else return 0;
            }
        });

        // 국가 K의 금, 은, 동 메달 수
        int gold = -1, silver = -1, bronze = -1;
        for (int i = 0; i < n; i++) {
            if(arr[i][0] == k) {
                gold = arr[i][1];
                silver = arr[i][2];
                bronze = arr[i][3];
                break;
            }
        }

        // 등수 확인
        int result = 1;
        for (int i = 0; i < n; i++) {
            if(arr[i][1] != gold || arr[i][2] != silver || arr[i][3] != bronze) {
                result += 1;
            } else break;
        }

        System.out.println(result);
    }
}
