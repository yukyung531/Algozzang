import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_12101_123더하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<String>[] list = new ArrayList[11]; // n은 10까지의 양수
        for(int i = 0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        list[1].add("1");

        list[2].add("1+1");
        list[2].add("2");

        list[3].add("1+1+1");
        list[3].add("1+2");
        list[3].add("2+1");
        list[3].add("3");

        for(int i = 4; i<list.length; i++){
            for(int j = 1; j<4; j++){
                for(String str : list[i-j]){
                    list[i].add(j+"+"+str);
                }
            }
        }

        if(list[n].size() >= k){
            System.out.println(list[n].get(k-1));
        }else System.out.println(-1);


    }
    // main
}

/*
1을 나타내는 식의 사전순 정렬
1

2를 나타내는 식의 사전순 정렬
1+1
2

3을 나타내는 식의 사전순 정렬
1+1+1
1+2
2+1
3

4를 나타내는 식의 사전순 정렬
1+1+1+1
1+1+2
1+2+1
1+3
2+1+1
2+2
3+1

다이나믹 프로그래밍 문제 풀이는 보통,
이전 단계에서부터 생각을 하면 된다.
이 문제는 1, 2, 3의 합으로 어떤 수를 나타내야 하는 문제이므로,

i >= 4일때
D(i) = D(i-1), D(i-2), D(i-3) 으로 구성된다.

예를 들어 위의 4를 나타내는 식의 사전순 정렬을 보면,
1로 시작하는 첫 네개의 식은 D(3) 에서 앞에 1만 붙이고,
2로 시작하는 두개의 식은 D(2) 에서 앞에 2만 붙이고,
3으로 시작하는 마지막 하나의 식은 D(1) 에서 앞에 3만 붙여서 온것이다.
 */