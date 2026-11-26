/**
 * [5-1 배열1] 레퍼런스형(객체) 배열
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
