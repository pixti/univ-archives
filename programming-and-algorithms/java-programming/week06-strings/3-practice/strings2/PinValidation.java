/**
 * [6강 실습] 문자열(2) - 4번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
