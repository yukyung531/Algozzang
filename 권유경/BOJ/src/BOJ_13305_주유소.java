import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13305_주유소 {
    static class PriceIdx{
        long price, idx;

        public PriceIdx(long price, long idx){
            this.price = price; // 리터당 가격
            this.idx = idx; // 인덱스
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 수

        Long[] dist = new Long[N - 1]; // 거리 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N-1; i++){
            dist[i] = Long.parseLong(st.nextToken());
        }// 거리 입력

        List<PriceIdx> priceList = new ArrayList<>(); // 가격과 인덱스 번호 저장 리스트
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            if(i == N-1){ // 마지막 도시에서의 가격은 고려하지 않아도 됨
                st.nextToken();
                break;
            }
            priceList.add(new PriceIdx(Long.parseLong(st.nextToken()), i));
        }// 리터당 가격 입력(priceList의 크기는 N-1)
        //입력 완료

        // 리터당 가격을 기준으로 오름차순으로 정렬
        Collections.sort(priceList, new Comparator<PriceIdx>() {
            @Override
            public int compare(PriceIdx o1, PriceIdx o2) {
                return o1.price - o2.price <= 0 ? -1 : 1;
            }
        });

        long nowIdx = N-1;
        long total = 0; // 총 주유비

        // 가장 작은 가격부터 그 뒤까지는 가장 작은 가격으로
        for(int i = 0; i<N-1; i++){
            // 현재 인덱스가 다음 인덱스보다 작다면 다음꺼 확인
            if(nowIdx < priceList.get(i).idx) continue;
            for(int j = (int) priceList.get(i).idx; j<nowIdx; j++){
                total += priceList.get(i).price * dist[j];
            }
            nowIdx = priceList.get(i).idx;
        }

        System.out.println(total);

    }
    // main


}
