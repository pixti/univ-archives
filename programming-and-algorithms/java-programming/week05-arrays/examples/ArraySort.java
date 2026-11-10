import java.util.Arrays;

/**
 * [5-2 배열2] 배열 정렬 : java.util.Arrays 의 정적 메소드 sort
 *
 * 다양한 정렬 방법이 있고 방법에 따라 코드가 다양하다.
 * 여기서는 java.util.Arrays 클래스의 정적 메소드 sort 를 사용한다.
 *
 * 포인트
 *  - 정적(static) 메소드 : 객체 없이 클래스이름.메소드() 로 부른다. (Math.random() 과 같은 방식)
 *  - Arrays.sort(array) 는 원본 배열 자체를 오름차순으로 바꾼다. (반환형 void)
 *  - for (int e : array) : 4-4 에서 배운 foreach. 인덱스 없이 원소를 하나씩 꺼낸다.
 *
 * ⚠ 슬라이드 오류를 고쳤다 : "졍렬" → "정렬", 둥근 따옴표 “ “ → " ",
 *   두 번째 출력의 e + ““ (공백 없음) → e + " "
 * 💡 슬라이드 코드에는 줄바꿈이 없어 정렬 전/후가 한 줄에 이어진다. 구분하려고 println() 을 넣었다.
 * 💡 Arrays.toString(array) 를 쓰면 [1, 2, 3, 4, 5] 형태로 한 번에 출력할 수 있다.
 *
 * 실행 예
 *  1 5 3 2 4
 *  1 2 3 4 5
 *  [1, 2, 3, 4, 5]
 */
public class ArraySort {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 2, 4};

        for (int e : array)   // 정렬 전 원소 출력
            System.out.print(e + " ");
        System.out.println();

        Arrays.sort(array);   // 배열 정렬

        for (int e : array)   // 정렬 후 원소 출력
            System.out.print(e + " ");
        System.out.println();

        System.out.println(Arrays.toString(array));   // 💡 한 번에 출력
    }
}
