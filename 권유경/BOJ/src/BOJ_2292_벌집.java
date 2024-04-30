import java.util.Scanner;

public class BOJ_2292_벌집 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if(N == 1){
            System.out.println(1);
            return;
        }

        int total = 1;

        for(int i = 1; i<N; i++){
            int nTotal = total + (6*i);
            if(total<N && N <= nTotal){
                System.out.println(i+1);
                break;
            }
            total = nTotal;
        }

    }
}
