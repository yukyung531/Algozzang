import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2583_영역구하기 {
    /*
    1. 모눈종이 배열 만든다.
    2. 입력받은 직사각형의 양 끝 좌표를 사용하여 직사각형 안의 값을 -1로 바꾼다.
    3. 모눈종이를 돌면서 0인 곳을 만나면 bfs
    4. bfs를 하면서 각 영역의 크기를 리스트에 저장한다.
    5. 리스트의 크기 = 영역의 개수
    6. 리스트 오름차순 후 출력 => 각 영역의 크기
     */
    static int m, n, k;
    static int[][] area;
    static List<Integer> areaSizes;
    // 우하좌상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 모눈종이의 세로
        m = Integer.parseInt(st.nextToken());
        // 모눈종이의 세로
        n = Integer.parseInt(st.nextToken());
        // 직사각형 개수
        k = Integer.parseInt(st.nextToken());

        // 모눈종이 배열
        area = new int[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            // 왼쪽 위 모서리
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            // 오른쪽 아래 모서리
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            // 직사각형 표시하기
            for (int k = x1; k < x2; k++) {
                for (int l = y1; l < y2; l++) {
                    area[k][l] = -1;
                }
            }
        }
        // 영역 넓이 저장할 리스트
        areaSizes = new ArrayList<>();

        // area 돌면서 bfs
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] == 0) {
                    bfs(new int[]{i, j});
                }
            }
        }

        System.out.println(areaSizes.size());
        Collections.sort(areaSizes);
        for (int i = 0; i < areaSizes.size(); i++) {
            System.out.print(areaSizes.get(i) + " ");
        }

    }

    //main
    public static void bfs(int[] arr) {
        int areaSize = 0;

        areaSize++;
        Queue<int[]> q = new ArrayDeque<>();

        q.add(arr);
        area[arr[0]][arr[1]] = 1;

        while (!q.isEmpty()) {
            int[] next = q.poll();

            for (int d = 0; d < 4; d++) {
                int nextR = next[0] + dr[d];
                int nextC = next[1] + dc[d];

                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && area[nextR][nextC] == 0) {
                    q.add(new int[]{nextR, nextC});
                    area[nextR][nextC] = 1;
                    areaSize++;
                }
            }
        }
        //while

        areaSizes.add(areaSize);
    }
    // bfs

}
