/**
 * [9강 실습] DateTime · Enum - 2번 문제 (도형 열거형)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
