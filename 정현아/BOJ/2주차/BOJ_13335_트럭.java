package BOJ_13335_트럭;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int truckNum = sc.nextInt(); // truckNum: 트럭의 갯수
		int bridgeLen = sc.nextInt(); // bridgeLen: 다리의 길이
		int maxWeight = sc.nextInt(); // maxWeight: 다리의 최대 하중

		Queue<Integer> truckQueue = new LinkedList<>(); // truckQueue: 트럭 모음 큐

		// 트럭의 무게를 입력 받아서 truckQueue에 저장
		for (int i = 0; i < truckNum; i++) {
			truckQueue.add(sc.nextInt());
		}

		// bridgeWeight: 다리의 현재 올라와 있는 트럭의 무게
		Queue<Integer> bridgeWeight = new LinkedList<>();

		// 올라오기 전엔 일단 모두 무게 0임
		for (int i = 0; i < bridgeLen; i++) {
			bridgeWeight.add(0);
		}

		int time = 0; // time: 총 걸린 시간
		int sumWeight = 0; // sumWeight: 갱신되는 다리의 총합 무게

		while (!bridgeWeight.isEmpty()) {

			time++;
			sumWeight -= bridgeWeight.poll(); // 시간이 흐르면 트럭이 한 칸씩 이동하는데, 이때 맨 끝의 트럭은 밖으로 나가면서 현재 다리의 총합 무게가 달라짐

			// 트럭이 남아 있다면
			if (!truckQueue.isEmpty()) {
				// 현재 다리에 있는 트럭 무게 + 올리려는 트럭의 무게 합이 최대 하중을 넘지 않는다면
				if (sumWeight + truckQueue.peek() <= maxWeight) {
					int truck = truckQueue.poll();
					sumWeight += truck; // 현재 트럭 무게 갱신
					bridgeWeight.add(truck); // 다리에 트럭 하나 올라가니까 올림
				} else {
					bridgeWeight.add(0); // 다리에 트럭이 하나도 안 올라간까 0만큼의 무게 올려 두기
				}
			}

		}

		System.out.println(time);

	}

}
