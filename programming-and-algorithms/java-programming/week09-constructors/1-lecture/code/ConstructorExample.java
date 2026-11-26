/**
 * [9-3 생성자와 소멸자] 생성자 기본
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ConstructorExample {
    public static void main(String[] args) {
        Cat c = new Cat("이쁜이", 45);
        System.out.println(c.toString() + "의 몸무게는 " + c.getSize());
        System.out.println(c + "의 몸무게는 " + c.getSize());   // 💡 toString() 자동 호출

        // Cat c2 = new Cat();   // ❌ 기본 생성자가 없으므로 컴파일 오류
    }
}

class Cat {
    int size;
    String name;

    public Cat(String n, int s) {   // 생성자 : 클래스 이름과 같고 반환형 없음
        name = n;
        size = s;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        return name;
    }
}
