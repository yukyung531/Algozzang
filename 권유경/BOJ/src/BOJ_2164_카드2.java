import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_2164_카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<=N; i++){
            queue.add(i);
        }

        int cards = N; // 남아있는 카드

        while(cards > 1){
            queue.poll(); // 맨 위 카드 버림
            int card = queue.poll(); // 그 다음 맨 위 카드를 꺼냄
            queue.add(card); // 그 카드를 맨 밑으로 보냄

            cards--; // 카드 한 장을 버린 것이 됨.
        }

        System.out.println(queue.poll());
    }
}
