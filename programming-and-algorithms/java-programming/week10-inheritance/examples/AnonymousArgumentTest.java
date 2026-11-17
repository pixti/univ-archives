/**
 * [10-3 상속3] 익명 내부 클래스 - 생성과 동시에 인수로 사용
 *
 * 포인트
 *  - 익명 클래스 객체는 변수에 담지 않고, 만들자마자 메소드의 인수로 넘길 수 있다.
 *      ob.display(new Greeting() {          // 생성과 동시에 인수로 사용
 *          public String message() {
 *              return "안녕하세요";
 *          }
 *      });                                  ← } 는 익명 클래스 몸체, ) 는 display( 의 닫는 괄호, ; 는 문장 끝
 *  - display(Greeting g) 는 Greeting 인터페이스를 구현한 객체라면 무엇이든 받을 수 있다.
 *    호출하는 쪽에서 message() 의 내용을 마음대로 정해서 넘긴다.
 *
 * 💡 display 는 static 이 아닌 일반(인스턴스) 메소드다. 그래서 static main 에서 부르려면 먼저 객체 ob 를 만든다.
 *      AnonymousTest ob = new AnonymousTest();   ob.display(...);
 *    (static 메소드에서 인스턴스 메소드를 바로 부르면 error: non-static method display(Greeting) cannot be referenced from a static context)
 * 💡 main(String args[]) 처럼 배열 괄호를 변수 이름 뒤에 써도 된다. (C 스타일)
 * 💡 강의 코드의 public class 이름은 AnonymousTest. 앞의 예제(AnonymousTest.java)와 겹쳐서 AnonymousArgumentTest 로 바꿨다.
 *
 * 실행 결과
 *  안녕하세요
 *  반갑습니다
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
