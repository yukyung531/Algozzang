package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		//전체 트럭 정보 저장할 큐 생성
		Queue<Integer> truck = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		
		//큐에 트럭 정보 추가
		for(int i= 0; i< n; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}
		
		int time = 0; //시간 변수 생성
		int bw = 0;
		
		//현재 다리위에 올라와 있는 트럭 큐 생성
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i =0; i<w ; i++) {
			q.add(0); //0으로 초기화
		}
		
		while(!q.isEmpty()) {
			time++; //시간 증가
			bw = bw - q.poll(); //현재 다리 위에 있는 무게 합에서 가장 끝에 있는 값 뺴기
			
			//지나가야 할 트럭이 남아있다면
			if(!truck.isEmpty()) {
				//지나갈 트럭과 현재 다리 위에 있는 트럭의 합이 L보다 작거나 같으면
				if(truck.peek() + bw <= L) {
					//무게 합치고
					bw = bw + truck.peek();
					//다리 위에 트럭 올리기
					q.offer(truck.poll());
				}
				//합이 L을 초과하면 트럭 대신 0을 추가
				else {
					q.offer(0);
				}
			}
		}
		
		//총 소요된 시간 출력
		System.out.println(time); 
	}
}
