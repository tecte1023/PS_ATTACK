package parkmingu.백준문제.bruteForce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class 접두사 {
    // 해결 X

    // 접두사가 아닌 부분집합중 가장 큰 값을 찾는문제
    // 7
    // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaae
    // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaad
    // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaac
    // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz
    // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    // aaa
    // aaaa
    // 5

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] str_x = new String[n];

        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        // set에 삽입해서 중복을 제거
        for (int i = 0; i < str_x.length; i++) {
            set.add(sc.next());
        }

        Iterator<String> iter_set = set.iterator();

        // 중복 제거후 하나씩 빼와서 검사후 list에 넣기
        while (iter_set.hasNext()) {

            Iterator<String> iter_list = list.iterator();

            Boolean check = false;
            String str = iter_set.next();

            // list에 값이 없는경우(첫번째 삽입의 경우) 우선 삽입
            if (!iter_list.hasNext()) {
                list.add(str);
            } else {
                while (iter_list.hasNext()) {
                    String str2 = iter_list.next();

                    if (str.length() < str2.length() && str.equals(str2.substring(0, str.length()))) {
                        check = false;
                        break;
                    } // 접두사가 이미 리스트에 있는 경우 해당 접두사는 삭제하고 str 삽입
                    else if (str2.length() < str.length() && str2.equals(str.substring(0, str2.length()))) {
                        list.remove(str2);
                        check = true;
                        break;
                    } else {
                        check = true;
                    }
                }

                // 접두사가 아니므로 list에 추가
                if (check == true) {
                    list.add(str);
                }
            }
        }

        // for (String string : list) {
        // System.out.println(string);
        // }

        System.out.println(list.size());

    }

}