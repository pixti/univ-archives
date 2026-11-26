/**
 * [9강 실습] 생성자 - 1번 문제 (Plane 클래스 - 생성자 중복 정의)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
