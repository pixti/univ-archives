/**
 * [5-1 배열1] 레퍼런스형(객체) 배열
 *
 * 레퍼런스형인 경우 추가로 작업이 필요하다.
 * 배열 객체가 생성되면 객체의 레퍼런스를 저장할 공간만 확보된다. (실제 객체 생성 x)
 *
 *   array ──▶ [  ●  |  ●  |  ●  ]
 *                │     │     └──▶ ( ExampleClass 객체 )
 *                │     └────────▶ ( ExampleClass 객체 )
 *                └──────────────▶ ( ExampleClass 객체 )
 *
 * 포인트
 *  - new ExampleClass[3] 직후에는 세 칸 모두 null.
 *    이 상태에서 array[0].getValue() 를 부르면 NullPointerException.
 *  - 그래서 반복문으로 칸마다 new 로 객체를 하나씩 만들어 넣는다.
 *
 * 💡 ExampleClass 는 슬라이드에 정의가 없어서, 숫자 하나를 기억하는 간단한 클래스로 만들었다.
 *    (클래스와 생성자는 이후 주차에서 배운다.)
 *
 * 실행 예
 *  생성 직후 array[0] = null
 *  array[0].getValue() = 0
 *  array[1].getValue() = 1
 *  array[2].getValue() = 2
 */
public class ReferenceArray {

    static class ExampleClass {
        private final int value;

        ExampleClass(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        ExampleClass [] array = new ExampleClass[3];
        System.out.println("생성 직후 array[0] = " + array[0]);   // 레퍼런스 공간만 확보 → null

        for (int i = 0; i < 3; i++) {
            array[i] = new ExampleClass(i);                        // 실제 객체 생성
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "].getValue() = " + array[i].getValue());
        }
    }
}
