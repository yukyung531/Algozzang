//우열님코드
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class node {
        public int parent;
        public List<Integer> others;
        node(){
            parent = 0;
            others = new LinkedList<>();
        }
    }

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());

    node[] nodes = new node[N+1];
    for (int i=1; i<=N; i++){
        nodes[i] = new node();
    }

    for (int i=0; i<N-1; i++){
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        nodes[a].others.add(b);
        nodes[b].others.add(a);
    }

    Queue<Integer> q = new ArrayDeque<>();
    q.add(1);

    while (!q.isEmpty()){
        int cur = q.poll();
        for (int val :nodes[cur].others){
            nodes[val].parent = cur;
            nodes[val].others.remove(Integer.valueOf(cur));
            q.offer(val);
        }
    }

    StringBuilder sb = new StringBuilder();

    for (int i=2; i<=N; i++){
        sb.append(nodes[i].parent).append('\n');
    }
    System.out.println(sb);
}
}