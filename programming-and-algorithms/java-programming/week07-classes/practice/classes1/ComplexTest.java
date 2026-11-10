import java.util.Scanner;

/**
 * [7강 실습] 클래스(1) - 3번 문제 (Complex 클래스 - 복소수의 덧셈과 뺄셈)
 *
 * 문제
 *  실수부(real)와 허수부(imagine)를 필드로 가지는 복소수 클래스 Complex 를 만드시오.
 *  getter / setter, 두 복소수를 더한 결과를 돌려주는 add(Complex c),
 *  뺀 결과를 돌려주는 sub(Complex c), 그리고 "실수부 + 허수부i" 형태로 바꾸는 toString() 을 작성한다.
 *  main 에서는 두 복소수를 입력받아 각 복소수, 합, 차를 출력한다.
 *
 *  (문제의 실행 예 : 8 13.9 / 4 4.0 입력 → 합은 : 12 + 17.9i, 뺄셈은 : 4 + 9.9i)
 *
 * 포인트
 *  - add / sub 는 자기 자신(this)과 매개변수(c)를 바꾸지 않고, "새 Complex 객체" 를 만들어 결과를 담아 돌려준다.
 *        Complex sum = c1.add(c2);      // this = c1, c = c2
 *  - toString() 을 오버라이딩하면 System.out.println(c1) 처럼 객체를 바로 출력할 때도 이 문자열이 쓰인다.
 *    (과제 클래스1 3번 📝 필기 : @Override 를 붙이는 이유)
 *  - Math.round(x * 100) / 100.0 : 소수점 둘째 자리에서 반올림
 *    → 6.1 + 8.2 = 14.299999999999999 처럼 생기는 실수 오차를 14.3 으로 정리
 *  - (r % 1 == 0) ? 정수로 : 실수로 : 소수 부분이 0 이면 "2.0" 대신 "2" 로 출력
 *
 * 📝 필기 : 객체가 아닌 클래스를 기준으로 접근을 제어하므로 private 더라도 getReal()이 아닌
 *    this.real로 접근할 수 있다.
 *
 * 📝 필기 (AI 설명) 맞다. private 은 "같은 클래스" 안이면 다른 객체(c)의 private 필드에도 직접 접근할 수 있다.
 *    그래서 add 를 이렇게 써도 된다. (sub 도 + 를 - 로 바꾸면 같다)
 *        public Complex add(Complex c) {
 *            Complex result = new Complex();
 *            result.real = this.real + c.real;
 *            result.imagine = this.imagine + c.imagine;
 *            return result;
 *        }
 *    → 아래 코드에는 내가 작성한 getter / setter 버전을 남기고, 이 직접 접근 버전은 addDirect() 로 넣었다.
 *
 * 💡 뺄셈 결과의 허수부가 음수이면 "-4 + -2.1i" 처럼 + 와 - 가 같이 나온다.
 *    "-4 - 2.1i" 로 출력하고 싶다면 toString() 에서 부호를 따로 처리하면 된다. (아래 toString 의 주석 참고)
 * 💡 main 이 있던 클래스(Main)는 ComplexTest 로 이름을 바꿨다.
 *
 * 실행 예
 *  1번째 실수부와 허수부를 입력하세요 : 2 6.1
 *  2번째 실수부와 허수부를 입력하세요 : 6 8.2
 *  ==========================
 *  복소수는 : 2 + 6.1i
 *  복소수는 : 6 + 8.2i
 *  합은 : 8 + 14.3i
 *  뺄셈은 : -4 + -2.1i
 *  ==========================
 *  (직접 접근 버전 addDirect : 8 + 14.3i)
 *
 *  (문제의 예 : 8 13.9 / 4 4.0 입력)
 *  복소수는 : 8 + 13.9i
 *  복소수는 : 4 + 4i
 *  합은 : 12 + 17.9i
 *  뺄셈은 : 4 + 9.9i
 */
public class ComplexTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Complex c1 = new Complex();
        Complex c2 = new Complex();

        System.out.print("1번째 실수부와 허수부를 입력하세요 : ");
        c1.setReal(sc.nextDouble());
        c1.setImagine(sc.nextDouble());
        System.out.print("2번째 실수부와 허수부를 입력하세요 : ");
        c2.setReal(sc.nextDouble());
        c2.setImagine(sc.nextDouble());

        Complex sum = c1.add(c2);
        Complex diff = c1.sub(c2);

        System.out.println("==========================");
        System.out.println("복소수는 : " + c1.toString());
        System.out.println("복소수는 : " + c2.toString());
        System.out.println("합은 : " + sum);            // toString() 을 안 써도 자동으로 호출된다
        System.out.println("뺄셈은 : " + diff);
        System.out.println("==========================");
        System.out.println("(직접 접근 버전 addDirect : " + c1.addDirect(c2) + ")");
        sc.close();
    }
}

class Complex {
    private double real;
    private double imagine;

    public double getReal() { return real; }
    public void setReal(double real) { this.real = real; }
    public double getImagine() { return imagine; }
    public void setImagine(double imagine) { this.imagine = imagine; }

    // 내가 작성한 코드 : getter / setter 로 계산
    public Complex add(Complex c) {
        Complex result = new Complex();
        result.setReal(this.real + c.getReal());
        result.setImagine(this.imagine + c.getImagine());
        return result;
    }

    public Complex sub(Complex c) {
        Complex result = new Complex();
        result.setReal(this.real - c.getReal());
        result.setImagine(this.imagine - c.getImagine());
        return result;
    }

    // 📝 AI 설명 버전 : 같은 클래스이므로 c 의 private 필드에 직접 접근
    public Complex addDirect(Complex c) {
        Complex result = new Complex();
        result.real = this.real + c.real;
        result.imagine = this.imagine + c.imagine;
        return result;
    }

    @Override
    public String toString() {
        double r = Math.round(this.real * 100) / 100.0;       // 소수점 둘째 자리 반올림
        double i = Math.round(this.imagine * 100) / 100.0;
        String realStr = (r % 1 == 0) ? String.valueOf((int) r) : String.valueOf(r);
        String imagStr = (i % 1 == 0) ? String.valueOf((int) i) : String.valueOf(i);
        return realStr + " + " + imagStr + "i";
        // 💡 허수부가 음수일 때 "a - bi" 로 출력하려면
        //    String sign = (i < 0) ? " - " : " + ";
        //    double absI = Math.abs(i);
        //    String imagStr = (absI % 1 == 0) ? String.valueOf((int) absI) : String.valueOf(absI);
        //    return realStr + sign + imagStr + "i";
    }
}
