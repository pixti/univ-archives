/**
 * [11강 실습] 상속 추가 실습 (인터페이스, 컴포지션, 다중 상속) - 3번 문제 (Person has-a Job : 컴포지션)
 *
 * 문제
 *  Inheritance 는 object 사이에 is-a relationship 을 갖고 있을 때 사용되며, composition 은 has-a relationship 을 갖고 있을 때
 *  사용한다. 둘 다 코드를 재사용하게 하는 기법이다. "Person 은 Job 을 갖는다" 라는 사실을 기초로 Person 과 Job 클래스를 정의하라.
 *  단, Job 클래스는 role, salary, id 를 필드로 갖는다.
 *
 *    public class Job {
 *        private String role;
 *        private long salary;
 *        private int id;
 *        (각 필드의 getter / setter)
 *    }
 *
 * 정답 코드
 *    public class Person {
 *        //composition has-a relationship
 *        private Job job;
 *
 *        public Person(){
 *            this.job=new Job();
 *            job.setSalary(1000L);
 *        }
 *        public long getSalary() {
 *            return job.getSalary();
 *        }
 *    }
 *    public class TestPerson {
 *        public static void main(String[] args) {
 *            Person person = new Person();
 *            long salary = person.getSalary();
 *        }
 *    }
 *
 * 📝 필기 : ★) is-a 관계 has-a 관계
 *
 * 📝 필기 : 1단계 - 자바의 기초 개념과 객체 생성 메커니즘
 *   상속과 포함을 이해하려면 먼저 클래스가 무엇이고, 객체가 메모리에 어떻게 만들어지는지 정확히 알아야 한다.
 *   1) 클래스 (Class) 와 객체 (Object)
 *      - 클래스 : 관련 있는 변수(데이터)와 메소드(기능)를 하나로 묶어 놓은 "설계도" 이자 "새로운 자료형(타입)" 이다.
 *        클래스 코드 자체는 하드디스크에 저장된 텍스트일 뿐, 프로그램이 실행될 때 실제 데이터를 저장하지 못한다.
 *      - 객체 (인스턴스) : 클래스라는 설계도를 바탕으로 실제 컴퓨터 메모리(RAM, 정확히는 Heap 영역)에 만들어진 실체다.
 *   2) 객체 생성 메커니즘 (Job j = new Job(); 의 작동 원리) - 이 한 줄을 적으면 컴퓨터 내부에서는 4단계의 일이 일어난다.
 *        [코드]  Job j     =      new Job();
 *               (1단계) (4단계)  (2단계, 3단계)
 *      1. Job j (참조 변수 선언) : 메모리의 스택(Stack) 영역에 j 라는 이름의 작은 상자가 만들어진다. 이 상자에는 Job 객체 자체가
 *         들어가는 것이 아니라, 앞으로 만들어질 Job 객체의 메모리 주소(위치 번호)만 들어갈 수 있다.
 *      2. new (메모리 공간 확보) : 메모리의 힙(Heap) 영역에 Job 클래스에 적힌 변수들(role, salary, id)이 들어갈 수 있는 실제 크기의
 *         공간을 확보한다. 그리고 그 공간의 고유한 메모리 주소(예 : 0x100번지)가 정해진다.
 *      3. Job() (생성자 호출) : 방금 만든 힙 메모리 공간 안의 변수들을 초기값으로 세팅한다.
 *      4. = (주소 대입) : new 가 만든 실제 객체의 메모리 주소(0x100번지)를 변수 j 에 저장한다.
 *         이제 변수 j 를 통해 실제 객체에 접근(j.setSalary(1000))할 수 있게 된다.
 *        [Stack 메모리]        [Heap 메모리]
 *        ┌──────────┐          ┌─────────────────────┐
 *        │ j: 0x100 │ ───────▶ │ (0x100번지) Job 객체 │
 *        └──────────┘          │  - role: null       │
 *                              │  - salary: 0        │
 *                              │  - id: 0            │
 *                              └─────────────────────┘
 *      이 구조가 자바의 가장 기본이 되는 객체 생성 메커니즘이다.
 *
 * 📝 필기 : 2단계 - 질문에 대한 핵심 답변 : "상속과 포함은 아예 다른 것인가?"
 *   결론부터 말하면 목적만 같고, 개념과 구현 방식(문법, 메모리 구조)은 완전히 다르다.
 *   - 유일한 공통점 (목적) : A 라는 클래스를 만들 때, 이미 만들어져 있는 B 라는 클래스의 코드(변수와 메소드)를 처음부터 다시 짜지 않고
 *     재사용하고 싶다는 목적은 같다.
 *   - 결정적 차이점 (방법)
 *     · 상속 (Inheritance) : B 클래스를 내 부모로 삼아서, A 와 B 를 하나의 몸체로 합쳐 버리는 방식이다. (extends 키워드 사용)
 *     · 포함 (Composition) : A 와 B 를 완전히 "남남(별개의 객체)" 으로 두되, A 클래스 안에서 B 객체를 new 로 생성하여
 *       부품처럼 들고 쓰면서 기능을 빌려 쓰는 방식이다. (멤버 변수 선언 방식 사용)
 *
 * 📝 필기 : 3단계 - 상속 (Inheritance) 상세 분석
 *   1) 개념적 의미 (is-a 관계) : 기존의 추상적이거나 포괄적인 클래스에 살을 더 붙여서, 더 구체적인 새로운 클래스를 만들 때 사용한다.
 *      - 예 : Person(사람) 클래스에는 name(이름)만 있다. 여기에 school(학교명)을 추가하여 Student(학생) 클래스를 만들고 싶다.
 *      - 현실 세계에서 "학생은 일종의 사람이다 (Student is a Person)" 라는 문장이 논리적으로 맞다. 이때 상속을 쓴다.
 *   2) 코드 구현 방식 : extends 키워드를 사용하며, 부모의 변수나 메소드를 내 것처럼 아무런 거쳐감 없이 바로 사용한다.
 *        class Person {
 *            String name;
 *            void eat() { System.out.println("밥을 먹는다"); }
 *        }
 *        // Person 을 상속받은 Student
 *        class Student extends Person {
 *            String school;   // 추가된 변수
 *            // 눈에 보이지 않지만 Person 의 name 변수와 eat() 메소드가 그대로 들어와 있음
 *        }
 *   3) 상속의 객체 생성 메커니즘 (메모리 구조) : Student s = new Student(); 를 실행하면 메모리에서는
 *      1. 자식 객체(Student)를 생성하라고 명령하면, 자바는 자동으로 부모(Person)의 생성자를 먼저 호출(super())한다.
 *      2. 그 결과, 힙 메모리에 부모인 Person 의 공간이 먼저 만들어지고, 그 바로 아래에 자식인 Student 의 공간이 붙어서
 *         하나의 거대한 단일 객체로 만들어진다.
 *        [Stack 메모리]        [Heap 메모리 : 하나의 덩어리로 합쳐짐]
 *        ┌──────────┐          ┌─────────────────────────────┐
 *        │ s: 0x200 │ ───────▶ │ (0x200번지) Student 객체     │
 *        └──────────┘          │  ┌──────────────────────┐   │
 *                              │  │ [부모 Person 영역]    │   │
 *                              │  │  - name              │   │
 *                              │  │  - eat()             │   │
 *                              │  └──────────────────────┘   │
 *                              │  - school (자식 영역)        │
 *                              └─────────────────────────────┘
 *      하나의 몸체로 합쳐져 있기 때문에, 외부에서 s.name = "홍길동";, s.eat(); 처럼 부모의 기능을 내 것처럼 바로 호출할 수 있다.
 *
 * 📝 필기 : 4단계 - 포함 / 합성 (Composition) 상세 분석
 *   1) 개념적 의미 (has-a 관계) : 서로 종류가 완전히 다른 클래스의 기능이 필요할 때, 그 클래스를 내 부품이나 속성으로 소유하는 관계다.
 *      - 예 : Person(사람) 클래스에서 Job(직업) 클래스에 있는 salary(급여) 기능이 필요하다.
 *      - 현실 세계에서 "사람은 일종의 직업이다 (Person is a Job)" 라고 하면 말이 안 된다. "사람은 직업을 가지고 있다
 *        (Person has a Job)" 가 맞다. 따라서 상속(extends)을 쓰면 안 되고 포함(Composition)을 써야 한다.
 *   2) 코드 구현 방식 : extends 를 쓰지 않는다. 대신 1단계에서 배웠던 객체 생성 메커니즘(Job job = new Job();)을 Person 클래스
 *      내부에서 그대로 수행한다.
 *        class Job {
 *            long salary;
 *            long getSalary() { return salary; }
 *        }
 *        class Person {
 *            // 1. Job 객체의 주소를 담을 참조 변수를 멤버(필드)로 선언
 *            private Job job;
 *            public Person() {
 *                // 2. Person 이 만들어질 때, Job 객체도 새로 만들어서 주소를 연결함
 *                this.job = new Job();
 *            }
 *            // 3. Job 의 기능을 쓰려면 반드시 참조 변수 "job." 을 거쳐서 호출해야 함
 *            public long getPersonSalary() {
 *                return this.job.getSalary();
 *            }
 *        }
 *   3) 포함의 객체 생성 메커니즘 (메모리 구조) : Person p = new Person(); 을 실행하면 메모리에서는 상속과 완전히 다르게 만들어진다.
 *      1. 힙 메모리에 Person 객체(0x300번지)가 만들어진다. 그 안에는 job 이라는 참조 변수가 들어 있다.
 *      2. Person 의 생성자가 실행되면서 new Job() 이 작동하여, 힙 메모리의 전혀 다른 위치(0x400번지)에 별개의 Job 객체가 만들어진다.
 *      3. Person 안의 job 변수에 0x400번지라는 주소값이 저장되어 두 객체가 선(참조)으로 연결된다.
 *        [Stack 메모리]        [Heap 메모리 : 두 객체가 따로 만들어지고 주소로 연결됨]
 *        ┌──────────┐          ┌──────────────────────┐        ┌───────────────────────┐
 *        │ p: 0x300 │ ───────▶ │ (0x300) Person 객체   │        │ (0x400) Job 객체       │
 *        └──────────┘          │  ┌────────────────┐  │        │  - salary: 1000       │
 *                              │  │ job: 0x400  ───┼──┼──────▶ │  - getSalary()        │
 *                              │  └────────────────┘  │        └───────────────────────┘
 *                              └──────────────────────┘
 *      이처럼 두 객체가 하나로 합쳐진 것이 아니라 독립된 두 개의 객체로 존재하기 때문에, Person 안에서 Job 의 기능을 쓰려면
 *      내 것처럼 바로 부를 수 없고 반드시 this.job.getSalary() 처럼 변수 이름을 거쳐서 불러야 한다.
 *
 * 📝 필기 : 5단계 - 한눈에 보는 코드 및 구조 비교
 *   만약 Person 이 Job 의 급여(getSalary) 기능을 재사용하려고 할 때, 상속으로 짰을 때(잘못된 설계)와 포함으로 짰을 때(올바른 설계)
 *     비교 항목         상속 (is-a) 방식으로 작성 시                    포함 (has-a) 방식으로 작성 시
 *     클래스 선언       class Person extends Job                        class Person { private Job job; }
 *     객체 생성 수      new Person() 실행 시 1개의 통합된 객체 생성      new Person() 과 내부의 new Job() 으로 2개의 개별 객체 생성
 *     기능 사용법       부모 것이 곧 내 것이므로 바로 호출               남의 객체를 변수로 쥐고 있으므로 변수를 통해 호출
 *                       long s = getSalary();                           long s = this.job.getSalary();
 *     외부(Main) 호출   person.getSalary() 가 자동으로 노출됨           Person 이 허락(위임 메소드 작성)한 기능만 노출됨
 *
 * 📝 필기 : 6단계 - 추가 개념 : 상속과 포함에서 쓰이는 필수 키워드 (this vs super)
 *   1. this 와 this() (자기 자신)
 *      - 모든 클래스에서 사용한다.
 *      - this.변수명 : 현재 만들어져 있는 객체 자기 자신의 멤버 변수를 가리킨다.
 *        (포함 관계에서 this.job = new Job(); 은 "내 객체 안에 있는 job 변수에 새로 만든 Job 객체 주소를 넣어라" 라는 뜻이다)
 *      - this() : 자기 자신의 다른 생성자를 호출할 때 쓴다.
 *   2. super 와 super() (부모 객체)
 *      - 오직 상속(extends) 관계에서만 사용한다.
 *      - super.변수명 / super.메소드명() : 자식 클래스 안에서 부모 클래스의 영역에 있는 변수나 메소드를 명시적으로 가리킬 때 쓴다.
 *      - super() : 자식 생성자 첫 줄에서 부모 클래스의 생성자를 호출할 때 쓴다. 개발자가 적지 않아도 컴파일러가 눈에 보이지 않게
 *        자동으로 첫 줄에 끼워 넣는다. (이 때문에 3단계에서 설명했던 자식 객체를 만들면 부모 영역이 먼저 메모리에 만들어지는 것이다)
 *
 * 📝 필기 : 요약 정리
 *   1. 자바에서 클래스를 사용하려면 new 를 통해 메모리에 객체를 만들고 그 주소를 참조 변수에 담아야 한다.
 *   2. 다른 클래스의 코드를 재사용하는 방법에는 상속과 포함 두 가지가 있다.
 *   3. 상속(extends, is-a)은 두 클래스를 부모-자식으로 묶어 메모리상에서 하나의 몸체로 합치는 것이다. ("학생은 사람이다")
 *   4. 포함(has-a)은 클래스 안에 다른 클래스 타입의 참조 변수를 선언하고, 내부에서 new 로 별도의 객체를 생성해 연결(소유)하여
 *      기능을 빌려 쓰는 것이다. ("사람은 직업을 가진다")
 *
 * 💡 문제의 정답 코드는 main 에서 salary 를 받기만 하고 출력하지 않는다. 확인용으로 출력문을 덧붙였다.
 * 💡 1000L 의 L 은 long 리터럴 표시다. (2강) setSalary(long) 에 1000 을 넣어도 자동 형변환되지만, long 임을 분명히 하려고 붙였다.
 * 💡 원래는 Job.java, Person.java, TestPerson.java 처럼 public class 마다 파일을 나눈다. 한 파일에 넣으려고 Job, Person 의
 *    public 을 뺐다.
 *
 * 실행 결과
 *  salary = 1000
 */
public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();
        long salary = person.getSalary();
        System.out.println("salary = " + salary);   // 💡 확인용
    }
}

class Job {
    private String role;
    private long salary;
    private int id;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Person {
    // composition has-a relationship
    private Job job;

    public Person() {
        this.job = new Job();
        job.setSalary(1000L);
    }

    public long getSalary() {
        return job.getSalary();
    }
}
