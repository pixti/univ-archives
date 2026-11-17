/**
 * [2-1 변수와 자료형1] 프로그램 및 클래스 구성 - 메인 메소드
 *
 * 이클립스에서 ProgramBasic 클래스를 정의할 때 자동으로 생성해주는 코드.
 *
 * main 메소드
 *  - 프로그램을 구성하는 클래스 중 적어도 한 클래스에서 main 메소드를 제공해야 한다.
 *  - public        : 외부(JVM)에서 호출 가능
 *  - static        : 객체 생성 없이 호출할 수 있음을 의미
 *  - void          : 반환값 없음
 *  - String[] args : 실행 파일명과 함께 주어지는 인라인(명령행) 인수를 받아들여 사용할 수 있게 함
 *                    예) java ProgramBasic aaa bbb  →  args[0] = "aaa", args[1] = "bbb"
 *
 * ⚠ 자주 틀리는 부분
 *  - C 처럼 public static int main(...) 으로 쓰면 컴파일은 되지만 실행되지 않는다.
 *    ("Main method not found") main 의 반환형은 반드시 void 다.
 *  - JDK 25 부터는 static 없는 void main() 도 실행된다(JEP 512).
 *    하지만 수업과 시험의 기준은 public static void main(String[] args) 이다.
 *
 * 📝 필기 (실습 시간)
 *  - 파이썬은 들여쓰기로 명령어의 레벨(블록)을 구분하지만, 자바는 중괄호 { } 로 구분한다.
 *  - 파이썬은 들여쓰기가 문법적으로 엄격하지만, 자바의 들여쓰기는 "가독성"을 위해서만 사용한다.
 */
public class ProgramBasic {
    public static void main(String[] args) {
        // 이 부분은 한 줄짜리 주석
        /* 이 부분은
           여러 줄짜리
           주석 */

        // 명령행 인수 확인용 (추가 코드)
        // 실행 예) java ProgramBasic.java aaa bbb
        System.out.println("전달된 인수 개수 : " + args.length);
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
