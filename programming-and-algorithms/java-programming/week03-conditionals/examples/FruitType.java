import java.util.Scanner;

/**
 * [3-3 조건문3] switch 문 - 식에 문자열(String) 변수 사용
 *
 * switch (식) {
 *     case 값1 : 실행문장들1; break;   // break 가 없으면 switch 문 끝까지 실행됨
 *     ...
 *     default  : 실행문장들n;
 * }
 *  - if - else if 문과 유사하지만, "조건" 이 아닌 "식의 값" 에 따라 작업을 달리한다.
 *  - Python 에는 없음 (Python 3.10 부터 비슷한 match-case 문이 생겼다)
 *  - 식에는 수식, 문자 변수뿐만 아니라 문자열 변수도 사용 가능 (Java 7 이상)
 *
 * 참고)
 *  - switch 식에 쓸 수 있는 자료형: byte, short, char, int (+ 래퍼 클래스), String, enum
 *    → long, float, double, boolean 은 불가
 *  - String switch 는 내부적으로 == 가 아니라 equals() 로 내용을 비교한다.
 *  - case 에는 값 외의 변수나 수식(조건식)이 오지 못한다.
 *      case x : ...        // 오류 (변수)
 *      case x > 5 : ...    // 오류 (조건식)
 *      case x == 3 : ...   // 오류 (조건식)
 *    단, final 상수나 case 1 + 2: 같은 "컴파일 시간 상수식" 은 허용된다.
 *
 * 슬라이드는 String s; 를 선언만 한 코드 조각이라, 실행할 수 있게 입력을 받도록 했다.
 *
 * 실행 예
 *  과일 이름 ? banana
 *  type = 2
 */
public class FruitType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("과일 이름 ? ");
        String s = sc.next();
        sc.close();

        int type;
        switch (s) { // 여기 - 문자열 변수
            case "apple":
                type = 1;
                break;
            case "banana":
                type = 2;
                break;
            case "carrot":
                type = 3;
                break;
            default:
                type = 4;
        }
        System.out.println("type = " + type);
    }
}
