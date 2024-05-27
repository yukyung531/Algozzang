import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512_예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 총 지방의 수
        int[] arr = new int[N]; // 각 지방의 금액 저장할 배열
        int total = 0; // 각 지방의 금액 합

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int price = Integer.parseInt(st.nextToken());
            arr[i] = price; // 배열에 값 넣어주고
            total += price; // 합에 저장
        }
        Arrays.sort(arr); // 오름차순 정렬

        int M = Integer.parseInt(br.readLine()); // 총 예산

        // 합이 총 예산을 넘지 않으면 가장 큰 금액 출력
        if(total <= M){
            System.out.println(arr[N-1]);
            return;
        }

        int divide = M/N; // 이 값보다 작은 수 체크 (총 예산/지방 수)
        int countryNum = 0;
        int idx = 0; // 시작할 인덱스(= divide보다 작은 지방 수)

        boolean flag = true;
        while(flag){
            if(arr[idx] > divide){
                flag = false;
            }
            for(int i = idx; i<N; i++){
                if(arr[i] <= divide){
                    M -= arr[i];
                    countryNum++;
                }
            }
            idx = countryNum;
            divide = M/(N-idx);
        }
        // while
        System.out.println(divide);
    }
    // main
}
