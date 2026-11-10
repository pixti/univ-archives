/**
 * [2-4 변수와 자료형4] 자료형 변환 - 자동 형변환 예제
 *
 * 자동 형변환(묵시적 형변환)
 *  - 치환문에서 왼쪽 변수의 자료형과 오른쪽 값의 자료형이 일치해야 한다.
 *  - 오른쪽 자료형이 왼쪽보다 "작은" 경우에는 컴파일러가 큰 자료형으로 자동 변환해서 허용.
 *  - 자동 형변환 방향: byte -> short 또는 char -> int -> long -> float -> double
 *
 * 강제 형변환(명시적 형변환, casting)
 *  - 왼쪽 자료형이 더 작으면 정보 손실 가능성 때문에 허용하지 않음 → 컴파일 에러
 *  - 손실을 감수하고서라도 저장하려면 (자료형) 을 붙여 강제 형변환
 *    예) int x = (int) 3.14;  // x 에 3 이 대입 (소수점 아래 버림)
 *
 * 실행 결과
 *  문자 : 한
 *  유니코드 : d55c
 *  문자 : 핝
 */
public class Assignment {
    public static void main(String[] args) {
        char c = '한';
        System.out.println("문자 : " + c);

        int code = c; // 자동 형변환 (char 2byte -> int 4byte)
        System.out.println("유니코드 : " + Integer.toHexString(code)); // 16진수 문자열로 변환

        int i = 0xd55d; // '한'(d55c) 의 다음 코드값
        // char c2 = i;     // 컴파일 에러! int(4byte) -> char(2byte) 는 자동 변환 불가
        char c2 = (char) i; // 강제 형변환 필요
        System.out.println("문자 : " + c2);

        // 슬라이드 7, 8 의 추가 예시
        int x;
        x = 6;            // 자료형 일치, OK
        // x = 3.7;       // 자료형 불일치 에러 - 우측(double)이 더 크다
        double d;
        d = 3;            // OK - int 3 이 3.0 으로 자동 형변환
        d = x;            // OK
        // x = d;         // 자료형 불일치 에러
        x = (int) 3.14;   // 강제 형변환, x 에 3 이 대입
        System.out.println("d = " + d + ", x = " + x);
    }
}
