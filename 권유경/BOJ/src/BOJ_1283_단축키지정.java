import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_1283_단축키지정 {
    static List<String> save;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 옵션 개수
        int N = Integer.parseInt(sc.nextLine());

        // 옵션 저장할 리스트 배열
        List<String>[] list = new ArrayList[N];

        // 옵션 저장
        for (int i = 0; i < N; i++) {
            // 리스트 초기화
            list[i] = new ArrayList<>();
            // 옵션 입력
            String input = sc.nextLine();
            // 공백으로 나눠서 저장
            list[i].addAll(Arrays.asList(input.split(" ")));
        }
        // 입력 완료

        // 단축키 저장할 리스트
        save = new ArrayList<>();

        // 첫단어에서 단축키가 지정됐는지 여부
        boolean firstChange = false;

        // 전체 배열 리스트 반복
        for (int i = 0; i < list.length; i++) {
            // 출력
            if(i>0){
                for(int j = 0; j<list[i-1].size(); j++) {
                    System.out.print(list[i - 1].get(j)+" ");
                }
                System.out.println();
            }

            // 각 리스트 반복
            // 첫 글자만 확인
            for (int b = 0; b < list[i].size(); b++) {
                // 기존 입력값
                List<String> originList = Arrays.asList(list[i].get(b).split(""));
                // 첫글자를 확인한 후의 값
                List<String> newList = checkFirst(list[i].get(b));
                // 기존 입력값과 첫글자를 확인한 후의 값이 다르다면 값을 바꿔주자.
                if (!originList.equals(newList)) {
                    StringBuilder sb = new StringBuilder();
                    for(int k = 0; k<newList.size(); k++){
                        sb.append(newList.get(k));
                    }
                    list[i].set(b, String.valueOf(sb));
                    // 첫단어가 단축키로 지정되었다면 다음 줄 확인하자
                    firstChange = true;
                    break;
                }
                firstChange = false;
            }

            // 첫단어에서 단축키가 지정되지 않았다면 두번째 글자부터 확인
            if (!firstChange) {
                // 두 번째 단어부터 확인
                for (int b = 0; b < list[i].size(); b++) {

                    List<String> originList = Arrays.asList(list[i].get(b).split(""));
                    List<String> newList = checkSecond(list[i].get(b));
                    // 기존 입력값과 첫글자를 확인한 후의 값이 다르다면 값을 바꿔주자.
                    if (!originList.equals(newList)) {
                        StringBuilder sb = new StringBuilder();
                        for(int k = 0; k<newList.size(); k++){
                            sb.append(newList.get(k));
                        }
                        list[i].set(b, String.valueOf(sb));
                        break;
                    }
                }
            }
        }

        // 마지막 인덱스 출력
        for(int i = 0; i<list[list.length-1].size(); i++){
            System.out.print(list[list.length-1].get(i)+" ");
        }
        System.out.println();

    }
    // main

    /**
     * 첫 글자 확인(option : 옵션(list[i].get(j))
     */
    public static List<String> checkFirst(String option) {
        List<String> newList = new ArrayList<>();
        // 옵션 수만큼 반복

        // 한글자씩 쪼갠 리스트로 만들기
        newList = new ArrayList<>(Arrays.asList(option.split("")));
        // 첫 글자 확인
        if (save.contains(newList.get(0).toUpperCase())) {
            return newList;
        } else {
            save.add(newList.get(0).toUpperCase());
            newList.add(0, "[");
            newList.add(2, "]");
            return newList;
        }
    }

    /**
     * 두 번째 글자부터 확인
     */
    public static List<String> checkSecond(String option) {
        List<String> newList = new ArrayList<>();
        // 옵션 수만큼 반복
        for (int i = 0; i < option.length(); i++) {
            // 각 단어를 한글자씩 쪼갠 리스트로 만들기
            newList = new ArrayList<>(Arrays.asList(option.split("")));
            // 두 번째 글자부터 확인
            for (int j = 1; j < newList.size(); j++) {
                if (save.contains(newList.get(j).toUpperCase())) {
                    continue;
                } else {
                    save.add(newList.get(j).toUpperCase());
                    newList.add(j, "[");
                    newList.add(j + 2, "]");
                    return newList;
                }
            }
        }
        return newList;
    }


}