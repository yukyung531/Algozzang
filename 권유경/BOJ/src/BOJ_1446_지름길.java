import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1446_지름길 {
    static class Road {
        int start, dist;

        public Road(int start, int dist) {
            this.start = start;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Road>[] list = new ArrayList[10001];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (arrive - start <= dist || arrive > D) continue; // 지름길이 더 길거나, 도착점보다 길면 continue

            Road road = new Road(start, dist);
            list[arrive].add(road);
        }
        // i

        // 다익스트라
        int[] distance = new int[D + 1]; // 최단 거리 저장할 배열
        Arrays.fill(distance, Integer.MAX_VALUE); // 가장 큰 값으로 일단 채워두기
        distance[0] = 0; // 시작점은 0

        // 최단거리 구하기
        distance[0] = 0; // 0->0까지의 이동거리 : 0
        for (int i = 1; i <= D; i++) {
            if (list[i].size() > 0) {
                // i지점에 도착하는 지름길이 있다면 ? 지름길 중 가장 최단거리로 갱신해주기
                for (Road s : list[i]) {
                    if (distance[s.start] + s.dist > distance[i]) continue; // 이미 갱신되었다면 ?
                    distance[i] = Math.min(distance[i - 1] + 1, distance[s.start] + s.dist);
                }
                continue;
            }
            distance[i] = distance[i - 1] + 1;
        }


        System.out.println(distance[D]); // D거리까지 이동하는데 걸리는 최단거리

    }
    // main
}

/*
5 10
0 2 1
1 3 2
4 7 2
5 10 4
5 9 3
 */