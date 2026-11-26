/**
 * [9강 퀴즈] 생성자와 소멸자 (생성자 · 소멸자 · 오버로딩 · this() · 복사 생성자)
 * 문제 · 정답 · 필기 → README.md
 */
public class ConstructorQuiz {
    public static void main(String[] args) {
        System.out.println("===== 0 =====");
        concept();
        System.out.println("===== 1 =====");
        q1();
        System.out.println("===== 1 (추가) =====");
        q1Extra();
        System.out.println("===== 2 =====");
        q2();
        System.out.println("===== 3 =====");
        q3();
    }

    // 0. 생성자와 소멸자, 오버로딩
    static void concept() {
        // println 은 println(int), println(String), println(double) ... 로 오버로딩되어 있다
        System.out.print("println(10) / println(\"열\") / println(10.5) → ");
        System.out.print(10);
        System.out.print(" / ");
        System.out.print("열");
        System.out.print(" / ");
        System.out.println(10.5);
    }

    // 1. 다음 코드에 존재하는 모든 오류를 수정하라.
    static void q1() {
        Cat1 cat1 = new Cat1();
        Cat1 cat2 = new Cat1("바둑이");
        Cat1 cat3 = new Cat1("거북이", 40);
        System.out.println("cat1 : " + cat1.name + ", " + cat1.weight + ", MAX_WEIGHT = " + Cat1.getMaxWeight());
        System.out.println("cat2 : " + cat2.name + ", " + cat2.weight);
        System.out.println("cat3 : " + cat3.name + ", " + cat3.weight);
    }

    // 1. (추가) 📝 추가 질문 : 생성자와 게터 세터의 차이
    static void q1Extra() {
        CatGS myCat = new CatGS("나비", 3);
        System.out.println(myCat.getWeight());   // 3 출력
        myCat.setWeight(4);
        System.out.println(myCat.getWeight());   // 4 출력
        myCat.setWeight(-1);                     // 0 이하 → 무시
        System.out.println("-1 은 무시됨 → " + myCat.getWeight());
    }

    // 2. Dog 클래스를 작성하시오.
    static void q2() {
        Dog d1 = new Dog(), d2 = new Dog("별", 6), d3 = new Dog("은비", "말티즈", 3);
        System.out.println("------------------------");
        d1.print();
        d2.print();
        d3.print();

        d1.setName("강아지");
        d1.setAge(1);
        d1.setBreed("요크셔테리어");
        d2.setBreed("말티즈");
        d1.print();
        d2.print();
        d3.print();
    }

    // 3. Cube 클래스를 작성하시오. (한 변의 길이 side, 부피 getVolume, 일반 생성자와 복사 생성자)
    static void q3() {
        Cube c1 = new Cube(20), c2 = new Cube(c1);
        System.out.println("c1의 한변의 길이 : " + c1.getSide());
        System.out.println("c1의 부      피 : " + c1.getVolume());
        System.out.println("c2의 한변의 길이 : " + c2.getSide());
        System.out.println("c2의 부      피 : " + c2.getVolume());
    }
}

/** 1번 : 오류를 고친 Cat (원래 이름 Cat) */
class Cat1 {                         // ① public 제거
    private static int MAX_WEIGHT;
    int weight;
    String name;

    Cat1() {                         // ② void 제거 → 생성자
        this("영순이", 50);          // ③ 첫 줄로 이동
        MAX_WEIGHT = 100;
    }

    Cat1(String name) {              // ④ 추가
        this(name, 0);
    }

    Cat1(String name, int weight) {  // ④ 추가
        this.name = name;
        this.weight = weight;
    }

    static int getMaxWeight() {      // 💡 확인용
        return MAX_WEIGHT;
    }
}

/** 1번 추가 : 생성자 vs 게터 / 세터 (예시 코드, 원래 이름 Cat) */
class CatGS {
    private String name;
    private int weight;

    // 1. 생성자: 태어날 때(객체 생성 시) 이름과 몸무게를 필수로 정하도록 강제함
    public CatGS(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    // 2. Getter: 현재 몸무게를 읽어갈 수 있는 출입구
    public int getWeight() {
        return weight;
    }

    // 3. Setter: 몸무게를 수정할 수 있는 출입구 (안전 검사 포함)
    public void setWeight(int weight) {
        if (weight > 0) {            // 몸무게가 0 이하가 되는 논리적 오류 방지
            this.weight = weight;
        }
    }
}

/** 2번 */
class Dog {
    private String name;             // 전용 멤버
    public String breed;             // 공용 멤버
    private int age;                 // 전용 멤버

    Dog() {
        this(null, null, 0);         // 주어지지 않은 데이터는 0(기본값)으로
    }

    Dog(String name, int age) {
        this(name, null, age);
    }

    Dog(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    void print() {
        System.out.println("이 름 : " + name);
        System.out.println("품 종 : " + breed);
        System.out.println("나 이 : " + age);
        System.out.println("------------------------");
    }
}

/** 3번 */
class Cube {
    private int side;                // 부피는 필드로 두지 않음

    Cube(int side) {                 // 일반 생성자
        this.side = side;
    }

    Cube(Cube c) {                   // 복사 생성자
        this.side = c.side;
    }

    int getSide() {
        return side;
    }

    int getVolume() {
        return side * side * side;   // 정육면체의 부피 = side³
    }
}
