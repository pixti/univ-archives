/**
 * [9강 실습] 생성자 - 1번 문제 (Plane 클래스 - 생성자 중복 정의)
 *
 * 문제 (요약)
 *  비행기의 식별 번호(id), 모델(model), 승객 수(passenger)를 필드로 가지는 Plane 클래스를 작성하시오.
 *  - 생성자를 중복 정의해 Plane(), Plane(id), Plane(id, model), Plane(id, model, passenger) 로 만들 수 있게 한다.
 *  - 필드는 private, getter / setter 를 둔다.
 *  - main 에서 p1 ~ p4 를 만들고 setter 로 값을 바꾼 뒤 출력한다.
 *
 * 포인트
 *  - 생성자 오버로딩 + this(...) 로 다른 생성자 호출
 *
 * 📝 필기 : 생성자 체이닝 this() 기법.
 *    매개변수가 가장 많은 생성자 Plane(int, String, int) 하나에만 실제 대입 코드를 두고,
 *    나머지 생성자는 this(...) 로 "빈 값"(0, null)을 채워 그 생성자를 호출한다.
 *      Plane()                → this(0, null, 0)
 *      Plane(1)               → this(1, null, 0)
 *      Plane(2, "B-747")      → this(2, "B-747", 0)
 *      Plane(3, "A-330", 80)  → 실제 초기화
 *    → 초기화 코드가 한 곳에 모여 중복이 없고, 고칠 때도 한 곳만 고치면 된다.
 *
 * 💡 this(...) 는 생성자의 첫 문장이어야 한다(교재 기준). (퀴즈 1번 📝 필기)
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 PlaneTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  식별 번호 : 0
 *  모    델 : A-380
 *  승 객 수 : 60
 *
 *  식별 번호 : 1
 *  모    델 : B-787
 *  승 객 수 : 120
 *
 *  식별 번호 : 2
 *  모    델 : B-747
 *  승 객 수 : 140
 *
 *  식별 번호 : 3
 *  모    델 : A-330
 *  승 객 수 : 80
 *
 */
public class PlaneTest {
    public static void main(String[] args) {
        Plane p1 = new Plane();
        Plane p2 = new Plane(1);
        Plane p3 = new Plane(2, "B-747");
        Plane p4 = new Plane(3, "A-330", 80);

        p1.setModel("A-380");
        p1.setPassenger(60);
        p2.setModel("B-787");
        p2.setPassenger(120);
        p3.setPassenger(140);

        p1.print();
        p2.print();
        p3.print();
        p4.print();
    }
}

class Plane {
    private int id;
    private String model;
    private int passenger;

    // 생성자 체이닝 : 모두 마지막 생성자로 모인다
    public Plane() {
        this(0, null, 0);
    }

    public Plane(int id) {
        this(id, null, 0);
    }

    public Plane(int id, String model) {
        this(id, model, 0);
    }

    public Plane(int id, String model, int passenger) {   // ← 실제 초기화는 여기서만
        this.id = id;
        this.model = model;
        this.passenger = passenger;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getPassenger() { return passenger; }
    public void setPassenger(int passenger) { this.passenger = passenger; }

    public void print() {
        System.out.println("식별 번호 : " + id);
        System.out.println("모    델 : " + model);
        System.out.println("승 객 수 : " + passenger);
        System.out.println();
    }
}
