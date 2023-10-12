import java.io.*;
import java.util.*;

class Main {
    static class Node implements Comparable<Node> {
        int depth; // 노드의 깊이
        String name; // 노드의 이름
        HashMap<String, Node> child; // 노드의 자식 노드

        public Node(int depth, String name) {
            this.depth = depth;
            this.name = name;
            child = new HashMap<>();
        }

        @Override
        public int compareTo(Node n) { // 우선순위 큐를 위한 compareTo 메소드
            if (n.depth == this.depth) { // 깊이가 같을 경우 사전순 우선
                return this.name.compareTo(n.name);
            }
            return n.depth - this.depth; // 깊이가 깊은 순 우선
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Node> floorOne = new HashMap<>(); // 1층 노드를 담을 map

        int n = Integer.parseInt(bufferedReader.readLine());
        for (int t = 0; t < n; t++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int k = Integer.parseInt(st.nextToken()); // 먹이 개수

            String root = st.nextToken();
            // 새로운 1층 먹이일 경우
            if (!floorOne.containsKey(root)) {
                floorOne.put(root, new Node(0, root));
            }
            Node node = floorOne.get(root);

            for (int i = 1; i < k; i++) {
                String key = st.nextToken();
                // 해당 층의 해당 노드에 대한 새로운 자식 노드일 경우
                if (!node.child.containsKey(key)) {
                    node.child.put(key, new Node(node.depth + 1, key));
                }
                node = node.child.get(key);
            }
        }

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (Node value : floorOne.values()) {
            pq.add(value);
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            // 깊이만큼 "--" 잇기
            for (int i = 0; i < node.depth; i++) {
                sb.append("--");
            }
            sb.append(node.name).append("\n");
            // 해당 개미굴을 진입하도록 자식 노드 pq에 추가
            for (Node child : node.child.values()) {
                pq.add(child);
            }
        }

        System.out.print(sb);
    }
}

