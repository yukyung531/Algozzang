import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐는 최소힙이다.

        int N = Integer.parseInt(br.readLine()); // 연산 수
        for(int i = 0; i<N; i++){
            int X = Integer.parseInt(br.readLine());
            if(pq.isEmpty() && X == 0) System.out.println(0);
            else if(!pq.isEmpty() && X == 0) System.out.println(pq.poll());
            else pq.add(X);
        }

    }
    // main
}
