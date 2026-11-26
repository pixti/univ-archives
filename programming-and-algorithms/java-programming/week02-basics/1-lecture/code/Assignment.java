/**
 * [2-4 변수와 자료형4] 자료형 변환 - 자동 형변환 예제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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

        // 자동 형변환과 강제 형변환 비교
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
