import java.util.Scanner;

public class BOJ_5073_삼각형과세변 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while(flag){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // 입력 끝
            if( a ==0 && b == 0 && c ==0){
                flag = false;
                break;
            }

            if(a == b && b == c){
                System.out.println("Equilateral");
                continue;
            }

            // 가장 큰 수 구하기
            int maxnum1 = Math.max(a,b);
            int minnum1 = Math.min(a,b);
            int maxnum2 = Math.max(maxnum1,c);
            int minnum2 = Math.min(maxnum1,c);

            // 만족하지 못하는 경우
            if(minnum1 + minnum2 <= maxnum2){
                System.out.println("Invalid");
                continue;
            }

            if(a == b || b == c || a == c){
                System.out.println("Isosceles");
                continue;
            }

            System.out.println("Scalene");
        }
    }
}
