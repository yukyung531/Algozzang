import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 리스트를 만들 때, 직속 부하를 넣을 리스트를 만들어 놓고, 실제 값은 직속 상사를 입력하는 실수를 해서 꽤 헤맸다.. 으이구

public class BOJ_14267_회사문화1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 직속 부하를 저장할 리스트
        List<Integer>[] list = new ArrayList[N+1];

        for(int i = 0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<N+1; i++){
            int num = Integer.parseInt(st.nextToken());
            // 사장은 직속상사가 없으니까 쳐내자 ~
            if(num == -1) continue;
            // 해당 인덱스에 직속 상사 넣어주기
            list[num].add(i);
        }

        // 칭찬 수치 저장 배열
        int[] arr = new int[N+1];

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            // 칭찬 받을 직원 번호
            int curr = Integer.parseInt(st.nextToken());
            // 칭찬 수치
            int score = Integer.parseInt(st.nextToken());
            // 칭찬 수치 입력
            arr[curr] += score;
        }

        dfs(list, arr, 1);

        for(int i = 1; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    // main

    public static void dfs(List<Integer>[] list, int[] arr, int curr){
        // 직속부하의 수만큼 반복
        for(int i = 0; i< list[curr].size(); i++){
            // 직속 부하
            int junior = list[curr].get(i);
            // 직속부하에게 상사의 점수를 더한다.
            arr[junior] += arr[curr];
            // dfs
            dfs(list,arr,junior);
        }
    }
    // dfs
}
