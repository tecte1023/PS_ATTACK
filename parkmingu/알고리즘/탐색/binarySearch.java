package parkmingu.알고리즘.탐색;

import java.util.Arrays;

public class binarySearch {
    public static void main(String[] args) {
        /*
         * 이진 탐색
         * 자바 Arrays에서 이진탐색 메서드를 제공함
         * 배열과 찾으려는 key값을 넣어주면 해당 배열의 인덱스를 반환함
         * 
         * 작동 방식은 ((첫번째 인덱스 + 마지막 인덱스) / 2) 의 키값과 찾으려는 값을 비교하며 
         * 탐색 범위를 반씩 줄여가는 방식 
         * 
         * 만약 찾고자 하는 값이 더크다면 다음 탐색의 첫번째 인덱스는
         * ((첫번째 인덱스 + 마지막 인덱스) / 2) + 1 이 된다
         * 
         * 이후 이를 반복하며 찾고자하는 값을 찾으면 종료된다
         * 시간 복잡도는 O(log n)이 나온다
         */
        int[] n = {1,2,3,4,5};
        System.out.println(Arrays.binarySearch(n, 5));
    }
}
