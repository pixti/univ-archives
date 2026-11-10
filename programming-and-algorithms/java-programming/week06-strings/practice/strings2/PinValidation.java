/**
 * [6강 실습] 문자열(2) - 4번 문제
 *
 * PIN 번호가 유효한지 검사하시오. 유효한 PIN 은 숫자로만 이루어진 4자리, 6자리, 8자리이다.
 *
 * 포인트
 *  - ^(\d{4}|\d{6}|\d{8})$
 *      \d{4}       숫자 정확히 4개
 *      ( A|B|C )   A 또는 B 또는 C   (| 는 OR, 괄호로 묶어 ^ $ 가 전체에 적용되도록)
 *      ^ ... $     처음부터 끝까지 → 중간에 숫자가 아닌 문자나 길이가 다른 경우 실패
 *
 * 📝 필기 (AI 설명) 요구사항 분석
 *  1. 숫자로만 구성          → \d
 *  2. 길이가 4, 6, 8 중 하나 → {4} | {6} | {8}
 *  3. 위 둘을 동시에         → ^(\d{4}|\d{6}|\d{8})$
 *
 * 💡 괄호 없이 "^\\d{4}|\\d{6}|\\d{8}$" 로 쓰면 ^ 는 첫 번째에만, $ 는 마지막에만 붙어 의미가 달라진다.
 *    (String.matches 는 어차피 전체 일치라 결과는 같지만, find 를 쓸 때는 큰 차이가 난다)
 * 💡 "\\d{4}|\\d{6}|\\d{8}" 대신 "(\\d{2}){2,4}" 로도 쓸 수 있다. (2자리 묶음이 2~4번 → 4, 6, 8자리)
 *
 * 실행 결과
 *  Original PIN Number: 123
 *  Is the said PIN number is valid? false
 *  Original PIN Number: 1234
 *  Is the said PIN number is valid? true
 *  Original PIN Number: 12345
 *  Is the said PIN number is valid? false
 *  Original PIN Number: 123456
 *  Is the said PIN number is valid? true
 *  Original PIN Number: 1234567
 *  Is the said PIN number is valid? false
 *  Original PIN Number: 12345678
 *  Is the said PIN number is valid? true
 *  Original PIN Number: 123456789
 *  Is the said PIN number is valid? false
 */
public class PinValidation {
    public static void main(String[] args) {
        String[] pins = { "123", "1234", "12345", "123456", "1234567", "12345678", "123456789" };
        String regex = "^(\\d{4}|\\d{6}|\\d{8})$";

        for (String pin : pins) {
            boolean isValid = pin.matches(regex);
            System.out.println("Original PIN Number: " + pin);
            System.out.println("Is the said PIN number is valid? " + isValid);
        }
    }
}
