import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14940_쉬운최단거리 {
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] visited;
    static int dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];

        Node start = new Node(0, 0);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) { // 시작점 찾기
                    map[i][j] = 0; // 거리를 0으로 만들어두기
                    start.x = i;
                    start.y = j;
                }
            }
        }
        // map 입력 완료

        visited = new boolean[N][M];

        // 시작점에서 BFS
        BFS(start);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    map[i][j] = -1;
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }



    }

    // main
    public static void BFS(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.add(start); // 시작점을 넣자
        visited[start.x][start.y] = true; // 방문처리

        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < 4; i++) { // 상하좌우 확인
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) { // map을 벗어난다면
                    continue;
                }
                if (visited[nx][ny] || map[nx][ny] == 0) { // 이미 방문했거나 벽이라면
                    continue;
                }
                q.add(new Node(nx, ny)); // q에 넣자
                visited[nx][ny] = true; // 방문처리
                map[nx][ny] = map[n.x][n.y] + 1;
            }
        }
    }
}
