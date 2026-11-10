/**
 * [1강] 첫 번째 자바 프로그램 - Hello World
 *
 * 개발 과정 (명령 프롬프트)
 *  1) javac HelloWorld.java   → 컴파일. 같은 폴더에 바이트코드 파일 HelloWorld.class 가 생성된다.
 *  2) java HelloWorld         → 실행. JVM 이 HelloWorld.class 를 읽어 실행한다.
 *                               (.java / .class 확장자를 붙이지 않는다!)
 *  - .class 파일이 생기지 않으면 컴파일 오류 (타이핑 오류 확인)
 *  - javac 가 동작하지 않으면 환경변수 Path 에 JDK 의 bin 폴더가 등록됐는지 확인
 *
 * 실행 결과
 *  Hello, World!
 */
public class HelloWorld {                       // 클래스 이름은 파일 이름(HelloWorld.java)과 같아야 한다 (public 클래스)
    public static void main(String[] args) {    // 프로그램의 시작점. JVM 이 가장 먼저 호출하는 메소드
        System.out.println("Hello, World!");    // 콘솔에 문자열을 출력하고 줄을 바꾼다
    }
}
