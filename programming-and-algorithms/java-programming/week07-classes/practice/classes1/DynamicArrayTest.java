/**
 * [7강 실습] 클래스(1) - 4번 문제 (DynamicArray - 크기가 자동으로 늘어나고 줄어드는 배열)
 *
 * 문제
 *  양의 정수를 저장하는 동적 배열 클래스 DynamicArray 를 만드시오.
 *   - 처음 용량(capacity)은 3, 사이즈(size, 실제로 저장된 개수)는 0
 *   - append(val) : val 이 0 이하이면 -1 반환. 용량이 꽉 찼으면 용량을 2배로 늘린 뒤 저장하고 size 반환
 *   - delete()    : 비어 있으면 -1 반환. 마지막 값을 지우고 그 값을 반환
 *   - shrink()    : size 가 capacity 의 반 미만이면 용량을 반으로 줄이고 새 용량 반환, 아니면 -1
 *   - getCapacity(), getSize()
 *
 * 포인트
 *  - 자바 배열은 한 번 만들면 크기를 바꿀 수 없다.
 *    → 더 큰(작은) 새 배열을 만들고, 기존 값을 복사한 뒤, 필드가 새 배열을 가리키게 한다. (array = newArray;)
 *  - array[size++] = val; : size 자리에 저장한 다음 size 를 1 증가 (후위 증가)
 *
 *      append(3), append(5)        cap 3  [3, 5, _]          size 2
 *      append(6), append(7)        cap 6  [3, 5, 6, 7, _, _] size 4   ← 7 을 넣을 때 꽉 차서 2배
 *      delete() → 7                cap 6  [3, 5, 6, _, _, _] size 3
 *      delete(), delete()          cap 6  [3, _, _, _, _, _] size 1
 *      shrink()                    cap 3  [3, _, _]          size 1   ← 1 < 6/2 이므로 반으로
 *      delete() → 3                cap 3  [_, _, _]          size 0
 *
 * 📝 필기 (AI 설명) 논리적 삭제 vs 물리적 삭제
 *   - delete() 는 size-- 만 한다. 배열 안의 값은 그대로 남아 있지만 size 밖이라 "없는 값" 으로 취급된다.
 *     → 논리적 삭제 : 빠르다. 나중에 append 하면 그 자리를 덮어쓴다.
 *   - 실제로 메모리에서 없애려면(물리적 삭제) 더 작은 새 배열을 만들어 복사해야 한다. (= shrink() 가 하는 일)
 *     중간 값을 지울 때는 뒤의 원소들을 한 칸씩 앞으로 당겨야(shift) 한다.
 *   - 그래서 보통은 논리적 삭제를 하고, 가끔 shrink() 로 용량을 줄인다.
 *
 * 📝 필기 (교수님 팁) 나눗셈은 한 번만 계산해서 재사용하기
 *      int newCapacity = capacity / 2;
 *      if (size <= newCapacity) {
 *          capacity = newCapacity;
 *          int[] newArray = new int[capacity];
 *          ...
 *      }
 * 📝 필기 (AI 설명)
 *   - 원래 코드에서 (double) 을 쓴 이유 : 문제의 "반 미만" 을 그대로 옮기면서 정수 나눗셈(3 / 2 = 1)을 피하려고.
 *   - 하지만 나눗셈은 비용이 큰 연산이라, 나눗셈 횟수를 줄이고 계산한 값을 재사용하는 것이 최적화다.
 *   → 아래 shrink() 는 내가 작성한 원래 코드, shrinkOptimized() 는 교수님 팁 버전이다.
 *
 * ⚠ 문제의 main 코드는 DynamicArray arr = new MyArray(); 로 되어 있다. MyArray 는 없는 클래스라서
 *    new DynamicArray() 로 고쳤다. (main 이 있던 클래스 이름 SayHello 는 DynamicArrayTest 로 바꿈)
 * 💡 두 shrink 의 조건은 경계값에서 조금 다르다.
 *      capacity = 3, size = 1 : 원래  1 < 1.5 → 줄임 (용량 1)     /  팁 버전  1 <= 1 → 줄임 (용량 1)
 *      capacity = 6, size = 3 : 원래  3 < 3.0 → 그대로             /  팁 버전  3 <= 3 → 줄임 (용량 3, 꽉 참)
 *    팁 버전은 "새 용량에 다 들어가면 줄인다" 는 뜻이고, 원래 버전은 문제 문장 "반 미만" 을 그대로 옮긴 것이다.
 *    이 문제의 main 에서는 두 버전의 결과가 같다.
 *
 * 실행 결과
 *  용량 : 3, 사이즈 : 2
 *  용량 : 6, 사이즈 : 4
 *  데이터 : 7
 *  용량 : 6, 사이즈 : 1
 *  용량 : 3, 사이즈 : 1
 *  데이터 : 3
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

    // 내가 작성한 코드 : "반 미만" 을 그대로 (double 로 실수 나눗셈)
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
