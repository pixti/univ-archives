/**
 * [9강 실습] DateTime · Enum - 2번 문제 (도형 열거형)
 *
 * 문제
 *  CIRCLE, SQUARE, TRIANGLE, RECTANGLE 을 값으로 가지는 열거형 Shape 를 정의하고,
 *  두 도형 변수(firstShape, secondShape)에 값을 넣어 출력하시오.
 *
 * 포인트
 *  - 열거형 변수 선언과 대입, == 비교 (9-2 "열거형 값 비교 가능")
 *
 * ⚠ 내 답안은 firstShape == secondShape 를 비교해 "No" 만 출력해서 문제의 실행 결과
 *    (First shape: CIRCLE / Second shape: SQUARE)와 달랐다. 두 도형을 출력하는 줄을 추가하고 비교는 💡 로 남겼다.
 *    ❌ 원본
 *       if (firstShape == secondShape) System.out.println("Yes");
 *       else System.out.println("No");
 *    ✅ 수정
 *       System.out.println("First shape: " + firstShape);
 *       System.out.println("Second shape: " + secondShape);
 * 💡 enum 상수는 프로그램 안에 딱 하나의 객체만 존재하므로 equals() 대신 == 로 비교해도 안전하다.
 *
 * 실행 결과
 *  First shape: CIRCLE
 *  Second shape: SQUARE
 *  💡 같은 도형인가? No
 */
public class ShapeTest {
    enum Shape {
        CIRCLE, SQUARE, TRIANGLE, RECTANGLE
    }

    public static void main(String[] args) {
        Shape firstShape = Shape.CIRCLE;
        Shape secondShape = Shape.SQUARE;

        System.out.println("First shape: " + firstShape);
        System.out.println("Second shape: " + secondShape);

        // 💡 원래 작성했던 비교 코드
        if (firstShape == secondShape) {
            System.out.println("💡 같은 도형인가? Yes");
        } else {
            System.out.println("💡 같은 도형인가? No");
        }
    }
}
