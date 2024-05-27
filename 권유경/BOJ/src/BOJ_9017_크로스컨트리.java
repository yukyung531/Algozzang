import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9017_크로스컨트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());

            List<Integer> scoreList = new ArrayList<>(); // 도착 순서 저장 리스트

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i<N; i++){
                int team = Integer.parseInt(st.nextToken());
                scoreList.add(team); // 도착 순서 저장
            }
            HashSet<Integer> hashSet = new HashSet<>();

            for(int i = 0; i<N; i++){
                hashSet.add(scoreList.get(i));
            }

            Iterator iterator = hashSet.iterator(); // hashset 값을 꺼내기 위해 iterator 사용

            // 6명 안되는 것 제외하자
            while(iterator.hasNext()){
                int cnt = 0;
                int teamNum = (int) iterator.next();
                for(int i = 0; i<N; i++){
                    if(scoreList.get(i) == teamNum){
                        cnt++;
                    }
                }
                if(cnt<6){ // 6명이 안되면 값을 0으로 바꾸자.
                    for(int i = 0; i<N; i++){
                        if(scoreList.get(i) == teamNum){
                            scoreList.set(i, 0);
                        }
                    }
                }
            }

            // scoreList 돌면서 0이 아닌 수에 점수를 주자
            List<int[]> arrList = new ArrayList<>(); // 0: 팀, 1: 점수
            int cnt = 1; // 점수
            for(int i = 0; i<scoreList.size(); i++){
                if(scoreList.get(i) != 0){
                    arrList.add(new int[]{scoreList.get(i), cnt});
                    cnt++;
                }
            }

            List<Integer>[] teamList = new ArrayList[201]; // 팀원별로 점수 구할 팀 리스트
            for(int i = 0; i<teamList.length; i++){
                teamList[i] = new ArrayList<>();
            }

            for(int i = 0; i<arrList.size(); i++){
                teamList[arrList.get(i)[0]].add(arrList.get(i)[1]);
            } // 팀원별 점수 추가

            int minNum = Integer.MAX_VALUE; // 최저점
            int win = 0; // 우승팀
            List<Integer> winList = new ArrayList<>(); // 최저점 가진 팀 저장

            List<int[]> sumList = new ArrayList<>(); // 0: 팀, 1: 점수 합

            // 4명까지의 합 구하자
            for(int i = 0; i<teamList.length; i++){
                int sum = 0;
                if(!teamList[i].isEmpty()){
                    for(int j = 0; j<4; j++){
                            sum+= teamList[i].get(j);
                        }
                    sumList.add(new int[]{i, sum});
                    minNum = Math.min(minNum, sum);
                }
            }

            // 가장 작은 값을 가지고 있는 팀 개수 구하자
            for(int i = 0; i<sumList.size(); i++){
                if(sumList.get(i)[1] == minNum){
                    win = sumList.get(i)[0];
                    winList.add(win);
                }
            }

            if(winList.size() == 1){
                System.out.println(win);
                continue;
            }
            else { // 만약 4명까지의 합이 같다면 5번 선수의 값이 가장 작은 것 구하기
                minNum = Integer.MAX_VALUE;
                for(int i = 0; i<winList.size(); i++){
                    minNum = Math.min(minNum, teamList[winList.get(i)].get(4));
                    if(minNum == teamList[winList.get(i)].get(4)){
                        win = winList.get(i);
                    }
                }
            }
            System.out.println(win);
        }
        // tc
    }
}
