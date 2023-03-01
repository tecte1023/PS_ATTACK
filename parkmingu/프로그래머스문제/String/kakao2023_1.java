package parkmingu.프로그래머스문제.String;

import java.util.ArrayList;

public class kakao2023_1 {
    public static void main(String[] args) {
        String str = "2022.02.19 C";
        System.out.println(str.substring(str.length() - 4, str.length() - 2));
    }

    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {

            ArrayList<Integer> integers1 = new ArrayList<Integer>();

            for (int i = 0; i < privacies.length; i++) {
                String privacies_str = privacies[i];

                for (int j = 0; j < terms.length; j++) {
                    String terms_str = terms[j];

                    // 약관 종류를 비교함
                    if (terms_str.substring(0,
                            1).equals(privacies_str.substring(privacies_str.length() - 1))) {
                        int tmp_today = 0;

                        // 오늘 날짜와 약관 동의 날짜를 달 수로 잡아서 계산해줌
                        // 년도가 같다면 privacies_day에 terms의 달수만 더해서 계산

                        if (today.substring(2, 4).equals(privacies_str.substring(2, 4))) {
                            tmp_today = Integer.parseInt(today.substring(5, 7));

                        } // 다르다면 (올해년도) - 약관년도) * 12 + 현재 달 = tmp_today
                          // (terms의 달) + 약관 달 = privacies_day
                        else {
                            tmp_today = ((Integer.parseInt(today.substring(2, 4))
                                    - Integer.parseInt(privacies_str.substring(2, 4))) * 12)
                                    + Integer.parseInt(today.substring(5, 7));
                        }

                        // privacies_day는 중복 됨으로 밖으로 뺌
                        // int privacies_day = Integer.parseInt(privacies_str.substring(5, 7))
                        // + Integer.parseInt(terms_str.substring(terms_str.length() - 1));

                        // 달을 가져올때 2자리수의 달을 생각못했었음 그래서 오류가 남
                        String intstr = terms_str.replaceAll("[^0-9]", "");
                        int privacies_day = Integer.parseInt(privacies_str.substring(5, 7)) + Integer.parseInt(intstr);

                        // 날짜를 비교함

                        // today가 더 크면 약관 만료임 삭제 예정

                        if (tmp_today > privacies_day) {
                            integers1.add(i + 1);
                        }
                        // 만약 달수가 같다면 일수도 비교 똑같이 today가 더 크면 약관 만료
                        else if (tmp_today == privacies_day) {
                            if (Integer.parseInt(today.substring(today.length() - 2)) >= Integer.parseInt(
                                    privacies_str.substring(privacies_str.length() - 4, privacies_str.length() - 2))) {
                                integers1.add(i + 1);
                            }
                        }
                    }
                }
            }

            int[] answer = new int[integers1.size()];
            for (int i = 0; i < integers1.size(); i++) {
                answer[i] = integers1.get(i).intValue();
            }

            return answer;
        }
    }
}
