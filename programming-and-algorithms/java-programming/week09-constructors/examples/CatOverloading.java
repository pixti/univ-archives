/**
 * [9-3 생성자와 소멸자] 생성자 중복 정의 · this() · this.필드 (슬라이드 7, 12, 13)
 *
 * 포인트
 *  ❶ 생성자 중복 정의(오버로딩) : Cat() 과 Cat(String, int)
 *  ❷ 생성자 안에서 다른 생성자 호출 : this("영순이", 50)  → 생성자의 첫 문장이어야 함
 *  ❸ 매개변수 이름 = 필드 이름일 때 : this.name = name
 *
 * 📝 필기 (퀴즈) 오버로딩 : 메소드를 여러 형태로 제공해주는 것. 파라미터의 개수나 타입이 다르게.
 *                          중복정의(overloading) 라고 함.
 * 📝 필기 (퀴즈, AI 설명) 오버로딩 핵심 규칙
 *    - 메소드 이름이 완전히 같아야 한다.
 *    - 파라미터의 개수, 타입(자료형), 순서 중 하나 이상이 반드시 달라야 한다.
 *    - 반환(return) 타입만 다르게 설정하는 것은 오버로딩으로 인정되지 않는다.
 *    - 도입 장점 : System.out.println() 이 대표적. 오버로딩이 없다면 printlnInt(), printlnString() 처럼
 *      이름을 다 외워야 하지만, println() 하나만 기억하면 컴파일러가 알맞은 메소드를 찾아 실행해 준다.
 * 📝 필기 (퀴즈 1번) : 다른 생성자를 호출할 때는 반드시 1번째 줄에 와야 함.
 *
 * ⚠ 슬라이드 7, 12 의 “영순이” 는 스마트 따옴표라 그대로 붙여 넣으면 컴파일 오류. " 로 고쳤다.
 * ⚠ JDK 25 (JEP 513 Flexible Constructor Bodies) 부터는 this(...) 앞에 System.out.println("test");
 *    처럼 this(아직 만들어지지 않은 객체)를 건드리지 않는 문장을 쓸 수 있다. (JDK 21 : 컴파일 오류)
 *    필드 대입처럼 this 를 쓰는 문장은 여전히 오류. 시험은 교재 기준 "this() 는 첫 문장" 으로 답한다.
 * 💡 ❸ 의 name = name; 은 컴파일은 되지만 매개변수에 자기 자신을 대입할 뿐이라 필드는 null / 0 그대로다.
 *    (BadCat 클래스로 확인)
 *
 * 실행 결과
 *  영순이의 몸무게는 50
 *  이쁜이의 몸무게는 45
 *  BadCat : null의 몸무게는 0
 *  GoodCat : 나비의 몸무게는 3
 */
public class CatOverloading {
    public static void main(String[] args) {
        Cat c1 = new Cat();               // Cat() 호출 → this("영순이", 50)
        Cat c2 = new Cat("이쁜이", 45);   // Cat(String, int) 호출
        System.out.println(c1 + "의 몸무게는 " + c1.getSize());
        System.out.println(c2 + "의 몸무게는 " + c2.getSize());

        BadCat bad = new BadCat("나비", 3);
        System.out.println("BadCat : " + bad.name + "의 몸무게는 " + bad.size);
        GoodCat good = new GoodCat("나비", 3);
        System.out.println("GoodCat : " + good.name + "의 몸무게는 " + good.size);
    }
}

class Cat {
    int size;
    String name;

    // 슬라이드 7 원본 : public Cat() { name = "영순이"; size = 50; }
    public Cat() {
        //System.out.println("test"); 이 줄이 주석이 아니면 오류 (⚠ JDK 25 부터는 허용)
        this("영순이", 50);  // this 사용, 첫 줄이 아니면 오류
    }

    public Cat(String n, int s) {
        name = n;  // this.name = n; 과 동일
        size = s;  // this.size = s; 와 동일
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        return name;
    }
}

/** 슬라이드 13 왼쪽 : 매개변수 이름과 필드 이름이 같은데 this 를 안 쓴 경우 */
class BadCat {
    int size;
    String name;

    public BadCat(String name, int size) {
        name = name;   // ❌ 매개변수 name 에 자기 자신을 대입 → 필드는 그대로 null
        size = size;   // ❌ 필드는 그대로 0
    }
}

/** 슬라이드 13 오른쪽 : this 키워드 사용 */
class GoodCat {
    int size;
    String name;

    public GoodCat(String name, int size) {
        this.name = name;  // this 키워드 사용
        this.size = size;  // this 키워드 사용
    }
}
