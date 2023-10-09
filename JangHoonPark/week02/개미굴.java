import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class Main {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //루트 노드
        TreeMap<String, TreeMap> map = new TreeMap<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int K = Integer.parseInt(st.nextToken());
            TreeMap<String, TreeMap> cur = map;
            for(int j = 0; j < K; j++) {
                String key = st.nextToken();
                //새로운 노드가 들어왔을 경우,
                if(!cur.containsKey(key)) {
                    //노드 생성 및 트리를 가리키게함
                    cur.put(key, new TreeMap<>());
                }
                //하단 노드로 이동
                cur = cur.get(key);
            }
        }
        sb = new StringBuilder();
        print(map, 0);
        System.out.print(sb.toString());
        br.close();
    }
    private static void print(TreeMap<String, TreeMap> map, int depth) {
        for(String key: map.keySet()) {
            for(int i = 0; i < depth; i++) {
                sb.append("--");
            }
            sb.append(key + "\n");
            print(map.get(key), depth + 1);
        }
    }
}