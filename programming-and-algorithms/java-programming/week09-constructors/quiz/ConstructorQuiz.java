/**
 * [9강 퀴즈] 생성자와 소멸자 (생성자 · 소멸자 · 오버로딩 · this() · 복사 생성자)
 *
 *  0. 생성자와 소멸자의 개념, 메소드 중복정의(오버로딩)                             → concept()
 *  1. 다음 코드(Main + Cat)에 존재하는 모든 오류를 수정하라.                        → q1()
 *     + 📝 AI 질문 : 생성자와 게터 / 세터의 차이, 왜 세터가 따로 필요한가              → q1Extra()
 *  2. Dog 클래스 : private / public 필드, 생성자 중복 정의, getter / setter           → q2()
 *  3. Cube 클래스 : 일반 생성자 + 복사 생성자, 부피 계산                             → q3()
 *
 * 💡 퀴즈 문제지(hwp)의 문항 본문은 자료에 남아 있지 않아서, 필기와 답안 코드를 보고 문항을 정리했다.
 * 💡 한 파일 안에서 실행하려고 문제의 클래스들을 아래쪽에 public 없이 넣었다.
 *    이름이 겹치는 것은 바꿨다. (1번 Cat → Cat1, 1번 추가 Cat → CatGS)
 *
 * 실행 결과
 *  ===== 0 =====
 *  println(10) / println("열") / println(10.5) → 10 / 열 / 10.5
 *  ===== 1 =====
 *  cat1 : 영순이, 50, MAX_WEIGHT = 100
 *  cat2 : 바둑이, 0
 *  cat3 : 거북이, 40
 *  ===== 1 (추가) =====
 *  3
 *  4
 *  -1 은 무시됨 → 4
 *  ===== 2 =====
 *  ------------------------
 *  이 름 : null
 *  품 종 : null
 *  나 이 : 0
 *  ------------------------
 *  이 름 : 별
 *  품 종 : null
 *  나 이 : 6
 *  ------------------------
 *  이 름 : 은비
 *  품 종 : 말티즈
 *  나 이 : 3
 *  ------------------------
 *  이 름 : 강아지
 *  품 종 : 요크셔테리어
 *  나 이 : 1
 *  ------------------------
 *  이 름 : 별
 *  품 종 : 말티즈
 *  나 이 : 6
 *  ------------------------
 *  이 름 : 은비
 *  품 종 : 말티즈
 *  나 이 : 3
 *  ------------------------
 *  ===== 3 =====
 *  c1의 한변의 길이 : 20
 *  c1의 부      피 : 8000
 *  c2의 한변의 길이 : 20
 *  c2의 부      피 : 8000
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

    /**
     * 0. 생성자와 소멸자, 오버로딩
     *
     * 📝 필기 : 객체가 생성될 때 → 생성자
     *          객체가 소멸될 때 → 소멸자. 자바에서는 가비지 컬렉터가 결정함. → 파이널라이즈(finalize)
     *
     * 📝 필기 : 메소드를 여러 형태로 제공해주는 것. 파라미터의 개수나 타입이 다르게.
     *          중복정의(overloading) 라고 함.
     *
     * 📝 필기 (AI 설명) 오버로딩 핵심 규칙
     *   - 메소드 이름이 완전히 같아야 한다.
     *   - 파라미터의 개수, 타입(자료형), 순서 중 하나 이상이 반드시 달라야 한다.
     *   - 반환(return) 타입만 다르게 설정하는 것은 오버로딩으로 인정되지 않는다.
     *       int  sum(int a, int b)
     *       long sum(int a, int b)   // ❌ 컴파일 오류 : 반환형만 다름 (method sum(int,int) is already defined)
     *   - 도입 장점 : 가장 대표적인 예가 System.out.println() 이다.
     *     오버로딩이 없다면 숫자, 문자, 문자열을 출력할 때마다 printlnInt(), printlnString() 처럼
     *     각기 다른 이름을 외워야 한다. 오버로딩 덕분에 println() 하나만 기억하고 값을 넘기면
     *     컴파일러가 알맞은 메소드를 찾아 실행해 주므로 가독성과 편의성이 크게 좋아진다.
     *
     * 💡 생성자도 메소드처럼 오버로딩할 수 있다. (Cat(), Cat(String), Cat(String, int) ...)
     * 💡 소멸자 자세한 내용과 ⚠ finalize deprecated : lecture-notes/9-3 7절, examples/FinalizeTest.java
     */
    static void concept() {
        // println 은 println(int), println(String), println(double) ... 로 오버로딩되어 있다
        System.out.print("println(10) / println(\"열\") / println(10.5) → ");
        System.out.print(10);
        System.out.print(" / ");
        System.out.print("열");
        System.out.print(" / ");
        System.out.println(10.5);
    }

    /**
     * 1. 다음 코드에 존재하는 모든 오류를 수정하라.
     *
     *   public class Main {
     *       public static void main(String[] args) {
     *           Cat cat1 = new Cat();
     *           Cat cat2 = new Cat("바둑이");
     *           Cat cat3 = new Cat("거북이", 40);
     *       }
     *   }
     *   public class Cat {
     *       private static int MAX_WEIGHT;
     *       int weight;
     *       String name;
     *       void Cat() {
     *           MAX_WEIGHT = 100;
     *           this("영순이", 50);
     *       }
     *   }
     *
     * 📝 필기 (AI 답변) 오류 원인 및 수정 방법
     *   ① 접근 제어자 : 하나의 .java 파일에는 public class 가 하나만 있어야 한다 → Cat 의 public 제거
     *   ② 생성자의 반환형 : 생성자에는 반환형을 쓰지 않는다 → void 제거
     *   ③ this() 의 위치 : 다른 생성자 호출 this(...) 는 생성자의 첫 줄에 와야 한다 → MAX_WEIGHT = 100 위로 이동
     *   ④ 정의되지 않은 생성자 : Cat(String), Cat(String, int) 가 없다 → 추가
     *
     * 📝 필기 : 다른 생성자를 호출할때는 반드시 1번째 줄에 와야함.
     * 📝 필기 : 다른 생성자들이 정의되어 있지 않음.
     *
     * ⚠ ② 를 정확히 말하면 void Cat() 은 "문법 오류"가 아니라 이름이 클래스와 같은 "일반 메소드"다.
     *   그래서 실제로 나는 오류는 그 메소드 안의 this(...) 이다.
     *     error: explicit constructor invocation may only appear within a constructor body
     *   그리고 생성자가 하나도 없으므로 기본 생성자 Cat() 만 자동으로 생기고, new Cat("바둑이") 등은
     *     error: constructor Cat in class Cat cannot be applied to given types;
     * ⚠ ③ JDK 25 (JEP 513) 부터는 this(...) 앞에 this 를 쓰지 않는 문장이 허용된다.
     *   MAX_WEIGHT 는 static 필드(객체가 아니라 클래스 소속)라서 MAX_WEIGHT = 100; this("영순이", 50); 순서도
     *   JDK 25 에서는 컴파일된다. (JDK 21 : flexible constructors is not supported in -source 21)
     *   시험은 교재 기준이므로 "this() 는 첫 줄" 로 답한다.
     * 💡 MAX_WEIGHT 는 static 이므로 생성자에서 대입하면 객체를 만들 때마다 덮어쓴다.
     *   한 번만 초기화하려면 선언과 함께(= 100) 또는 static { MAX_WEIGHT = 100; } 블록. (9-3 6절, FieldInitTest.java)
     * 💡 아래 Cat1 은 AI 가 고쳐 준 코드에 Cat(String) 도 this(...) 로 연결하고, 출력용 메소드를 덧붙였다.
     *   AI 원본 : Cat(String name) { this.name = name; }  → 결과는 같음 (weight 는 기본값 0)
     */
    static void q1() {
        Cat1 cat1 = new Cat1();
        Cat1 cat2 = new Cat1("바둑이");
        Cat1 cat3 = new Cat1("거북이", 40);
        System.out.println("cat1 : " + cat1.name + ", " + cat1.weight + ", MAX_WEIGHT = " + Cat1.getMaxWeight());
        System.out.println("cat2 : " + cat2.name + ", " + cat2.weight);
        System.out.println("cat3 : " + cat3.name + ", " + cat3.weight);
    }

    /**
     * 1. (추가) 📝 AI 에게 질문 : 생성자와 게터 세터의 차이
     *
     * 📝 필기 (AI 답변)
     *   생성자는 객체가 처음 만들어질 때 "딱 한 번" 초기 상태를 세팅하고,
     *   게터 / 세터는 객체가 만들어진 "이후 필요할 때마다" 값을 안전하게 읽거나 수정한다.
     *
     *   작동 시점과 목적의 차이
     *     - 생성자 (탄생 / 초기화) : new 로 객체를 만들 때 단 한 번 호출된다.
     *                               객체가 반드시 가져야 할 초기값을 강제로 넣어 준다.
     *     - 게터 / 세터 (접근 / 수정) : 객체가 만들어진 뒤 언제든지 호출할 수 있다.
     *                               private 필드에 접근하는 합법적인 통로이고,
     *                               세터 안의 조건문으로 잘못된 값(예: 음수 나이)을 막을 수 있다.
     *
     *   실제 사용 흐름
     *     Cat myCat = new Cat("나비", 3);          // 생성자 : 태어날 때 이름과 몸무게 설정
     *     System.out.println(myCat.getWeight());   // 3 출력
     *     myCat.setWeight(4);                      // 세터 : 나중에 몸무게 변경
     *
     * 📝 질문 : 생성자로 초기화할 수 있는데 왜 굳이 세터(Setter) 메서드까지 따로 만들어야 하는지 이유를 알려줘.
     * 📝 필기 (AI 답변) : 생성자는 "초기 상태"만 정할 수 있기 때문이다.
     *   - 상태 변화(업데이트) : 데스크톱을 조립할 때 RAM 을 48GB 로 정하는 것은 생성자의 일이다.
     *     나중에 RAM 을 바꾸고 싶을 때 PC 를 새로 사는(= 객체를 새로 만드는) 대신 부품만 교체하는 것이 세터다.
     *     게임 캐릭터의 레벨 업, HP 감소도 세터로 처리한다.
     *   - 유효성 검사 유지 : 값이 바뀔 때마다 검사해야 한다. (예: HP 는 0 아래로 내려가지 않게)
     *   - 선택적 유연성 : 절대 바뀌면 안 되는 데이터(주민등록번호, 계정 생성일)는 세터를 만들지 않고
     *     생성자로만 값을 넣는다. → 읽기 전용 필드
     *
     * 💡 "절대 바뀌면 안 되는 데이터" 는 9-3 의 final 필드(생성자에서 초기화)로 만들면 컴파일러가 보장해 준다.
     */
    static void q1Extra() {
        CatGS myCat = new CatGS("나비", 3);
        System.out.println(myCat.getWeight());   // 3 출력
        myCat.setWeight(4);
        System.out.println(myCat.getWeight());   // 4 출력
        myCat.setWeight(-1);                     // 0 이하 → 무시
        System.out.println("-1 은 무시됨 → " + myCat.getWeight());
    }

    /**
     * 2. Dog 클래스를 작성하시오.
     *   - 이름(name) : 전용 멤버,  품종(breed) : 공용 멤버 (예: "요크셔테리어", "푸들", "말티즈"),  나이(age) : 전용 멤버
     *   - 생성자 : Dog(string name, int age), Dog(string name, string breed, int age)
     *   - 주어지지 않은 데이터는 0 으로 초기화한다.
     *
     *   main
     *     Dog d1 = new Dog, d2 = new Dog("별", 6), d3 = new Dog("은비", "말티즈", 3);
     *     (d1, d2, d3 출력)
     *     d1.setName("강아지"); d1.setAge(1); d1.setBreed("요크셔테리어");
     *     d2.setBreed("말티즈");
     *     (d1, d2, d3 출력)
     *
     * 📝 필기 (AI 답변) : 전용 = private, 공용 = public.
     *   Dog() { this(null, null, 0); },  Dog(String name, int age) { this(name, null, age); },
     *   Dog(String name, String breed, int age) 에서 실제 초기화. 모든 필드에 getter / setter.
     *
     * ⚠ 문제의 오타 (C++ 문법이 섞임)
     *   ❌ string        ✅ String          (자바의 문자열 클래스는 대문자 S)
     *   ❌ new Dog,      ✅ new Dog();      (자바는 괄호 생략 불가, 변수마다 Dog 선언)
     *   그리고 new Dog() 를 쓰려면 매개변수 없는 생성자 Dog() 도 만들어야 한다. (생성자를 하나라도 만들면 기본 생성자는 안 생김)
     * 💡 "0 으로 초기화" 는 int 는 0, String 은 null(레퍼런스의 기본값)이 된다. "" 로 하고 싶으면 this("", "", 0).
     * 💡 breed 는 public 이라 d2.breed = "말티즈" 처럼 직접 바꿀 수도 있지만, 문제의 main 은 setBreed 를 쓴다.
     */
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

    /**
     * 3. Cube 클래스를 작성하시오. (한 변의 길이 side, 부피 getVolume, 일반 생성자와 복사 생성자)
     *
     *   main
     *     Cube c1 = new Cube(20), c2 = new Cube(c1);
     *     System.out.println("c1의 한변의 길이 : " + c1.getSide());
     *     System.out.println("c1의 부      피 : " + c1.getVolume());
     *     System.out.println("c1의 한변의 길이 : " + c1.getSide());   ← ⚠
     *     System.out.println("c1의 부      피 : " + c1.getVolume());  ← ⚠
     *
     * 📝 필기 : 부피는 새로운 필드로 정의할 필요가 없다. 한변의 길이 x 한변의 길이가 부피이므로.
     * 📝 필기 (AI 답변) : 이 문제의 핵심은 일반 int 생성자와 복사 생성자 Cube(Cube c) 의 오버로딩.
     *   Cube(Cube c) { this.side = c.side; }   getVolume() { return side * side * side; }
     *
     * ⚠ 필기의 "한변의 길이 x 한변의 길이" 는 넓이(side²)다. 정육면체의 부피는 side x side x side (side³).
     *   20 x 20 x 20 = 8000 이 실행 결과와 맞다. (20 x 20 = 400 이면 틀림)
     * ⚠ 문제의 main 아래 두 줄은 c2 를 출력해야 하는데 c1 으로 되어 있다. AI 가 c2 로 고쳤다.
     * 💡 부피를 필드로 두지 않는 이유 : side 를 바꾸면 부피도 바뀌어야 하는데, 필드로 두면 두 값이 어긋날 수 있다.
     *   필요할 때 계산하면 항상 정확하다.
     * 💡 복사 생성자 : 같은 클래스의 객체를 받아 그 값을 복사한 "새" 객체를 만든다.
     *   c2 = c1 (레퍼런스 복사, 같은 객체) 과 다르게 c2 는 독립된 객체라 c1 을 바꿔도 c2 는 그대로다.
     *   Cube(Cube c) { this(c.side); } 처럼 this(...) 로 연결해도 된다.
     *   c.side 는 private 이지만 같은 클래스 안이라 접근할 수 있다. (7강 실습 ComplexTest 📝)
     */
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

/** 1번 추가 : 생성자 vs 게터 / 세터 (AI 예시 코드, 원래 이름 Cat) */
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
