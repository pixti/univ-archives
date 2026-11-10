import java.util.Scanner; // ← 이 줄이 없으면 "Scanner cannot be resolved to a type" 컴파일 에러

/**
 * [2-4 변수와 자료형4] [실습] 사용자 이름을 입력 받아 인사말 출력하기
 *
 * 이클립스 실습 순서
 *  1) File -> New -> Java Project, 프로젝트 이름은 SayHelloTest
 *  2) 프로젝트 탐색기(Project Explorer)에서 프로젝트 우클릭 -> New -> Class
 *  3) 클래스 이름(SayHello)과 main 메소드 자동 생성 옵션(public static void main) 선택
 *
 * 슬라이드 코드처럼 import 없이 입력하면 Scanner 클래스 위치를 몰라서 컴파일 에러.
 *  → import java.util.Scanner; 를 맨 윗줄에 추가하면 해결
 *  → 이클립스: 빨간 줄 위에 마우스를 올리면 해결 창이 뜨는데,
 *    가장 위의 "'Scanner' (java.util) 가져오기" 를 선택하면 자동으로 import 추가
 *  → 빨간 줄이 사라지면 File -> Save All 로 저장 후 실행
 *
 * 📝 필기
 *  - 이미 정의된 클래스라도 어디에 있는지 알려주지 않으면 자바(컴파일러)는 모른다.
 *    import java.util.Scanner; 라고 선언해야 컴파일러가 "아, 이 클래스를 가져와서 쓰는구나" 하고 해석한다.
 *  - 단, java.lang 패키지(System, String, Math 등)는 자동 import 된다.
 */
public class SayHello {
    public static void main(String[] args) {
        System.out.println("이름 입력 >> ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();   // 공백 전까지의 문자열(단어) 하나를 읽음
        sc.close();

        // + 기호로 긴 문자열 연결 (문자열 + 변수 + 문자열)
        // ⚠ 슬라이드에는 두 번째 줄 따옴표가 “ (전각 따옴표)로 되어 있어 그대로 복사하면 에러
        String helloMessage = "안녕하세요. " + name +
                " 님, 자바 세계에 오실 것을 축하드립니다.";
        System.out.println(helloMessage);
    }
}
