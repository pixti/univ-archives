/**
 * [7강 과제] 클래스(2) - 2번 문제 (CellPhone 클래스 - boolean 필드와 is~ getter)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
