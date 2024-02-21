import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BOJ_2533_사회망서비스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // 친구관계 저장할 리스티 배b
        List<Integer>[] list = new ArrayList[N+1];

        // 각 리스트 초기화
        for(int i = 0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        // 친구관계 입력
        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        // 얼리어댑터 저장할 Set
        Set<Integer> earlyAdaptor = new HashSet<>();
        // 친구가 한명뿐인 사람들 저장
        List<Integer> oneFriend = new ArrayList<>();

        // 리스트의 크기가 1인(친구가 한명뿐인 사람) 인덱스는 그 친구가 무조건 얼리어댑터여야 한다.
        for(int i = 0; i<list.length; i++){
            if(list[i].size() == 1) {
                earlyAdaptor.add(list[i].get(0));
                oneFriend.add(i);
                // 친구가 한명뿐인 사람의 값을 비운다.
                list[i].clear();
            }
        }

//        for(int i = 0; i<list.length; i++){
//            System.out.println(list[i]);
//        }

        // earlyAdaptor 수
        int result = earlyAdaptor.size();

        // 친구관계 리스트에서 친구가 한명뿐인 사람들의 값을 친구리스트에서 지우자.
        for(int i = 0; i<oneFriend.size(); i++){
            for(int j = 0; j<list.length; j++){
                if(list[j].contains(oneFriend.get(i))){
                    list[j].remove(Integer.valueOf(oneFriend.get(i)));
                }
            }
        }

//                for(int i = 0; i<list.length; i++){
//            System.out.println(list[i]);
//        }

        // earlyAdaptor에 포함되는 값도 지우자
        for(int i = 0; i<list.length; i++){
            Iterator<Integer> iterator = earlyAdaptor.iterator();
            while (iterator.hasNext()) {
                Integer value = iterator.next();
                list[i].remove(value);
            }
        }

                        for(int i = 0; i<list.length; i++){
            System.out.println(list[i]);
        }
        List<Integer> newList = new ArrayList<>();

        // 이제 리스트의 크기가 0이 아닌 것이라면, 인덱스와 숫자를 확인하여 새로운 리스트에 넣자.
        for(int i = 0; i<list.length; i++){
            if(list[i].size()!=0){
                newList.add(i);
                for(int j = 0; j<list[i].size(); j++){
                    newList.add(list[i].get(j));
                }
            }
        }

        // 리스트의 숫자중에서 가장 큰 수의 크기로 배열을 만든다.
        int[] arr = new int[newList.size()+1];

        // 리스트를 돌며 수를 카운트한다.
        for(int i =0; i<newList.size(); i++){
            arr[newList.get(i)]++;
        }

        // 카운트된 수가 1이 있다면 earlyAdaptor의 수를 1 더한다.
        for(int i = 0; i<arr.length; i++){
            if(arr[i]==1){
                result++;
            }
        }

        System.out.println(result);
    }
    // main
}
