/**
 * [9강 과제] 2번 문제 (CellPhone 클래스 - 생성자 중복 정의)
 *
 * 문제 (요약)
 *  모델명(model), 제조사(manufacturer), 색상(color), 전원 상태(power), 카메라 장착 여부(hasCamera)를
 *  필드로 가지는 CellPhone 클래스를 작성하시오.
 *  - 생성자를 중복 정의한다 : CellPhone(), CellPhone(model, manufacturer), 모든 값을 받는 생성자
 *  - powerOn() / powerOff() 와 getter / setter 를 둔다.
 *  - NEXUS ONE, HTC, Black, 전원 off, 카메라 장착인 휴대폰을 만들어 출력한다.
 *
 * 포인트
 *  - 7강 과제 클래스2 2번 CellPhone(setter 로 값 설정)을 생성자로 바꾼 문제.
 *  - boolean 필드의 getter 는 get~ 대신 is~ 로 짓는다 : isPower(), isHasCamera()
 *    (7강 과제 📝 핵심 개념 표 참고)
 *
 * 💡 boolean 값을 "장착 / 미장착" 처럼 글자로 보여 주려고 삼항 연산자 (조건 ? A : B) 를 썼다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. CellPhoneTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  모델명 : NEXUS ONE
 *  제조사 : HTC
 *  색상 : Black
 *  카메라 장착여부 : 장착
 */
public class CellPhoneTest {
    public static void main(String[] args) {
        // 객체 생성 및 테스트 (NEXUS ONE, HTC, Black, 전원 off, 카메라 장착)
        CellPhone phone = new CellPhone("NEXUS ONE", "HTC", "Black", false, true);

        // 실행 결과 포맷에 맞춰 출력
        System.out.println("모델명 : " + phone.getModel());
        System.out.println("제조사 : " + phone.getManufacturer());
        System.out.println("색상 : " + phone.getColor());
        System.out.println("카메라 장착여부 : " + (phone.isHasCamera() ? "장착" : "미장착"));
    }
}

class CellPhone {
    private String model;
    private String manufacturer;
    private String color;
    private boolean power;
    private boolean hasCamera;

    public CellPhone() {
        this("미정", "미정", "Black", false, false);
    }

    public CellPhone(String model, String manufacturer) {
        this(model, manufacturer, "Black", false, false);
    }

    public CellPhone(String model, String manufacturer, String color, boolean power, boolean hasCamera) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.color = color;
        this.power = power;
        this.hasCamera = hasCamera;
    }

    public void powerOn() { power = true; }
    public void powerOff() { power = false; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public boolean isPower() { return power; }
    public boolean isHasCamera() { return hasCamera; }
    public void setHasCamera(boolean hasCamera) { this.hasCamera = hasCamera; }
}
