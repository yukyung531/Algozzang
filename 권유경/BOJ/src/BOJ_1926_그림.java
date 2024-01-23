import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {
    /*
    1. 도화지의 정보를 입력받는다.
    2. 도화지 배열을 돌면서 1을 만나면 bfs 시작
    3. bfs를 실행한 숫자 = 그림의 개수
    4. 그림의 최대 넓이는 bfs를 돌고 기존 max값과 비교하여 갱신해준다.
     */
    public static class Node {
        // 도화지의 좌표
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // 도화지 세로, 가로
    static int n, m;
    // 도화지 배열
    static int[][] paper;
    // 그림 개수
    static int cnt;
    // 그림 max 넓이
    static int maxSize;
    // 그림 넓이
    static int artSize;
    // 우하좌상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도화지 세로
        n = Integer.parseInt(st.nextToken());
        // 도화지 가로
        m = Integer.parseInt(st.nextToken());

        // 도화지 배열
        paper = new int[n][m];

        // 그림 정보 입력받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 그림 개수
        cnt = 0;
        // 그림 넓이
        maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 그림을 만나면 bfs탐색
                if (paper[i][j] == 1) {
                    bfs(new Node(i, j));
                    cnt++;
                    // 가장 넓은 그림 넓이 갱신
                    if (maxSize < artSize) {
                        maxSize = artSize;
                    }
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxSize);
    }

    // main
    public static void bfs(Node node) {
        artSize = 0;
        Queue<Node> q = new ArrayDeque<>();

        // 시작 위치 넣기
        q.add(node);
        // 그림 넓이 +1
        artSize++;
        // 해당 도화지 좌표값을 0으로 바꾸기
        paper[node.r][node.c] = 0;

        while (!q.isEmpty()) {
            Node next = q.poll();
            // 델타탐색하며
            for (int d = 0; d < 4; d++) {
                int nextR = next.r + dr[d];
                int nextC = next.c + dc[d];

                // 다음 좌표가 도화지 안에 있고, 값이 1이면 q에 넣고 그림 넓이 +1
                if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && paper[nextR][nextC] == 1) {
                    q.add(new Node(nextR, nextC));
                    artSize++;
                    paper[nextR][nextC] = 0;
                }
            }
        }
    }
    //bfs
}
// 별로 어렵지 않은 bfs 문제였다.
// 문제를 다 풀고 다른 사람들의 정답과 비교해보니 다들 비슷하게 풀었다.
// 그런데 나랑 메모리 차이가 너무 많이 나서 buffered로 제출해보니, scanner로 했을 때보다 메모리가 많이 줄었다.
// 230000 kb -> 46000 kb 정도로 많이 차이났다.
// 시간만 빠른 줄 알았는데, 메모리도 적게 사용한다는 걸 이제야 알았다..ㅎ
