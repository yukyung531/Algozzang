import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1197_최소스패닝트리 {
    public static int[][] edges;
    public static int[] p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // 정점 개수
        int E = sc.nextInt(); // 간선 개수

        edges = new int[E][3];

        for(int i = 0; i<E; i++){
            edges[i][0] = sc.nextInt(); // 정점
            edges[i][1] = sc.nextInt(); // 정점
            edges[i][2] = sc.nextInt(); // 가중치
        }
        // 입력 완료

        // 가중치를 기준으로 오름차순 정렬
//        Arrays.sort(edges, new Comparator<int[]>(){
//            @Override
//            public int compare(int[] o1, int[] o2){
//                return (o1[2]-o2[2] < 0 ? -1 : 1);
//            }
//        });

        // 위의 방법을 간소화 한 코드임
        Arrays.sort(edges, (o1, o2) -> (o1[2]-o2[2] < 0 ? -1 : 1));

        // 부모 배열 만들자
        p = new int[V+1];

        // make-set
        for(int i = 1; i<p.length; i++){
            p[i] = i;
        }

        // 총 가중치
        int ans = 0;
        // 선택된 간선 수
        int num = 0;

        // edges 배열 돌면서 union
        for(int i = 0; i<edges.length; i++){

            int px = findset(edges[i][0]);
            int py = findset(edges[i][1]);

            // 이미 연결되어 있다면 continue
            if(px == py){
                continue;
            }

            // 연결되어 있지 않다면 union
            union(px, py);
            // 가중치 더하자
            ans+= edges[i][2];
            // 간선 수 더하자
            num++;

            // 간선의 수가 V-1 개가 되면 break
            if(num == V-1) break;
        }

        System.out.println(ans);

    }
    // main

    public static void union(int x, int y){
        p[y] = x;
    }

    public static int findset(int a){
        if(a != p[a]){
            return findset(p[a]);
        }
        else{
            return p[a];
        }
    }


}
