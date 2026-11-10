/**
 * [8-3 실습] 접근자에 따른 변수 접근성 확인하기 - 필드를 private 으로, getter 로 읽기
 *
 * 포인트
 *  - 필드를 private 으로 선언하면 해당 클래스 내부에서만 접근 가능
 *    → main(StudentScorePrivate 클래스)에서 students[i].kor 로 직접 접근하면 컴파일 오류!
 *      error: kor has private access in Student
 *  - 그래서 public 메소드인 getter(getKor, getEng, getMath)로 값을 읽는다.
 *  - private 필드는 public 메소드로 접근
 *      getter : private 로 선언된 필드 값을 읽는 메소드
 *      setter : private 로 선언된 필드 값을 수정하는 메소드  (여기서는 setInfo 가 setter 역할)
 *
 * 📝 퀴즈 2번 필기 (getter/setter 를 쓰는 이유) : 캡슐화와 정보 은닉.
 *    데이터 무결성(유효성 검사), 접근 권한 제어(읽기 전용/쓰기 전용), 유지보수성
 *
 * 💡 슬라이드는 main 의 "..." 부분이 생략되어 있어 8-1 예제의 학생 3명 데이터로 채웠다.
 *    (원래 이름 StudentScore 는 8-1 예제와 겹쳐서 StudentScorePrivate 로 바꿈)
 *
 * 실행 결과
 *  bmkim1, 2016001, 70, 80, 90
 *  bmkim2, 2016002, 60, 70, 80
 *  bmkim3, 2016003, 50, 60, 70
 *  국어 평균 : 60.0
 *  영어 평균 : 70.0
 *  수학 평균 : 80.0
 *  전체 평균 : 70.0
 */
public class StudentScorePrivate {
    public static void main(String[] args) {
        int korSum = 0, engSum = 0, mathSum = 0;
        double totalSum = 0.0, korAvg, engAvg, mathAvg, totalAvg;

        Student[] students = new Student[3];
        students[0] = new Student();
        students[0].setInfo("bmkim1", 2016001, 70, 80, 90);
        students[1] = new Student();
        students[1].setInfo("bmkim2", 2016002, 60, 70, 80);
        students[2] = new Student();
        students[2].setInfo("bmkim3", 2016003, 50, 60, 70);

        for (int i = 0; i < 3; i++) {
            System.out.println(students[i].getInfo());
            // korSum += students[i].kor;     // ❌ 컴파일 오류 : kor has private access in Student
            korSum += students[i].getKor();    // ✅ getter 로 읽기
            engSum += students[i].getEng();
            mathSum += students[i].getMath();
            totalSum += students[i].getAverage();
        }
        korAvg = korSum / 3.0;
        engAvg = engSum / 3.0;
        mathAvg = mathSum / 3.0;
        totalAvg = totalSum / 3.0;
        System.out.println("국어 평균 : " + korAvg);
        System.out.println("영어 평균 : " + engAvg);
        System.out.println("수학 평균 : " + mathAvg);
        System.out.println("전체 평균 : " + totalAvg);
    }
}

class Student {
    private String sname;
    private int sid, kor, eng, math;

    public String getName() { return sname; }
    public int getSID() { return sid; }
    public int getKor() { return kor; }
    public int getEng() { return eng; }
    public int getMath() { return math; }

    void setInfo(String name, int id, int k, int e, int m) {
        sname = name; sid = id; kor = k; eng = e; math = m;
    }

    double getAverage() { return (kor + eng + math) / 3.0; }

    String getInfo() {
        return sname + ", " + sid + ", " + kor + ", " + eng + ", " + math;
    }
}
