import java.util.Scanner;

/**
 * [7강 실습] 클래스(1) - 3번 문제 (Complex 클래스 - 복소수의 덧셈과 뺄셈)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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

    // 처음 작성한 코드 : getter / setter 로 계산
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

    // 📝 필기 버전 : 같은 클래스이므로 c 의 private 필드에 직접 접근
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
