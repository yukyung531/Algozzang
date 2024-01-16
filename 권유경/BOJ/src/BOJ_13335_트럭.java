
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1. 다리 위에 동시에 올라갈 수 있는 트럭의 수(W)는 정해져 있으므로, 그 수만큼 q에 넣어준다.
 * (LinkedLIst 보다 ArrayDeque의 성능이 더 좋다고 하여 ArrayDeque 사용함.)
 * 2. while문 시작 => 남아있는 트럭이 없을 때까지
 * 3. while문이 반복될 때마다 시간(time) 증가
 * 4. 새로운 트럭을 넣기 위해 q에서 하나를 뺀 후, 뺀 값을 다리 위의 트럭 무게(sum)에 더해준다.
 * 5. 새로운 트럭을 넣었을 때, 최대하중보다 작거나 같다면 새로운 트럭을 넣고, 합(sum)에 더한다.
 * 6. 새로운 트럭을 넣은 후, 남아있는 트럭의 수를 하나 뺀다. => 남아있는 트럭의 수가 없다면 while문 종료
 * 7. 새로운 트럭을 넣었을 때, 최대하중보다 크다면 0을 넣는다.
 * 8. while문 종료 후, 현재까지의 시간(time)과 다리 위에 남아있는 트럭의 합, 즉 다리 위의 트럭이 모두 다리를 건너는 시간을 더한다.
 */


public class BOJ_13335_트럭 {
	static int N, W, L; // 트럭 수, 다리길이, 최대하중
	static Queue<Integer> bridge = new ArrayDeque<Integer>();
	static int sum; // 다리 위에 있는 트럭 무게 합

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		// 다리길이만큼 큐에 0 넣어줌
		for (int i = 0; i < W; i++) {
			bridge.add(0);
		}

		// 초기화
		sum = 0;
		int time = 0;

		st = new StringTokenizer(br.readLine());

		// 첫번째 트럭
		int truck = Integer.parseInt(st.nextToken());

		// 더이상 넣을 트럭이 없을때까지 반복
		while (true) {
			// 반복할 때마다 +1시간
			time++;

			// 트럭을 넣기 위해 q에서 하나를 뺀다.
			sum -= bridge.poll();

			// 새로운 트럭을 넣었을 때, 최대하중보다 작거나 같다면, 즉 다리를 건널 수 있다면
			if (sum + truck <= L) {
				// 새로운 트럭 넣자.
				bridge.add(truck);
				// 다리 위에 있는 트럭 무게 + 새로운 트럭 무게
				sum += truck;
				// 만약 남아있는 트럭 수가 0이라면 중단.
				if (--N == 0)
					break;

				// 다음 입력받을 트럭이 새로운 트럭이 됨
				truck = Integer.parseInt(st.nextToken());

			}
			// 새로운 트럭이 다리를 건널 수 없다면, q에 0을 넣어주자.
			else {
				bridge.add(0);
			}
		}
		// while

		// 새로운 트럭이 없을 때까지의 시간 + 다리 위에 남아있는 트럭들이 건너는 시간
		time += bridge.size();
		System.out.println(time);
	}
	// main
}

// 이 문제도 2시간이나 헤매고 결국 답을 보고 풀었다..ㅠ
// 답을 보니까 쉽다고 느껴지는데, 직접 생각해내기 어려웠다.
// q에 처음에 w만큼 0을 넣는 것, 새로운 트럭이 없다면 0을 넣는 아이디어를 생각해내지 못했다.
// 역시 많은 문제를 풀어보는 것만이 답인 것 같다..
