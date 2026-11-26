/**
 * [9-3 생성자와 소멸자] 생성자 중복 정의 · this() · this.필드
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class CatOverloading {
    public static void main(String[] args) {
        CatOverload c1 = new CatOverload();               // CatOverload() 호출 → this("영순이", 50)
        CatOverload c2 = new CatOverload("이쁜이", 45);   // CatOverload(String, int) 호출
        System.out.println(c1 + "의 몸무게는 " + c1.getSize());
        System.out.println(c2 + "의 몸무게는 " + c2.getSize());

        BadCat bad = new BadCat("나비", 3);
        System.out.println("BadCat : " + bad.name + "의 몸무게는 " + bad.size);
        GoodCat good = new GoodCat("나비", 3);
        System.out.println("GoodCat : " + good.name + "의 몸무게는 " + good.size);
    }
}

class CatOverload {
    int size;
    String name;

    // 💡 처음 배운 형태 : public CatOverload() { name = "영순이"; size = 50; }
    public CatOverload() {
        //System.out.println("test"); 이 줄이 주석이 아니면 오류 (⚠ JDK 25 부터는 허용)
        this("영순이", 50);  // this 사용, 첫 줄이 아니면 오류
    }

    public CatOverload(String n, int s) {
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

/** ❌ 틀린 예 : 매개변수 이름과 필드 이름이 같은데 this 를 안 쓴 경우 */
class BadCat {
    int size;
    String name;

    public BadCat(String name, int size) {
        name = name;   // ❌ 매개변수 name 에 자기 자신을 대입 → 필드는 그대로 null
        size = size;   // ❌ 필드는 그대로 0
    }
}

/** ✅ 고친 예 : this 키워드 사용 */
class GoodCat {
    int size;
    String name;

    public GoodCat(String name, int size) {
        this.name = name;  // this 키워드 사용
        this.size = size;  // this 키워드 사용
    }
}
