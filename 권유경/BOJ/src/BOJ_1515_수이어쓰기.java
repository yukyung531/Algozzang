import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1515_수이어쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int pt = 0;

        int base = 0;
        while (base++ <= 30000) {
            String tmp = String.valueOf(base);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == s.charAt(pt))
                    pt++;
                if (pt == s.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String num = br.readLine(); // 공백없이 입력
//        String[] strArr = num.split("");
//
//        int start = Integer.parseInt(strArr[0]);
//        if(start ==0) start = 1;
//        int maxNum = Integer.MAX_VALUE;
//
//        int idx = 0;
//        int res = 0;
//        for(int i = start; i<maxNum; i++){
//            int number = Integer.parseInt(strArr[idx]); // 다음 숫자
////            System.out.println(i+","+idx+","+number);
//            // 첫자리와 같은지 먼저 확인
//            int divide = String.valueOf(i).length(); // i의 자릿수
//            if(10*(divide-1) > 0){
//                int first = i/(10*(divide-1)); // 첫자리 수
//                if(divide > 1 && first == number){
////                    System.out.println(first+"두 자리 이상");
//                    if(idx == strArr.length-1){
////                        System.out.println(i);
//                        res = i;
//                        break;
//                    }
//                    // divide 자릿수만큼 number 자르기
//                    StringBuilder s = new StringBuilder();
//                    for(int j = 0; j<divide; j++){
//                        s.append(strArr[idx + j]);
//                    }
//                    if(i == Integer.parseInt(s.toString())){
//                        idx+= divide;
//                    }
//                    continue;
//                }
//            }
//            // 숫자가 포함되는지 확인
//            if(String.valueOf(i).contains(strArr[idx])){
//                idx++;
////                System.out.println("숫자 포함");
//            }
//
//            if(idx > strArr.length-1) {
//                res = i;
//                break; // 마지막 숫자까지 확인했다면 종료
//            }
//        }
//
//        System.out.println(res);
    }
    // main
}
