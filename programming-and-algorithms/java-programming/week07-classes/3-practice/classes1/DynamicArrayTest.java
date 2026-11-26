/**
 * [7강 실습] 클래스(1) - 4번 문제 (DynamicArray - 크기가 자동으로 늘어나고 줄어드는 배열)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray();     // ⚠ 문제 : new MyArray();
        int x;
        arr.append(3);
        arr.append(5);
        System.out.println("용량 : " + arr.getCapacity() + ", 사이즈 : " + arr.getSize());
        arr.append(6);
        arr.append(7);
        System.out.println("용량 : " + arr.getCapacity() + ", 사이즈 : " + arr.getSize());
        x = arr.delete();
        System.out.println("데이터 : " + x);
        arr.delete();
        arr.delete();
        System.out.println("용량 : " + arr.getCapacity() + ", 사이즈 : " + arr.getSize());
        arr.shrink();
        System.out.println("용량 : " + arr.getCapacity() + ", 사이즈 : " + arr.getSize());
        x = arr.delete();
        System.out.println("데이터 : " + x);
    }
}

class DynamicArray {
    private int capacity;
    private int size;
    private int[] array;

    public DynamicArray() {          // 💡 생성자 (9주차) : new DynamicArray() 할 때 자동으로 실행
        capacity = 3;
        size = 0;
        array = new int[capacity];
    }

    public int append(int val) {
        if (val <= 0) {
            return -1;                                   // 양의 정수만 저장
        }
        if (size == capacity) {                          // 꽉 찼으면
            capacity *= 2;                               // 용량 2배
            int[] newArray = new int[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];                  // 기존 값 복사
            }
            array = newArray;                            // 필드가 새 배열을 가리키게
        }
        array[size++] = val;
        return size;
    }

    public int delete() {
        if (size == 0) {
            return -1;
        }
        int deletedValue = array[size - 1];
        size--;                                          // 논리적 삭제
        return deletedValue;
    }

    public int getCapacity() { return capacity; }
    public int getSize() { return size; }

    // 처음 작성한 코드 : "반 미만" 을 그대로 (double 로 실수 나눗셈)
    public int shrink() {
        if (size < (double) capacity / 2) {
            capacity /= 2;
            int[] newArray = new int[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;                            // 물리적으로 용량 줄이기
            return capacity;
        }
        return -1;
    }

    // 📝 교수님 팁 버전 : 나눗셈을 한 번만 하고 재사용
    public int shrinkOptimized() {
        int newCapacity = capacity / 2;
        if (size <= newCapacity) {
            capacity = newCapacity;
            int[] newArray = new int[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            return capacity;
        }
        return -1;
    }
}
