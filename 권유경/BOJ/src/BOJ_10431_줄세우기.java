import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_10431_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수

        // 테스트 케이스 수만큼 반복
        for(int tc = 1; tc<=T; tc++){
            sc.nextInt();

            int[] arr = new int[20];

            int cnt = 0; // 물러난 횟수
            // 키 입력받기
            for(int i = 0; i<20; i++){
                arr[i]= sc.nextInt();
            }
            // i

            for(int i =1; i<20; i++){
                // 앞번호가 더 크다면 이동
                for(int j = i-1; j>=0; j--){
                    if(arr[j] > arr[i]){
                        cnt++;
                    }
                }
            }

            System.out.println(tc+" "+cnt);
        }
        // tc
    }
}
