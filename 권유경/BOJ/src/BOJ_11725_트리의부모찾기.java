import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. N+1 크기의 리스트를 원소로 가지는 배열을 만든다.
    - 접점의 정보를 저장할 리스트
    - index는 0 부터 시작이므로 입력받을 노드의 마지막 숫자와 맞추기 위해 1을 더해준다.
2. 방문체크 배열(N+1)과 부모노드를 저장할 배열(N+1)을 만든다.
3. q에 1을 넣고 visited[1] = true 한다.
4. q.poll()해서 나온 값과 연결된 노드를 찾아서, 방문체크가 안되어있고, 부모노드를 저장할 배열의 값이 아직 0이라면 q.poll()값을 입력하고 방문체크한다.
    - q가 빌 때까지 반복한다.
 */
public class BOJ_11725_트리의부모찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 노드 개수
            int N = Integer.parseInt(st.nextToken());
        // 리스트를 원소로 가지는 배열
        List<Integer>[] list = new ArrayList[N + 1];

        // 초기화
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        // 정점의 정보를 입력한다.
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int[] arr = new int[N+1];

        boolean[] visited = new boolean[N+1];

        Queue<Integer> q = new LinkedList<>();

        // 루트가 1이므로 1을 q에 넣는다.
        q.add(1);
        // 방문체크하고
        visited[1] = true;
        // q가 빌 때까지 반복한다.
        while (!q.isEmpty()) {
            // q에서 값을 뽑는다.
            int curr = q.poll();

            // 그 값과 연결된 노드가
            for (int i = 0; i < list[curr].size(); i++) {
                // 방문체크가 되어있지 않다면
                if (!visited[list[curr].get(i)]) {
                    // q에 넣고
                    q.add(list[curr].get(i));
                    // 방문체크한다.
                    visited[list[curr].get(i)] = true;
                    // 그 값의 부모가 아직 기록되지 않았다면
                    if (arr[list[curr].get(i)] == 0) {
                        // 기록해준다.
                        arr[list[curr].get(i)] = curr;
                    }
                }
            }
        }
        // while

        for(int i = 2; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    // main
}
