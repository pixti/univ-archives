/**
 * [9강 과제] 2번 문제 (CellPhone 클래스 - 생성자 중복 정의)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
