/**
 * [2-6 수식2] [실습] 관계 연산자 실습하기
 *
 * 관계 연산자: 두 피연산자가 주어진 관계를 만족하는지 검사 → 만족하면 true, 아니면 false
 * 조건식을 기술할 때 많이 사용한다.
 *
 * | 연산    | 의미                        | 예                          |
 * |---------|-----------------------------|-----------------------------|
 * | a < b   | a 가 b 보다 작으면 true      | 3 < 5 : true,  5 < 3 : false |
 * | a > b   | a 가 b 보다 크면 true        | 5 > 3 : true,  3 > 5 : false |
 * | a <= b  | a 가 b 보다 작거나 같으면 true | 3 <= 5 : true, 5 <= 3 : false|
 * | a >= b  | a 가 b 보다 크거나 같으면 true | 5 >= 3 : true, 3 >= 5 : false|
 * | a == b  | a 가 b 와 같으면 true        | 5 == 5 : true, 5 == 3 : false|
 * | a != b  | a 가 b 와 다르면 true        | 5 != 3 : true, 5 != 5 : false|
 *
 * 실행 결과 (x = 3, y = 5)
 *  true / false / true / false / false / true
 */
public class RelationOperation {
    public static void main(String[] args) {
        int x = 3, y = 5;
        System.out.println(x < y);
        System.out.println(x > y);
        System.out.println(x <= y);
        System.out.println(x >= y);
        System.out.println(x == y);
        System.out.println(x != y);
    }
}
