import java.util.*;

public class BOJ_1260_DFS와BFS {
    static Stack<Integer> s = new Stack<>();// dfs 사용
    static Queue<Integer> q = new LinkedList<>(); // bfs 사용
    static boolean[] visited; // 방문체크할 배열
    static List<Integer>[] listArr; // 인접한 정점 저장할 리스트 배열
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점 개수
        int M = sc.nextInt(); // 간선 개수
        int V = sc.nextInt(); // 탐색 시작할 번호

        listArr= new ArrayList[N+1]; // 인접한 정점 저장할 리스트 배열

        for(int i = 1; i<listArr.length; i++){
            listArr[i] = new ArrayList<>();
        } // 각 배열의 리스트 초기화

        for(int i = 0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 무방향
            listArr[a].add(b);
            listArr[b].add(a);
        }
        // 정점 정보 저장

        // 오름차순
        for(int i = 1; i<listArr.length; i++){
            Collections.sort(listArr[i]);
        }

        visited = new boolean[N+1];
        DFS(V);
        // DFS
        System.out.println();
        visited = new boolean[N+1];
        BFS(V);
        // BFS

    }
    // main
    public static void DFS(int V){
        s.add(V);
        visited[V] = true;
        System.out.print(V+" ");

        for(int i = 0; i<listArr[V].size(); i++){
            int next = listArr[V].get(i);
            if(!visited[next]){
                DFS(next);
            }
        }
    }
    // DFS

    public static void BFS(int V){
        q.add(V);
        visited[V] = true;
        System.out.print(V+" ");

        while (!q.isEmpty()){
            int t = q.poll();

            for(int i = 0; i<listArr[t].size(); i++){
                int next = listArr[t].get(i);
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                    System.out.print(next+" ");
                }
            }
        }
    }

}
