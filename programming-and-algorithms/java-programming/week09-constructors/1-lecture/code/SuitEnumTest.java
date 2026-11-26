/**
 * [9-2 Enumeration] 상수(int) 방식의 문제점과 열거형(enum)으로 해결하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
