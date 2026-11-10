/**
 * [7강 과제] 클래스(2) - 2번 문제 (CellPhone 클래스 - boolean 필드와 is~ getter)
 *
 * 문제
 *  모델명(model), 제조사(manufacturer), 색상(color), 전원(power), 카메라 장착 여부(camera)를 필드로 가지는
 *  CellPhone 클래스를 작성하시오. getter / setter 와 전원을 켜고 끄는 turnOn() / turnOff() 를 만든다.
 *  main 에서 값을 넣고 휴대폰 정보를 출력한다.
 *
 * 📝 필기 (AI 설명) 핵심 개념
 *       | 개념         | 이 코드에서                                       | 설명                                       |
 *       |--------------|---------------------------------------------------|--------------------------------------------|
 *       | private      | private String model; ...                         | 필드를 밖에서 직접 못 바꾸게 숨김 (캡슐화) |
 *       | getter       | getModel(), isPower(), isCamera()                 | 필드 값을 읽어 돌려줌                      |
 *       | setter       | setModel(...), setCamera(true)                    | 필드 값을 바꿈                             |
 *       | boolean      | private boolean power, camera;                    | true / false 두 가지 상태                  |
 *       | turnOn       | power = true;                                     | 전원 켜기                                  |
 *       | turnOff      | power = false;                                    | 전원 끄기                                  |
 *       | 삼항 연산자  | phone.isCamera() ? "장착" : "미장착"              | 조건 ? 참일 때 값 : 거짓일 때 값           |
 *   - boolean 필드의 getter 는 관례적으로 get 대신 is 를 붙인다.  getCamera() → isCamera()
 *     ("카메라가 있는가?" 처럼 질문 형태로 읽힘)
 *
 * 💡 power 는 turnOn() 으로 true 가 되지만 출력하지는 않는다. 확인하려면
 *        System.out.println("전원 : " + (phone.isPower() ? "켜짐" : "꺼짐"));
 *
 * 실행 결과
 *  모델명 : NEXUS ONE
 *  제조사 : HTC
 *  색상 : Black
 *  카메라 장착여부 : 장착
 */
public class CellPhoneTest {
    public static void main(String[] args) {
        CellPhone phone = new CellPhone();
        phone.setModel("NEXUS ONE");
        phone.setManufacturer("HTC");
        phone.setColor("Black");
        phone.setCamera(true);
        phone.turnOn();

        System.out.println("모델명 : " + phone.getModel());
        System.out.println("제조사 : " + phone.getManufacturer());
        System.out.println("색상 : " + phone.getColor());
        System.out.println("카메라 장착여부 : " + (phone.isCamera() ? "장착" : "미장착"));
    }
}

class CellPhone {
    private String model;
    private String manufacturer;
    private String color;
    private boolean power;
    private boolean camera;

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public boolean isPower() { return power; }              // boolean getter → is~
    public void setPower(boolean power) { this.power = power; }

    public boolean isCamera() { return camera; }
    public void setCamera(boolean camera) { this.camera = camera; }

    public void turnOn() { power = true; }
    public void turnOff() { power = false; }
}
