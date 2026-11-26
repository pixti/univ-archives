/**
 * [10-3 상속3] 익명 내부 클래스 - 생성과 동시에 인수로 사용
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class AnonymousArgumentTest {

    interface Greeting {
        String message();
    }

    public void display(Greeting g) {
        System.out.println(g.message());
    }

    public static void main(String args[]) {
        AnonymousArgumentTest ob = new AnonymousArgumentTest();

        ob.display(new Greeting() {      // 생성과 동시에 인수로 사용
            public String message() {
                return "안녕하세요";
            }
        });

        ob.display(() -> "반갑습니다");   // 💡 같은 일을 람다식으로 (강의 코드에는 없음)
    }
}
