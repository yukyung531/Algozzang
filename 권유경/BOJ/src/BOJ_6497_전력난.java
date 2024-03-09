import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 입력은 여러 개의 케이스로 구분되어 있다는 것을 인지하지 못하고... 왜 틀렸지 고민하였다..ㅎ
public class BOJ_6497_전력난 {
    static int[] p;
    static List<Node> list;

    static class Node {
        int a;
        int b;
        int c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        // 0, 0 이 출력되기 전까지 반복해야 함.
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken()); // 집의 수
            int n = Integer.parseInt(st.nextToken()); // 길의 수

            if (m == 0 && n == 0) {
                flag = false;
                break;
            }

            list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                Node node = new Node(a, b, c);
                list.add(node);
            }
            // 입력 완료

            // 가중치를 중심으로 오름차순 정렬
            Collections.sort(list, (Node o1, Node o2) -> (o1.c - o2.c <= 0 ? -1 : 1));

            // 부모배열
            p = new int[m + 1];

            // makeset
            for (int i = 1; i < p.length; i++) {
                p[i] = i;
            }

            // 절약하는 비용
            int sum = 0;

            // 연결된 경로의 수
            int road = 0;

            // list 돌면서 서로 그룹이 아니라면 union
            for (int i = 0; i < list.size(); i++) {
                // 두 집의 부모 찾자
                int px = findset(list.get(i).a);
                int py = findset(list.get(i).b);

                // 연결되어 있다면 continue
                if (px == py) continue;

                // 연결되어 있지 않다면 union
                union(px, py);
                // 비용 추가
                sum += list.get(i).c;
                // 경로 추가
                road++;
                // 연결된 경로의 수가 m-1 이면 break
                if (road == m - 1) break;
            }

            // 원래 나가던 비용
            int origin = 0;
            for (int i = 0; i < list.size(); i++) {
                origin += list.get(i).c;
            }

            // 절약 가능한 최대 비용
            System.out.println(origin - sum);
        }

    }

    // main
    public static int findset(int a) {
        if (a != p[a]) {
            return findset(p[a]);
        }
        return p[a];
    }

    public static void union(int x, int y) {
        p[y] = x;
    }
}
