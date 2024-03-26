import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_1283_단축키지정 {
    static List<String> save;
    static List<String>[] list;

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

        // 저장된 옵션 확인
        save = new ArrayList<>();

        // 첫단어에서 단축키가 지정됐는지 여부
        boolean firstChange = false;

        // 전체 배열 리스트 반복
        for (int i = 0; i < list.length; i++) {

            // 각 리스트 반복
            for (int b = 0; b < list[i].size(); b++) {

                // list[i]의 단어들을 처음부터 확인
                // 첫 단어 확인
                List<String> originList = Arrays.asList(list[i].get(b).split(""));
                List<String> newList = checkFirst(list[i].get(b));
                if (!originList.equals(newList)) {
                    list[i].set(b, newList.toString());
                    firstChange = true;
                    break;
                }
                firstChange = false;
            }

            if (!firstChange) {
                // 두 번째 단어부터 확인
                for (int b = 0; b < list[i].size(); b++) {

                    List<String> originList = Arrays.asList(list[i].get(b).split(""));
                    List<String> newList = checkSecond(list[i].get(b));
                    if (!originList.equals(newList)) {
                        list[i].set(b, newList.toString());
                        break;
                    }
                }

            }

            // else

        }
//         입력 확인


        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                System.out.print(list[i].get(j).toString());
            }
            System.out.println();
        }

    }
    // main


    /**
     * 첫 글자 확인(option : 옵션(list[i])
     */
    public static List<String> checkFirst(String options) {
        List<String> newList = new ArrayList<>();
        // 옵션 수만큼 반복
        for (int i = 0; i < options.length(); i++) {
            // 한글자씩 쪼갠 리스트로 만들기
            newList = new ArrayList<>(Arrays.asList(options.split("")));
            // 첫 글자 확인
            if (save.contains(newList.get(0))) {
                return newList;
            } else {
                save.add(newList.get(0));
                newList.add(0, "[");
                newList.add(2, "]");
                return newList;
            }
        }
        return newList;
    }

    /**
     * 두 번째 글자부터 확인
     */
    public static List<String> checkSecond(String options) {
        List<String> newList = new ArrayList<>();
        // 옵션 수만큼 반복
        for (int i = 0; i < options.length(); i++) {
            // 각 단어를 한글자씩 쪼갠 리스트로 만들기
            newList = new ArrayList<>(Arrays.asList(options.split("")));
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