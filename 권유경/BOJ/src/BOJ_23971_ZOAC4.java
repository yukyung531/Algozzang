import java.util.Scanner;

public class BOJ_23971_ZOAC4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double H = sc.nextInt(); // 세로
        double W = sc.nextInt(); // 가로
        double N = sc.nextInt()+1; // 세로 간격
        double M = sc.nextInt()+1; // 가로 간격

        int a = (int)Math.ceil(H/N);
        int b = (int)Math.ceil(W/M);

        System.out.println(a*b);


//        int[][] classroom = new int[H][W];

//        int cnt = 0;

//        for(int i = 0; i<H; i+=N+1) {
//            for(int j = 0; j<W; j+=M+1){
//                cnt++;
//            }
//        }


//        for(int i = 0; i<H; i++){
//            for(int j = 0; j<W; j++){
//                System.out.print(classroom[i][j]);
//            }
//            System.out.println();
//        }

//        System.out.println(cnt);
    }
}
