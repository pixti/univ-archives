/**
 * [9-3 생성자와 소멸자] 생성자 기본 (슬라이드 3)
 *
 * 포인트
 *  - 생성자 : 객체가 생성되면서 자동으로 호출되는 메소드. 주로 필드 초기화에 쓴다.
 *  - 클래스 이름과 같은 이름, 반환형 없음(void 도 안 씀).
 *  - 보통 public. private(같은 클래스 안에서만 생성 가능), protected(주로 추상 클래스)도 가능.
 *
 * 📝 필기 (퀴즈) : 객체가 생성될 때 → 생성자 / 객체가 소멸될 때 → 소멸자.
 *                  자바에서는 (소멸 시점을) 가비지 컬렉터가 결정함 → 파이널라이즈(finalize). (FinalizeTest.java)
 *
 * 💡 new Cat("이쁜이", 45) 의 실행 순서
 *    1. Heap 에 Cat 객체를 만들고 필드를 기본값(size = 0, name = null)으로 채운다.
 *    2. 인수 개수 · 자료형이 맞는 생성자 Cat(String, int) 를 호출해 필드를 초기화한다.
 *    3. 만들어진 객체의 레퍼런스를 c 에 대입한다.
 * 💡 생성자를 하나도 안 만들면 컴파일러가 기본 생성자 Cat() {} 를 자동으로 넣어 준다.
 *    하지만 Cat(String, int) 를 하나라도 만들면 기본 생성자는 생기지 않는다 → new Cat() 은 컴파일 오류.
 *      error: constructor Cat in class Cat cannot be applied to given types;
 *        required: String,int
 *        found:    no arguments
 * 💡 toString() 을 만들어 두면 c.toString() 대신 System.out.println(c) 만 써도 자동으로 호출된다.
 *
 * 실행 결과
 *  이쁜이의 몸무게는 45
 *  이쁜이의 몸무게는 45
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
