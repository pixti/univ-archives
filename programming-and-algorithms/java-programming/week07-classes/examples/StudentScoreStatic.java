/**
 * [7-2 실습] 앞 예제(StudentScore.java)를 this 키워드와 정적 변수를 사용하여 재구현하기
 *
 * 포인트
 *  1. this 키워드 사용
 *     - this.sname = name; 처럼 "이 객체의 필드" 임을 명시.
 *       여기서는 매개변수 이름(name, k ...)과 필드 이름이 달라서 this 를 빼도 같은 의미다.
 *       이름이 같을 때(this.name = name)는 this 가 꼭 필요하다. (실습 클래스1 1번 📝 필기)
 *  2. 정적 변수 count 추가
 *     - static int count = 0;  → 모든 StudentStatic 객체가 공유하는 "학생 수"
 *     - StudentStatic.count++;       → 클래스명으로 접근 (students[0].count++ 로 써도 같은 변수)
 *     - 배열은 100칸이지만 실제로 들어 있는 학생은 count 명 → for 문을 students.length 가 아니라
 *       StudentStatic.count 까지만 돈다. (100 까지 돌면 비어 있는 칸(null)에서 NullPointerException)
 *
 * 💡 이 파일은 강의의 StudentStatic.java + StudentScore.java 두 파일을 한 파일로 합쳤다.
 *    public class 는 하나만 둘 수 있으므로 StudentStatic 의 public 을 뺐다.
 *    (원래 이름 StudentScore 는 7-1 예제와 겹쳐서 StudentScoreStatic 으로 바꿈)
 * 💡 count++ 를 main 에서 직접 하지 않고 setInfo 안에서 하면 빠뜨릴 걱정이 없다.
 *    9주차 생성자에서 "객체가 만들어질 때마다 count++" 하는 형태로 많이 쓴다.
 *
 * 실행 결과
 *  bmkim1, 2016001, 70, 80, 90
 *  bmkim2, 2016002, 60, 70, 80
 *  bmkim3, 2016003, 50, 60, 70
 *  국어 평균 : 60.0
 *  영어 평균 : 70.0
 *  수학 평균 : 80.0
 *  전체 평균 : 70.0
 *
 * 💡 같은 모듈의 다른 예제에도 같은 이름의 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.
 *    그래서 클래스 이름을 바꿨다. (Student → StudentStatic, 강의 코드에서는 바꾸기 전 이름)
 */
public class StudentScoreStatic {
    public static void main(String[] args) {
        int korSum = 0, engSum = 0, mathSum = 0;
        double totalSum = 0.0, korAvg, engAvg, mathAvg, totalAvg;

        StudentStatic[] students = new StudentStatic[100];
        students[0] = new StudentStatic();
        students[0].setInfo("bmkim1", 2016001, 70, 80, 90);
        StudentStatic.count++; // students[0].count++;
        students[1] = new StudentStatic();
        students[1].setInfo("bmkim2", 2016002, 60, 70, 80);
        StudentStatic.count++; // students[0].count++;
        students[2] = new StudentStatic();
        students[2].setInfo("bmkim3", 2016003, 50, 60, 70);
        StudentStatic.count++; // students[0].count++;

        for (int i = 0; i < StudentStatic.count; i++) {
            System.out.println(students[i].getInfo());
            korSum += students[i].kor;
            engSum += students[i].eng;
            mathSum += students[i].math;
            totalSum += students[i].getAverage();
        }
        korAvg = ((double) korSum) / StudentStatic.count;
        engAvg = ((double) engSum) / StudentStatic.count;
        mathAvg = ((double) mathSum) / StudentStatic.count;
        totalAvg = totalSum / StudentStatic.count;
        System.out.println("국어 평균 : " + korAvg);
        System.out.println("영어 평균 : " + engAvg);
        System.out.println("수학 평균 : " + mathAvg);
        System.out.println("전체 평균 : " + totalAvg);
    }
}

class StudentStatic {
    String sname;
    int sid, kor, eng, math;
    static int count = 0; // 정적 변수 추가!

    void setInfo(String name, int id, int k, int e, int m) {
        this.sname = name; this.sid = id; this.kor = k; this.eng = e; this.math = m;
    }

    double getAverage() { return (this.kor + this.eng + this.math) / 3.0; }

    String getInfo() {
        return this.sname + ", " + this.sid + ", " + this.kor + ", " + this.eng + ", " + this.math;
    }
}
