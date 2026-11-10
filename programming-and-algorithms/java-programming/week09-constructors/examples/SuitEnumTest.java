/**
 * [9-2 Enumeration] 상수(int) 방식의 문제점과 열거형(enum)으로 해결하기
 *
 * 포인트
 *  - 상수 방식(public static final int SUIT_CLUBS = 0 ...)의 문제점 4가지
 *    1. 허용되는 값이 명확하지 않음   2. 유형 안전성 없음
 *    3. 이름 공간 없음(SUIT_ 접두사)  4. 출력하면 숫자만 나옴
 *  - enum : 가능한 값을 쉼표로 나열한 "자료형". Java 5 부터.
 *  - 기타 이점 : values() 로 모든 값 꺼내기, == 비교, switch 문에서 사용
 *
 * 💡 슬라이드의 이클립스 화면에 Test.Suit 라고 나오는 것은 Suit 가 Test 클래스 "안에" 선언되었기 때문이다.
 *    여기서도 SuitEnumTest 안에 선언했다. (public enum 을 따로 두려면 Suit.java 파일이 필요)
 * 💡 ⚠ 슬라이드 본문의 value() 는 values() 의 오타.
 * 💡 enum 상수는 프로그램 안에 딱 하나의 객체만 존재 → 문자열과 달리 == 로 비교해도 안전.
 * 💡 switch 의 case 에는 Suit.CLUBS 가 아니라 CLUBS 처럼 상수 이름만 쓴다.
 *
 * 실행 결과
 *  ===== 상수(int) 방식 =====
 *  Card is a Queen of 2
 *  drawSuitOnCard(int) : 9452435 ← 이상한 값도 그냥 들어감
 *  ===== enum 방식 =====
 *  Card is a Queen of HEARTS
 *  drawSuitOnCard(Suit) : HEARTS
 *  ===== values() =====
 *  CLUBS
 *  DIAMONDS
 *  HEARTS
 *  SPADES
 *  ===== == 비교, switch =====
 *  CLUBS : 클럽입니다 / 검은색
 *  DIAMONDS : 빨간색
 *  HEARTS : 빨간색
 *  SPADES : 검은색
 *  ===== 💡 자주 쓰는 메소드 =====
 *  valueOf("HEARTS") = HEARTS
 *  HEARTS.name() = HEARTS
 *  HEARTS.ordinal() = 2
 */
public class SuitEnumTest {
    // ----- 기존 방식 : 상수 -----
    public static final int SUIT_CLUBS = 0;
    public static final int SUIT_DIAMONDS = 1;
    public static final int SUIT_HEARTS = 2;
    public static final int SUIT_SPADES = 3;

    // ----- 열거형 -----
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

    // 문제점 2 : 아무 int 나 들어올 수 있음
    public static void drawSuitOnCard(int suit) {
        System.out.println("drawSuitOnCard(int) : " + suit + " ← 이상한 값도 그냥 들어감");
    }

    // 해결 : Suit 에 나열된 값만 가능 (오버로딩)
    public static void drawSuitOnCard(Suit suit) {
        System.out.println("drawSuitOnCard(Suit) : " + suit);
    }

    public static void main(String[] args) {
        System.out.println("===== 상수(int) 방식 =====");
        System.out.println("Card is a Queen of " + SUIT_HEARTS);  // 문제점 4 : 숫자만 출력
        drawSuitOnCard(9452435);                                    // 문제점 2 : 막을 수 없음

        System.out.println("===== enum 방식 =====");
        System.out.println("Card is a Queen of " + Suit.HEARTS);  // Prints "Card is a Queen of HEARTS"
        drawSuitOnCard(Suit.HEARTS);
        // 💡 int 버전이 없다면 drawSuitOnCard(9452435) 는 컴파일 오류 :
        //    The method drawSuitOnCard(Test.Suit) in the type Test is not applicable for the arguments (int)

        System.out.println("===== values() =====");
        Suit[] suits = Suit.values();
        for (Suit s : suits) {
            System.out.println(s);
        }

        System.out.println("===== == 비교, switch =====");
        for (Suit suit : Suit.values()) {
            System.out.print(suit + " : ");
            if (suit == Suit.CLUBS) {            // == 로 비교
                System.out.print("클럽입니다 / ");
            }
            switch (suit) {
                case CLUBS:                      // break 가 없으므로 SPADES 와 같은 코드 실행 (fall-through)
                case SPADES:
                    System.out.println("검은색");
                    break;
                case HEARTS:
                case DIAMONDS:
                    System.out.println("빨간색");
                    break;
                default:
                    System.out.println("?");
                    break;
            }
        }

        System.out.println("===== 💡 자주 쓰는 메소드 =====");
        System.out.println("valueOf(\"HEARTS\") = " + Suit.valueOf("HEARTS"));
        System.out.println("HEARTS.name() = " + Suit.HEARTS.name());
        System.out.println("HEARTS.ordinal() = " + Suit.HEARTS.ordinal());
    }
}
