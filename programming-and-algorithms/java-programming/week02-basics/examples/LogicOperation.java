/**
 * [2-7 수식3] [실습] 논리 연산자 실습하기
 *
 * 사용 형태: 조건식1 논리연산자 조건식2   또는   논리연산자 조건식
 *
 * | e1    | e2    | e1 && e2 | e1 || e2 | e1 ^ e2 | !e1   |
 * |-------|-------|----------|----------|---------|-------|
 * | true  | true  | true     | true     | false   | false |
 * | true  | false | false    | true     | true    | false |
 * | false | true  | false    | true     | true    | true  |
 * | false | false | false    | false    | false   | true  |
 *
 * - && (AND) : 둘 다 true 일 때만 true
 * - || (OR)  : 하나라도 true 면 true
 * - ^  (XOR) : 두 값이 다를 때 true
 * - !  (NOT) : 반대로
 *
 * 참고) && 와 || 는 단락 평가(short-circuit)를 한다.
 *  - false && ... → 오른쪽은 계산하지 않고 바로 false
 *  - true  || ... → 오른쪽은 계산하지 않고 바로 true
 */
public class LogicOperation {
    public static void main(String[] args) {
        int x = 3, y = 9;

        System.out.println("논리 AND 테스트");
        System.out.println((x < y) + ", " + (x > 0) + " : " + (x < y && x > 0));
        System.out.println((x > y) + ", " + (x > 0) + " : " + (x > y && x > 0));
        System.out.println((x < y) + ", " + (x < 0) + " : " + (x < y && x < 0));
        System.out.println((x > y) + ", " + (x < 0) + " : " + (x > y && x < 0));

        System.out.println("논리 OR 테스트");
        System.out.println((x < y) + ", " + (x > 0) + " : " + (x < y || x > 0));
        System.out.println((x > y) + ", " + (x > 0) + " : " + (x > y || x > 0));
        System.out.println((x < y) + ", " + (x < 0) + " : " + (x < y || x < 0));
        System.out.println((x > y) + ", " + (x < 0) + " : " + (x > y || x < 0));

        System.out.println("논리 XOR 테스트");
        System.out.println((x < y) + ", " + (x > 0) + " : " + (x < y ^ x > 0));
        System.out.println((x > y) + ", " + (x > 0) + " : " + (x > y ^ x > 0));
        System.out.println((x < y) + ", " + (x < 0) + " : " + (x < y ^ x < 0));
        System.out.println((x > y) + ", " + (x < 0) + " : " + (x > y ^ x < 0));

        System.out.println("논리 NOT 테스트");
        System.out.println((x < y) + " : " + !(x < y));
        System.out.println((x > y) + " : " + !(x > y));
    }
}
