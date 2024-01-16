//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BOJ_13335_트럭 {
//
//	static Queue<Integer> q;
//	static int answer;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		int n = Integer.parseInt(st.nextToken());
//		int w = Integer.parseInt(st.nextToken());
//		int L = Integer.parseInt(st.nextToken());
//
//		q = new LinkedList<>();
//		answer = 0;
//
//		st = new StringTokenizer(br.readLine());
//		// 트럭당 시간 체크할 리스트
//		List<int[]> timeCheck = new ArrayList<>();
//
//		// 트럭 무게 받기
//		for (int i = 0; i < n; i++) {
//			timeCheck.add(new int[] { Integer.parseInt(st.nextToken()), 0 });
//		}
//
//		// 첫번째 트럭 넣자
//		int first = timeCheck.get(0)[0];
//		q.add(first);
//		timeCheck.get(0)[1]++;
//		// 시간 증가
//		answer++;
//
////		 q안의 무게 기록
//		int qWeight = first;
//		int truckIdx = 0;
//
//		while (n != 1 && timeCheck.size() > 0 && !q.isEmpty()) {
//
//			for (int[] a : timeCheck) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println();
//
////			if (truckIdx >= n) {
////				truckIdx = 0;
////			}
//
//			// 시간 증가
//			answer++;
//
//			// 트럭 q의 무게랑 새로 받은 트럭 무게의 합 <= L 이라면 q에 넣자
//			if (qWeight + timeCheck.get(truckIdx)[0] <= L) {
//				q.add(timeCheck.get(truckIdx)[0]);
//				// q안의 무게 갱신
//				timeCheck.get(truckIdx)[1]++;
//				qWeight += timeCheck.get(truckIdx)[1];
//			}
//			// q의 time++(timeCheck배열에서 index가 i보다 작은 위치의 값++)
//			for (int j = 0; j < truckIdx; j++) {
//				timeCheck.get(j)[1]++;
//			}
//			// time > w 라면 q, timeCheck에서 뽑쟈
//			if (timeCheck.get(0)[1] > w) {
//				q.poll();
//				timeCheck.remove(0);
//			}
//			truckIdx++;
//		}
//		// while
//
//		System.out.println(answer);
//	}
//	// main
//}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335_트럭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<int[]> bridge = new LinkedList<>();
        int[] truckWeights = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            truckWeights[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0, weightOnBridge = 0, idx = 0;

        while (idx < n) {
            if (!bridge.isEmpty() && bridge.peek()[1] + w == time) {
                weightOnBridge -= bridge.poll()[0];
            }

            if (weightOnBridge + truckWeights[idx] <= L) {
                bridge.offer(new int[]{truckWeights[idx], time});
                weightOnBridge += truckWeights[idx++];
            }

            time++;
        }

        while (!bridge.isEmpty()) {
            time = bridge.peek()[1] + w;
            bridge.poll();
        }

        System.out.println(time + 1);
    }
}

